package com.maiziyun.boss.facade.product.service;

import com.maiziyun.boss.facade.product.model.*;

/**
 * Created by admin on 2017/8/29.
 */
public interface HomePageSiteService {
    public QuerySelectFofListResponse querySelectFofListCanbuy(QuerySelectFofListRequest request);
    public QuerySelectFofListResponse querySelectFofList(QuerySelectFofListRequest request);
    public UpdateSelectFofListResponse updateSelectFofList(UpdateSelectFofListRequest request);

    public QueryFirP2PLoanResponse queryLoanList(QueryP2PLoanRequest request);
    public QueryLoanSiteResponse queryLoanSite(QueryLoanSiteRequest request);
    public UpdateLoanSiteResponse updateLoanSite(UpdateLoanSiteRequest request);

    public SelectFundListResponse querySelectFund(SelectFundListRequest request);
    public SelectFundListResponse querySelectFundAll(SelectFundListRequest request);
    public UpdateSelectFundResponse updateSelectFund(UpdateSelectFundRequest request);

}
