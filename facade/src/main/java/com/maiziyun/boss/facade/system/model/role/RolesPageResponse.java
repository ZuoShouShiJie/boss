package com.maiziyun.boss.facade.system.model.role;

import com.maiziyun.boss.facade.system.model.vo.RoleVo;
import com.maiziyun.boss.facade.system.model.vo.SysUserVo;
import com.solar.framework.core.base.AbstractResponse;

import java.util.List;

/**
 * Created by len.song on 2016/11/24.
 */
public class RolesPageResponse extends AbstractResponse {
    private Integer total;  //总数
    private List<RoleVo> roles;


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<RoleVo> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleVo> roles) {
        this.roles = roles;
    }
}
