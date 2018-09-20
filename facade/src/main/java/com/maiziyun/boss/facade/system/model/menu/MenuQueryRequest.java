package com.maiziyun.boss.facade.system.model.menu;

import com.solar.framework.core.base.AbstractRequest;

/**
 * Created by len.song on 2016/12/4.
 */
public class MenuQueryRequest extends AbstractRequest {
    private Integer roleId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
