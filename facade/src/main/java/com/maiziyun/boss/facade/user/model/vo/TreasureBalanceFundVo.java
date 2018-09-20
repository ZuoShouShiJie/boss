package com.maiziyun.boss.facade.user.model.vo;

import com.solar.framework.core.base.AbstractModel;


/**
 * 财神宝余额
 * Created by fanlinlong on 2016/12/13.
 */
public class TreasureBalanceFundVo extends AbstractModel {

    private String id;//主键id
    private String transFundCode;//交易基金代码
    private String transFundName;//交易基金名称
    private String payType;//支付方式
    private String cardTailNo;//卡号后4位
    private String chargeMethod;//收费方式
    private String totalShare;//总份额
    private String fastWithdrawAmount;//可快速取现的最高份额
    private String outputAmount;//可以普通取现的最高份额
    private String fundDividendType;//基金分红方式
    private String latestIncome;//最新收益（元）
    private String accumulatedIncome;//累计收益（元）

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

    public String getFastWithdrawAmount() {
        return fastWithdrawAmount;
    }

    public void setFastWithdrawAmount(String fastWithdrawAmount) {
        this.fastWithdrawAmount = fastWithdrawAmount;
    }

    public String getOutputAmount() {
        return outputAmount;
    }

    public void setOutputAmount(String outputAmount) {
        this.outputAmount = outputAmount;
    }

    public String getFundDividendType() {
        return fundDividendType;
    }

    public void setFundDividendType(String fundDividendType) {
        this.fundDividendType = fundDividendType;
    }

    public String getLatestIncome() {
        return latestIncome;
    }

    public void setLatestIncome(String latestIncome) {
        this.latestIncome = latestIncome;
    }

    public String getAccumulatedIncome() {
        return accumulatedIncome;
    }

    public void setAccumulatedIncome(String accumulatedIncome) {
        this.accumulatedIncome = accumulatedIncome;
    }
}
