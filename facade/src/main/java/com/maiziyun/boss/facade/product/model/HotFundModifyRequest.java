package com.maiziyun.boss.facade.product.model;

import com.solar.framework.core.base.AbstractPagedRequest;

/**
 * Created by admin on 2017/6/2.
 */
public class HotFundModifyRequest extends AbstractPagedRequest {
    private String type;
    private String id;
    private String label;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
