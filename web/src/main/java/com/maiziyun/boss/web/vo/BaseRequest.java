package com.maiziyun.boss.web.vo;

import com.solar.framework.core.base.AbstractModel;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Created by admin on 2017/6/30.
 */
public abstract class BaseRequest extends AbstractModel{

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
