package com.maiziyun.boss.facade.system.model.sysuser;

import com.solar.framework.core.base.AbstractRequest;

/**
 * Created by len.song on 2016/11/24.
 */
public class SysUserPageRequest extends AbstractRequest {
    private Integer rows;
    private Integer page;

    private String loginUserName;//当前登录用户账号名
    //查询条件
    private String userName;
    private String realName;//用户真实姓名
    private String status;
    private Integer roleId;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

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

    public String getRealName() {
        return realName;
    }

    public SysUserPageRequest setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public SysUserPageRequest setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
        return this;
    }
}
