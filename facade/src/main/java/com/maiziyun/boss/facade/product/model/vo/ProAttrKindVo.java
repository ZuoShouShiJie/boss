package com.maiziyun.boss.facade.product.model.vo;

import com.solar.framework.core.base.AbstractModel;

/**
 * Created by len.song on 2016/12/22.
 */
public class ProAttrKindVo extends AbstractModel {
    private String attrKind;//基金分类，WellChosen：对应分类基金管理（精选）  Recommend 对应首页基金（推荐）
    private String name;//栏目名称
    private String desc;//栏目描述

    public String getAttrKind() {
        return attrKind;
    }

    public ProAttrKindVo setAttrKind(String attrKind) {
        this.attrKind = attrKind;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProAttrKindVo setName(String name) {
        this.name = name;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public ProAttrKindVo setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
