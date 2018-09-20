package com.maiziyun.boss.biz.product.service;

import com.maiziyun.boss.facade.product.model.*;
import com.maiziyun.boss.facade.product.service.HomePageSiteService;

/**
 * Created by admin on 2017/8/29.
 */
public interface LocalHomePageSiteService extends HomePageSiteService {
    public QuerySelectFofListResponse querySelectFofListCanbuy(QuerySelectFofListRequest request); //首页精选策略组合
    public QuerySelectFofListResponse querySelectFofList(QuerySelectFofListRequest request);//首页精选策略组合
    public UpdateSelectFofListResponse updateSelectFofList(UpdateSelectFofListRequest request);//首页精选策略组合

    @Override
    QueryFirP2PLoanResponse queryLoanList(QueryP2PLoanRequest request);

    @Override
    UpdateLoanSiteResponse updateLoanSite(UpdateLoanSiteRequest request);

    @Override
    QueryLoanSiteResponse queryLoanSite(QueryLoanSiteRequest request);

    public SelectFundListResponse querySelectFund(SelectFundListRequest request); //首页精选基金
    public SelectFundListResponse querySelectFundAll(SelectFundListRequest request); //首页精选基金
    public UpdateSelectFundResponse updateSelectFund(UpdateSelectFundRequest request); //首页精选基金
}
