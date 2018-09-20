package com.maiziyun.boss.integration.jysmng;

import com.maiziyun.cif.facade.model.QueryCustomRequest;
import com.maiziyun.cif.facade.model.QueryCustomResponse;
import com.maiziyun.cif.facade.model.QueryUserListRequest;
import com.maiziyun.cif.facade.model.QueryUserListResponse;
import com.maiziyun.fmgw.facade.j2p.acct.J2PGetFundFlowRequest;
import com.maiziyun.fmgw.facade.j2p.acct.J2PGetFundFlowResponse;
import com.maiziyun.fund.trade.facade.model.fixed.QueryFixedProductInvestmentRecordListRequest;
import com.maiziyun.fund.trade.facade.model.fixed.QueryFixedProductInvestmentRecordListResponse;
import com.maiziyun.mgw.facade.model.MgwResult;
import com.maiziyun.product.facade.model.*;

/**
 * Created by admin on 2017/11/4.
 */
public interface JYSMngServiceClient {
    QueryFixedProductInvestmentRecordListResponse userInvestListQuery(QueryFixedProductInvestmentRecordListRequest request);
    QueryCustomResponse queryUserMsg(QueryCustomRequest request);
    QueryUserListResponse fundsRecordQuery(QueryUserListRequest request);
    QueryExchangeProjectByConditionResponse projectConfQuery(QueryExchangeProjectByConditionRequest request);
    AddExchangeProjectResponse addExchangeProject(AddExchangeProjectRequest request);
    UpdateExchangeProjectResponse updateExchangeProject(UpdateExchangeProjectRequest request);
    QueryAllExchangeResponse queryAllExchange(QueryAllExchangeRequest request);
    MgwResult getFundFlow(J2PGetFundFlowRequest request);

    QueryExchangePublisherInfoResponse queryAllExchangePublisher(QueryExchangePublisherInfoRequest request);
    QueryProjectContractTypeResponse queryProjectProtocolList(QueryProjectContractTypeRequest request);
    QueryExchangeProductByConditionResponse productConfQuery(QueryExchangeProductByConditionRequest request);
    QueryExchangeProjectByExchangeResponse queryExchangeProjectByExchange(QueryExchangeProjectByExchangeRequest request);
    AddExchangeProductResponse addExchangeProduct(AddExchangeProductRequest request);
    UpdateExchangeProductResponse updateExchangeProduct(UpdateExchangeProductRequest request);
    UpdateExchangeProductByIdResponse releaseProd(UpdateExchangeProductByIdRequest request);
    DeleteExchangeProductResponse deleteExchangeProduct(DeleteExchangeProductRequest request);


}
