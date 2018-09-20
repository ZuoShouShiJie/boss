package com.maiziyun.boss.web.vo;

/**
 * Created by admin on 2017/7/7.
 */
public class LoginVo extends BaseRequest {
    private String userAccount;
    private String loginPassword;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
