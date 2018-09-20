package com.maiziyun.boss.facade.system.model.sysuser;

import com.solar.framework.core.base.AbstractRequest;

import java.util.List;

/**
 * Created by len.song on 2016/12/1.
 */
public class SysUserModifyRequest extends AbstractRequest {
    private Integer id;
    private String userName;
    private String realName;
    private String password;
    private String status;
    private List<Integer> roleIds;//角色

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public SysUserModifyRequest setRealName(String realName) {
        this.realName = realName;
        return this;
    }
}
