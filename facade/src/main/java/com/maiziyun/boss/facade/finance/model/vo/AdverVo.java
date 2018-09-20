package com.maiziyun.boss.facade.finance.model.vo;

import com.solar.framework.core.base.AbstractModel;

import java.io.Serializable;

/**
 * Created by admin on 2017/6/16.
 */
public class AdverVo implements Serializable{
    private String id;
    private String title;
    private String positionId;
    private String PositionName;
    private String order;
    private String updateTime;
    private String stateId;
    private String stateName;
    private String startTime;
    private String endTime;

    private String targetUrl;
    private String coverImgUrl;
    private String qudaoId;
    private String qudaoName;

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

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return PositionName;
    }

    public void setPositionName(String positionName) {
        PositionName = positionName;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
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

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
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

    @Override
    public String toString() {
        return "AdverVo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", positionId='" + positionId + '\'' +
                ", PositionName='" + PositionName + '\'' +
                ", order='" + order + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", stateId='" + stateId + '\'' +
                ", stateName='" + stateName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", targetUrl='" + targetUrl + '\'' +
                ", coverImgUrl='" + coverImgUrl + '\'' +
                ", qudaoId='" + qudaoId + '\'' +
                ", qudaoName='" + qudaoName + '\'' +
                '}';
    }
}
