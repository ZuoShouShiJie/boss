package com.maiziyun.boss.web.controller.product;

import com.maiziyun.boss.biz.jysmng.convert.JYSMngConverter;
import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.product.model.*;
import com.maiziyun.boss.facade.product.service.HomePageSiteService;
import com.maiziyun.boss.web.common.utils.CommonUtils;
import com.maiziyun.boss.web.controller.common.BaseController;
import com.maiziyun.boss.web.interceptor.annotation.TokenLogin;
import com.maiziyun.boss.web.vo.ResponseData;
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
 * 首页产品位置
 * Created by admin on 2017/8/29.
 */
@Controller
@RequestMapping("/homePageSite")
public class HomePageSiteController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(HomePageSiteController.class);
    @Resource(name = "boss.HomePageSiteService")
    private HomePageSiteService homePageSiteService;


    //---------------------------------------精选策略组合----------------------------------------------

    /**
     * 首页精选策略组合区域查询
     */
    @TokenLogin
    @RequestMapping("/querySelectFofListEffect.do")
    @ResponseBody
    public Object querySelectFofListEffect(@RequestBody QuerySelectFofListRequest request) {
        QuerySelectFofListResponse $response = new QuerySelectFofListResponse();
        ResponseData data = new ResponseData();
        try {
            Map<String, Object> map = new HashMap<>();
            $response = homePageSiteService.querySelectFofListCanbuy(request);
            map.put("list", $response.getList() == null ? "" : $response.getList());
            map.put("effectFlagList", CommonUtils.getEffectFlag());// 是否上下架
            data.setData(map);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            logger.info("向web返回数据：" + data);
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("组合列表管理查询异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("组合列表管理查询异常", e);
        }
        return data;
    }

    /**
     * 首页精选策略组合区域查询
     */
    @TokenLogin
    @RequestMapping("/querySelectFofList.do")
    @ResponseBody
    public Object querySelectFofList(@RequestBody QuerySelectFofListRequest request) {
        QuerySelectFofListResponse $response = new QuerySelectFofListResponse();
        ResponseData data = new ResponseData();
        try {
            Map<String, Object> map = new HashMap<>();
            $response = homePageSiteService.querySelectFofList(request);
            map.put("list", $response.getList() == null ? "" : $response.getList());
            map.put("listTotal", $response.getPageCount() == null ? "" : $response.getPageCount());
            map.put("effectFlagList", CommonUtils.getEffectFlag());// 是否上下架
            data.setData(map);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            logger.info("向web返回数据：" + data);
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("组合列表管理查询异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("组合列表管理查询异常", e);
        }
        return data;
    }

    /**
     * 首页精选策略组合修改
     *
     * @param request
     * @return
     */
    @TokenLogin
    @RequestMapping("/updateSelectFofList.do")
    @ResponseBody
    public Object updateSelectFofList(@RequestBody UpdateSelectFofListRequest request) {
        UpdateSelectFofListResponse $response = new UpdateSelectFofListResponse();
        ResponseData data = new ResponseData();
        try {
            $response = homePageSiteService.updateSelectFofList(request);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            logger.info("向web返回数据：" + data);
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("组合列表管理查询异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("组合列表管理查询异常", e);
        }
        return data;

    }

    //----------------------------------优选网贷---------------------------------------------------

    /**
     * 优选网贷查询列表
     */
    @RequestMapping("/queryLoanList.do")
    @TokenLogin
    @ResponseBody
    public Object queryLoanList(@RequestBody QueryP2PLoanRequest request) {
        QueryFirP2PLoanResponse $response = new QueryFirP2PLoanResponse();
        ResponseData data = new ResponseData();
        try {
            $response = homePageSiteService.queryLoanList(request);

            data.setData($response.getData() == null ? "" : $response.getData());
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            logger.info("向web返回数据：" + data);
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("首页网贷查询异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("首页网贷查询异常", e);
        }
        return data;
    }


    /**
     * 查询位置调整
     */
    @TokenLogin
    @RequestMapping("/queryLoanSite.do")
    @ResponseBody
    public Object queryLoanSite(@RequestBody QueryLoanSiteRequest request) {
        QueryLoanSiteResponse $response = new QueryLoanSiteResponse();
        ResponseData data = new ResponseData();
        try {
            $response = homePageSiteService.queryLoanSite(request);
            data.setData($response.getDeadLineList() == null ? "" : $response.getDeadLineList());
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("查询位置调整异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("查询位置调整异常", e);
        }
        return data;

    }

    /**
     * 修改位置调整
     */
    @TokenLogin
    @RequestMapping("/updateLoanSite.do")
    @ResponseBody
    public Object updateLoanSite(@RequestBody UpdateLoanSiteRequest request) {
        UpdateLoanSiteResponse $response = new UpdateLoanSiteResponse();
        ResponseData data = new ResponseData();
        try {
            $response = homePageSiteService.updateLoanSite(request);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            logger.info("向web返回数据：" + data);
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("首页网贷位置修改异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("首页网贷位置修改异常", e);
        }
        return data;
    }


    //----------------------------------精选基金---------------------------------------------

    /**
     * 基金
     * 查询精选基金未分页
     *
     * @param request
     * @return
     */
    @TokenLogin
    @RequestMapping("/querySelectFund.do")
    @ResponseBody
    public Object querySelectFund(@RequestBody SelectFundListRequest request) {
        SelectFundListResponse $response = new SelectFundListResponse();
        ResponseData data = new ResponseData();
        try {
            $response = homePageSiteService.querySelectFund(request);
            data.setData($response.getDatas() == null ? "" : $response.getDatas());
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            logger.info("向web返回数据：" + data);
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("精选基金查询异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("精选基金查询异常", e);
        }
        return data;
    }


    /**
     * 查询精选基金分页
     *
     * @param request
     * @return
     */
    @TokenLogin
    @RequestMapping("/querySelectFundAll.do")
    @ResponseBody
    public Object querySelectFundAll(@RequestBody SelectFundListRequest request) {
        SelectFundListResponse $response = new SelectFundListResponse();
        ResponseData data = new ResponseData();
        try {
            $response = homePageSiteService.querySelectFundAll(request);
            Map<String, Object> map = new HashMap<>();
            map.put("list", $response.getDatas() == null ? "" : $response.getDatas());
            map.put("listTotal", $response.getTotal() == null ? "" : $response.getTotal());
            data.setData(map);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            logger.info("向web返回数据：" + data);
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("精选基金查询异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("精选基金查询异常", e);
        }
        return data;
    }

    /**
     * 精选基金确认变更
     *
     * @param request
     * @return
     */
    @TokenLogin
    @RequestMapping("/updateSelectFund.do")
    @ResponseBody
    public Object updateSelectFund(@RequestBody UpdateSelectFundRequest request) {
        UpdateSelectFundResponse $response = new UpdateSelectFundResponse();
        ResponseData data = new ResponseData();
        try {
            $response = homePageSiteService.updateSelectFund(request);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            logger.info("向web返回数据：" + data);
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("精选基金查询异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("精选基金查询异常", e);
        }
        return data;
    }


}
