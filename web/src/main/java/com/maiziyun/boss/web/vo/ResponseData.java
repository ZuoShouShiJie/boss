package com.maiziyun.boss.web.vo;

import com.solar.framework.core.base.AbstractModel;

/**
 * Created by admin on 2017/7/15.
 */
public class ResponseData extends AbstractModel{
    private String code;
    private String msg;
    private Object data;

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
