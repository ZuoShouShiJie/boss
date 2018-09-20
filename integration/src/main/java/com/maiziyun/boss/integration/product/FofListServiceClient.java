package com.maiziyun.boss.integration.product;

import com.maiziyun.boss.facade.product.model.QueryFofSiteRequest;
import com.maiziyun.boss.facade.product.model.QueryFofSiteResponse;
import com.maiziyun.product.facade.model.*;

/**
 * Created by admin on 2017/7/22.
 */
public interface FofListServiceClient {
    QueryFOFInfoBuyResponse queryFofListCanbuy(QueryFOFInfoBuyRequest request);
    QueryFOFAndFOFNavInfoAllPageResponse queryFofList(QueryFOFAndFOFNavInfoAllPageRequest request);
    QueryFOFAndFOFNavInfoAllByProductIdResponse queryFofDetail(QueryFOFAndFOFNavInfoAllByProductIdRequest request);
    UpdateFOFAndFOFNavInfoAllByProductIdResponse updateFofList(UpdateFOFAndFOFNavInfoAllByProductIdRequest request);
    UpdateFOFInfoSortResponse updateFofSort(UpdateFOFInfoSortRequest request);  //组合排序修改
    QueryBuyFOFInfoPageResponse queryFofSite(QueryBuyFOFInfoPageRequest request);

    UpdateFOFInfoEffectByProductIdResponse updateFofListShowSts(UpdateFOFInfoEffectByProductIdRequest request);


    QueryFOFInfoEffectResponse  querySelectFofListCanbuy(QueryFOFInfoEffectRequest request);
    QueryBuyFOFInfoPageResponse querySelectFofList(QueryBuyFOFInfoPageRequest request);
    UpdateFOFInfoEffectResponse updateSelectFofList(UpdateFOFInfoEffectRequest $request);


}
