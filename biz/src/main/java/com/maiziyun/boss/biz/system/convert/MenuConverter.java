package com.maiziyun.boss.biz.system.convert;

import com.maiziyun.boss.dal.dao.MenuDAO;
import com.maiziyun.boss.dal.dataobject.MenuDO;
import com.maiziyun.boss.facade.system.model.vo.MenuVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by len.song on 2016/11/22.
 */
public class MenuConverter {
    public static MenuVo reConvert(MenuDO menuDO){
        MenuVo menu = new MenuVo();
        menu.setId(menuDO.getId());
        menu.setLevel(menuDO.getLevel());
        menu.setMenuCode(menuDO.getModuleCode());
        menu.setMenuName(menuDO.getName());
        menu.setMenuParentCode(menuDO.getParentCode());
        menu.setSort(menuDO.getSort());
        menu.setUrlStr(menuDO.getUrl());
        menu.set_parentId(menuDO.getParentCode());
        return menu;
    }

    public static List<MenuVo> reConvert(List<MenuDO> params){
        List<MenuVo> lists = new ArrayList<MenuVo>();
        for(MenuDO m : params){
            MenuVo mv = reConvert(m);
            lists.add(mv);
        }
        return lists;
    }
}
