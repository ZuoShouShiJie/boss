package com.maiziyun.boss.web.controller.common;

import com.maiziyun.boss.common.spring.DateEditor;
import org.apache.log4j.lf5.LF5Appender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;


/**
 * Created by songliang on 2016/11/11.
 */
public class BaseController {

    private  static  final Logger logger = LoggerFactory.getLogger(BaseController.class);
    /**
     * 自定义Date转换器
     * 对于需要转换为Date类型的属性，使用DateEditor进行处理
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateEditor());
    }

    /**
     * controller 执行前 注入
     * 解决浏览器同域的问题
     * @param request
     * @param response
     */
//    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        logger.info("接收到请求{}：" + request);
//        response.setHeader("X-Frame-Options", "SAMEORIGIN");
//        response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8080");
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS,DELETE,PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type");
        response.setHeader("Access-Control-Request-Methods", "POST,PUT");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Content-Type", "text/plain");
    }

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    /**
     * 获取域
     */
    @ModelAttribute
    public void initField(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    public UserDetails getUsers(){
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public String getUserName(){
        UserDetails user = this.getUsers();
        if(user==null){
            return null;
        }
        return user.getUsername();
    }
}
