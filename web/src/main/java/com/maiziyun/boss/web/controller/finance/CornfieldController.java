package com.maiziyun.boss.web.controller.finance;

import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.finance.model.*;
import com.maiziyun.boss.facade.finance.service.CornfieldService;
import com.maiziyun.boss.web.common.utils.CommonUtils;
import com.maiziyun.boss.web.controller.common.BaseController;
import com.maiziyun.boss.web.interceptor.annotation.TokenLogin;
import com.maiziyun.boss.web.vo.ResponseData;
import com.solar.framework.core.base.BaseException;
import com.solar.framework.core.model.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 开心麦田管理
 * Created by admin on 2017/6/21.
 */
@Controller
@RequestMapping("/cornfield")
public class CornfieldController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(CornfieldController.class);

    @Resource(name = "boss.cornfieldService")
    private CornfieldService cornfieldService;

    /**
     * 麦田查询
     */
    @TokenLogin
    @RequestMapping("/queryCornfield.do")
    @ResponseBody
    public Object queryAllCornfield(@RequestBody QueryCornRequest queryCorn) {
        logger.info("麦田查询action：queryAllCornfield");
        QueryCornResponse $response = new QueryCornResponse();
        ResponseData data = new ResponseData();
        try {
            $response = cornfieldService.queryAllCornfield(queryCorn);

            Map<String, Object> map = new HashMap<>();
            map.put("listTotal", $response.getTotal() == null ? "" : $response.getTotal());
            map.put("statusList", CommonUtils.getStatusList()); // 状态
            map.put("taskActionList", CommonUtils.getTaskActList()); //任务行为
            map.put("taskTypeList", CommonUtils.getTaskTypeList());  // 任务类型
            map.put("inveScopeList", CommonUtils.getInveScopeList());  //投资范围
            map.put("inveConditList", CommonUtils.getInveConditListList()); //投资条件
            map.put("frontVisibleList", CommonUtils.getFrontVisibleList()); //是否可见
            map.put("list", $response.getDatas() == null ? "" : $response.getDatas());
            data.setData(map);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("麦田管理查询异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("麦田管理查询异常", e);
        }
        return data;
    }

    /**
     * 点击编辑按钮（通过id查询）
     */
    @TokenLogin
    @RequestMapping("/queryCornById.do")
    @ResponseBody
    public Object queryCornById(@RequestBody QueryCornRequest queryCorn) {
        logger.info("麦田查询详情action：queryCornById");
        QueryCornResponse $response = new QueryCornResponse();
        ResponseData data = new ResponseData();
        try {
            $response = cornfieldService.queryCornById(queryCorn);
            data.setData($response.getCornfieldVo());
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("麦田管理查询详情异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("麦田管理查询详情异常", e);
        }
        return data;
    }

    /**
     * 新增保存按钮
     */
    @TokenLogin
    @RequestMapping("/createCornfield.do")
    @ResponseBody
    public Object createCornfield(@RequestBody CreateCornRequest createCorn) {
        logger.info("麦田新增action：createCornfield");
        CreateCornResponse $response = new CreateCornResponse();
        ResponseData data = new ResponseData();
        try {
            $response = cornfieldService.createCornfield(createCorn);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("麦子管理新增异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("麦子管理新增异常", e);
        }
        return data;
    }

    /**
     * 修改保存按钮;
     */
    @TokenLogin
    @RequestMapping("/updateCornfield.do")
    @ResponseBody
    public Object updateCornfield(@RequestBody UpdateCornRequest updateCorn) {
        logger.info("麦田管理修改action：updateCornfield");
        UpdateCornResponse $response = new UpdateCornResponse();
        ResponseData data = new ResponseData();
        try {
            $response = cornfieldService.updateCornfield(updateCorn);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("麦子管理修改异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("麦子管理修改异常", e);
        }
        return data;
    }

    /**
     * 上线，下线状态修改按钮
     *
     * @param updateCorn
     * @return
     */
    @TokenLogin
    @RequestMapping("/updateCornStatus.do")
    @ResponseBody
    public Object updateCornStatus(@RequestBody UpdateCornRequest updateCorn) {
        logger.info("麦田管理上下线状态修改action：updateCornStatus");
        UpdateCornResponse $response = new UpdateCornResponse();
        ResponseData data = new ResponseData();
        try {
            $response = cornfieldService.updateCornStatus(updateCorn);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("麦子管理状态修改异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("麦子管理状态修改异常", e);
        }
        return data;
    }


    /**
     * 编辑页面删除按钮
     */
    @TokenLogin
    @RequestMapping("/deleteCornfield.do")
    @ResponseBody
    public Object deleteCornfield(@RequestBody UpdateCornRequest updateCorn) {
        logger.info("麦田管理删除action：deleteCornfield");
        UpdateCornResponse $response = new UpdateCornResponse();
        ResponseData data = new ResponseData();
        try {
            $response = cornfieldService.deleteCornfield(updateCorn);
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
        } catch (BaseException e) {
            data.setCode($response.getCode().code());
            data.setMsg($response.getMessage());
            e.printStackTrace();
            logger.error("麦子管理删除异常", e);
        } catch (Exception e) {
            data.setCode(BossBizCode.Unknown.code());
            data.setMsg(e.getMessage());
            e.printStackTrace();
            logger.error("麦子管理删除异常", e);
        }
        return data;
    }

}
