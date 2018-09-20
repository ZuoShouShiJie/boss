package com.maiziyun.boss.facade.product.model;

import com.solar.framework.core.base.AbstractRequest;

/**
 * Created by admin on 2017/6/2.
 */
public class FundItemModifyRequest extends AbstractRequest {
    private String id; //
    private String attrKindName;
    private String attrKindTag;
    private String attrKindDesc;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttrKindName() {
        return attrKindName;
    }

    public void setAttrKindName(String attrKindName) {
        this.attrKindName = attrKindName;
    }

    public String getAttrKindTag() {
        return attrKindTag;
    }

    public void setAttrKindTag(String attrKindTag) {
        this.attrKindTag = attrKindTag;
    }

    public String getAttrKindDesc() {
        return attrKindDesc;
    }

    public void setAttrKindDesc(String attrKindDesc) {
        this.attrKindDesc = attrKindDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
