package com.maiziyun.boss.integration.product.impl;

import com.maiziyun.boss.facade.product.model.QueryFofSiteRequest;
import com.maiziyun.boss.facade.product.model.QueryFofSiteResponse;
import com.maiziyun.boss.integration.product.FofListServiceClient;
import com.maiziyun.common.enums.MyServiceCode;
import com.maiziyun.product.facade.ProductFOFInfoService;
import com.maiziyun.product.facade.model.*;
import com.solar.framework.core.enums.SourceCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 2017/7/22.
 */
public class FofListServiceClientImpl implements FofListServiceClient {
    private static final Logger logger = LoggerFactory.getLogger(FofListServiceClientImpl.class);
    private ProductFOFInfoService productFOFInfoService;

    public void setProductFOFInfoService(ProductFOFInfoService productFOFInfoService) {
        this.productFOFInfoService = productFOFInfoService;
    }

    @Override
    public QueryFOFInfoBuyResponse queryFofListCanbuy(QueryFOFInfoBuyRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product组合发送请求：{}",request);
        QueryFOFInfoBuyResponse response = productFOFInfoService.queryFOFInfoBuy(request);
        logger.info("product组合返回数据：{}", response);
        return response;
    }

    @Override
    public QueryFOFAndFOFNavInfoAllPageResponse queryFofList(QueryFOFAndFOFNavInfoAllPageRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product组合发送请求：{}",request);
        QueryFOFAndFOFNavInfoAllPageResponse response = productFOFInfoService.queryFOFAndFOFInfoAll(request);
        logger.info("product组合返回数据：{}", response);
        return response;

    }

    @Override
    public QueryFOFAndFOFNavInfoAllByProductIdResponse queryFofDetail(QueryFOFAndFOFNavInfoAllByProductIdRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product组合发送请求：{}",request);
        QueryFOFAndFOFNavInfoAllByProductIdResponse response = productFOFInfoService.queryFOFAndFOFNavInfoAllByProductId(request);
        logger.info("product组合返回数据：{}", response);
        return response;
    }

    /**
     * 组合排序修改
     * @param request
     * @return
     */
    @Override
    public UpdateFOFInfoSortResponse updateFofSort(UpdateFOFInfoSortRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product组合发送请求：{}",request);
        UpdateFOFInfoSortResponse response = productFOFInfoService.updateFOFInfoSort(request);
        logger.info("product组合返回数据：{}", response);
        return response;
    }

    @Override
    public UpdateFOFAndFOFNavInfoAllByProductIdResponse updateFofList(UpdateFOFAndFOFNavInfoAllByProductIdRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product组合发送请求：{}",request);
        UpdateFOFAndFOFNavInfoAllByProductIdResponse response = productFOFInfoService.updateFOFAndFOFNavInfoAllByProductId(request);
        logger.info("product组合返回数据：{}", response);
        return response;
    }

    @Override
    public QueryBuyFOFInfoPageResponse queryFofSite(QueryBuyFOFInfoPageRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product组合发送请求：{}",request);
        QueryBuyFOFInfoPageResponse response = productFOFInfoService.queryBuyFOFInfoPage(request);
        logger.info("product组合返回数据：{}", response);
        return response;
    }

    @Override
    public UpdateFOFInfoEffectByProductIdResponse updateFofListShowSts(UpdateFOFInfoEffectByProductIdRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product组合发送请求：{}",request);
        UpdateFOFInfoEffectByProductIdResponse response = productFOFInfoService.updateFOFInfoEffectByProductId(request);
        logger.info("product组合返回数据：{}", response);
        return response;
    }


    @Override
    public QueryFOFInfoEffectResponse querySelectFofListCanbuy(QueryFOFInfoEffectRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product组合发送请求：{}",request);
        QueryFOFInfoEffectResponse response = productFOFInfoService.queryFOFInfoEffect(request);
        logger.info("product组合返回数据：{}", response);
        return response;
    }

    @Override
    public QueryBuyFOFInfoPageResponse querySelectFofList(QueryBuyFOFInfoPageRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product组合发送请求：{}",request);
        QueryBuyFOFInfoPageResponse response = productFOFInfoService.queryBuyFOFInfoPage(request);
        logger.info("product组合返回数据：{}", response);
        return response;
    }

    @Override
    public UpdateFOFInfoEffectResponse updateSelectFofList(UpdateFOFInfoEffectRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product组合发送请求：{}",request);
        UpdateFOFInfoEffectResponse response = productFOFInfoService.updateFOFInfoEffect(request);
        logger.info("product组合返回数据：{}", response);
        return response;
    }
}
