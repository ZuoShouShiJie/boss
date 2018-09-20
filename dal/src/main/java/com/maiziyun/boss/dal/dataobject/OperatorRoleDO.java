package com.maiziyun.boss.dal.dataobject;

import java.util.Date;

/**
 * The table BOSS_OPERATOR_ROLE
 */
public class OperatorRoleDO{

    /**
     * id ID.
     */
    private Integer id;
    /**
     * roleId ROLE_ID.
     */
    private Integer roleId;
    /**
     * createTime CREATE_TIME.
     */
    private Date createTime;
    /**
     * operatorId OPERATOR_ID.
     */
    private Integer operatorId;
    /**
     * updateTime UPDATE_TIME.
     */
    private Date updateTime;

    /**
     * Set id ID.
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * Get id ID.
     *
     * @return the string
     */
    public Integer getId(){
        return id;
    }

    /**
     * Set roleId ROLE_ID.
     */
    public void setRoleId(Integer roleId){
        this.roleId = roleId;
    }

    /**
     * Get roleId ROLE_ID.
     *
     * @return the string
     */
    public Integer getRoleId(){
        return roleId;
    }

    /**
     * Set createTime CREATE_TIME.
     */
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    /**
     * Get createTime CREATE_TIME.
     *
     * @return the string
     */
    public Date getCreateTime(){
        return createTime;
    }

    /**
     * Set operatorId OPERATOR_ID.
     */
    public void setOperatorId(Integer operatorId){
        this.operatorId = operatorId;
    }

    /**
     * Get operatorId OPERATOR_ID.
     *
     * @return the string
     */
    public Integer getOperatorId(){
        return operatorId;
    }

    /**
     * Set updateTime UPDATE_TIME.
     */
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }

    /**
     * Get updateTime UPDATE_TIME.
     *
     * @return the string
     */
    public Date getUpdateTime(){
        return updateTime;
    }
}
