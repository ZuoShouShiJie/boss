package com.maiziyun.boss.facade.system.enums;

import com.solar.framework.core.base.AbstractEnum;

/**
 * Created by len.song on 2016/11/22.
 */
public class MenuLevel extends AbstractEnum {
    public static final MenuLevel ZERO = new MenuLevel("0","主菜单");
    public static final MenuLevel ONE = new MenuLevel("1","一级菜单");
    public static final MenuLevel TWO = new MenuLevel("2","二级菜单");

    public MenuLevel(String code, String name) {
        super(code, name);
    }

    MenuLevel(){

    }

    @Override
    protected Class<? extends AbstractEnum> getEnumType() {
        return MenuLevel.class;
    }
}
