package com.maiziyun.boss.web.controller;

import com.alibaba.fastjson.JSON;
import com.maiziyun.boss.facade.common.model.SuccessResponse;
import com.solar.framework.core.base.AbstractPagedResponse;
import com.solar.framework.core.base.AbstractResponse;
import com.solar.framework.core.enums.BizCode;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by len.song on 2016/11/22.
 */
public class ResponseUtil {
    private static Logger logger = LoggerFactory.getLogger(ResponseUtil.class);

    private static String DEFAULT_ENCODING = "UTF-8";
    private static String DEFAULT_JSONP = "jsoncallback";

    public static void setContentTypeHeader(HttpServletResponse response) {
        String encoding = response.getCharacterEncoding();
        if (StringUtils.isBlank(encoding)) {
            encoding = DEFAULT_ENCODING;
            response.setCharacterEncoding(encoding);
        }
        response.setContentType("text/html;charset=" + encoding);
    }

    /**
     * 向客户端写响应内容
     *
     * @param response
     *            http响应
     * @param content
     *            需要写到浏览器的响应内容
     */
    private static void writeResponse(HttpServletRequest request, HttpServletResponse response, String content) {
        Writer writer = null;
        try {
            String jsoncallback = request.getParameter(DEFAULT_JSONP);

            setContentTypeHeader(response);
            writer = response.getWriter();
            if (StringUtils.isBlank(jsoncallback)) {
                writer.write(content);
            } else {
                writer.write(jsoncallback + "(" + content + ")");
            }
        } catch (IOException e) {
            logger.error("write response error", e);
        } finally {
            if (writer != null) {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    logger.error("close response error", e);
                }
            }
        }
    }

    public static void writeResponse(HttpServletRequest request, HttpServletResponse response, ViewResponseModel model) {
        writeResponse(request, response, JSON.toJSONString(model));// ,SerializerFeature.BrowserCompatible));
    }

    public static void writeResponse(HttpServletRequest request, HttpServletResponse response, Object object) {
        writeResponse(request, response, JSON.toJSONString(object));// ,SerializerFeature.BrowserCompatible));
    }


    /**
     * 获取成功返回码
     * @return
     */
    public static AbstractResponse getSuccessResponse(){
        SuccessResponse response = new SuccessResponse();
        response.setCode(BizCode.Success);
        //response.setMessage("Success");
        response.setMessage("成功");
        return response;
    }

}
