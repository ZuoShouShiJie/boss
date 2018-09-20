package com.maiziyun.boss.facade.user.model.vo;

import com.solar.framework.core.base.AbstractModel;

/**
 * Created by fanlinlong on 2016/12/13.
 */
public class UserBindCardVo extends AbstractModel {

    private String bankName;
    private String CardNo;
    private String phone;//银行预留手机号码
    private String openingProvince;//开户省份
    private String openingCity;//开户城市
    private String date;//添加时间
    private String fundAccount;//基金开户   (开通)

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardNo() {
        return CardNo;
    }

    public void setCardNo(String cardNo) {
        CardNo = cardNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpeningProvince() {
        return openingProvince;
    }

    public void setOpeningProvince(String openingProvince) {
        this.openingProvince = openingProvince;
    }

    public String getOpeningCity() {
        return openingCity;
    }

    public void setOpeningCity(String openingCity) {
        this.openingCity = openingCity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }
}
