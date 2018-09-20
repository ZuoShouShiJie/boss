package com.maiziyun.boss.facade.product.model;

import com.maiziyun.boss.facade.common.model.BaseRequest;

import java.util.List;

/**
 * Created by admin on 2017/9/4.
 */
public class UpdateSelectFofListRequest extends BaseRequest {
    private String attrKind;
    private List<String> sortList;

    public String getAttrKind() {
        return attrKind;
    }

    public void setAttrKind(String attrKind) {
        this.attrKind = attrKind;
    }

    public List<String> getSortList() {
        return sortList;
    }

    public void setSortList(List<String> sortList) {
        this.sortList = sortList;
    }
}
