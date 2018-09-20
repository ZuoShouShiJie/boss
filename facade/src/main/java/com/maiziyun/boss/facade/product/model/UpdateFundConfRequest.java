package com.maiziyun.boss.facade.product.model;

import com.solar.framework.core.base.AbstractRequest;

import java.util.List;

/**
 * Created by admin on 2017/7/3.
 */
public class UpdateFundConfRequest extends AbstractRequest {
    private List<Long> list;
    private String attrKind;

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }

    public String getAttrKind() {
        return attrKind;
    }

    public void setAttrKind(String attrKind) {
        this.attrKind = attrKind;
    }
}
