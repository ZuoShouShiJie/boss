package com.maiziyun.boss.facade.jysmng.model;

import com.maiziyun.boss.facade.common.model.BaseRequest;

/**
 * Created by admin on 2017/11/4.
 */
public class ProductConfUpdateRequest extends BaseRequest {
    private String exchangeProjectId;   //项目编号
    private String exchangeId;    //交易所名称
    private String productId;     //产品id
    private String productName;   //产品名称
    private String projectName;   //项目名称
    private String planRaiseFund;  //计划募集资金
    private String investAmount;  //起投金额
    private String increaseAmount;  //递增金额
    private String raiseStartTime; //募集开始时间
    private String raiseEndTime;  //募集结束时间
    private String releaseTime;  //发布时间
    private String limitAmount; //限购金额
    private String isLimitAmount; //是否限额
    private String repayTypeId;//还款方式
    private String isSupportRightsTransfer; //是否支持债转
    private String isShow;
    private String content;//产品文案说明
    private String productStatusId; //产品状态

    public String getProductStatusId() {
        return productStatusId;
    }

    public void setProductStatusId(String productStatusId) {
        this.productStatusId = productStatusId;
    }

    public String getIsLimitAmount() {
        return isLimitAmount;
    }

    public void setIsLimitAmount(String isLimitAmount) {
        this.isLimitAmount = isLimitAmount;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExchangeProjectId() {
        return exchangeProjectId;
    }

    public void setExchangeProjectId(String exchangeProjectId) {
        this.exchangeProjectId = exchangeProjectId;
    }

    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPlanRaiseFund() {
        return planRaiseFund;
    }

    public void setPlanRaiseFund(String planRaiseFund) {
        this.planRaiseFund = planRaiseFund;
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

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(String limitAmount) {
        this.limitAmount = limitAmount;
    }

    public String getRepayTypeId() {
        return repayTypeId;
    }

    public void setRepayTypeId(String repayTypeId) {
        this.repayTypeId = repayTypeId;
    }

    public String getIsSupportRightsTransfer() {
        return isSupportRightsTransfer;
    }

    public void setIsSupportRightsTransfer(String isSupportRightsTransfer) {
        this.isSupportRightsTransfer = isSupportRightsTransfer;
    }


}
