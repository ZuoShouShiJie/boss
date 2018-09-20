package com.maiziyun.boss.facade.finance.model;

import com.maiziyun.boss.facade.finance.model.vo.AdverVo;
import com.maiziyun.boss.facade.finance.model.vo.CornfieldVo;
import com.maiziyun.boss.facade.finance.model.vo.StateListVo;
import com.solar.framework.core.base.AbstractPagedResponse;

import java.util.List;

/**
 * Created by admin on 2017/6/16.
 */
public class QueryCornResponse extends AbstractPagedResponse<CornfieldVo> {
    public CornfieldVo cornfieldVo;

    public CornfieldVo getCornfieldVo() {
        return cornfieldVo;
    }

    public void setCornfieldVo(CornfieldVo cornfieldVo) {
        this.cornfieldVo = cornfieldVo;
    }
}
