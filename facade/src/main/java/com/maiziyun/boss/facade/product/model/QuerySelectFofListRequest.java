package com.maiziyun.boss.facade.product.model;

import com.maiziyun.boss.facade.common.model.BaseRequest;

/**
 * Created by admin on 2017/9/4.
 */
public class QuerySelectFofListRequest extends BaseRequest {
    private String sortFlag; //可购买/不可购买标识
    private String attrKind;
    private String pageNo;
    private String pageSize;

    public String getSortFlag() {
        return sortFlag;
    }

    public void setSortFlag(String sortFlag) {
        this.sortFlag = sortFlag;
    }

    public String getAttrKind() {
        return attrKind;
    }

    public void setAttrKind(String attrKind) {
        this.attrKind = attrKind;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
