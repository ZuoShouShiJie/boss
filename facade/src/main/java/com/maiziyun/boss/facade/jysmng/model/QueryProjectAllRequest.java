package com.maiziyun.boss.facade.jysmng.model;

import com.maiziyun.boss.facade.common.model.BaseRequest;

/**
 * Created by admin on 2017/11/8.
 */
public class QueryProjectAllRequest extends BaseRequest {
    private String exchangeId;

    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }
}
