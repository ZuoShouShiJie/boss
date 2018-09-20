package com.maiziyun.boss.web.interceptor;

import com.maiziyun.boss.web.vo.BaseRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截处理适配器
 * <p>
 * Created by  on 2017/4/12.
 */
public abstract class TokenInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(TokenInterceptorAdapter.class);

    public void preHandle(BaseRequest baseRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {

//        return true;
    }

//    ProceedingJoinPoint point,
    public Object preHandle(HttpServletRequest request) throws Exception {

        return true;
    }

  /*  protected void returnJson(HttpServletResponse response, String json) throws Exception {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);
        } catch (IOException e) {
            logger.error("httpResponse error", e);
        } finally {
            if (writer != null)
                writer.close();
        }
    }*/
}
