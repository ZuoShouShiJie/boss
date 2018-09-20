package com.maiziyun.boss.facade.product.model;

import com.maiziyun.boss.facade.product.model.vo.P2PLoanListVo;
import com.solar.framework.core.base.AbstractRequest;
import com.solar.framework.core.base.AbstractResponse;

import java.util.List;

/**
 * Created by admin on 2017/8/31.
 */
public class QueryP2PLoanResponse extends AbstractResponse {
    private List<P2PLoanListVo> data;
    private String listTotal;
    private List<P2PLoanListVo> deadLineList;

    public List<P2PLoanListVo> getDeadLineList() {
        return deadLineList;
    }

    public void setDeadLineList(List<P2PLoanListVo> deadLineList) {
        this.deadLineList = deadLineList;
    }

    public List<P2PLoanListVo> getData() {
        return data;
    }

    public void setData(List<P2PLoanListVo> data) {
        this.data = data;
    }

    public String getListTotal() {
        return listTotal;
    }

    public void setListTotal(String listTotal) {
        this.listTotal = listTotal;
    }
}
