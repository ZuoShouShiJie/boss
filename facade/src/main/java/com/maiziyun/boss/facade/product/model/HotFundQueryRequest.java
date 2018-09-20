package com.maiziyun.boss.facade.product.model;

import com.solar.framework.core.base.AbstractPagedRequest;
import com.solar.framework.core.base.AbstractRequest;

/**
 * Created by admin on 2017/6/2.
 */
public class HotFundQueryRequest extends AbstractPagedRequest {
    private String fundType;
    private String fundName;
    private String fundCode;
    private String type;

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
