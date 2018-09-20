package com.maiziyun.boss.facade.product.model;

import com.maiziyun.boss.facade.product.model.vo.FirP2PLoanListVo;
import com.maiziyun.boss.facade.product.model.vo.P2PLoanListVo;
import com.solar.framework.core.base.AbstractResponse;

import java.util.List;

/**
 * Created by admin on 2017/9/8.
 */
public class QueryFirP2PLoanResponse extends AbstractResponse {
    private List<FirP2PLoanListVo> data;

    public List<FirP2PLoanListVo> getData() {
        return data;
    }

    public void setData(List<FirP2PLoanListVo> data) {
        this.data = data;
    }
}
