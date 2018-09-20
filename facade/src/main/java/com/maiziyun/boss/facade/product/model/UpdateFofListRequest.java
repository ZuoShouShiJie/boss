package com.maiziyun.boss.facade.product.model;

import com.maiziyun.boss.facade.common.model.BaseRequest;

import java.util.List;

/**
 * Created by admin on 2017/7/22.
 */
public class UpdateFofListRequest extends BaseRequest {
    private String id;   //产品ID
    private String poDesc;  //组合简介
    private List<String> labels;   //组合标签
    private String poRichDesc;   //组合明细说明
    private String effectFlagId;  //上下架状态

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoDesc() {
        return poDesc;
    }

    public void setPoDesc(String poDesc) {
        this.poDesc = poDesc;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public String getPoRichDesc() {
        return poRichDesc;
    }

    public void setPoRichDesc(String poRichDesc) {
        this.poRichDesc = poRichDesc;
    }

    public String getEffectFlagId() {
        return effectFlagId;
    }

    public void setEffectFlagId(String effectFlagId) {
        this.effectFlagId = effectFlagId;
    }
}
