package com.maiziyun.boss.facade.common.model.vo;

import com.maiziyun.boss.facade.system.model.vo.RoleVo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by songliang on 2016/11/15.
 */
public class OperatorVo implements Serializable{
    private Integer operatorId;//操作员id
    private String password;//密码
    private String operatorName;//操作员名称
    private String lastLoginTime;//上一次登录时间

    private List<RoleVo> roleVos;//角色id

    public List<RoleVo> getRoleVos() {
        return roleVos;
    }

    public void setRoleVos(List<RoleVo> roleVos) {
        this.roleVos = roleVos;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
