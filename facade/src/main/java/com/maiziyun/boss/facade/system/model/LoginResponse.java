package com.maiziyun.boss.facade.system.model;

import com.solar.framework.core.base.AbstractResponse;

/**
 * Created by songliang on 2016/11/15.
 */
public class LoginResponse extends AbstractResponse {
    private com.maiziyun.boss.facade.common.model.vo.OperatorVo OperatorVo;
    private String msg;//登录信息
    private boolean isLoginSuccess;//是否登录成功


    public com.maiziyun.boss.facade.common.model.vo.OperatorVo getOperatorVo() {
        return OperatorVo;
    }

    public void setOperatorVo(com.maiziyun.boss.facade.common.model.vo.OperatorVo operatorVo) {
        OperatorVo = operatorVo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isLoginSuccess() {
        return isLoginSuccess;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        isLoginSuccess = loginSuccess;
    }
}
