package com.maiziyun.boss.facade.product.model;

import com.maiziyun.boss.facade.product.model.vo.QueryFofDetailVo;
import com.solar.framework.core.base.AbstractResponse;

/**
 * Created by admin on 2017/7/22.
 */
public class QueryFofDetailResponse extends AbstractResponse {
    private QueryFofDetailVo fofVo;

    public QueryFofDetailVo getFofVo() {
        return fofVo;
    }

    public void setFofVo(QueryFofDetailVo fofVo) {
        this.fofVo = fofVo;
    }
}
