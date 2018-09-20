package com.maiziyun.boss.facade.finance.service;

import com.maiziyun.boss.facade.finance.model.QueryAdvertisementRequest;
import com.maiziyun.boss.facade.finance.model.QueryAdvertisementResponse;
import com.maiziyun.boss.facade.finance.model.UpdateAdverRequest;
import com.maiziyun.boss.facade.finance.model.UpdateAdverResponse;

/**
 * Created by admin on 2017/6/16.
 */
public interface AdvertisementService {

    /**
     *广告位查询
     */
    public QueryAdvertisementResponse  queryAdvertisement(QueryAdvertisementRequest request);

    public QueryAdvertisementResponse queryAdverById(QueryAdvertisementRequest request);

    public UpdateAdverResponse createAdver(UpdateAdverRequest request);

    public UpdateAdverResponse updateAdver(UpdateAdverRequest request);

    public UpdateAdverResponse updateAdverStatus(UpdateAdverRequest request);

    public UpdateAdverResponse deleteAdver(UpdateAdverRequest request);


}
