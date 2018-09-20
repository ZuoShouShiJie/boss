package com.maiziyun.boss.integration.product;

import com.maiziyun.product.facade.model.*;

/**
 * Created by admin on 2017/9/4.
 */
public interface HomePageSiteClient {
    public QueryWellChosenFundNavInfoAttrValResponse querySelectFund(QueryWellChosenFundNavInfoAttrValRequest request);
    public QueryWellChosenFundNavInfoPageResponse querySelectFundAll(QueryWellChosenFundNavInfoPageRequest request);
    public UpdateWellChosenAttrKindRelResponse updateSelectFund(UpdateWellChosenAttrKindRelRequest request);

}
