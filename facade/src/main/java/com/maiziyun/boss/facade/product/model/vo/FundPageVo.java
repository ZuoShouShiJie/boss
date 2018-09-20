package com.maiziyun.boss.facade.product.model.vo;

import com.solar.framework.core.base.AbstractModel;

/**
 * Created by len.song on 2016/12/25.
 */
public class FundPageVo extends AbstractModel {
    private String productId;
    private String fundName;
    private String fundCode;

    public String getFundName() {
        return fundName;
    }

    public FundPageVo setFundName(String fundName) {
        this.fundName = fundName;
        return this;
    }

    public String getFundCode() {
        return fundCode;
    }

    public FundPageVo setFundCode(String fundCode) {
        this.fundCode = fundCode;
        return this;
    }

    public String getProductId() {
        return productId;
    }

    public FundPageVo setProductId(String productId) {
        this.productId = productId;
        return this;
    }
}
