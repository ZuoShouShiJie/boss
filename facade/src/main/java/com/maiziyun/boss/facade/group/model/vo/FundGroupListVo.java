package com.maiziyun.boss.facade.group.model.vo;

import com.solar.framework.core.base.AbstractModel;

/**
 * Created by admin on 2017/11/21.
 */
public class FundGroupListVo extends AbstractModel {
    private String id;
    private String levelId;
    private String levelName;
    private String jijinId;
    private String jijinName;
    private String jijinPercent;
    private String jijinLabel;
    private String gushouId;
    private String gushouName;
    private String gushouPercent;
    private String gushouLabel;
    private String qitouAmount;
    private String stepAmount;
    private String statusId;
    private String statusName;
    private String createTime;
    private String updateTime;
    private String createrId;
    private String createrName;

    public String getJijinLabel() {
        return jijinLabel;
    }

    public void setJijinLabel(String jijinLabel) {
        this.jijinLabel = jijinLabel;
    }

    public String getGushouLabel() {
        return gushouLabel;
    }

    public void setGushouLabel(String gushouLabel) {
        this.gushouLabel = gushouLabel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getJijinId() {
        return jijinId;
    }

    public void setJijinId(String jijinId) {
        this.jijinId = jijinId;
    }

    public String getJijinName() {
        return jijinName;
    }

    public void setJijinName(String jijinName) {
        this.jijinName = jijinName;
    }

    public String getJijinPercent() {
        return jijinPercent;
    }

    public void setJijinPercent(String jijinPercent) {
        this.jijinPercent = jijinPercent;
    }

    public String getGushouId() {
        return gushouId;
    }

    public void setGushouId(String gushouId) {
        this.gushouId = gushouId;
    }

    public String getGushouName() {
        return gushouName;
    }

    public void setGushouName(String gushouName) {
        this.gushouName = gushouName;
    }

    public String getGushouPercent() {
        return gushouPercent;
    }

    public void setGushouPercent(String gushouPercent) {
        this.gushouPercent = gushouPercent;
    }

    public String getQitouAmount() {
        return qitouAmount;
    }

    public void setQitouAmount(String qitouAmount) {
        this.qitouAmount = qitouAmount;
    }

    public String getStepAmount() {
        return stepAmount;
    }

    public void setStepAmount(String stepAmount) {
        this.stepAmount = stepAmount;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }
}
