package com.maiziyun.boss.facade.system.model.role;

import com.solar.framework.core.base.AbstractRequest;

/**
 * Created by len.song on 2016/11/30.
 */
public class RoleAddRequest  extends AbstractRequest {
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
}
