package com.maiziyun.boss.facade.jysmng.model.vo;

import com.solar.framework.core.base.AbstractModel;

/**
 * Created by admin on 2017/11/9.
 */
public class UserInvestListVo extends AbstractModel {
    private String exchangeName;//交易所名称
    private String productId;//理财产品编号
    private String orderNo;//块钱订单号
    private String mobile;//手机号
    private String userName;//投资人姓名
    private String investAmount;//投资金额
    private String investTime;//投资时间
    private String investType;//投资方式
    private String productName;//投资产品名称
    private String raiseStartTime;//募集开始时间
    private String raiseEndTime;//募集结束时间
    private String interestStartTime;//计息开始时间
    private String interestEndTime;//计息结束时间
    private String expectEarnings;//预期到账收益
    private String investStatus;//投资状态

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(String investAmount) {
        this.investAmount = investAmount;
    }

    public String getInvestTime() {
        return investTime;
    }

    public void setInvestTime(String investTime) {
        this.investTime = investTime;
    }

    public String getInvestType() {
        return investType;
    }

    public void setInvestType(String investType) {
        this.investType = investType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getInterestStartTime() {
        return interestStartTime;
    }

    public void setInterestStartTime(String interestStartTime) {
        this.interestStartTime = interestStartTime;
    }

    public String getInterestEndTime() {
        return interestEndTime;
    }

    public void setInterestEndTime(String interestEndTime) {
        this.interestEndTime = interestEndTime;
    }

    public String getExpectEarnings() {
        return expectEarnings;
    }

    public void setExpectEarnings(String expectEarnings) {
        this.expectEarnings = expectEarnings;
    }

    public String getInvestStatus() {
        return investStatus;
    }

    public void setInvestStatus(String investStatus) {
        this.investStatus = investStatus;
    }
}
