package com.maiziyun.boss.facade.product.model;

import com.maiziyun.boss.facade.product.model.vo.P2PLoanListVo;
import com.solar.framework.core.base.AbstractResponse;

import java.util.List;

/**
 * Created by admin on 2017/9/8.
 */
public class QueryLoanSiteResponse extends AbstractResponse {
    List<P2PLoanListVo> deadLineList;

    public List<P2PLoanListVo> getDeadLineList() {
        return deadLineList;
    }

    public void setDeadLineList(List<P2PLoanListVo> deadLineList) {
        this.deadLineList = deadLineList;
    }
}
