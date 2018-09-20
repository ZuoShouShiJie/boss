package com.maiziyun.boss.facade.finance.model;

import com.maiziyun.boss.facade.finance.model.vo.AdverVo;
import com.maiziyun.boss.facade.finance.model.vo.StateListVo;
import com.solar.framework.core.base.AbstractPagedResponse;

import java.util.List;

/**
 * Created by admin on 2017/6/16.
 */
public class QueryAdvertisementResponse extends AbstractPagedResponse<AdverVo> {
    private List<StateListVo> stateList;
    private AdverVo adverVo;

    public AdverVo getAdverVo() {
        return adverVo;
    }

    public void setAdverVo(AdverVo adverVo) {
        this.adverVo = adverVo;
    }

    public QueryAdvertisementResponse() {
    }

    public List<StateListVo> getStateList() {
        return stateList;
    }

    public void setStateList(List<StateListVo> stateList) {
        this.stateList = stateList;
    }
}
