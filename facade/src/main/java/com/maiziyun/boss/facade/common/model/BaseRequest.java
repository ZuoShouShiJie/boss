package com.maiziyun.boss.facade.common.model;

import com.solar.framework.core.base.AbstractRequest;

/**
 * Created by admin on 2017/6/30.
 */
public abstract class BaseRequest extends AbstractRequest{

    private String userId;

    private String tokenId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
}
