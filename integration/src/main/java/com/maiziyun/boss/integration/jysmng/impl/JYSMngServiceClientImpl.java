package com.maiziyun.boss.integration.jysmng.impl;

import com.maiziyun.boss.integration.jysmng.JYSMngServiceClient;
import com.maiziyun.cif.facade.UserInfoService;
import com.maiziyun.cif.facade.model.QueryCustomRequest;
import com.maiziyun.cif.facade.model.QueryCustomResponse;
import com.maiziyun.cif.facade.model.QueryUserListRequest;
import com.maiziyun.cif.facade.model.QueryUserListResponse;
import com.maiziyun.common.enums.MyServiceCode;
import com.maiziyun.fmgw.facade.j2p.acct.J2PGetFundFlowRequest;
import com.maiziyun.fund.trade.facade.CoreQueryService;
import com.maiziyun.fund.trade.facade.model.fixed.QueryFixedProductInvestmentRecordListRequest;
import com.maiziyun.fund.trade.facade.model.fixed.QueryFixedProductInvestmentRecordListResponse;
import com.maiziyun.mgw.facade.TransReceiverService;
import com.maiziyun.mgw.facade.model.MgwResult;
import com.maiziyun.product.facade.ExchangeManagerService;
import com.maiziyun.product.facade.ExchangeSelectedService;
import com.maiziyun.product.facade.model.*;
import com.solar.framework.core.enums.SourceCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 2017/11/4.
 */
public class JYSMngServiceClientImpl implements JYSMngServiceClient {
    private static Logger logger = LoggerFactory.getLogger(JYSMngServiceClientImpl.class);

    private ExchangeSelectedService exchangeService;
    private ExchangeManagerService exchangeManagerService;
    //
    private UserInfoService userInfoService;
    private CoreQueryService trdCoreQueryService;
    //调网关
    private TransReceiverService transReceiverService;


    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    public void setExchangeManagerService(ExchangeManagerService exchangeManagerService) {
        this.exchangeManagerService = exchangeManagerService;
    }

    public void setExchangeService(ExchangeSelectedService exchangeService) {
        this.exchangeService = exchangeService;
    }

    public void setTrdCoreQueryService(CoreQueryService trdCoreQueryService) {
        this.trdCoreQueryService = trdCoreQueryService;
    }

    public void setTransReceiverService(TransReceiverService transReceiverService) {
        this.transReceiverService = transReceiverService;
    }

    @Override
    public MgwResult getFundFlow(J2PGetFundFlowRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向交易所发送请求：{}", request);
        MgwResult mgwResult = transReceiverService.syncSendAndReceive(request);
        logger.info("交易所返回数据：{}", mgwResult);
        return mgwResult;
    }

    @Override
    public QueryCustomResponse queryUserMsg(QueryCustomRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向交易所发送请求：{}", request);
        QueryCustomResponse response = userInfoService.getByNameOrMobile(request);
        logger.info("交易所返回数据：{}", response);
        return response;
    }

    @Override
    public QueryUserListResponse fundsRecordQuery(QueryUserListRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向交易所发送请求：{}", request);
        QueryUserListResponse response = userInfoService.queryUserList(request);
        logger.info("交易所返回数据：{}", response);
        return response;
    }

    @Override
    public QueryFixedProductInvestmentRecordListResponse userInvestListQuery(QueryFixedProductInvestmentRecordListRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向交易所发送请求：{}", request);
        QueryFixedProductInvestmentRecordListResponse response = trdCoreQueryService.queryFixedProductInvestmentRecordList(request);
        logger.info("交易所返回数据：{}", response);
        return response;
    }

    @Override
    public QueryExchangeProjectByConditionResponse projectConfQuery(QueryExchangeProjectByConditionRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向交易所发送请求：{}", request);
        QueryExchangeProjectByConditionResponse response = exchangeService.queryExchangeProjectByCondition(request);
        logger.info("交易所返回数据：{}", response);
        return response;
    }

    @Override
    public AddExchangeProjectResponse addExchangeProject(AddExchangeProjectRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向交易所发送请求：{}", request);
        AddExchangeProjectResponse response = exchangeManagerService.addExchangeProject(request);
        logger.info("交易所返回数据：{}", response);
        return response;
    }

    @Override
    public UpdateExchangeProjectResponse updateExchangeProject(UpdateExchangeProjectRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向交易所发送请求：{}", request);
        UpdateExchangeProjectResponse response = exchangeManagerService.updateExchangeProject(request);
        logger.info("交易所返回数据：{}", response);
        return response;
    }

    @Override
    public QueryAllExchangeResponse queryAllExchange(QueryAllExchangeRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向交易所发送请求：{}", request);
        QueryAllExchangeResponse response = exchangeService.queryAllExchange(request);
        logger.info("交易所返回数据：{}", response);
        return response;
    }

    @Override
    public QueryExchangePublisherInfoResponse queryAllExchangePublisher(QueryExchangePublisherInfoRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向交易所发送请求：{}", request);
        QueryExchangePublisherInfoResponse response = exchangeService.queryAllExchangePublisher(request);
        logger.info("交易所返回数据：{}", response);
        return response;

    }

    @Override
    public QueryProjectContractTypeResponse queryProjectProtocolList(QueryProjectContractTypeRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向交易所发送请求：{}", request);
        QueryProjectContractTypeResponse response = exchangeService.queryProjectContractType(request);
        logger.info("交易所返回数据：{}", response);
        return response;

    }

    @Override
    public QueryExchangeProductByConditionResponse productConfQuery(QueryExchangeProductByConditionRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向交易所发送请求：{}", request);
        QueryExchangeProductByConditionResponse response = exchangeService.queryExchangeProductByCondition(request);
        logger.info("交易所返回数据：{}", response);
        return response;
    }

    @Override
    public QueryExchangeProjectByExchangeResponse queryExchangeProjectByExchange(QueryExchangeProjectByExchangeRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向交易所发送请求：{}", request);
        QueryExchangeProjectByExchangeResponse response = exchangeService.queryExchangeProjectByExchange(request);
        logger.info("交易所返回数据：{}", response);
        return response;
    }

    @Override
    public AddExchangeProductResponse addExchangeProduct(AddExchangeProductRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向交易所发送请求：{}", request);
        AddExchangeProductResponse response = exchangeManagerService.addExchangeProduct(request);
        logger.info("交易所返回数据：{}", response);
        return response;
    }

    @Override
    public UpdateExchangeProductResponse updateExchangeProduct(UpdateExchangeProductRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向交易所发送请求：{}", request);
        UpdateExchangeProductResponse response = exchangeManagerService.updateExchangeProduct(request);
        logger.info("交易所返回数据：{}", response);
        return response;
    }

    @Override
    public UpdateExchangeProductByIdResponse releaseProd(UpdateExchangeProductByIdRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向交易所发送请求：{}", request);
        UpdateExchangeProductByIdResponse response = exchangeManagerService.updateExchangeProductById(request);
        logger.info("交易所返回数据：{}", response);
        return response;
    }

    @Override
    public DeleteExchangeProductResponse deleteExchangeProduct(DeleteExchangeProductRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向交易所发送请求：{}", request);
        DeleteExchangeProductResponse response = exchangeManagerService.deleteExchangeProduct(request);
        logger.info("交易所返回数据：{}", response);
        return response;
    }
}
