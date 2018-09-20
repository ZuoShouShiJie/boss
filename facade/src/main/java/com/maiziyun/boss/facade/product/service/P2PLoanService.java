package com.maiziyun.boss.facade.product.service;

import com.maiziyun.boss.facade.product.model.*;

/**
 * Created by admin on 2017/8/31.
 */
public interface P2PLoanService {
    public QueryP2PLoanResponse queryLoanList(QueryP2PLoanRequest request);
    public QueryP2PLoanDetailResponse queryLoanById(QueryP2PLoanDetailRequest request);
    public UpdateP2PLoanResponse updateP2PLoan(UpdateP2PLoanRequest request);

}
