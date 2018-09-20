package com.maiziyun.boss.facade.product.model;

import com.solar.framework.core.base.AbstractPagedRequest;
import com.solar.framework.core.base.AbstractPagedResponse;
import com.solar.framework.core.base.AbstractRequest;

/**
 * Created by admin on 2017/7/3.
 */
public class QueryFundConfRequest extends AbstractPagedRequest {
    private String attrKind;
    private String productName;
    private String fundCode;
    private String fundType;


    public String getAttrKind() {
        return attrKind;
    }

    public void setAttrKind(String attrKind) {
        this.attrKind = attrKind;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

}
