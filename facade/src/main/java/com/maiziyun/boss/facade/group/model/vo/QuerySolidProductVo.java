package com.maiziyun.boss.facade.group.model.vo;

import com.solar.framework.core.base.AbstractModel;

/**
 * Created by admin on 2017/11/22.
 */
public class QuerySolidProductVo extends AbstractModel {
    private String id;
    private String name;
    private String stepAmount;
    private String qitouAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStepAmount() {
        return stepAmount;
    }

    public void setStepAmount(String stepAmount) {
        this.stepAmount = stepAmount;
    }

    public String getQitouAmount() {
        return qitouAmount;
    }

    public void setQitouAmount(String qitouAmount) {
        this.qitouAmount = qitouAmount;
    }
}
