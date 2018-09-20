package com.maiziyun.boss.facade.product.model;

import com.maiziyun.boss.facade.product.model.vo.QueryFofListVo;
import com.solar.framework.core.base.AbstractResponse;

import java.util.List;

/**
 * Created by admin on 2017/9/4.
 */
public class QuerySelectFofListResponse extends AbstractResponse {
    private List<QueryFofListVo> list;
    private String pageCount;

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public List<QueryFofListVo> getList() {
        return list;
    }

    public void setList(List<QueryFofListVo> list) {
        this.list = list;
    }
}
