package com.maiziyun.boss.facade.user.model;

import com.solar.framework.core.base.AbstractRequest;

/**
 * Created by len.song on 2016/11/24.
 */
public class UserPageRequest extends AbstractRequest {
    private Integer rows;
    private Integer page;

    //查询条件
    private String userName;//姓名
    private String phone;//手机

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
