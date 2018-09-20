package com.maiziyun.boss.dal.dataobject;

import java.util.Date;

/**
 * The table BOSS_EMPLOYEE
 */
public class EmployeeDO{

    /**
     * id ID.
     */
    private Integer id;
    /**
     * age AGE.
     */
    private String age;
    /**
     * sex SEX.
     */
    private String sex;
    /**
     * status STATUS.
     */
    private String status;
    /**
     * address ADDRESS.
     */
    private String address;
    /**
     * isvalid ISVALID.
     */
    private String isvalid;
    /**
     * nickName NICK_NAME.
     */
    private String nickName;
    /**
     * userName USER_NAME.
     */
    private String userName;
    /**
     * createTime CREATE_TIME.
     */
    private Date createTime;
    /**
     * updateTime UPDATE_TIME.
     */
    private Date updateTime;
    /**
     * englishName ENGLISH_NAME.
     */
    private String englishName;

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
     * Set age AGE.
     */
    public void setAge(String age){
        this.age = age;
    }

    /**
     * Get age AGE.
     *
     * @return the string
     */
    public String getAge(){
        return age;
    }

    /**
     * Set sex SEX.
     */
    public void setSex(String sex){
        this.sex = sex;
    }

    /**
     * Get sex SEX.
     *
     * @return the string
     */
    public String getSex(){
        return sex;
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
     * Set address ADDRESS.
     */
    public void setAddress(String address){
        this.address = address;
    }

    /**
     * Get address ADDRESS.
     *
     * @return the string
     */
    public String getAddress(){
        return address;
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
     * Set nickName NICK_NAME.
     */
    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    /**
     * Get nickName NICK_NAME.
     *
     * @return the string
     */
    public String getNickName(){
        return nickName;
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
     * Set englishName ENGLISH_NAME.
     */
    public void setEnglishName(String englishName){
        this.englishName = englishName;
    }

    /**
     * Get englishName ENGLISH_NAME.
     *
     * @return the string
     */
    public String getEnglishName(){
        return englishName;
    }
}
