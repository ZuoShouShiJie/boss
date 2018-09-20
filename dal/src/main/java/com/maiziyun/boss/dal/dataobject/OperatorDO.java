package com.maiziyun.boss.dal.dataobject;

import java.util.Date;

/**
 * The table BOSS_OPERATOR
 */
public class OperatorDO{

    /**
     * id ID.
     */
    private Integer id;
    /**
     * level LEVEL.
     */
    private String level;
    /**
     * status STATUS.
     */
    private String status;
    /**
     * isvalid ISVALID.
     */
    private String isvalid;
    /**
     * password PASSWORD.
     */
    private String password;
    /**
     * realName REAL_NAME.
     */
    private String realName;
    /**
     * userName USER_NAME.
     */
    private String userName;
    /**
     * createTime CREATE_TIME.
     */
    private Date createTime;
    /**
     * employeeId EMPLOYEE_ID.
     */
    private Integer employeeId;
    /**
     * updateTime UPDATE_TIME.
     */
    private Date updateTime;
    /**
     * lastLoginIp LAST_LOGIN_IP.
     */
    private String lastLoginIp;
    /**
     * lastLoginTime LAST_LOGIN_TIME.
     */
    private Date lastLoginTime;
    /**
     * firstLoginTime FIRST_LOGIN_TIME.
     */
    private Date firstLoginTime;

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
     * Set level LEVEL.
     */
    public void setLevel(String level){
        this.level = level;
    }

    /**
     * Get level LEVEL.
     *
     * @return the string
     */
    public String getLevel(){
        return level;
    }

    /**
     * Set status STATUS.
     */
    public void setStatus(String status){
        this.status = status;
    }

    /**
     * Get status STATUS.
     *
     * @return the string
     */
    public String getStatus(){
        return status;
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
     * Set password PASSWORD.
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * Get password PASSWORD.
     *
     * @return the string
     */
    public String getPassword(){
        return password;
    }

    /**
     * Set realName REAL_NAME.
     */
    public void setRealName(String realName){
        this.realName = realName;
    }

    /**
     * Get realName REAL_NAME.
     *
     * @return the string
     */
    public String getRealName(){
        return realName;
    }

    /**
     * Set userName USER_NAME.
     */
    public void setUserName(String userName){
        this.userName = userName;
    }

    /**
     * Get userName USER_NAME.
     *
     * @return the string
     */
    public String getUserName(){
        return userName;
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
     * Set employeeId EMPLOYEE_ID.
     */
    public void setEmployeeId(Integer employeeId){
        this.employeeId = employeeId;
    }

    /**
     * Get employeeId EMPLOYEE_ID.
     *
     * @return the string
     */
    public Integer getEmployeeId(){
        return employeeId;
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
     * Set lastLoginIp LAST_LOGIN_IP.
     */
    public void setLastLoginIp(String lastLoginIp){
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * Get lastLoginIp LAST_LOGIN_IP.
     *
     * @return the string
     */
    public String getLastLoginIp(){
        return lastLoginIp;
    }

    /**
     * Set lastLoginTime LAST_LOGIN_TIME.
     */
    public void setLastLoginTime(Date lastLoginTime){
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * Get lastLoginTime LAST_LOGIN_TIME.
     *
     * @return the string
     */
    public Date getLastLoginTime(){
        return lastLoginTime;
    }

    /**
     * Set firstLoginTime FIRST_LOGIN_TIME.
     */
    public void setFirstLoginTime(Date firstLoginTime){
        this.firstLoginTime = firstLoginTime;
    }

    /**
     * Get firstLoginTime FIRST_LOGIN_TIME.
     *
     * @return the string
     */
    public Date getFirstLoginTime(){
        return firstLoginTime;
    }
}
