package com.maiziyun.boss.facade.group.model.vo;

import com.solar.framework.core.base.AbstractModel;

/**
 * Created by admin on 2017/11/22.
 */
public class QueryFundProductVo extends AbstractModel{
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
