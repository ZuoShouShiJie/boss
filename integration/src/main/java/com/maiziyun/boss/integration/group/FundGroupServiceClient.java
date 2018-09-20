package com.maiziyun.boss.integration.group;

import com.maiziyun.product.facade.model.*;

/**
 * Created by admin on 2017/11/21.
 */
public interface FundGroupServiceClient {
    //查询组合列表
    QueryProductGroupByConditionResponse queryProductGroupBycondition(QueryProductGroupByConditionRequest request);
//查询组合产品详情
    QueryProductGroupByIdResponse queryGroupProductById(QueryProductGroupByIdRequest request);
    //新增
    AddProductGroup4BossResponse addGroupProduct(AddProductGroup4BossRequest request);
//修改组合配置
    UpdateProductGroupResponse updateProductGroup(UpdateProductGroupRequest request);

    //查询基金产品
    QueryLiveProductByNameResponse queryFundProduct(QueryLiveProductByNameRequest request);

    //查询交易所产品
    QueryExchangeProductByNameResponse querySolidProduct(QueryExchangeProductByNameRequest request);
}
