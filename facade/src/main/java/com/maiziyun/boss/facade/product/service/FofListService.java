package com.maiziyun.boss.facade.product.service;

import com.maiziyun.boss.facade.product.model.*;

/**
 * Created by admin on 2017/7/22.
 */
public interface FofListService {
    public QueryFofListResponse queryFofListCanbuy(QueryFofListRequest request);
    public QueryFofListResponse queryFofList(QueryFofListRequest request);
    public QueryFofDetailResponse queryFofDetail(QueryFofDetailRequest request);
    public UpdateFofListResponse updateFofList(UpdateFofListRequest request);
    public UpdateFofSortResponse updateFofSort(UpdateFofSortRequest request);
    public QueryFofSiteResponse queryFofSite(QueryFofSiteRequest request);
    public UpdateFofListShowStsResponse updateFofListShowSts(UpdateFofListShowStsRequest request);
}
