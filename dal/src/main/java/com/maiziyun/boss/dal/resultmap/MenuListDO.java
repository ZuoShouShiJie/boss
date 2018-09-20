package com.maiziyun.boss.dal.resultmap;

import java.io.Serializable;

/**
 * The table MenuListDO
 */
public class MenuListDO implements Serializable {

private static final long serialVersionUID = -1L;

    /**
     * level .
     */
    private String level;
    /**
     * id .
     */
    private String id;
    /**
     * name .
     */
    private String name;
    /**
     * url .
     */
    private String url;
    /**
     * reload .
     */
    private String reload;
    /**
     * moduleCode .
     */
    private String moduleCode;
    /**
     * parentCode .
     */
    private String parentCode;

    /**
     * Set level .
     */
    public void setLevel(String level){
        this.level = level;
    }

    /**
     * Get level .
     *
     * @return the string
     */
    public String getLevel(){
        return level;
    }

    /**
     * Set id .
     */
    public void setId(String id){
        this.id = id;
    }

    /**
     * Get id .
     *
     * @return the string
     */
    public String getId(){
        return id;
    }

    /**
     * Set name .
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get name .
     *
     * @return the string
     */
    public String getName(){
        return name;
    }

    /**
     * Set url .
     */
    public void setUrl(String url){
        this.url = url;
    }

    /**
     * Get url .
     *
     * @return the string
     */
    public String getUrl(){
        return url;
    }

    /**
     * Set reload .
     */
    public void setReload(String reload){
        this.reload = reload;
    }

    /**
     * Get reload .
     *
     * @return the string
     */
    public String getReload(){
        return reload;
    }

    /**
     * Set moduleCode .
     */
    public void setModuleCode(String moduleCode){
        this.moduleCode = moduleCode;
    }

    /**
     * Get moduleCode .
     *
     * @return the string
     */
    public String getModuleCode(){
        return moduleCode;
    }

    /**
     * Set parentCode .
     */
    public void setParentCode(String parentCode){
        this.parentCode = parentCode;
    }

    /**
     * Get parentCode .
     *
     * @return the string
     */
    public String getParentCode(){
        return parentCode;
    }
}
