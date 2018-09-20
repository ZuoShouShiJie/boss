package com.maiziyun.boss.facade.user.model;

import com.solar.framework.core.base.AbstractRequest;

/**
 * Created by len.song on 2016/12/18.
 */
public class UserTransPageRequest extends AbstractRequest {
    private Integer rows;
    private Integer page;

    //查询条件
    private String userId;
    private String userTransName;//交易名称
    private String userTransStatus;//交易状态
    private String startTime;
    private String endTime;

    public Integer getRows() {
        return rows;
    }

    public UserTransPageRequest setRows(Integer rows) {
        this.rows = rows;
        return this;
    }

    public Integer getPage() {
        return page;
    }

    public UserTransPageRequest setPage(Integer page) {
        this.page = page;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public UserTransPageRequest setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUserTransName() {
        return userTransName;
    }

    public UserTransPageRequest setUserTransName(String userTransName) {
        this.userTransName = userTransName;
        return this;
    }

    public String getUserTransStatus() {
        return userTransStatus;
    }

    public UserTransPageRequest setUserTransStatus(String userTransStatus) {
        this.userTransStatus = userTransStatus;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public UserTransPageRequest setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public UserTransPageRequest setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }
}
