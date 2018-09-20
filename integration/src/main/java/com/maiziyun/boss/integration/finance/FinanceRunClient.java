package com.maiziyun.boss.integration.finance;

import com.maiziyun.cms.facade.model.*;

/**
 * Created by admin on 2017/6/16.
 */
public interface FinanceRunClient {
    QueryAdvertisementManagerResponse queryAdvertisement(QueryAdvertisementManagerRequest request);

    QueryPositionResponse queryPositionByAppCode(QueryPositionRequest request);

    QueryAdvertisementManagerResponse queryAdverById(QueryAdvertisementManagerRequest request);

    CreateAdvertisementResponse createAdver(CreateAdvertisementRequest request);

    UpdateAdvertisementResponse updateAdver(UpdateAdvertisementRequest request);

    UpdateAdvertisementResponse updateAdverStatus(UpdateAdvertisementRequest request);

    DeleteAdvertisementResponse deleteAdver(DeleteAdvertisementRequest request);






}
