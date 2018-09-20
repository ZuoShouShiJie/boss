package com.maiziyun.boss.biz.common.service.impl;

import com.maiziyun.boss.biz.common.service.LocalOperatorService;
import com.maiziyun.boss.common.utils.DateUtils;
import com.maiziyun.boss.dal.dao.OperatorDAO;
import com.maiziyun.boss.dal.dao.RoleDAO;
import com.maiziyun.boss.dal.dataobject.OperatorDO;
import com.maiziyun.boss.dal.dataobject.RoleDO;
import com.maiziyun.boss.dal.resultmap.MenuListDO;
import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.common.model.MenuResponse;
import com.maiziyun.boss.facade.common.model.OperatorRequest;
import com.maiziyun.boss.facade.common.model.OperatorResponse;
import com.maiziyun.boss.facade.common.model.vo.MenuVo1;
import com.maiziyun.boss.facade.common.model.vo.MenuVo2;
import com.maiziyun.boss.facade.common.model.vo.OperatorVo;

import com.maiziyun.boss.facade.system.model.vo.RoleVo;
import com.solar.framework.core.base.BaseException;
import com.solar.framework.core.enums.BizCode;
import com.solar.framework.core.exception.BizException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by songliang on 2016/11/17.
 */
@Service("boss.OperatorService")
public class OperatorServiceImpl implements LocalOperatorService {
    private static Logger logger = LoggerFactory.getLogger(OperatorServiceImpl.class);
    @Resource
    private OperatorDAO operatorDAO;
    @Resource
    private RoleDAO roleDAO;


    /**
     * 根据操作员id查找操作员详情
     *
     * @param request
     * @return
     */
    @Override
    public OperatorResponse getByOperId(OperatorRequest request) {
        OperatorResponse response = new OperatorResponse();
        try {
            response.setOperatorVo(this.getLocalByOperId(request.getUserId()));
//            response.setOperatorVo(this.getLocalByOperName(request.getUserName()));
            response.setCode(BizCode.Success);
            response.setMessage("通过操作员编号获取操作员vo对象成功");
        } catch (BaseException e) {
            logger.error("通过操作员编号获取操作员vo对象错误", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("通过操作员编号获取操作员vo对象错误", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    /**
     * 根据操作员用户名或者用户角色信息
     *
     * @param request
     * @return
     */
    @Override
    public OperatorResponse getByOperName(OperatorRequest request) {
        OperatorResponse response = new OperatorResponse();
        try {
            response.setOperatorVo(this.getLocalByOperName(request.getUserName()));
            response.setCode(BizCode.Success);
            response.setMessage("通过操作员姓名获取操作员vo对象成功");
        } catch (BaseException e) {
            logger.error("通过操作员姓名获取操作员vo对象错误", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("通过操作员姓名获取操作员vo对象错误", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @Override
    public OperatorVo getLocalByOperName(String userName) throws Exception {
        if (StringUtils.isEmpty(userName)) {
            throw new BizException(BossBizCode.OperatorNameNull, "操作员名字为空");
        }
        OperatorDO operatorDO = operatorDAO.getByUserName(userName);
        if (operatorDO == null) {
            return null;
        }
        OperatorVo operatorVo = this.setOperatorVo(operatorDO);
        return operatorVo;
    }

    @Override
    public OperatorVo getLocalByOperId(Integer userId) throws Exception {
        if (userId == null) {
            throw new BizException(BossBizCode.OperatorIdNull, "操作员id为空");
        }
        OperatorDO operatorDO = operatorDAO.getByPrimary(userId);
        if (operatorDO == null) {
            throw new BizException(BossBizCode.GetOperByIdNull, BossBizCode.GetOperByIdNull.desc());
        }
        OperatorVo operatorVo = this.setOperatorVo(operatorDO);
        return operatorVo;
    }


    /**
     * 赋值operatorVo
     *
     * @param operatorDO
     * @return
     */
    private OperatorVo setOperatorVo(OperatorDO operatorDO) throws Exception {
        OperatorVo operatorVo = new OperatorVo();
        List<RoleVo> roles = this.getOperatorDetail(operatorDO.getUserName());
        if (roles == null || roles.size() == 0) {

        } else {
            // 赋值
            operatorVo.setLastLoginTime(operatorDO.getLastLoginTime() == null ? null : DateUtils.formatDatetime(operatorDO.getLastLoginTime(), "yyyy-MM-dd HH:mm:ss"));
            operatorVo.setOperatorId(operatorDO.getId());
            operatorVo.setOperatorName(operatorDO.getUserName());
            operatorVo.setPassword(operatorDO.getPassword());
            operatorVo.setRoleVos(roles);
        }
        return operatorVo;

    }

    /**
     * 根据用户名查询出对应的角色信息
     *
     * @param userName
     * @return
     */
    private List<RoleVo> getOperatorDetail(String userName) {
        List<RoleVo> roleVos = null;
        // 查询角色相关信息
        if (StringUtils.isNotEmpty(userName)) {
            roleVos = new ArrayList<RoleVo>();
            List<RoleDO> roles = roleDAO.getRolesByOperatorName(userName);
            if (roles.size() == 0) {

            } else {
                for (int i = 0; i < roles.size(); i++) {
                    RoleVo roleVo = new RoleVo();
                    RoleDO role = roles.get(i);
                    roleVo.setRoleCode(role.getRoleCode());
                    roleVo.setRoleId(role.getId());
                    roleVo.setRoleName(role.getRoleName());
                    roleVos.add(roleVo);
                }
            }
        }
        return roleVos;
    }

    @Override
    public OperatorResponse getByUserNamePass(OperatorRequest request) {
        OperatorResponse response = new OperatorResponse();
        try {
            response.setOperatorVo(this.getLocalByUserNamePass(request.getUserName(), request.getPassword()));
            response.setCode(BizCode.Success);
            response.setMessage("通过操作员姓名,密码获取操作员vo对象成功");
        } catch (BaseException e) {
            logger.error("通过操作员姓名，密码获取操作员vo对象错误", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("通过操作员姓名，密码获取操作员vo对象错误", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @Override
    public OperatorVo getLocalByUserNamePass(String userName, String password) throws Exception {
        if (StringUtils.isEmpty(userName)) {
            throw new BizException(BossBizCode.OperatorNameNull, "操作员名字为空");
        }
        if (StringUtils.isEmpty(password)) {
            throw new BizException(BossBizCode.OperatorPassNull, "操作员密码为空");
        }

        OperatorDO operatorDO = operatorDAO.getByUserNamePass(password, userName);
        if (operatorDO == null) {
            return null;
        }
        OperatorVo operatorVo = this.setOperatorVo(operatorDO);
        return operatorVo;
    }

    @Override
    public MenuResponse getMenuList(OperatorRequest request) {
        logger.info("service查询菜单列表"+request);
        MenuResponse response = new MenuResponse();
        try {
            String userName = request.getUserName();
            List<MenuVo1> list = new ArrayList<>();
            List<MenuListDO> menuList = operatorDAO.getMenuList(userName); //全部
            if (menuList != null) {
                List<MenuListDO> menuRootList = new ArrayList<>(); //一级菜单
                for (MenuListDO DO : menuList) {
                    if (DO.getModuleCode().length() == 4) {
                        menuRootList.add(DO);
                    }
                }
                for (MenuListDO DO : menuRootList) {
                    MenuVo1 vo = new MenuVo1();
                    vo.setId(DO.getId() == null ? "" : DO.getId());
                    vo.setName(DO.getName() == null ? "" : DO.getName());
                    List<MenuVo2> list2 = new ArrayList<>(); //二级菜单
                    for (MenuListDO menu2 : menuList) {
                        if (DO.getModuleCode().equals(menu2.getParentCode())) {
                            MenuVo2 vo2 = new MenuVo2();
                            vo2.setId(menu2.getId() == null ? "" : menu2.getId());
                            vo2.setName(menu2.getName() == null ? "" : menu2.getName());
                            vo2.setTitle(menu2.getUrl() == null ? "" : menu2.getUrl());
                            vo2.setReload(menu2.getReload() == null ? "" : menu2.getReload());
                            list2.add(vo2);
                        }
                    }
                    vo.setMenus(list2);
                    list.add(vo);
                }
                response.setLevel(menuList.get(0).getLevel() == null ? "" : menuList.get(0).getLevel());
                response.setList(list);
                response.setMessage("查询成功");
                logger.info("菜单列表"+list);
            } else {
                response.setLevel(null);
                response.setList(null);
                response.setMessage("查询成功");
                logger.info("菜单列表为空");
            }

        } catch (BaseException e) {
            logger.error("菜单初始化错误", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("菜单初始化错误", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        return response;
    }


}
