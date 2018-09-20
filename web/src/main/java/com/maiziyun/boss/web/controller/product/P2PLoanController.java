package com.maiziyun.boss.web.controller.product;

import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.product.model.*;
import com.maiziyun.boss.facade.product.service.P2PLoanService;
import com.maiziyun.boss.web.controller.common.BaseController;
import com.maiziyun.boss.web.interceptor.annotation.TokenLogin;
import com.maiziyun.boss.web.vo.ResponseData;
import com.maiziyun.product.facade.model.ProductP2PFixedInvestmentRequest;
import com.maiziyun.product.facade.model.ProductP2PFixedInvestmentResponse;
import com.solar.framework.core.base.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 网贷列表
 * Created by admin on 2017/8/31.
 */
@Controller
@RequestMapping("/p2PLoan")
public class P2PLoanController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(P2PLoanController.class);
    @Resource(name = "boss.P2PLoanService")
    private P2PLoanService p2PLoanService;


    /**
     * 网贷列表查询
     *
     * @return
     */
    @ResponseBody
    @TokenLogin
    @RequestMapping("/queryLoanList.do")
    public Object queryLoanList(@RequestBody QueryP2PLoanRequest request) {
        QueryP2PLoanResponse $response = new QueryP2PLoanResponse();
        ResponseData data = new ResponseData();
        try {
            $response = p2PLoanService.queryLoanList(request);
            Map<String, Object> map = new HashMap<>();
            map.put("list", $response.getData() == null ? "" : $response.getData());
            map.put("listTotal", $response.getListTotal() == null ? "" : $response.getListTotal());
            map.put("deadLineList", $response.getDeadLineList());
            data.setData(map);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            logger.info("向web返回数据：" + data);
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("网贷列表查询异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("网贷列表查询异常", e);
        }
        return data;
    }

    /**
     * 查询详情
     *
     * @param request
     * @return
     */
    @ResponseBody
    @TokenLogin
    @RequestMapping("/queryLoanById.do")
    public Object queryLoanById(@RequestBody QueryP2PLoanDetailRequest request) {
        QueryP2PLoanDetailResponse $response = new QueryP2PLoanDetailResponse();
        ResponseData data = new ResponseData();
        try {
            $response = p2PLoanService.queryLoanById(request);
            data.setData($response.getData() == null ? "" : $response.getData());
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            logger.info("向web返回数据：" + data);
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("网贷查询详情查询异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("网贷查询详情查询异常", e);
        }
        return data;
    }


    /**
     * 详情修改确定按钮
     */
    @ResponseBody
    @TokenLogin
    @RequestMapping("/updateP2PLoan.do")
    public Object updateP2PLoan(@RequestBody UpdateP2PLoanRequest request) {
        UpdateP2PLoanResponse $response = new UpdateP2PLoanResponse();
        ResponseData data = new ResponseData();
        try {
            $response = p2PLoanService.updateP2PLoan(request);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            logger.info("向web返回数据：" + data);
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("网贷详情修改异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("网贷详情修改询异常", e);
        }
        return data;
    }





    /**
     * 查询位置调整
     */
    @TokenLogin
    @RequestMapping("/queryLoanSite.do")
    @ResponseBody
    public Object queryLoanSite( ) {





        return null;

    }

}
