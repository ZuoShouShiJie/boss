package com.maiziyun.boss.facade.finance.model.vo;

import com.solar.framework.core.base.AbstractModel;

import java.io.Serializable;

/**
 * Created by admin on 2017/6/26.
 */
public class NoticeManagerVo implements Serializable{
    private String announcementId;
    private String title;
    private String typeId;
    private String typeName;
    private String updateTime;
    private String stateId;
    private String stateName;
    private String startTime;
    private String endTime;

    private String content;
    private String qudaoId;
    private String qudaoName;

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

    public String getQudaoName() {
        return qudaoName;
    }

    public void setQudaoName(String qudaoName) {
        this.qudaoName = qudaoName;
    }

    public String getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(String announcementId) {
        this.announcementId = announcementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
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
