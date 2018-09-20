package com.maiziyun.boss.integration.product;

import com.maiziyun.boss.facade.product.model.UpdateLoanSiteResponse;
import com.maiziyun.product.facade.model.*;

/**
 * Created by admin on 2017/8/31.
 */
public interface P2PLoanServiceClient {
    public QueryP2PInfoByExpectPageResponse queryLoanList(QueryP2PInfoByExpectPageRequest request);

    public QueryP2PInfoConfigTypeResponse queryLoanListExpect(QueryP2PInfoConfigTypeRequest request);

    public QueryProductP2PInfoByProductIdResponse queryLoanById(QueryProductP2PInfoByProductIdRequest request);

    public UpdateP2PInfoByProductIdAndAttrResponse updateP2PLoan(UpdateP2PInfoByProductIdAndAttrRequest request);

    public QueryBuyP2PInfoSortResponse queryLoanList(QueryBuyP2PInfoSortRequest request);

    public QueryP2PInfoConfigResponse queryLoanSite(QueryP2PInfoConfigRequest request);

    public UpdateBuyP2PInfoSortResponse updateLoanSite(UpdateBuyP2PInfoSortRequest request);

}
