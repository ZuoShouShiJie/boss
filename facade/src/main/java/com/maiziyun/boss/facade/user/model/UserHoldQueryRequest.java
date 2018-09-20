package com.maiziyun.boss.facade.user.model;

import com.solar.framework.core.base.AbstractRequest;

/**
 * Created by len.song on 2016/12/18.
 */
public class UserHoldQueryRequest extends AbstractRequest {

    //查询条件
    private String userId;

    public String getUserId() {
        return userId;
    }

    public UserHoldQueryRequest setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
