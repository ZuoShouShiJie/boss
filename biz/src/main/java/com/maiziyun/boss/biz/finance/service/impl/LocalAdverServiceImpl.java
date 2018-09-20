package com.maiziyun.boss.biz.finance.service.impl;

import com.maiziyun.boss.biz.common.CommonUtils;
import com.maiziyun.boss.biz.finance.convert.AdverQueryConverter;
import com.maiziyun.boss.biz.finance.service.LocalAdverService;
import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.finance.model.QueryAdvertisementRequest;
import com.maiziyun.boss.facade.finance.model.QueryAdvertisementResponse;
import com.maiziyun.boss.facade.finance.model.UpdateAdverRequest;
import com.maiziyun.boss.facade.finance.model.UpdateAdverResponse;
import com.maiziyun.boss.facade.finance.model.vo.AdverVo;
import com.maiziyun.boss.integration.finance.FinanceRunClient;
import com.maiziyun.cms.facade.model.*;
import com.solar.framework.core.base.BaseException;
import com.solar.framework.core.enums.BizCode;
import com.solar.framework.core.exception.BizException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/6/16.
 */
@Service("boss.adverService")
public class LocalAdverServiceImpl implements LocalAdverService {
    private static final Logger logger = LoggerFactory.getLogger(LocalAdverServiceImpl.class);

    @Resource(name = "boss.financeRunClient")
    private FinanceRunClient financeRunClient;

    /**
     * 查询广告位,查询全部
     *
     * @param request
     * @return
     */
    @Override
    public QueryAdvertisementResponse queryAdvertisement(QueryAdvertisementRequest request) {
        logger.info("接收请求{}", request);
        QueryAdvertisementResponse response = new QueryAdvertisementResponse();
        try {
            if (request == null) {
                throw new BizException(BizCode.ParamError, BizCode.ParamError.desc());
            }
            QueryAdvertisementManagerRequest $request = new QueryAdvertisementManagerRequest();
            if ("all".equals(request.getState()) || StringUtils.isBlank(request.getState())) {
                $request.setOnline(null);
            } else {
                $request.setOnline(Integer.valueOf(request.getState()));
            }
            if ("all".equals(request.getPosition()) || StringUtils.isBlank(request.getPosition())) {
                $request.setPostition(null);
            } else {
                $request.setPostition(Integer.valueOf(request.getPosition()));
            }
            if (!StringUtils.isBlank(request.getTitle())) {
                $request.setTitle(request.getTitle());
            }
            $request.setCurrentPageNo(request.getPageNo());
            $request.setPageSize(request.getPageSize());
            QueryAdvertisementManagerResponse $response = financeRunClient.queryAdvertisement($request);
            QueryPositionRequest request1 = new QueryPositionRequest();
            QueryPositionResponse response1 = financeRunClient.queryPositionByAppCode(request1);
            if ($response != null && $response.getData() != null && $response.getData().size() != 0) {
                List<AdverVo> list = AdverQueryConverter.reConvert($response.getData());
                response.setDatas(list);
                response.setTotal(Integer.valueOf($response.getTotalRecord() + ""));
            } else {
                response.setDatas(null);
                response.setTotal(null);
            }
            if (response1 != null && response1.getData() != null && response1.getData().size() > 0) {
                response.setStateList(AdverQueryConverter.reConvertSta(response1.getData()));
            }
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error(" 查询异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("广告位查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 编辑查询页面,（通过id查询）
     *
     * @param request
     * @return
     */
    @Override
    public QueryAdvertisementResponse queryAdverById(QueryAdvertisementRequest request) {
        logger.info("接收请求{}", request);
        QueryAdvertisementResponse response = new QueryAdvertisementResponse();
        try {
            QueryAdvertisementManagerRequest $request = new QueryAdvertisementManagerRequest();
            $request.setId(Integer.valueOf(request.getId()));
            QueryAdvertisementManagerResponse $response = financeRunClient.queryAdverById($request);
            if ($response != null && $response.getData() != null && $response.getData().size() != 0) {
                AdverVo adver = AdverQueryConverter.reConvert1($response.getData().get(0));
                if (adver != null) {
                    logger.info("广告位返回图片路径：" + adver.getCoverImgUrl());
                }
                response.setAdverVo(adver);
            } else {
                response.setAdverVo(null);
            }
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error(" 广告位编辑页面查询异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("广告位编辑页面查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }


    /**
     * 广告位新增
     *
     * @param request
     * @return
     */
    @Override
    public UpdateAdverResponse createAdver(UpdateAdverRequest request) {
        logger.info("接收消息{}", request);
        UpdateAdverResponse response = new UpdateAdverResponse();
        try {
            CreateAdvertisementRequest $request = new CreateAdvertisementRequest();
            $request.setTitle(request.getTitle());
            $request.setEvent(request.getTargetUrl());//广告位链接
            if (StringUtils.isNotBlank(request.getPosition())) {
                $request.setPosition(Integer.valueOf(request.getPosition()));
            }
            //结束时间不能小于当前时间
            String endTime = request.getEndTime();
            if ("1".equals(request.getState()) && StringUtils.isNotBlank(endTime)) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:sss");
                Date endDate = sdf.parse(endTime);
                Date date = new Date();
                if (endDate.getTime() < date.getTime()) {
                    throw new BizException(BossBizCode.DateError, "endTime" + BossBizCode.DateError.desc());
                }
            }
            if (StringUtils.isNotBlank(request.getOrder())) {//顺位
                if (Integer.valueOf(request.getOrder()) < 1 || Integer.valueOf(request.getOrder()) > 99) {
                    throw new BizException(BossBizCode.showOrder, "展示顺位" + BossBizCode.showOrder.desc());
                }
                $request.setSort(Integer.valueOf(request.getOrder()));
            }
            $request.setPrefixImage(request.getPrefixImage());//图片
            $request.setImagePath(request.getImagePath());
            $request.setShowChannel(request.getQudao());
            if (StringUtils.isNotBlank(request.getState())) {
                $request.setOnline(Integer.valueOf(request.getState()));
            }
            if (StringUtils.isNotBlank(request.getBeginTime())) {
                $request.setStartTime(CommonUtils.parseToDate(request.getBeginTime()));
            } else {
                String time = CommonUtils.parseDate(new Date());
                $request.setStartTime(CommonUtils.parseToDate(time));
            }
            if (StringUtils.isNotBlank(request.getEndTime())) {
                $request.setEndTime(CommonUtils.parseToDate(request.getEndTime()));
            }

            CreateAdvertisementResponse $response = financeRunClient.createAdver($request);
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error(" 广告位编辑页面查询异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("广告位编辑页面查询异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 广告位修改(保存按钮)
     *
     * @param request
     * @return
     */
    @Override
    public UpdateAdverResponse updateAdver(UpdateAdverRequest request) {
        logger.info("接收请求{}", request);
        UpdateAdverResponse response = new UpdateAdverResponse();
        try {
            //结束时间不能小于当前时间
            String endTime = request.getEndTime();
            if ("1".equals(request.getState()) && StringUtils.isNotBlank(endTime)) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:sss");
                Date endDate = sdf.parse(endTime);
                Date date = new Date();
                if (endDate.getTime() < date.getTime()) {
                    throw new BizException(BossBizCode.DateError, "endTime" + BossBizCode.DateError.desc());
                }
            }

            UpdateAdvertisementRequest $request = new UpdateAdvertisementRequest();
            $request.setId(Integer.valueOf(request.getId()));
            $request.setTitle(request.getTitle());
            $request.setEvent(request.getTargetUrl());//广告位链接
            if (StringUtils.isNotBlank(request.getPosition())) {
                $request.setPosition(Integer.valueOf(request.getPosition()));
            }
            if (StringUtils.isNotBlank(request.getOrder())) {//顺位
                if (Integer.valueOf(request.getOrder()) < 1 || Integer.valueOf(request.getOrder()) > 99) {
                    throw new BizException(BossBizCode.showOrder, "展示顺位" + BossBizCode.showOrder.desc());
                }
                $request.setSort(Integer.valueOf(request.getOrder()));
            }
            $request.setPrefixImage(request.getPrefixImage());//图片
            $request.setImagePath(request.getImagePath());
            $request.setShowChannel(request.getQudao());
            if (StringUtils.isNotBlank(request.getState())) {
                $request.setOnline(Integer.valueOf(request.getState()));
            }
            if (StringUtils.isNotBlank(request.getBeginTime())) {
                $request.setStartTime(CommonUtils.parseToDate(request.getBeginTime()));
            } else {
                String time = CommonUtils.parseDate(new Date());
                $request.setStartTime(CommonUtils.parseToDate(time));
            }
            if (StringUtils.isNotBlank(request.getEndTime())) {
                $request.setEndTime(CommonUtils.parseToDate(request.getEndTime()));
            }

            UpdateAdvertisementResponse $response = financeRunClient.updateAdver($request);
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());

        } catch (BaseException e) {
            logger.error(" 广告位编辑保存异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("广告位编辑保存异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }


    /**
     * 广告位上线，下线状态修改
     *
     * @param request
     * @return
     */
    @Override
    public UpdateAdverResponse updateAdverStatus(UpdateAdverRequest request) {
        logger.info("接收请求{}", request);
        UpdateAdverResponse response = new UpdateAdverResponse();
        try {
            UpdateAdvertisementRequest $request = new UpdateAdvertisementRequest();
            $request.setId(Integer.valueOf(request.getId()));
            $request.setOnline(Integer.valueOf(request.getState()));
            UpdateAdvertisementResponse $response = financeRunClient.updateAdverStatus($request);
            response.setCode($response.getCode());
            response.setMessage($response.getMessage());

        } catch (BaseException e) {
            logger.error(" 广告位状态修改异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("广告位状态修改异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }

    /**
     * 广告位删除
     *
     * @param request
     * @return
     */
    @Override
    public UpdateAdverResponse deleteAdver(UpdateAdverRequest request) {
        logger.info("接收请求{}", request);
        UpdateAdverResponse response = new UpdateAdverResponse();
        try {
            DeleteAdvertisementRequest $request = new DeleteAdvertisementRequest();
            $request.setId(Integer.valueOf(request.getId()));
            DeleteAdvertisementResponse $response = financeRunClient.deleteAdver($request);

            response.setCode($response.getCode());
            response.setMessage($response.getMessage());
        } catch (BaseException e) {
            logger.error("广告位删除异常 ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("广告位删除异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }
}