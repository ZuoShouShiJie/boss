package com.maiziyun.boss.facade.system.model.vo;

import com.solar.framework.core.base.AbstractModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by len.song on 2016/11/21.
 */
public class MenuVo extends AbstractModel {
    private Integer id;
    private String menuName;
    private String menuCode;//菜单编码
    private String menuParentCode;//菜单父类编码
    private String level;//菜单级别
    private String sort;//菜单排序

    private String urlStr;//访问路径

    private String _parentId;//easy用来前端识别字段

    private List<MenuVo> childMenus;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuParentCode() {
        return menuParentCode;
    }

    public void setMenuParentCode(String menuParentCode) {
        this.menuParentCode = menuParentCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getUrlStr() {
        return urlStr;
    }

    public void setUrlStr(String urlStr) {
        this.urlStr = urlStr;
    }

    public List<MenuVo> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<MenuVo> childMenus) {
        this.childMenus = childMenus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String get_parentId() {
        return _parentId;
    }

    public void set_parentId(String _parentId) {
        this._parentId = _parentId;
    }
}
