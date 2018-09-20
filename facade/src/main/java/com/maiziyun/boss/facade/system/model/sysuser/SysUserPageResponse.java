package com.maiziyun.boss.facade.system.model.sysuser;

import com.maiziyun.boss.facade.system.model.vo.RoleVo;
import com.maiziyun.boss.facade.system.model.vo.SysUserVo;
import com.solar.framework.core.base.AbstractResponse;

import java.util.List;

/**
 * Created by len.song on 2016/11/24.
 */
public class SysUserPageResponse extends AbstractResponse {
    private Integer total;  //总数
    private List<SysUserVo> users;


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<SysUserVo> getUsers() {
        return users;
    }

    public void setUsers(List<SysUserVo> users) {
        this.users = users;
    }
}
