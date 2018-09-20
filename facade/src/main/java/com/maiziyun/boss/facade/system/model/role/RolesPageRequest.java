package com.maiziyun.boss.facade.system.model.role;

import com.solar.framework.core.base.AbstractRequest;

/**
 * Created by len.song on 2016/11/24.
 */
public class RolesPageRequest extends AbstractRequest {
    private Integer rows;
    private Integer page;

    //查询条件
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
}
