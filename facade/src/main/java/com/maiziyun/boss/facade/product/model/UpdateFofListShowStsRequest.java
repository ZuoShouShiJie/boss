package com.maiziyun.boss.facade.product.model;

import com.maiziyun.boss.facade.common.model.BaseRequest;

/**
 * Created by admin on 2017/7/22.
 */
public class UpdateFofListShowStsRequest extends BaseRequest {
    private String id;
    private String effectFlagId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEffectFlagId() {
        return effectFlagId;
    }

    public void setEffectFlagId(String effectFlagId) {
        this.effectFlagId = effectFlagId;
    }
}
