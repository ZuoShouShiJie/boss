package com.maiziyun.boss.facade.system.model;

import com.maiziyun.boss.facade.system.model.base.AbstractServiceOperatorRequest;

/**
 * Created by songliang on 2016/11/15.
 */
public class LoginRequest extends AbstractServiceOperatorRequest {

    private String captcha;//验证码

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
