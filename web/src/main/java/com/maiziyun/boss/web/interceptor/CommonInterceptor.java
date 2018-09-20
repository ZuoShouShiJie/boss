package com.maiziyun.boss.web.interceptor;

/**
 * Created by zhangshihang on 2017/3/10.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Spring MVC拦截器
 *
 * @author gary
 */
public class CommonInterceptor extends HandlerInterceptorAdapter implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonInterceptor.class);

    /**
     * 在系统启动时执行
     */
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("=======初始化CommonInterceptor拦截器=========");
    }

    /**
     * 在Controller方法前进行拦截
     * 如果返回false
     * 从当前拦截器往回执行所有拦截器的afterCompletion方法,再退出拦截器链.
     * 如果返回true
     * 执行下一个拦截器,直到所有拦截器都执行完毕.
     * 再运行被拦截的Controller.
     * 然后进入拦截器链,从最后一个拦截器往回运行所有拦截器的postHandle方法.
     * 接着依旧是从最后一个拦截器往回执行所有拦截器的afterCompletion方法.
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info("=====preHandle====：");
        LOGGER.info("httpRequest{}："+request);
        LOGGER.info("contentType{}："+request.getContentType());
        LOGGER.info("authType{}："+request.getAuthType());
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS,DELETE,PUT");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type");
//        response.setHeader("Access-Control-Request-Methods", "POST, OPTIONS,PUT");
//        response.addHeader("Access-Control-Allow-Credentials", "true");
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        LOGGER.info("==========postHandle=========");

        if (modelAndView != null) {
            String viewName = modelAndView.getViewName();
            LOGGER.info("view name : " + viewName);
        } else {
            LOGGER.info("view is null");
        }
    }

    /**
     * 在Controller方法后进行拦截
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有拦截器的afterCompletion方法
     */
    @Override
    public void afterCompletion(HttpServletRequest httpservletrequest,
                                HttpServletResponse httpservletresponse, Object obj,
                                Exception exception) throws Exception {
        LOGGER.info("=====afterCompletion====");
        LOGGER.info("httpResponse{}:", httpservletresponse);
        LOGGER.info("Object{}:", obj);
        LOGGER.info("=====本次请求结束=====");
    }


}
