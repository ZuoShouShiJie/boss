package com.maiziyun.boss.facade.system.model.role;

import com.solar.framework.core.base.AbstractRequest;

/**
 * Created by len.song on 2016/11/30.
 */
public class RoleModifyRequest extends AbstractRequest {
    private Integer roleId;
    private String isValid;

    private String roleName;
    private String roleCode;


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }
}
