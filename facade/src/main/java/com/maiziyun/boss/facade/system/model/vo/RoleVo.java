package com.maiziyun.boss.facade.system.model.vo;

import com.solar.framework.core.base.AbstractModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by songliang on 2016/11/17.
 */
public class RoleVo extends AbstractModel {
    private Integer roleId;//角色名称
    private String roleName;//角色名称
    private String roleCode;//角色编号
    private String createTime;//创建时间

    private String updateTime;//更新时间

    private List<Integer> menus; //对应的菜单列表



    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

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

    public List<Integer> getMenus() {
        return menus;
    }

    public void setMenus(List<Integer> menus) {
        this.menus = menus;
    }
}
