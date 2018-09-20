package com.maiziyun.boss.facade.group.model;

import com.maiziyun.boss.facade.common.model.BaseRequest;

/**
 * Created by admin on 2017/11/21.
 */
public class FundGroupUpdateRequest extends BaseRequest {
    private String id;
    private String levelId;
    private String jijinId;
    private String jijinPercent;
    private String jijinLabel;
    private String gushouId;
    private String gushouPercent;
    private String gushouLabel;
    private String qitouAmount;
    private String stepAmount;
    private String statusId;

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

    public String getJijinId() {
        return jijinId;
    }

    public void setJijinId(String jijinId) {
        this.jijinId = jijinId;
    }

    public String getJijinPercent() {
        return jijinPercent;
    }

    public void setJijinPercent(String jijinPercent) {
        this.jijinPercent = jijinPercent;
    }

    public String getJijinLabel() {
        return jijinLabel;
    }

    public void setJijinLabel(String jijinLabel) {
        this.jijinLabel = jijinLabel;
    }

    public String getGushouId() {
        return gushouId;
    }

    public void setGushouId(String gushouId) {
        this.gushouId = gushouId;
    }

    public String getGushouPercent() {
        return gushouPercent;
    }

    public void setGushouPercent(String gushouPercent) {
        this.gushouPercent = gushouPercent;
    }

    public String getGushouLabel() {
        return gushouLabel;
    }

    public void setGushouLabel(String gushouLabel) {
        this.gushouLabel = gushouLabel;
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
}
