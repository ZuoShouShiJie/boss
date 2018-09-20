package com.maiziyun.boss.integration.product.impl;

import com.maiziyun.boss.integration.product.FundServiceClient;
import com.maiziyun.common.enums.MyServiceCode;
import com.maiziyun.mdc.facade.model.DeleteNoticeResponse;
import com.maiziyun.product.facade.ProductAttrService;
import com.maiziyun.product.facade.model.*;
import com.solar.framework.core.enums.SourceCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 2017/6/2.
 */
public class FundServiceClientImpl implements  FundServiceClient{
    private static final Logger logger = LoggerFactory.getLogger(FundServiceClientImpl.class);

    private ProductAttrService productAttrService;

    public void setProductAttrService(ProductAttrService productAttrService) {
        this.productAttrService = productAttrService;
    }

    @Override
    public QueryProductAttrKindByProductTypeResponse getFundItemList(QueryProductAttrKindByProductTypeRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product发送请求：{}",request);
        QueryProductAttrKindByProductTypeResponse response  = productAttrService.queryProductAttrKindByProductType(request);
        logger.info("product返回数据：{}", response);
        return response;
    }

    @Override
    public QueryProductAttrKindByProductTypeResponse getAllFundItemList(QueryProductAttrKindByProductTypeRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product发送请求：{}",request);
        QueryProductAttrKindByProductTypeResponse response  = productAttrService.queryProductAttrKindByStatus(request);
        logger.info("product返回数据：{}", response);
        return response;
    }

    @Override
    public UpdateProductAttrKindByIdsResponse fundItemModify(UpdateProductAttrKindByIdsRequest request){
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product发送请求：{}",request);
        UpdateProductAttrKindByIdsResponse  response = productAttrService.updateProductAttrKindById(request);
        logger.info("product返回数据：{}", response);
        return response;
    }

    @Override
    public QueryProductAttrKindByIdResponse querySubDetail(QueryProductAttrKindByIdRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product发送请求：{}",request);
        QueryProductAttrKindByIdResponse response = productAttrService.queryProductAttrKindById(request);
        logger.info("product返回数据：{}", response);
        return response;
    }

    @Override
    public UpdateProductAttrKindResponse updateSubDetail(UpdateProductAttrKindRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product发送请求：{}",request);
        UpdateProductAttrKindResponse response = productAttrService.updateProductAttrKindByAttrKind(request);
        logger.info("product返回数据：{}", response);
        return response;
    }

    @Override
    public QueryFundNavInfoAndTagResponse queryHotFund(QueryFundNavInfoAndTagRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product发送请求：{}",request);
        QueryFundNavInfoAndTagResponse response = productAttrService.queryFundNavInfoAndTag(request);
        logger.info("product返回数据：{}", response);
        return response;
    }

    @Override
    public QueryFundNavInfoPageResponse  queryAllHotFund(QueryFundNavInfoPageRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product发送请求：{}",request);
        QueryFundNavInfoPageResponse  response = productAttrService.queryFundNavInfoPage(request);
        logger.info("product返回数据：{}", response);
        return response;
    }

    @Override
    public UpdateAttrKindRelByEffectFlagAndTagResponse  HotFundModify(UpdateAttrKindRelByEffectFlagAndTagRequest  request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product发送请求：{}",request);
        UpdateAttrKindRelByEffectFlagAndTagResponse   response = productAttrService.updateProductEffectFlagAndTag(request);
        logger.info("product返回数据：{}", response);
        return response;
    }

    @Override
    public AddProductAttrKindResponse addHotItem(AddProductAttrKindRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product发送请求：{}",request);
        AddProductAttrKindResponse   response = productAttrService.addProductAttrKind(request);
        logger.info("product返回数据：{}", response);
        return response;
    }

    @Override
    public DeleteProductAttrKindResponse deleteHotItem(DeleteProductAttrKindRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product发送请求：{}",request);
        DeleteProductAttrKindResponse response = productAttrService.deleteProductAttrKind(request);
        logger.info("product返回数据：{}", response);
        return response;
    }

    @Override
    public QueryFundAllocationResponse queryFundConf(QueryFundAllocationRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product发送请求：{}",request);
        QueryFundAllocationResponse response = productAttrService.queryFundAllocation(request);
        logger.info("product返回数据：{}", response);
        return response;
    }

    @Override
    public QueryFundNavInfoPageResponse queryAllFundConf(QueryFundNavInfoPageRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product发送请求：{}",request);
        QueryFundNavInfoPageResponse response = productAttrService.queryFundAllocationPage(request);
        logger.info("product返回数据：{}", response);
        return response;
    }

    @Override
    public FundAllocationResponse updateFundConf(FundAllocationRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向product发送请求：{}",request);
        FundAllocationResponse response = productAttrService.fundAllocation(request);
        logger.info("product返回数据：{}", response);
        return response;
    }
}
