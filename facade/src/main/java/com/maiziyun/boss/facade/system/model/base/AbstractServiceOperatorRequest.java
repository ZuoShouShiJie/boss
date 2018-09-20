package com.maiziyun.boss.facade.system.model.base;

import com.solar.framework.core.base.AbstractRequest;

/**
 * Created by songliang on 2016/11/15.
 */
public abstract class AbstractServiceOperatorRequest extends AbstractRequest implements OperatorServiceRequest {
    private Integer userId;//用户名编号
    private String userName;//登录用户名

    private String password;//登录密码

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
