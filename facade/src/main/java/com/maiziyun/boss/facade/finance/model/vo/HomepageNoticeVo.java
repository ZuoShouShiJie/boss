package com.maiziyun.boss.facade.finance.model.vo;

import com.solar.framework.core.base.AbstractModel;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/31.
 */
public class HomepageNoticeVo implements Serializable {
    private String id;
    private String type;
    private String content;
    private String qudaoId;
    private String stateId;
    private String startTime;
    private String endTime;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "HomepageNoticeVo{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", qudaoId='" + qudaoId + '\'' +
                ", stateId='" + stateId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
