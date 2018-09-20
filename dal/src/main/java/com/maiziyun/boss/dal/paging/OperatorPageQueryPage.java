package com.maiziyun.boss.dal.paging;

import com.maiziyun.boss.dal.paging.BasePage;
import com.maiziyun.boss.dal.dataobject.OperatorDO;

/**
 * The table BOSS_OPERATOR BOSS_OPERATOR
 */
public class OperatorPageQueryPage extends BasePage<OperatorDO>{

    /**
     * nameQuery .
     */
    private String nameQuery;
    /**
     * realName REAL_NAME.
     */
    private String realName;
    /**
     * loginUserName .
     */
    private String loginUserName;
    /**
     * statusQuery .
     */
    private String statusQuery;
    /**
     * roleId .
     */
    private Integer roleId;

    /**
     * Set nameQuery .
     */
    public void setNameQuery(String nameQuery){
        this.nameQuery = nameQuery;
    }

    /**
     * Get nameQuery .
     *
     * @return the string
     */
    public String getNameQuery(){
        return nameQuery;
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
     * Set loginUserName .
     */
    public void setLoginUserName(String loginUserName){
        this.loginUserName = loginUserName;
    }

    /**
     * Get loginUserName .
     *
     * @return the string
     */
    public String getLoginUserName(){
        return loginUserName;
    }

    /**
     * Set statusQuery .
     */
    public void setStatusQuery(String statusQuery){
        this.statusQuery = statusQuery;
    }

    /**
     * Get statusQuery .
     *
     * @return the string
     */
    public String getStatusQuery(){
        return statusQuery;
    }

    /**
     * Set roleId .
     */
    public void setRoleId(Integer roleId){
        this.roleId = roleId;
    }

    /**
     * Get roleId .
     *
     * @return the string
     */
    public Integer getRoleId(){
        return roleId;
    }
}
