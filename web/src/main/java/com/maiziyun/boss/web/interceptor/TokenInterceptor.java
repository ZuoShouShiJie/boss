package com.maiziyun.boss.web.interceptor;


import com.maiziyun.boss.biz.redis.IBaseRedisService;
import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.facade.system.model.LoginResponse;
import com.maiziyun.boss.web.controller.ResponseUtil;
import com.maiziyun.boss.web.controller.ViewResponseModel;
import com.maiziyun.boss.web.vo.BaseRequest;
import com.maiziyun.common.enums.MyServiceCode;
import com.solar.framework.core.exception.BizException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 安全拦截器实现
 * <p>
 * Created by zhangshihang on 2017/4/11.
 */
@Aspect
@Order(2)
@Component
public class TokenInterceptor extends TokenInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(TokenInterceptorAdapter.class);

    @Resource(name = "boss.BaseRedisService")
    private IBaseRedisService baseRedisService;
    @Before("@annotation(com.maiziyun.boss.web.interceptor.annotation.TokenLogin)&&args(baseRequest,request,response)")
    @ResponseBody
    @Override
    public void preHandle(@RequestBody BaseRequest baseRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("AOP开始校验token");
        LoginResponse login = new LoginResponse();

        try {
            logger.info("token开始");
            String userName = baseRequest.getUserId();
            String token = baseRequest.getTokenId();

            Boolean flag = baseRedisService.cantainsKey(userName);
            if (flag) {
                if (!token.equals((String)baseRedisService.getValue(userName))) {
                    login.setCode(BossBizCode.TokenLoginFail);
                    login.setMessage(BossBizCode.TokenLoginFail.desc());
                    ResponseUtil.writeResponse(request, response, new ViewResponseModel(login, null));
                }
            } else {
                login.setCode(BossBizCode.TokenLoginFail);
                login.setMessage(BossBizCode.TokenLoginFail.desc());
                ResponseUtil.writeResponse(request, response, new ViewResponseModel(login, null));
            }

        } catch (Exception e) {
            login.setCode(BossBizCode.Unknown);
            login.setMessage(e.getMessage());
            ResponseUtil.writeResponse(request, response, new ViewResponseModel(login, null));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }


}
