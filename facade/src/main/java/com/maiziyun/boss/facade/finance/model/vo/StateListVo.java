package com.maiziyun.boss.facade.finance.model.vo;

import com.solar.framework.core.base.AbstractModel;

import java.io.Serializable;

/**
 * Created by admin on 2017/6/22.
 */
public class StateListVo implements Serializable{
    private String id;
    private String name;

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
}
