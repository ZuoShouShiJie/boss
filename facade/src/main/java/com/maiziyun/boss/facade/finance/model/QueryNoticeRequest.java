package com.maiziyun.boss.facade.finance.model;

import com.solar.framework.core.base.AbstractPagedRequest;

/**
 * Created by admin on 2017/6/26.
 */
public class QueryNoticeRequest extends AbstractPagedRequest{
    private String id;
    private String stateId;
    private String type;
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
