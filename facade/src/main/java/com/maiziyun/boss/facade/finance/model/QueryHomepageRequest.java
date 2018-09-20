package com.maiziyun.boss.facade.finance.model;

import com.maiziyun.boss.facade.common.model.BaseRequest;

/**
 * Created by admin on 2017/8/31.
 */
public class QueryHomepageRequest extends BaseRequest {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
