package com.maiziyun.boss.facade.product.model;

import com.maiziyun.boss.facade.product.model.vo.P2PLoanDetailVo;
import com.solar.framework.core.base.AbstractResponse;

/**
 * Created by admin on 2017/9/1.
 */
public class QueryP2PLoanDetailResponse extends AbstractResponse {
    private P2PLoanDetailVo data;
    public P2PLoanDetailVo getData() {
        return data;
    }

    public void setData(P2PLoanDetailVo data) {
        this.data = data;
    }
}
