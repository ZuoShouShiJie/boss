package com.maiziyun.boss.integration.product.impl;

import com.maiziyun.boss.integration.product.HomePageSiteClient;
import com.maiziyun.common.enums.MyServiceCode;
import com.maiziyun.product.facade.ProductAttrService;
import com.maiziyun.product.facade.model.*;
import com.solar.framework.core.enums.SourceCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 2017/9/4.
 */
public class HomePageSiteClientImpl implements HomePageSiteClient {
    Logger logger = LoggerFactory.getLogger(HomePageSiteClientImpl.class);

    private ProductAttrService productAttrService;

    public void setProductAttrService(ProductAttrService productAttrService) {
        this.productAttrService = productAttrService;
    }

    @Override
    public QueryWellChosenFundNavInfoAttrValResponse querySelectFund(QueryWellChosenFundNavInfoAttrValRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product首页精选基金发送请求：{}",request);
        QueryWellChosenFundNavInfoAttrValResponse response = productAttrService.queryWellChosenFundNavInfoAttrVal(request);
        logger.info("product首页精选基金返回数据：{}", response);
        return response;
    }

    @Override
    public QueryWellChosenFundNavInfoPageResponse querySelectFundAll(QueryWellChosenFundNavInfoPageRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product首页精选基金发送请求：{}",request);
        QueryWellChosenFundNavInfoPageResponse response = productAttrService.queryWellChosenFundNavInfoPage(request);
        logger.info("product首页精选基金返回数据：{}", response);
        return response;
    }

    @Override
    public UpdateWellChosenAttrKindRelResponse updateSelectFund(UpdateWellChosenAttrKindRelRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product首页精选基金发送请求：{}",request);
        UpdateWellChosenAttrKindRelResponse response = productAttrService.updateWellChosenAttrKindRel(request);
        logger.info("product首页精选基金返回数据：{}", response);
        return response;
    }
}
