package com.maiziyun.boss.facade.product.model;

import com.maiziyun.boss.facade.common.model.BaseRequest;

import java.util.List;

/**
 * Created by admin on 2017/8/28.
 */
public class UpdateFofSortRequest extends BaseRequest {
    private List<String> sortList;

    public List<String> getSortList() {
        return sortList;
    }

    public void setSortList(List<String> sortList) {
        this.sortList = sortList;
    }
}
