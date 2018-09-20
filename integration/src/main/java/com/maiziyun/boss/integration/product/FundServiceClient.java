package com.maiziyun.boss.integration.product;


import com.maiziyun.mdc.facade.model.DeleteNoticeResponse;
import com.maiziyun.product.facade.model.*;

/**
 * Created by admin on 2017/6/2.
 */
public interface FundServiceClient {

    QueryProductAttrKindByProductTypeResponse getFundItemList(QueryProductAttrKindByProductTypeRequest request);

    QueryProductAttrKindByProductTypeResponse getAllFundItemList(QueryProductAttrKindByProductTypeRequest request);

    UpdateProductAttrKindByIdsResponse fundItemModify(UpdateProductAttrKindByIdsRequest request);

    QueryProductAttrKindByIdResponse querySubDetail(QueryProductAttrKindByIdRequest request);

    UpdateProductAttrKindResponse updateSubDetail(UpdateProductAttrKindRequest request);

    QueryFundNavInfoAndTagResponse  queryHotFund(QueryFundNavInfoAndTagRequest request);

    QueryFundNavInfoPageResponse  queryAllHotFund(QueryFundNavInfoPageRequest request);

    UpdateAttrKindRelByEffectFlagAndTagResponse  HotFundModify(UpdateAttrKindRelByEffectFlagAndTagRequest  request);

    AddProductAttrKindResponse addHotItem(AddProductAttrKindRequest request);

    DeleteProductAttrKindResponse deleteHotItem(DeleteProductAttrKindRequest request);

    QueryFundAllocationResponse queryFundConf(QueryFundAllocationRequest request);

    QueryFundNavInfoPageResponse queryAllFundConf(QueryFundNavInfoPageRequest request);

    FundAllocationResponse  updateFundConf(FundAllocationRequest request);



}
