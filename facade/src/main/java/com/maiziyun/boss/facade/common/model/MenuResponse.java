package com.maiziyun.boss.facade.common.model;

import com.maiziyun.boss.facade.common.model.vo.MenuVo1;
import com.maiziyun.boss.facade.system.model.vo.MenuVo;
import com.solar.framework.core.base.AbstractResponse;

import java.util.List;

/**
 * Created by admin on 2017/8/3.
 */
public class MenuResponse extends AbstractResponse {
    private String level;
    private List<MenuVo1> list;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<MenuVo1> getList() {
        return list;
    }

    public void setList(List<MenuVo1> list) {
        this.list = list;
    }
}
