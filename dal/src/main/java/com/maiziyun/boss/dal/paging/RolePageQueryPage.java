package com.maiziyun.boss.dal.paging;

import com.maiziyun.boss.dal.paging.BasePage;
import com.maiziyun.boss.dal.dataobject.RoleDO;

/**
 * The table BOSS_ROLE BOSS_ROLE
 */
public class RolePageQueryPage extends BasePage<RoleDO>{

    /**
     * nameQuery .
     */
    private String nameQuery;
    /**
     * codeQuery .
     */
    private String codeQuery;

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
     * Set codeQuery .
     */
    public void setCodeQuery(String codeQuery){
        this.codeQuery = codeQuery;
    }

    /**
     * Get codeQuery .
     *
     * @return the string
     */
    public String getCodeQuery(){
        return codeQuery;
    }
}
