package com.maiziyun.boss.facade.jysmng.model.vo;

import java.math.BigDecimal;

/**
 * Created by admin on 2017/11/12.
 */
public class J2PMgwGetFundFlowVo {
    private String outUserNo;
    private String oppOutUserNo;
    private String transCode;
    private String dcFlag;
    private BigDecimal amount;
    private String remark;
    private String createTime;
    private String balance;
    private String freezeAmount;

    public String getOutUserNo() {
        return outUserNo;
    }

    public void setOutUserNo(String outUserNo) {
        this.outUserNo = outUserNo;
    }

    public String getOppOutUserNo() {
        return oppOutUserNo;
    }

    public void setOppOutUserNo(String oppOutUserNo) {
        this.oppOutUserNo = oppOutUserNo;
    }

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    public String getDcFlag() {
        return dcFlag;
    }

    public void setDcFlag(String dcFlag) {
        this.dcFlag = dcFlag;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getFreezeAmount() {
        return freezeAmount;
    }

    public void setFreezeAmount(String freezeAmount) {
        this.freezeAmount = freezeAmount;
    }
}
