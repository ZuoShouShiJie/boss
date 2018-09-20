package com.maiziyun.boss.facade.system.model.role;

import com.solar.framework.core.base.AbstractRequest;

import java.util.List;

/**
 * Created by len.song on 2016/12/5.
 */
public class RoleAddMenuRequest extends AbstractRequest {
    private Integer roleId;
    private List<Integer> menuIds;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }
}
