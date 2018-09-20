package com.maiziyun.boss.integration.group.impl;

import com.maiziyun.boss.integration.group.FundGroupServiceClient;
import com.maiziyun.common.enums.MyServiceCode;
import com.maiziyun.product.facade.ExchangeSelectedService;
import com.maiziyun.product.facade.ProductGroupManagerService;
import com.maiziyun.product.facade.ProductGroupSelectedService;
import com.maiziyun.product.facade.ProductSelectedService;
import com.maiziyun.product.facade.model.*;
import com.solar.framework.core.enums.SourceCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 2017/11/21.
 */
public class FundGroupServiceClientImpl implements FundGroupServiceClient {
    private static Logger logger = LoggerFactory.getLogger(FundGroupServiceClientImpl.class);
    private ProductGroupManagerService productGroupManagerService;
    private ExchangeSelectedService exchangeSelectedService;
    private ProductSelectedService productSelectedService;
    private ProductGroupSelectedService productGroupSelectedService;

    public void setProductGroupManagerService(ProductGroupManagerService productGroupManagerService) {
        this.productGroupManagerService = productGroupManagerService;
    }

    public void setExchangeSelectedService(ExchangeSelectedService exchangeSelectedService) {
        this.exchangeSelectedService = exchangeSelectedService;
    }

    public void setProductSelectedService(ProductSelectedService productSelectedService) {
        this.productSelectedService = productSelectedService;
    }

    public void setProductGroupSelectedService(ProductGroupSelectedService productGroupSelectedService) {
        this.productGroupSelectedService = productGroupSelectedService;
    }

    @Override
    public AddProductGroup4BossResponse addGroupProduct(AddProductGroup4BossRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向产品发送请求：{}", request);
        AddProductGroup4BossResponse response = productGroupManagerService.addProductGroup4Boss(request);
        logger.info("产品返回数据：{}", response);
        return response;
    }

    @Override
    public UpdateProductGroupResponse updateProductGroup(UpdateProductGroupRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向产品发送请求：{}", request);
        UpdateProductGroupResponse response = productGroupManagerService.updateProductGroup(request);
        logger.info("产品返回数据：{}", response);
        return response;
    }

    @Override
    public QueryProductGroupByConditionResponse queryProductGroupBycondition(QueryProductGroupByConditionRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向产品发送请求：{}", request);
        QueryProductGroupByConditionResponse response = productGroupSelectedService.queryProductGroupBycondition(request);
        logger.info("产品返回数据：{}", response);
        return response;
    }

    @Override
    public QueryProductGroupByIdResponse queryGroupProductById(QueryProductGroupByIdRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向产品发送请求：{}", request);
        QueryProductGroupByIdResponse response = productGroupSelectedService.queryProductGroupById(request);
        logger.info("产品返回数据：{}", response);
        return response;
    }

    @Override
    public QueryLiveProductByNameResponse queryFundProduct(QueryLiveProductByNameRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向产品发送请求：{}", request);
        QueryLiveProductByNameResponse response = productSelectedService.queryLiveProductByName(request);
        logger.info("产品返回数据：{}", response);
        return response;
    }

    @Override
    public QueryExchangeProductByNameResponse querySolidProduct(QueryExchangeProductByNameRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向产品发送请求：{}", request);
        QueryExchangeProductByNameResponse response = exchangeSelectedService.queryExchangeProductByName(request);
        logger.info("产品返回数据：{}", response);
        return response;
    }


}
