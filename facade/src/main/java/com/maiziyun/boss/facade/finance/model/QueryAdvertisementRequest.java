package com.maiziyun.boss.facade.finance.model;

import com.solar.framework.core.base.AbstractPagedRequest;
import com.solar.framework.core.base.AbstractRequest;

/**
 * Created by admin on 2017/6/15.
 */
public class QueryAdvertisementRequest extends AbstractPagedRequest {
    private String id;
    private String state;
    private String position;
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
