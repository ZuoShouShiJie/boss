package com.maiziyun.boss.dal.resultmap;

import java.io.Serializable;
import java.lang.Integer;

/**
 * The table RoleNameMap
 */
public class RoleNameMap implements Serializable {

private static final long serialVersionUID = -1L;

    /**
     * operatorId 操作员编号.
     */
    private Integer operatorId;
    /**
     * userName 用户名.
     */
    private String userName;
    /**
     * roleName 角色名称.
     */
    private String roleName;
    /**
     * roleCode 角色缩写编号.
     */
    private String roleCode;

    /**
     * Set operatorId 操作员编号.
     */
    public void setOperatorId(Integer operatorId){
        this.operatorId = operatorId;
    }

    /**
     * Get operatorId 操作员编号.
     *
     * @return the string
     */
    public Integer getOperatorId(){
        return operatorId;
    }

    /**
     * Set userName 用户名.
     */
    public void setUserName(String userName){
        this.userName = userName;
    }

    /**
     * Get userName 用户名.
     *
     * @return the string
     */
    public String getUserName(){
        return userName;
    }

    /**
     * Set roleName 角色名称.
     */
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

    /**
     * Get roleName 角色名称.
     *
     * @return the string
     */
    public String getRoleName(){
        return roleName;
    }

    /**
     * Set roleCode 角色缩写编号.
     */
    public void setRoleCode(String roleCode){
        this.roleCode = roleCode;
    }

    /**
     * Get roleCode 角色缩写编号.
     *
     * @return the string
     */
    public String getRoleCode(){
        return roleCode;
    }
}
