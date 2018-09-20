package com.maiziyun.boss.facade.finance.model.vo;

import com.solar.framework.core.base.AbstractModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/7/17.
 */
public class CornfieldVo implements Serializable{
    private String id;
    private String name;
    private String taskActionId;//任务行为
    private String taskActionName;
    private String modifyTime;
    private String statusId; //状态
    private String statusName;
    private String sort;
    private String taskTypeId; //任务类型
    private String taskTypeName;
    private String frontVisibleId; //前端可见
    private String frontVisibleName;
    private String inveScopeId;  //投资范围
    private String inveScopeName;
    private String inveCondId; //投资条件
    private String inveCondName;
    private List<UnitAwardRuleVo> accAwardRules;

    public List<UnitAwardRuleVo> getAccAwardRules() {
        return accAwardRules;
    }

    public void setAccAwardRules(List<UnitAwardRuleVo> accAwardRules) {
        this.accAwardRules = accAwardRules;
    }

    public String getInveScopeId() {
        return inveScopeId;
    }

    public void setInveScopeId(String inveScopeId) {
        this.inveScopeId = inveScopeId;
    }

    public String getInveScopeName() {
        return inveScopeName;
    }

    public void setInveScopeName(String inveScopeName) {
        this.inveScopeName = inveScopeName;
    }

    public String getInveCondId() {
        return inveCondId;
    }

    public void setInveCondId(String inveCondId) {
        this.inveCondId = inveCondId;
    }

    public String getInveCondName() {
        return inveCondName;
    }

    public void setInveCondName(String inveCondName) {
        this.inveCondName = inveCondName;
    }

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

    public String getTaskActionId() {
        return taskActionId;
    }

    public void setTaskActionId(String taskActionId) {
        this.taskActionId = taskActionId;
    }

    public String getTaskActionName() {
        return taskActionName;
    }

    public void setTaskActionName(String taskActionName) {
        this.taskActionName = taskActionName;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(String taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getTaskTypeName() {
        return taskTypeName;
    }

    public void setTaskTypeName(String taskTypeName) {
        this.taskTypeName = taskTypeName;
    }

    public String getFrontVisibleId() {
        return frontVisibleId;
    }

    public void setFrontVisibleId(String frontVisibleId) {
        this.frontVisibleId = frontVisibleId;
    }

    public String getFrontVisibleName() {
        return frontVisibleName;
    }

    public void setFrontVisibleName(String frontVisibleName) {
        this.frontVisibleName = frontVisibleName;
    }
}
