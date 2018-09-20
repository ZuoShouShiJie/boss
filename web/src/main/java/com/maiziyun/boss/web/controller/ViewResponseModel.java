package com.maiziyun.boss.web.controller;

import com.maiziyun.boss.web.common.utils.AuthenticationCode;
import com.solar.framework.core.base.AbstractModel;
import com.solar.framework.core.base.AbstractResponse;

import java.util.Map;

/**
 * Created by len.song on 2016/11/21.
 */
public class ViewResponseModel extends AbstractModel {
    private String code;//返回编码
    private String msg;//描述
    private Object data;//传输数据

    public ViewResponseModel() {

    }

    public ViewResponseModel(AbstractResponse response, Object data) {
        this.code = response.getCode().code();
        this.msg = response.getMessage();
        this.data = data;

    }

    /*public ViewResponseModel(AuthenticationCode e, Object object) {
        this.code = e.getCode();
        this.msg = e.getName();
        this.object = object;
    }*/

    public ViewResponseModel(AbstractResponse response, String token,String s) {
        this.code = "000000";
        this.msg = response.getCode().desc();
        if (token != null ) {
            putExtField("token", token);
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
