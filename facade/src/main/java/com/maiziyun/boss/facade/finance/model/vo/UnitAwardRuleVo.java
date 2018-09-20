package com.maiziyun.boss.facade.finance.model.vo;

import com.solar.framework.core.base.AbstractModel;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by admin on 2017/7/17.
 */
public class UnitAwardRuleVo implements Serializable{
    private String unitCondition;
    private String unitAwardPoint;

    public String getUnitCondition() {
        return unitCondition;
    }

    public void setUnitCondition(String unitCondition) {
        this.unitCondition = unitCondition;
    }

    public String getUnitAwardPoint() {
        return unitAwardPoint;
    }

    public void setUnitAwardPoint(String unitAwardPoint) {
        this.unitAwardPoint = unitAwardPoint;
    }
}
