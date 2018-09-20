package com.maiziyun.boss.facade.common.model.vo;

import com.maiziyun.boss.facade.common.model.BaseRequest;

import java.io.Serializable;

/**
 * Created by admin on 2017/11/6.
 */
public class StateVo implements Serializable {


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
    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
