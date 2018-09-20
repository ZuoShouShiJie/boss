package com.maiziyun.boss.web.controller.jysmng;

import com.maiziyun.boss.facade.common.model.ResponseNewData;
import com.maiziyun.boss.facade.jysmng.model.*;
import com.maiziyun.boss.facade.jysmng.service.JYSMngService;
import com.maiziyun.boss.web.controller.common.BaseController;
import com.maiziyun.boss.web.interceptor.annotation.TokenLogin;
import com.solar.framework.core.base.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 交易所管理
 * Created by admin on 2017/11/4.
 */
@Controller
@RequestMapping("/jysmng")
public class JYSMngController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(JYSMngController.class);
    @Resource(name = "boss.JYSMngService")
    private JYSMngService jysMngService;
    /**
     * 用户投资列表查询 CoreQueryService
     */
    @RequestMapping("/userInvestList.do")
    @ResponseBody
    @TokenLogin
    public Object userInvestListQuery(@RequestBody UserInvestListQueryRequest request) {

        logger.info("接收请求{ }", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.userInvestListQuery(request);
        } catch (BaseException e) {
            logger.error("用户投资列表查询异常", e);
        } catch (Exception e) {
            logger.error("用户投资列表查询异常", e);
        }
        return data;
    }


    /**
     * 资金记录 第一步:查用户信息
     */
    @RequestMapping("/queryUserMsg.do")
    @ResponseBody
    @TokenLogin
    public Object queryUserMsg(@RequestBody FundsRecordQueryRequest request) {

        logger.info("接收请求{ }", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.queryUserMsg(request);
        } catch (BaseException e) {
            logger.error("查用户信息异常", e);
        } catch (Exception e) {
            logger.error("查用户信息异常", e);
        }
        return data;
    }



    /**
     * 资金记录 第二步：查资金记录
     */
    @RequestMapping("/fundsRecordQuery.do")
    @ResponseBody
    @TokenLogin
    public Object fundsRecordQuery(@RequestBody FundsRecordQueryRequest request) {
        logger.info("接收请求{ }", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.fundsRecordQuery(request);
        } catch (BaseException e) {
            logger.error("资金记录查询异常", e);
        } catch (Exception e) {
            logger.error("资金记录查询异常", e);
        }
        return data;

    }
//---------------------------------------------交易所项目-------------------------------------------------------
    /**
     * 交易所项目配置查询
     */
    @RequestMapping("/projectConfQuery.do")
    @ResponseBody
    @TokenLogin
    public Object projectConfQuery(@RequestBody ProjectConfQueryRequest request) {
        logger.info("接收请求{}", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.projectConfQuery(request);
        } catch (BaseException e) {
            logger.error("交易所项目配置查询异常", e);
        } catch (Exception e) {
            logger.error("交易所项目配置查询异常", e);
        }
        return data;
    }

    /**
     * 交易所项目配置新增/修改
     */
    @RequestMapping("/projectConfUpdate.do")
    @ResponseBody
    @TokenLogin
    public Object projectConfUpdate(@RequestBody ProjectConfUpdateRequest request) {
        logger.info("接收请求{}", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.projectConfUpdate(request);
        } catch (BaseException e) {
            logger.error("交易所项目配置新增/修改异常", e);
        } catch (Exception e) {
            logger.error("交易所项目配置新增/修改异常", e);
        }
        return data;
    }


 /*   *//**
     * 上传协议
     *//*
    @RequestMapping("/projectAddProtocol.do")
    @ResponseBody
    @TokenLogin
    public Object projectAddProtocol(HttpServletRequest request) throws IOException {
        logger.info("接收请求{}", request);
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
        MultipartFile coverImgFile = multiRequest.getFile("protocol");
        ResponseNewData data = new ResponseNewData();
        String filePath = "E:\\test\\test.html";
        File pic = new File(filePath);
        InputStream stream = null;
        stream = coverImgFile.getInputStream();
        FileOutputStream outputStream = new FileOutputStream(pic);
        try {

            int byteCount;
            byte[] bytes = new byte[1024];
            while ((byteCount = stream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, byteCount);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            outputStream.close();
            stream.close();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("url", "d://teml"); //上下线状态
        data.setData(map);
        data.setCode("000000");
        data.setMsg("成功");

        return data;
    }
*/



//------------------------------------------------------产品-----------------------------------------------------
    /**
     * 理财产品配置查询
     *
     * @return
     */
    @RequestMapping("/productConfQuery.do")
    @ResponseBody
    @TokenLogin
    public Object productConfQuery(@RequestBody ProductConfQueryRequest request) {
        logger.info("接收请求{}", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.productConfQuery(request);
        } catch (BaseException e) {
            logger.error("理财产品配置查询异常", e);
        } catch (Exception e) {
            logger.error("理财产品配置查询异常", e);
        }
        return data;
    }

    /**
     * 通过交易所查询项目
     * @param request
     * @return
     */
    @RequestMapping("/queryProjectByExchange.do")
    @ResponseBody
    @TokenLogin
    public Object queryProjectByExchange(@RequestBody QueryProjectAllRequest request) {
        logger.info("接收请求{}", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.queryProjectByExchange(request);
        } catch (BaseException e) {
            logger.error("查询项目异常", e);
        } catch (Exception e) {
            logger.error("查询项目异常", e);
        }
        return data;
    }


    /**
     * 理财产品配置新增/修改
     *
     * @return
     */
    @RequestMapping("/productConfUpdate.do")
    @ResponseBody
    @TokenLogin
    public Object productConfUpdate(@RequestBody ProductConfUpdateRequest request) {
        logger.info("接收请求{}", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.productConfUpdate(request);
        } catch (BaseException e) {
            logger.error("理财产品配置新增/修改异常", e);
        } catch (Exception e) {
            logger.error("理财产品配置新增/修改异常", e);
        }
        return data;
    }

    /**
     * 已发布状态修改显示状态
     *
     * @return
     */
    @RequestMapping("/productUpdateStatus.do")
    @ResponseBody
    @TokenLogin
    public Object productUpdateStatus(@RequestBody ProductConfUpdateRequest request) {
        logger.info("接收请求{}", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.productUpdateStatus(request);
        } catch (BaseException e) {
            logger.error("理财产品修改显示状态异常", e);
        } catch (Exception e) {
            logger.error("理财产品修改状态异常", e);
        }
        return data;
    }

    /**
     * 发布
     */
    @RequestMapping("/releaseProd.do")
    @ResponseBody
    @TokenLogin
    public Object releaseProd(@RequestBody ReleaseProdRequest request) {

        logger.info("接收请求{}", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.releaseProd(request);
        } catch (BaseException e) {
            logger.error("理财产品发布异常", e);
        } catch (Exception e) {
            logger.error("理财产品发布异常", e);
        }
        return data;


    }

    /**
     * 理财产品配置删除
     */
    @RequestMapping("/productConfDele.do")
    @ResponseBody
    @TokenLogin
    public Object productConfDele(@RequestBody ProductConfDeleRequest request) {
        logger.info("接收请求{}", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.productConfDele(request);
        } catch (BaseException e) {
            logger.error("理财产品配置删除异常", e);
        } catch (Exception e) {
            logger.error("理财产品配置删除异常", e);
        }
        return data;
    }


    //------------------------------------------------交易所产品还款---------------------------------------------------
    /**
     * 产品还款列表查询
     */
    @RequestMapping("/productRepayQueryList.do")
    @ResponseBody
    @TokenLogin
    public Object productRepayQueryList(@RequestBody ProductRepayQueryRequest request) {
        logger.info("接收请求{}", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.productRepayQueryList(request);
        } catch (BaseException e) {
            logger.error("产品还款列表查询异常", e);
        } catch (Exception e) {
            logger.error("产品还款列表查询异常", e);
        }
        return data;
    }

    /**
     * 查询还款详情
     */
    @RequestMapping("/productRepayQueryById.do")
    @ResponseBody
    @TokenLogin
    public Object productRepayQueryById(@RequestBody ProductRepayQueryRequest request) {
        logger.info("接收请求{}", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.productRepayQueryById(request);
        } catch (BaseException e) {
            logger.error("查询还款详情异常", e);
        } catch (Exception e) {
            logger.error("查询还款详情异常", e);
        }
        return data;
    }


    /**
     * 点击还款进行还款
     */
    @RequestMapping("/productRepay.do")
    @ResponseBody
    @TokenLogin
    public Object productRepay(@RequestBody ProductRepayQueryRequest request) {
        logger.info("接收请求{}", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.productRepay(request);
        } catch (BaseException e) {
            logger.error("点击还款异常", e);
        } catch (Exception e) {
            logger.error("点击还款异常", e);
        }
        return data;
    }

    /**
     * 还款用户下载
     */
    @RequestMapping("/productRepayLoad.do")
    @ResponseBody
    @TokenLogin
    public Object productRepayLoad(@RequestBody ProductRepayQueryRequest request) {
        logger.info("接收请求{}", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.productRepayLoad(request);
        } catch (BaseException e) {
            logger.error("还款用户下载异常", e);
        } catch (Exception e) {
            logger.error("还款用户下载异常", e);
        }
        return data;
    }

    /**
     * 还款用户查询列表
     */
    @RequestMapping("/productRepayUserList.do")
    @ResponseBody
    @TokenLogin
    public Object productRepayUserList(@RequestBody ProductRepayQueryRequest request) {
        logger.info("接收请求{}", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.productRepayUserList(request);
        } catch (BaseException e) {
            logger.error("还款用户查询列表异常", e);
        } catch (Exception e) {
            logger.error("还款用户查询列表异常", e);
        }
        return data;
    }

//-----------------------------------------账户管理-------------------------------------------------
    /**
     * 企业账户信息查询
     */
    @RequestMapping("/queryAccoInfo.do")
    @ResponseBody
    @TokenLogin
    public Object queryAccoInfo(@RequestBody ProductRepayQueryRequest request) {
        logger.info("接收请求{}", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.productRepayUserList(request);
        } catch (BaseException e) {
            logger.error("企业账户信息查询异常", e);
        } catch (Exception e) {
            logger.error("企业账户信息查询异常", e);
        }
        return data;
    }

    /**
     * 调账
     */
    @RequestMapping("/updateAccoAdjust.do")
    @ResponseBody
    @TokenLogin
    public Object updateAccoAdjust(@RequestBody ProductRepayQueryRequest request) {
        logger.info("接收请求{}", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.productRepayUserList(request);
        } catch (BaseException e) {
            logger.error("调账异常", e);
        } catch (Exception e) {
            logger.error("调账异常", e);
        }
        return data;
    }

    /**
     * 资金记录查询
     * @param request
     * @return
     */
    @RequestMapping("/queryfundRecord.do")
    @ResponseBody
    @TokenLogin
    public Object queryfundRecord(@RequestBody ProductRepayQueryRequest request) {
        logger.info("接收请求{}", request);
        ResponseNewData data = null;
        try {
            data = jysMngService.productRepayUserList(request);
        } catch (BaseException e) {
            logger.error("资金记录查询异常", e);
        } catch (Exception e) {
            logger.error("资金记录查询异常", e);
        }
        return data;
    }



}
