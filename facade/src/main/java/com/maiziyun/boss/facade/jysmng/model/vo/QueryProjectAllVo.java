package com.maiziyun.boss.facade.jysmng.model.vo;

import com.solar.framework.core.base.AbstractModel;

/**
 * Created by admin on 2017/11/8.
 */
public class QueryProjectAllVo extends AbstractModel {
    private String exchangeProjectId;
    private String projectName;
    private String annualRate;//年化收益率
    private String interestUnitId;//计息单位
    private String productCycle; //产品周期

    public String getProductCycle() {
        return productCycle;
    }

    public void setProductCycle(String productCycle) {
        this.productCycle = productCycle;
    }

    public String getExchangeProjectId() {
        return exchangeProjectId;
    }

    public void setExchangeProjectId(String exchangeProjectId) {
        this.exchangeProjectId = exchangeProjectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(String annualRate) {
        this.annualRate = annualRate;
    }

    public String getInterestUnitId() {
        return interestUnitId;
    }

    public void setInterestUnitId(String interestUnitId) {
        this.interestUnitId = interestUnitId;
    }
}
