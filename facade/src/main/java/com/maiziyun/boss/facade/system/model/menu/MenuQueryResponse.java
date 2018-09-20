package com.maiziyun.boss.facade.system.model.menu;

import com.maiziyun.boss.facade.common.model.QueryResponse;
import com.maiziyun.boss.facade.system.model.vo.MenuVo;

import java.util.List;

/**
 * Created by len.song on 2016/12/4.
 */
public class MenuQueryResponse extends QueryResponse{
    private List<Integer> menuIds;

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }
}
