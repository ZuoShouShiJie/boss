package com.maiziyun.boss.facade.user.model.vo;

import com.solar.framework.core.base.AbstractModel;


/**
 * 持有基金
 * Created by fanlinlong on 2016/12/13.
 */
public class HoldingFundVo extends AbstractModel {

    private String id;//主键id
    private String productName;//产品名称
    private String transFundCode;//交易基金代码
    private String transFundName;//交易基金名称
    private String payType;//支付方式
    private String cardTailNo;//卡号后4位
    private String fundType;//基金类型
    private String chargeMethod;//收费方式
    private String totalShare;//总份额
    private String availableShare;//可用份额
    private String fundValue;//基金市值（元）
    private String latestNetDate;//最新净值日期
    private String latestNetWorth;//最新净值
    private String fundDividendType;//基金分红方式
    private String accumulatedIncome;//累计收益（元）
    private String latestOfficialIncome;//最新的正式收益
    private String latestOfficialIncomeDate;//最新正式收益日期
    private String latestEstimatesIncome;//最新预估收益
    private String latestEstimatesIncomeDate;//最新预估收益日期

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransFundCode() {
        return transFundCode;
    }

    public void setTransFundCode(String transFundCode) {
        this.transFundCode = transFundCode;
    }

    public String getTransFundName() {
        return transFundName;
    }

    public void setTransFundName(String transFundName) {
        this.transFundName = transFundName;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getCardTailNo() {
        return cardTailNo;
    }

    public void setCardTailNo(String cardTailNo) {
        this.cardTailNo = cardTailNo;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public String getChargeMethod() {
        return chargeMethod;
    }

    public void setChargeMethod(String chargeMethod) {
        this.chargeMethod = chargeMethod;
    }

    public String getTotalShare() {
        return totalShare;
    }

    public void setTotalShare(String totalShare) {
        this.totalShare = totalShare;
    }

    public String getAvailableShare() {
        return availableShare;
    }

    public void setAvailableShare(String availableShare) {
        this.availableShare = availableShare;
    }

    public String getFundValue() {
        return fundValue;
    }

    public void setFundValue(String fundValue) {
        this.fundValue = fundValue;
    }

    public String getLatestNetDate() {
        return latestNetDate;
    }

    public void setLatestNetDate(String latestNetDate) {
        this.latestNetDate = latestNetDate;
    }

    public String getLatestNetWorth() {
        return latestNetWorth;
    }

    public void setLatestNetWorth(String latestNetWorth) {
        this.latestNetWorth = latestNetWorth;
    }

    public String getFundDividendType() {
        return fundDividendType;
    }

    public void setFundDividendType(String fundDividendType) {
        this.fundDividendType = fundDividendType;
    }

    public String getAccumulatedIncome() {
        return accumulatedIncome;
    }

    public void setAccumulatedIncome(String accumulatedIncome) {
        this.accumulatedIncome = accumulatedIncome;
    }

    public String getLatestOfficialIncome() {
        return latestOfficialIncome;
    }

    public void setLatestOfficialIncome(String latestOfficialIncome) {
        this.latestOfficialIncome = latestOfficialIncome;
    }

    public String getLatestOfficialIncomeDate() {
        return latestOfficialIncomeDate;
    }

    public void setLatestOfficialIncomeDate(String latestOfficialIncomeDate) {
        this.latestOfficialIncomeDate = latestOfficialIncomeDate;
    }

    public String getLatestEstimatesIncome() {
        return latestEstimatesIncome;
    }

    public void setLatestEstimatesIncome(String latestEstimatesIncome) {
        this.latestEstimatesIncome = latestEstimatesIncome;
    }

    public String getLatestEstimatesIncomeDate() {
        return latestEstimatesIncomeDate;
    }

    public void setLatestEstimatesIncomeDate(String latestEstimatesIncomeDate) {
        this.latestEstimatesIncomeDate = latestEstimatesIncomeDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
