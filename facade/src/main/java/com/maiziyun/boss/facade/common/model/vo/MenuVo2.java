package com.maiziyun.boss.facade.common.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/8/3.
 */
public class MenuVo2 implements Serializable {
    private String id;
    private String title;
    private String reload;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReload() {
        return reload;
    }

    public void setReload(String reload) {
        this.reload = reload;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
