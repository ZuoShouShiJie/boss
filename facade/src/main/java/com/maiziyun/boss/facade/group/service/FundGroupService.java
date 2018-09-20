package com.maiziyun.boss.facade.group.service;

import com.maiziyun.boss.facade.common.model.ResponseNewData;
import com.maiziyun.boss.facade.group.model.FundGroupListQueryRequest;
import com.maiziyun.boss.facade.group.model.FundGroupUpdateRequest;

/**
 * Created by admin on 2017/11/21.
 */
public interface FundGroupService {
    ResponseNewData queryGroupProductList(FundGroupListQueryRequest request);
    ResponseNewData queryGroupProductById(FundGroupListQueryRequest request);
    ResponseNewData updateGroupProduct(FundGroupUpdateRequest request);
    ResponseNewData queryFundProduct(FundGroupListQueryRequest request);
    ResponseNewData querySolidProduct(FundGroupListQueryRequest request);

}
