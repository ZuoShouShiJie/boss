package com.maiziyun.boss.facade.common.model.vo;

import java.io.Serializable;

/**
 * 用户交易
 * Created by fanlinlong on 2016/12/13.
 */
public class UserTransVo implements Serializable {

    private String transId;//交易流水号
    private String orderNo;//订单流水号
    private String orderCreateTime;//订单创建时间
    private String orderAreTradingDay;//订单所属交易日
    private String orderAreConfirmDate;//订单的确认日期
    private String orderPayType;//订单支付方式
    private String cardTailNo;//卡号后4位
    private String transType;//交易类型
    private String transFundName;//交易基金名称
    private String transFundCode;//交易基金代码
    private String productName;//产品名称
    private String chargeMethod;//收费方式
    private String transAmount;//交易金额（元）
    private String transShare;//交易份额
    private String ActualSucTransAmount;//实际成功成交金额
    private String ActualSucTransShare;//实际成功成交份额
    private String transCost;//交易费用
    private String orderPaymentStatus;//订单支付状态
    private String orderConfirmStatus;//订单确认状态
    private String converTargetFundName;//转换目标基金名称
    private String converTargetFundCode;//转换目标基金代码
    private String transFlag;//交易标识

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(String orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public String getOrderAreTradingDay() {
        return orderAreTradingDay;
    }

    public void setOrderAreTradingDay(String orderAreTradingDay) {
        this.orderAreTradingDay = orderAreTradingDay;
    }

    public String getOrderAreConfirmDate() {
        return orderAreConfirmDate;
    }

    public void setOrderAreConfirmDate(String orderAreConfirmDate) {
        this.orderAreConfirmDate = orderAreConfirmDate;
    }

    public String getOrderPayType() {
        return orderPayType;
    }

    public void setOrderPayType(String orderPayType) {
        this.orderPayType = orderPayType;
    }

    public String getCardTailNo() {
        return cardTailNo;
    }

    public void setCardTailNo(String cardTailNo) {
        this.cardTailNo = cardTailNo;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTransFundName() {
        return transFundName;
    }

    public void setTransFundName(String transFundName) {
        this.transFundName = transFundName;
    }

    public String getTransFundCode() {
        return transFundCode;
    }

    public void setTransFundCode(String transFundCode) {
        this.transFundCode = transFundCode;
    }

    public String getChargeMethod() {
        return chargeMethod;
    }

    public void setChargeMethod(String chargeMethod) {
        this.chargeMethod = chargeMethod;
    }

    public String getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(String transAmount) {
        this.transAmount = transAmount;
    }

    public String getTransShare() {
        return transShare;
    }

    public void setTransShare(String transShare) {
        this.transShare = transShare;
    }

    public String getActualSucTransAmount() {
        return ActualSucTransAmount;
    }

    public void setActualSucTransAmount(String actualSucTransAmount) {
        ActualSucTransAmount = actualSucTransAmount;
    }

    public String getActualSucTransShare() {
        return ActualSucTransShare;
    }

    public void setActualSucTransShare(String actualSucTransShare) {
        ActualSucTransShare = actualSucTransShare;
    }

    public String getTransCost() {
        return transCost;
    }

    public void setTransCost(String transCost) {
        this.transCost = transCost;
    }

    public String getOrderPaymentStatus() {
        return orderPaymentStatus;
    }

    public void setOrderPaymentStatus(String orderPaymentStatus) {
        this.orderPaymentStatus = orderPaymentStatus;
    }

    public String getOrderConfirmStatus() {
        return orderConfirmStatus;
    }

    public void setOrderConfirmStatus(String orderConfirmStatus) {
        this.orderConfirmStatus = orderConfirmStatus;
    }

    public String getConverTargetFundName() {
        return converTargetFundName;
    }

    public void setConverTargetFundName(String converTargetFundName) {
        this.converTargetFundName = converTargetFundName;
    }

    public String getConverTargetFundCode() {
        return converTargetFundCode;
    }

    public void setConverTargetFundCode(String converTargetFundCode) {
        this.converTargetFundCode = converTargetFundCode;
    }

    public String getTransFlag() {
        return transFlag;
    }

    public UserTransVo setTransFlag(String transFlag) {
        this.transFlag = transFlag;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
