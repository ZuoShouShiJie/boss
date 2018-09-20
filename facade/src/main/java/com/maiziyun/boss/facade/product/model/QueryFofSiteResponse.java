package com.maiziyun.boss.facade.product.model;

import com.maiziyun.boss.facade.product.model.vo.QueryFofSiteListVo;
import com.solar.framework.core.base.AbstractResponse;

import java.util.List;

/**
 * Created by admin on 2017/7/31.
 */
public class QueryFofSiteResponse extends AbstractResponse {
    private List<QueryFofSiteListVo> list;
    private String listTotal;

    public List<QueryFofSiteListVo> getList() {
        return list;
    }

    public void setList(List<QueryFofSiteListVo> list) {
        this.list = list;
    }

    public String getListTotal() {
        return listTotal;
    }

    public void setListTotal(String listTotal) {
        this.listTotal = listTotal;
    }
}
