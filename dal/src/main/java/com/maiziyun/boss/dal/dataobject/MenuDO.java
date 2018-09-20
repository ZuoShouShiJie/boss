package com.maiziyun.boss.dal.dataobject;

import java.util.Date;

/**
 * The table BOSS_MENU
 */
public class MenuDO{

    /**
     * id ID.
     */
    private Integer id;
    /**
     * url URL.
     */
    private String url;
    /**
     * name NAME.
     */
    private String name;
    /**
     * sort SORT.
     */
    private String sort;
    /**
     * level LEVEL.
     */
    private String level;
    /**
     * isvalid ISVALID.
     */
    private String isvalid;
    /**
     * createTime CREATE_TIME.
     */
    private Date createTime;
    /**
     * moduleCode MODULE_CODE.
     */
    private String moduleCode;
    /**
     * parentCode PARENT_CODE.
     */
    private String parentCode;
    /**
     * updateTime UPDATE_TIME.
     */
    private Date updateTime;
    /**
     * description DESCRIPTION.
     */
    private String description;

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
     * Set url URL.
     */
    public void setUrl(String url){
        this.url = url;
    }

    /**
     * Get url URL.
     *
     * @return the string
     */
    public String getUrl(){
        return url;
    }

    /**
     * Set name NAME.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get name NAME.
     *
     * @return the string
     */
    public String getName(){
        return name;
    }

    /**
     * Set sort SORT.
     */
    public void setSort(String sort){
        this.sort = sort;
    }

    /**
     * Get sort SORT.
     *
     * @return the string
     */
    public String getSort(){
        return sort;
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
     * Set moduleCode MODULE_CODE.
     */
    public void setModuleCode(String moduleCode){
        this.moduleCode = moduleCode;
    }

    /**
     * Get moduleCode MODULE_CODE.
     *
     * @return the string
     */
    public String getModuleCode(){
        return moduleCode;
    }

    /**
     * Set parentCode PARENT_CODE.
     */
    public void setParentCode(String parentCode){
        this.parentCode = parentCode;
    }

    /**
     * Get parentCode PARENT_CODE.
     *
     * @return the string
     */
    public String getParentCode(){
        return parentCode;
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
     * Set description DESCRIPTION.
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Get description DESCRIPTION.
     *
     * @return the string
     */
    public String getDescription(){
        return description;
    }
}
