package com.maiziyun.boss.facade.common.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/8/3.
 */
public class MenuVo1 implements Serializable {
    private String id;
    private String name;
    private List<MenuVo2> menus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuVo2> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuVo2> menus) {
        this.menus = menus;
    }
}
