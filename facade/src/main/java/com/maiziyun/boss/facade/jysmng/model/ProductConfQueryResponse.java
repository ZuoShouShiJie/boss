package com.maiziyun.boss.facade.jysmng.model;

import com.solar.framework.core.base.AbstractResponse;

/**
 * Created by admin on 2017/11/6.
 */
public class ProductConfQueryResponse extends AbstractResponse {
    private String id;                             //id
    private String exchangeName;                  //交易所名称
    private String projectName;                   //项目名称
    private String productName;                   //理财产品名称
    private String planRaiseFund;                //计划募集资金
    private String remainRainAmount;              //剩余募集金额
    private String releaseTime;                    //发布时间
    private String raiseStartTime;                //募集开始时间
    private String raiseEndTime;                  //募集结束时间
    private String investAmount;                   //起投金额
    private String increaseAmount;                //递增金额
    private String limitAmount;                  //每人限额
    private String repayType;                     //还款方式
    private String createTime;                      //创建时间
    private String modifyTime;                      //更新时间
    private String annualYield;                   //年化收益率
    private String productCycle;                  //锁定周期
    private String isSupportRightsTransfer;         //是否支持债转
    private String isShow;                         //前端是否可见
    private String productStatus;                  //产品状态
    private String opeartor;                        //操作人

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPlanRaiseFund() {
        return planRaiseFund;
    }

    public void setPlanRaiseFund(String planRaiseFund) {
        this.planRaiseFund = planRaiseFund;
    }

    public String getRemainRainAmount() {
        return remainRainAmount;
    }

    public void setRemainRainAmount(String remainRainAmount) {
        this.remainRainAmount = remainRainAmount;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getRaiseStartTime() {
        return raiseStartTime;
    }

    public void setRaiseStartTime(String raiseStartTime) {
        this.raiseStartTime = raiseStartTime;
    }

    public String getRaiseEndTime() {
        return raiseEndTime;
    }

    public void setRaiseEndTime(String raiseEndTime) {
        this.raiseEndTime = raiseEndTime;
    }

    public String getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(String investAmount) {
        this.investAmount = investAmount;
    }

    public String getIncreaseAmount() {
        return increaseAmount;
    }

    public void setIncreaseAmount(String increaseAmount) {
        this.increaseAmount = increaseAmount;
    }

    public String getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(String limitAmount) {
        this.limitAmount = limitAmount;
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getAnnualYield() {
        return annualYield;
    }

    public void setAnnualYield(String annualYield) {
        this.annualYield = annualYield;
    }

    public String getProductCycle() {
        return productCycle;
    }

    public void setProductCycle(String productCycle) {
        this.productCycle = productCycle;
    }

    public String getIsSupportRightsTransfer() {
        return isSupportRightsTransfer;
    }

    public void setIsSupportRightsTransfer(String isSupportRightsTransfer) {
        this.isSupportRightsTransfer = isSupportRightsTransfer;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getOpeartor() {
        return opeartor;
    }

    public void setOpeartor(String opeartor) {
        this.opeartor = opeartor;
    }
}
