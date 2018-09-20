package com.maiziyun.boss.web.controller.common;

import com.maiziyun.boss.biz.redis.IBaseRedisService;
import com.maiziyun.boss.common.utils.Md5Util;
import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.common.model.MenuResponse;
import com.maiziyun.boss.facade.common.model.OperatorRequest;
import com.maiziyun.boss.facade.common.model.OperatorResponse;
import com.maiziyun.boss.facade.common.model.vo.OperatorVo;
import com.maiziyun.boss.facade.system.enums.MenuLevel;
import com.maiziyun.boss.facade.system.model.LoginResponse;
import com.maiziyun.boss.facade.system.model.vo.MenuVo;
import com.maiziyun.boss.facade.common.model.service.LocalOperatorService;
import com.maiziyun.boss.web.common.utils.CommonUtils;
import com.maiziyun.boss.web.controller.ViewResponseModel;
import com.maiziyun.boss.web.controller.ResponseUtil;
import com.maiziyun.boss.web.vo.BaseRequest;
import com.maiziyun.boss.web.vo.LoginVo;
import com.maiziyun.boss.web.vo.ResponseData;
import com.maiziyun.common.enums.MyServiceCode;
import com.solar.framework.core.enums.BizCode;
import com.solar.framework.core.exception.BizException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by songliang on 2016/11/14.
 */
@Controller
public class AuthorizationController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationController.class);

    @Resource(name = "boss.OperatorService")
    private LocalOperatorService operatorService;
    /*  @Resource(name = "boss.MenuService")
      private MenuService menuService;*/
    @Resource(name = "boss.BaseRedisService")
    private IBaseRedisService baseRedisService;

    /**
     * 登录页面
     */
    @RequestMapping(value = "login.htm", method = {RequestMethod.POST, RequestMethod.GET})
    public String login() {
        return "login";
    }

    /**
     * 1.通过用户名，密码，查询是否存在，若存在，则登录成功；若失败，登录失败
     * 2.若成功，生成一个token，保存并传递给前段，
     *
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/loginByPass.do")
    public Object toPasswordLogin(@RequestBody LoginVo vo, HttpServletRequest request, HttpServletResponse response) {
        logger.info("密码登录开始");
        ResponseData data = new ResponseData();
        OperatorResponse opResponse = new OperatorResponse();
        MenuResponse menuResponse = new MenuResponse();
        try {
            String userName = vo.getUserAccount();
            String password = vo.getLoginPassword();
            if (StringUtils.isBlank(userName)) {
                throw new BizException(BossBizCode.OperatorNameNull, "操作员名字为空");
            }
            if (StringUtils.isBlank(password)) {
                throw new BizException(BossBizCode.OperatorPassNull, "操作员密码为空");
            }
            OperatorRequest opRequest = new OperatorRequest();
            String passwordMd5 = Md5Util.getMd5(password);

            opRequest.setUserName(userName);
            opRequest.setPassword(passwordMd5);
            opResponse = operatorService.getByOperName(opRequest);
            OperatorVo operatorVo = opResponse.getOperatorVo();
            if (operatorVo == null) {
                data.setData(null);
                data.setCode(BossBizCode.operEmpty.code());
                data.setMsg(BossBizCode.operEmpty.desc());
                return data;
            }
            //查询用户，密码
            opResponse = operatorService.getByUserNamePass(opRequest);
            OperatorVo operatorVo2 = opResponse.getOperatorVo();
            if (operatorVo2 == null) {
                data.setData(null);
                data.setCode(BossBizCode.operOrPassError.code());
                data.setMsg(BossBizCode.operOrPassError.desc());
                return data;
            } else {
                logger.info("存在用户" + opRequest.getUserName());
                //菜单显示
                menuResponse = operatorService.getMenuList(opRequest);
                //生成token
                Boolean flag = baseRedisService.cantainsKey(MyServiceCode.Boss.code() + operatorVo2.getOperatorId());
                String token = CommonUtils.genToken(operatorVo2);
                Boolean b = baseRedisService.cacheValue(MyServiceCode.Boss.code() + operatorVo2.getOperatorId(), token, 1);
                Map<String, Object> map = new HashMap<>();
                map.put("userId", MyServiceCode.Boss.code() + operatorVo2.getOperatorId());
                map.put("tokenId", token);
                map.put("list", menuResponse.getList() == null ? "" : menuResponse.getList());
                map.put("level", menuResponse.getLevel() == null ? "" : menuResponse.getLevel());
                logger.info("输出数据：map:" + map);
                data.setData(map);
                data.setCode(BizCode.Success.code());
                data.setMsg(BossBizCode.Success.desc());
                return data;
            }
        } catch (BizException e) {
            data.setCode(e.getCode().code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("用户登录异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("用户登录异常", e);
        }
        logger.info("密码登录完成");
        return data;
    }

    /**
     * 通过token登录
     * 1.根据传递过来的token,userName,查询redis是否存在，
     * 若存在，则登录成功，
     * 若不存在，则失败
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/loginByTok.do")
    public void toTokenLogin(BaseRequest baseRequest, HttpServletRequest request, HttpServletResponse response) {
        try {
            logger.info("token登录开始");
            LoginResponse login = new LoginResponse();
            String userName = baseRequest.getUserId();
            String token = baseRequest.getTokenId();

            Boolean flag = baseRedisService.cantainsKey(userName);
            if (flag) {
                if (token.equals(baseRedisService.getValue(userName))) {
                    login.setCode(BossBizCode.LoginFail);
                    login.setMsg(BossBizCode.LoginFail.desc());
                    ResponseUtil.writeResponse(request, response, new ViewResponseModel(login, null));
                }
            } else {
                login.setCode(BossBizCode.LoginFail);
                login.setMsg(BossBizCode.LoginFail.desc());
                ResponseUtil.writeResponse(request, response, new ViewResponseModel(login, null));
            }

        } catch (UsernameNotFoundException e) {
            logger.info("用户登录异常", e);
        } catch (Exception e) {
            logger.info("用户登录异常", e);
        }
        logger.info("token登录完成");

    }


    /**
     * 登录逻辑处理
     */
    @RequestMapping(value = "index.htm")
    public String toIndex(HttpServletRequest request) {
        logger.info("登录逻辑处理[index.htm]:", request);
        return "index";
    }

    @RequestMapping(value = "main.htm")
    public String toMain(HttpServletRequest request) {
        return "system/main";
    }


    /**
     * ajax登录后菜单数据加载
     */
    @RequestMapping(value = "index.do")
    @ResponseBody
 /*   public void loadIndex(HttpServletRequest request, HttpServletResponse response) {
       String userName =  (String)request.getSession().getAttribute("username");
        MenuGPSRequest $request = new MenuGPSRequest();
        $request.setUserName(userName);
        MenuGPSResponse $response = menuService.getMenusByUser($request);
        //转换成树形结构的list
        List<MenuVo> menus = $response.getMenuVos();
        menus = this.convertToTree(menus);
        ResponseUtil.writeResponse(request,response,new ViewResponseModel($response,menus));
    }*/

    /**
     * 将普通的一串菜单组装成树形菜单
     * @param menuVos
     * @return
     */
    private List<MenuVo> convertToTree(List<MenuVo> menuVos) {
        List<MenuVo> results = new ArrayList<MenuVo>();
        if (menuVos == null || menuVos.size() == 0) {
            return null;
        }
        for (MenuVo m : menuVos) {
            if (MenuLevel.ONE.name().equals(m.getLevel())) {//从一级菜单开始添加
                //判断是否有子菜单
                if (this.isHasChild(menuVos, m.getMenuCode())) {
                    List<MenuVo> childs = this.addChild(menuVos, m.getMenuCode());
                    //插入子菜单
                    m.setChildMenus(childs);
                }
                results.add(m);
            }
        }

        return results;
    }

    /**
     * 判断该节点是否有子节点
     *
     * @param menus
     * @param code
     * @return
     */
    private boolean isHasChild(List<MenuVo> menus, String code) {
        if (StringUtils.isEmpty(code)) {
            return false;
        }
        for (MenuVo m : menus) {
            if (code.equals(m.getMenuParentCode())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 递归新增子节点
     *
     * @param menus
     * @param code
     * @return
     */
    private List<MenuVo> addChild(List<MenuVo> menus, String code) {
        List<MenuVo> ms = new ArrayList<MenuVo>();
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        for (MenuVo m : menus) {
            if (code.equals(m.getMenuParentCode())) {
                //if(this.isHasChild(menus,m.getMenuCode())){
                List<MenuVo> childMenus = this.addChild(menus, m.getMenuCode());
                m.setChildMenus(childMenus);
                //}
                ms.add(m);
            }
        }
        if (ms.size() == 0) {
            return null;
        }
        return ms;
    }

    @RequestMapping(value = "sessionKeeper.do")
    public void sessionKeeper(HttpServletRequest request, HttpServletResponse response) {
        Object object = null;
        ResponseUtil.writeResponse(request, response, new ViewResponseModel(ResponseUtil.getSuccessResponse(), object));
    }
}
