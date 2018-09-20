package com.maiziyun.boss.facade.system.service;

import com.maiziyun.boss.facade.system.model.LoginRequest;
import com.maiziyun.boss.facade.system.model.LoginResponse;

/**
 * Created by songliang on 2016/11/15.
 */
public interface LoginService {
    /**
     * 用户登录
     * @param request
     * @return
     */
    LoginResponse login(LoginRequest request);
}
