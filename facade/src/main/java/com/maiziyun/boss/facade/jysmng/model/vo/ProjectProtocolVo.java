package com.maiziyun.boss.facade.jysmng.model.vo;

import com.solar.framework.core.base.AbstractModel;

/**
 * Created by admin on 2017/12/4.
 */
public class ProjectProtocolVo extends AbstractModel {
    private String name;
    private String url;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
