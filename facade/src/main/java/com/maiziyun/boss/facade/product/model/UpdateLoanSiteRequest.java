package com.maiziyun.boss.facade.product.model;

import com.maiziyun.boss.facade.common.model.BaseRequest;

import java.util.List;

/**
 * Created by admin on 2017/9/7.
 */
public class UpdateLoanSiteRequest extends BaseRequest {
    private List<String> expectList;

    public List<String> getExpectList() {
        return expectList;
    }

    public void setExpectList(List<String> expectList) {
        this.expectList = expectList;
    }
}
