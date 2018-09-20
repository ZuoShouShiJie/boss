package com.maiziyun.boss.facade.jysmng.model.vo;

import com.solar.framework.core.base.AbstractModel;

/**
 * Created by admin on 2017/11/7.
 */
public class ProductConfQueryVo extends AbstractModel {
    private String productId;                             //产品id
    private String exchangeId;
    private String exchangeName;                  //交易所名称
    private String exchangeProjectId;          //项目id
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
    private String isLimitAmount;//是否限额
    private String repayTypeId;                     //还款方式
    private String repayTypeName;
    private String createTime;                      //创建时间
    private String modifyTime;                      //更新时间
    private String annualRate;                   //年化收益率
    private String productCycle;                  //锁定周期
    private String isSupportRightsTransferId;         //是否支持债转
    private String isSupportRightsTransferName;
    private String isShowId;                         //前端是否可见
    private String isShowName;
    private String productStatusId;                  //产品状态
    private String productStatusName;
    private String opeartor;                        //操作人
    private String content;
    private String interestUnitId;  //计息单位
    private String interestUnitName;

    public String getInterestUnitId() {
        return interestUnitId;
    }

    public void setInterestUnitId(String interestUnitId) {
        this.interestUnitId = interestUnitId;
    }

    public String getInterestUnitName() {
        return interestUnitName;
    }

    public void setInterestUnitName(String interestUnitName) {
        this.interestUnitName = interestUnitName;
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

    public String getIsLimitAmount() {
        return isLimitAmount;
    }

    public void setIsLimitAmount(String isLimitAmount) {
        this.isLimitAmount = isLimitAmount;
    }

    public String getIsShowId() {
        return isShowId;
    }

    public void setIsShowId(String isShowId) {
        this.isShowId = isShowId;
    }

    public String getIsShowName() {
        return isShowName;
    }

    public void setIsShowName(String isShowName) {
        this.isShowName = isShowName;
    }

    public String getProductStatusId() {
        return productStatusId;
    }

    public void setProductStatusId(String productStatusId) {
        this.productStatusId = productStatusId;
    }

    public String getProductStatusName() {
        return productStatusName;
    }

    public void setProductStatusName(String productStatusName) {
        this.productStatusName = productStatusName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public String getRepayTypeId() {
        return repayTypeId;
    }

    public String getRepayTypeName() {
        return repayTypeName;
    }

    public void setRepayTypeName(String repayTypeName) {
        this.repayTypeName = repayTypeName;
    }

    public void setRepayTypeId(String repayTypeId) {
        this.repayTypeId = repayTypeId;
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

    public String getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(String annualRate) {
        this.annualRate = annualRate;
    }

    public String getProductCycle() {
        return productCycle;
    }

    public void setProductCycle(String productCycle) {
        this.productCycle = productCycle;
    }

    public String getIsSupportRightsTransferId() {
        return isSupportRightsTransferId;
    }

    public void setIsSupportRightsTransferId(String isSupportRightsTransferId) {
        this.isSupportRightsTransferId = isSupportRightsTransferId;
    }

    public String getIsSupportRightsTransferName() {
        return isSupportRightsTransferName;
    }

    public void setIsSupportRightsTransferName(String isSupportRightsTransferName) {
        this.isSupportRightsTransferName = isSupportRightsTransferName;
    }

    public String getOpeartor() {
        return opeartor;
    }

    public void setOpeartor(String opeartor) {
        this.opeartor = opeartor;
    }
}
