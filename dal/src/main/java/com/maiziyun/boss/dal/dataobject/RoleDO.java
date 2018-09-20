package com.maiziyun.boss.dal.dataobject;

import java.util.Date;

/**
 * The table BOSS_ROLE
 */
public class RoleDO{

    /**
     * id ID.
     */
    private Integer id;
    /**
     * isvalid ISVALID.
     */
    private String isvalid;
    /**
     * roleCode ROLE_CODE.
     */
    private String roleCode;
    /**
     * roleName ROLE_NAME.
     */
    private String roleName;
    /**
     * createTime CREATE_TIME.
     */
    private Date createTime;
    /**
     * updateTime UPDATE_TIME.
     */
    private Date updateTime;
    /**
     * describeContext DESCRIBE_CONTEXT.
     */
    private String describeContext;

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
     * Set isvalid ISVALID.
     */
    public void setIsvalid(String isvalid){
        this.isvalid = isvalid;
    }

    /**
     * Get isvalid ISVALID.
     *
     * @return the string
     */
    public String getIsvalid(){
        return isvalid;
    }

    /**
     * Set roleCode ROLE_CODE.
     */
    public void setRoleCode(String roleCode){
        this.roleCode = roleCode;
    }

    /**
     * Get roleCode ROLE_CODE.
     *
     * @return the string
     */
    public String getRoleCode(){
        return roleCode;
    }

    /**
     * Set roleName ROLE_NAME.
     */
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

    /**
     * Get roleName ROLE_NAME.
     *
     * @return the string
     */
    public String getRoleName(){
        return roleName;
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

    /**
     * Set describeContext DESCRIBE_CONTEXT.
     */
    public void setDescribeContext(String describeContext){
        this.describeContext = describeContext;
    }

    /**
     * Get describeContext DESCRIBE_CONTEXT.
     *
     * @return the string
     */
    public String getDescribeContext(){
        return describeContext;
    }
}
