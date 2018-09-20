package com.maiziyun.boss.facade.user.model.vo;

import com.solar.framework.core.base.AbstractModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fanlinlong on 2016/12/13.
 */
public class UserVo extends AbstractModel {

    private String userId;//用户id
    private String userName;//姓名
    private String phone;//手机
    private String regDate;//注册时间
    private String cert;//认证
    private String bindCard;//绑卡
    private String riskInves;//风险调查
    private String certNO;//身份证号码

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public String getBindCard() {
        return bindCard;
    }

    public void setBindCard(String bindCard) {
        this.bindCard = bindCard;
    }

    public String getRiskInves() {
        return riskInves;
    }

    public void setRiskInves(String riskInves) {
        this.riskInves = riskInves;
    }

    public String getCertNO() {
        return certNO;
    }

    public void setCertNO(String certNO) {
        this.certNO = certNO;
    }
}
