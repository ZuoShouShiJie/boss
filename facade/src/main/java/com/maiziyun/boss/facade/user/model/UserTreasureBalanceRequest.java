package com.maiziyun.boss.facade.user.model;

import com.solar.framework.core.base.AbstractRequest;

/**
 * Created by len.song on 2016/11/24.
 */
public class UserTreasureBalanceRequest extends AbstractRequest {

    //查询条件
    private String userId;

    public String getUserId() {
        return userId;
    }

    public UserTreasureBalanceRequest setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
