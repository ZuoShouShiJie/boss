package com.maiziyun.boss.integration.product.impl;

import com.maiziyun.boss.integration.product.P2PLoanServiceClient;
import com.maiziyun.common.enums.MyServiceCode;
import com.maiziyun.product.facade.ProductP2PInfoService;
import com.maiziyun.product.facade.model.*;
import com.solar.framework.core.enums.SourceCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 2017/8/31.
 */
public class P2PLoanServiceClientImpl implements P2PLoanServiceClient {
    private static final Logger logger = LoggerFactory.getLogger(P2PLoanServiceClientImpl.class);
    private ProductP2PInfoService productP2PInfoService;

    public void setProductP2PInfoService(ProductP2PInfoService productP2PInfoService) {
        this.productP2PInfoService = productP2PInfoService;
    }

    @Override
    public QueryP2PInfoByExpectPageResponse queryLoanList(QueryP2PInfoByExpectPageRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product网贷发送请求：{}",request);
        QueryP2PInfoByExpectPageResponse response = productP2PInfoService.queryP2PInfoByExpectPage(request);
        logger.info("product网贷返回数据：{}", response);
        return response;
    }

    @Override
    public QueryP2PInfoConfigTypeResponse queryLoanListExpect(QueryP2PInfoConfigTypeRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product网贷发送请求：{}",request);
        QueryP2PInfoConfigTypeResponse response = productP2PInfoService.queryP2PInfoConfigType(request);
        logger.info("product网贷返回数据：{}", response);
        return response;
    }

    @Override
    public QueryProductP2PInfoByProductIdResponse queryLoanById(QueryProductP2PInfoByProductIdRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product网贷发送请求：{}",request);
        QueryProductP2PInfoByProductIdResponse response = productP2PInfoService.queryProductP2PInfoByProductId(request);
        logger.info("product网贷返回数据：{}", response);
        return response;
    }

    @Override
    public UpdateP2PInfoByProductIdAndAttrResponse updateP2PLoan(UpdateP2PInfoByProductIdAndAttrRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product网贷发送请求：{}",request);
        UpdateP2PInfoByProductIdAndAttrResponse response = productP2PInfoService.updateP2PInfoByProductIdAndAttr(request);
        logger.info("product网贷返回数据：{}", response);
        return response;
    }

    @Override
    public QueryBuyP2PInfoSortResponse queryLoanList(QueryBuyP2PInfoSortRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product首页网贷发送请求：{}",request);
        QueryBuyP2PInfoSortResponse response = productP2PInfoService.queryBuyP2PInfoSort(request);
        logger.info("product首页网贷返回数据：{}", response);
        return response;
    }

    @Override
    public QueryP2PInfoConfigResponse queryLoanSite(QueryP2PInfoConfigRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product首页网贷发送请求：{}",request);
        QueryP2PInfoConfigResponse response = productP2PInfoService.queryP2PInfoConfig(request);
        logger.info("product首页网贷返回数据：{}", response);
        return response;
    }

    @Override
    public UpdateBuyP2PInfoSortResponse updateLoanSite(UpdateBuyP2PInfoSortRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product首页网贷发送请求：{}",request);
        UpdateBuyP2PInfoSortResponse response = productP2PInfoService.updateBuyP2PInfoSort(request);
        logger.info("product首页网贷返回数据：{}", response);
        return response;
    }
}
