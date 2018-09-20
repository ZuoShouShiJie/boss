package com.maiziyun.boss.web.common.utils;

import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by len.song on 2016/12/14.
 */
public class AuthenticationCode {
    private String code;
    private String name;

    private static final AuthenticationCode BadCredentials;
    private static final AuthenticationCode InsufficientAuthenticationException;
    private static final AuthenticationCode UserNotFound ;
    private static final AuthenticationCode AccountExpired;
    private static final AuthenticationCode ProviderNotFound;
    private static final AuthenticationCode Disabled;
    private static final AuthenticationCode Locked;
    private static final AuthenticationCode AuthenticationService;
    private static final AuthenticationCode CredentialsExpired;
    private static final AuthenticationCode Unknown;
    private static final AuthenticationCode Success;

    public AuthenticationCode(String code, String name){
        this.code = code;
        this.name = name;
    }

    static {
        BadCredentials = new AuthenticationCode("sec003","用户名或密码错误");
        UserNotFound = new AuthenticationCode("sec004","用户不存在");
        AccountExpired = new AuthenticationCode("sec002","登录超时");
        ProviderNotFound = new AuthenticationCode("sec005","");
        Disabled = new AuthenticationCode("sec006","");
        Locked = new AuthenticationCode("sec007","");
        AuthenticationService = new AuthenticationCode("sec008","用户不存在");
        CredentialsExpired = new AuthenticationCode("sec009","");
        Unknown = new AuthenticationCode("sec001","登录未知异常");
        InsufficientAuthenticationException = new AuthenticationCode("sec010","访问受限");
        Success = new AuthenticationCode("000000","验证成功");
    }

    public static AuthenticationCode getSuccess(){
        return AuthenticationCode.Success;
    }

    public static AuthenticationCode buildAuthCode(AuthenticationException exception) {
        AuthenticationCode authCode = null;
        if (exception instanceof BadCredentialsException) {
            authCode = AuthenticationCode.BadCredentials;
        } else if (exception instanceof UsernameNotFoundException) {
            authCode = AuthenticationCode.UserNotFound;
        } else if (exception instanceof AccountExpiredException) {
            authCode = AuthenticationCode.AccountExpired;
        } else if (exception instanceof ProviderNotFoundException) {
            authCode = AuthenticationCode.ProviderNotFound;
        } else if (exception instanceof DisabledException) {
            authCode = AuthenticationCode.Disabled;
        } else if (exception instanceof LockedException) {
            authCode = AuthenticationCode.Locked;
        } else if (exception instanceof AuthenticationServiceException) {
            authCode = AuthenticationCode.AuthenticationService;
        } else if (exception instanceof CredentialsExpiredException) {
            authCode = AuthenticationCode.CredentialsExpired;
        } else if(exception instanceof InsufficientAuthenticationException){
            authCode = AuthenticationCode.InsufficientAuthenticationException;
        }else {
            authCode = AuthenticationCode.Unknown;
        }
        return authCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
