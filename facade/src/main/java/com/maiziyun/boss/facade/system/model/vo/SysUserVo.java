package com.maiziyun.boss.facade.system.model.vo;

import com.solar.framework.core.base.AbstractModel;

import java.util.Date;
import java.util.List;

/**
 * Created by len.song on 2016/12/1.
 */
public class SysUserVo extends AbstractModel {
    private Integer userId;//用户主键id
    private String userName;//用户名
    private String realName;//用户姓名

    private String status;//状态

    private List<Integer> roleIds;//角色编号

    private String lastLoginIp;
    private String lastLoginTime;
    private String firstLoginTime;
    private String createTime;//创建时间
    private String updateTime;//修改时间


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getFirstLoginTime() {
        return firstLoginTime;
    }

    public void setFirstLoginTime(String firstLoginTime) {
        this.firstLoginTime = firstLoginTime;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getRealName() {
        return realName;
    }

    public SysUserVo setRealName(String realName) {
        this.realName = realName;
        return this;
    }
}
