package com.maiziyun.boss.facade.product.model;

import com.maiziyun.boss.facade.product.model.vo.FundItemVo;
import com.solar.framework.core.base.AbstractResponse;

import java.util.List;

/**
 * Created by admin on 2017/6/2.
 */
public class FundItemQueryResponse extends AbstractResponse {
    private List<FundItemVo> datas;
    private FundItemVo data;

    public FundItemVo getData() {
        return data;
    }

    public void setData(FundItemVo data) {
        this.data = data;
    }

    public List<FundItemVo> getDatas() {
        return datas;
    }

    public void setDatas(List<FundItemVo> datas) {
        this.datas = datas;
    }
}
