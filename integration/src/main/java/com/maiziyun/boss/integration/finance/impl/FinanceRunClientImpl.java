package com.maiziyun.boss.integration.finance.impl;

import com.maiziyun.boss.integration.finance.FinanceRunClient;
import com.maiziyun.cms.facade.AdvertisementInfoManagerService;
import com.maiziyun.cms.facade.PositionManagerService;
import com.maiziyun.cms.facade.model.*;
import com.maiziyun.common.enums.MyServiceCode;
import com.maiziyun.product.facade.model.QueryProductAttrKindByProductTypeResponse;
import com.solar.framework.core.enums.BizCode;
import com.solar.framework.core.enums.SourceCode;
import com.solar.framework.core.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 2017/6/16.
 */
public class FinanceRunClientImpl implements FinanceRunClient {
    private static final Logger logger = LoggerFactory.getLogger(FinanceRunClientImpl.class);

    private AdvertisementInfoManagerService advertisementInfoManagerService;
    private PositionManagerService positionManagerService;

    public void setAdvertisementInfoManagerService(AdvertisementInfoManagerService advertisementInfoManagerService) {
        this.advertisementInfoManagerService = advertisementInfoManagerService;
    }

    public void setPositionManagerService(PositionManagerService positionManagerService) {
        this.positionManagerService = positionManagerService;
    }

    /**
     * 查询广告位,查询全部
     * @param request
     * @return
     */
    @Override
    public QueryAdvertisementManagerResponse queryAdvertisement(QueryAdvertisementManagerRequest request){
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("调用cms开始",request);
        QueryAdvertisementManagerResponse response = advertisementInfoManagerService.queryAdvertisement(request);
        logger.info("调用cms结束",response);
        return response;

    }

    @Override
    public QueryPositionResponse queryPositionByAppCode(QueryPositionRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("调用cms开始",request);
        QueryPositionResponse response =  positionManagerService.queryPositionByAppCode(request);
        logger.info("调用cms结束",response);
        return response;
    }

    /**
     *  编辑查询页面,（通过id查询）
     * @param request
     * @return
     */
    @Override
    public QueryAdvertisementManagerResponse queryAdverById(QueryAdvertisementManagerRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("调用cms开始",request);
        QueryAdvertisementManagerResponse response = advertisementInfoManagerService.queryAdvertisement(request);
        logger.info("调用cms结束",response);
        return response;
    }

    /**
     * 广告位新增
     * @param request
     * @return
     */
    @Override
    public CreateAdvertisementResponse createAdver(CreateAdvertisementRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("调用cms开始",request);
        CreateAdvertisementResponse response = advertisementInfoManagerService.createAdvertisement(request);
        logger.info("调用cms结束",response);
        return response;
    }

    /**
     * 广告位修改(保存按钮)
     * @param request
     * @return
     */
    @Override
    public UpdateAdvertisementResponse updateAdver(UpdateAdvertisementRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("调用cms开始",request);
        UpdateAdvertisementResponse response = advertisementInfoManagerService.updateAdvertisement(request);
        logger.info("调用cms结束",response);
        return response;
    }

    /**
     * 广告位上线，下线状态修改
     * @param request
     * @return
     */
    @Override
    public UpdateAdvertisementResponse updateAdverStatus(UpdateAdvertisementRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("调用cms开始",request);
        UpdateAdvertisementResponse response = advertisementInfoManagerService.updateAdvertisement(request);
        logger.info("调用cms结束",response);
        return response;
    }

    @Override
    public DeleteAdvertisementResponse deleteAdver(DeleteAdvertisementRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("调用cms开始",request);
        DeleteAdvertisementResponse response = advertisementInfoManagerService.deleteAdvertisement(request);
        logger.info("调用cms结束",response);
        return response;
    }
}
