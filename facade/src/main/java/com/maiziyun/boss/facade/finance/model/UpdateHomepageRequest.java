package com.maiziyun.boss.facade.finance.model;

import com.maiziyun.boss.facade.common.model.BaseRequest;

/**
 * Created by admin on 2017/8/31.
 */
public class UpdateHomepageRequest extends BaseRequest {
    private String id;
    private String type;
    private String content;
    private String qudaoId;
    private String stateId;
    private String startTime;
    private String endTime;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQudaoId() {
        return qudaoId;
    }

    public void setQudaoId(String qudaoId) {
        this.qudaoId = qudaoId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
