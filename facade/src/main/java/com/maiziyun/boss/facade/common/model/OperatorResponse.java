package com.maiziyun.boss.facade.common.model;

import com.maiziyun.boss.facade.common.model.vo.OperatorVo;
import com.solar.framework.core.base.AbstractResponse;

/**
 * Created by len.song on 2016/11/21.
 */
public class OperatorResponse extends AbstractResponse {

    private OperatorVo operatorVo;//操作员vo

    public OperatorVo getOperatorVo() {
        return operatorVo;
    }

    public void setOperatorVo(OperatorVo operatorVo) {
        this.operatorVo = operatorVo;
    }
}
