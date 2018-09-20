package com.maiziyun.boss.biz.product.service;

import com.maiziyun.boss.facade.product.model.*;
import com.maiziyun.boss.facade.product.service.P2PLoanService;

/**
 * Created by admin on 2017/8/31.
 */
public interface LocalP2PLoanService extends P2PLoanService {
    public QueryP2PLoanResponse queryLoanList(QueryP2PLoanRequest request);
    public QueryP2PLoanDetailResponse queryLoanById(QueryP2PLoanDetailRequest request);
    public UpdateP2PLoanResponse updateP2PLoan(UpdateP2PLoanRequest request);

}
