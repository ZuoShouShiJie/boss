package com.maiziyun.boss.web.controller.jysmng;

import com.maiziyun.boss.facade.common.model.ResponseNewData;
import com.maiziyun.boss.facade.group.model.FundGroupListQueryRequest;
import com.maiziyun.boss.facade.group.model.FundGroupUpdateRequest;
import com.maiziyun.boss.facade.group.service.FundGroupService;
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
 * 组合产品控制
 * Created by admin on 2017/11/4.
 */
@Controller
@RequestMapping("/fundGroup")
public class FundGoupController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(FundGoupController.class);
    @Resource(name = "boss.FundGroupService")
    private FundGroupService fundGroupService;

    /**
     * 组合产品查询列表
     */
    @RequestMapping("/queryGroupProductList.do")
    @ResponseBody
    @TokenLogin
    public Object queryGroupProductList(@RequestBody FundGroupListQueryRequest request) {
        logger.info("接收请求{ }", request);
        ResponseNewData data = null;
        try {
            data = fundGroupService.queryGroupProductList(request);
        } catch (BaseException e) {
            logger.error("组合产品查询列表异常", e);
        } catch (Exception e) {
            logger.error("组合产品查询列表异常", e);
        }
        return data;
    }

    /**
     * 查询组合产品详情
     */
    @RequestMapping("/queryGroupProductById.do")
    @ResponseBody
    @TokenLogin
    public Object queryGroupProductById(@RequestBody FundGroupListQueryRequest request) {
        logger.info("接收请求{ }", request);
        ResponseNewData data = null;
        try {
            data = fundGroupService.queryGroupProductById(request);
        } catch (BaseException e) {
            logger.error("查询组合产品详情异常", e);
        } catch (Exception e) {
            logger.error("查询组合产品详情异常", e);
        }
        return data;
    }

    /**
     * 新增/修改组合配置
     */
    @RequestMapping("/updateGroupProduct.do")
    @ResponseBody
    @TokenLogin
    public Object updateGroupProduct(@RequestBody FundGroupUpdateRequest request) {
        logger.info("接收请求{ }", request);
        ResponseNewData data = null;
        try {
            data = fundGroupService.updateGroupProduct(request);
        } catch (BaseException e) {
            logger.error("新增/修改组合配置异常", e);
        } catch (Exception e) {
            logger.error("新增/修改组合配置异常", e);
        }
        return data;
    }

    /**
     * 查询基金产品(模糊查询)
     *
     * @return
     */
    @RequestMapping("/queryFundProduct.do")
    @ResponseBody
    @TokenLogin
    public Object queryFundProduct(@RequestBody FundGroupListQueryRequest request) {
        logger.info("接收请求{ }", request);
        ResponseNewData data = null;
        try {
            data = fundGroupService.queryFundProduct(request);
        } catch (BaseException e) {
            logger.error("查询基金产品异常", e);
        } catch (Exception e) {
            logger.error("查询基金产品异常", e);
        }
        return data;
    }

    /**
     * 查询固收产品(模糊查询)
     *
     * @return
     */
    @RequestMapping("/querySolidProduct.do")
    @ResponseBody
    @TokenLogin
    public Object querySolidProduct(@RequestBody FundGroupListQueryRequest request) {
        logger.info("接收请求{ }", request);
        ResponseNewData data = null;
        try {
            data = fundGroupService.querySolidProduct(request);
        } catch (BaseException e) {
            logger.error("查询固收产品异常", e);
        } catch (Exception e) {
            logger.error("查询固收产品异常", e);
        }
        return data;
    }

}
