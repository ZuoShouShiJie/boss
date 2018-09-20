package com.maiziyun.boss.facade.finance.model;

import com.maiziyun.boss.facade.common.model.BaseRequest;
import com.maiziyun.boss.facade.finance.model.vo.UnitAwardRuleVo;

import java.util.List;

/**
 * Created by admin on 2017/7/17.
 */
public class UpdateCornRequest extends BaseRequest {
    private String id;
    private String name;//任务名称
    private String sort;//展示顺位
    private String statusId; //状态
    private String taskTypeId;//任务类型
    private String taskActionId;//任务行为
    private String inveScopeId;//投资范围
    private String inveCondId;//投资行为
    private String investTimes;
    private String frontVisibleId;//前端可见
    private String unitCondition;//投资次数
    private String unitAwardPoint;//奖励麦子
    private List<UnitAwardRuleVo> accAwardRules;//累计任务，连续任务时用，（完成次数，奖励麦子）

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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(String taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getTaskActionId() {
        return taskActionId;
    }

    public void setTaskActionId(String taskActionId) {
        this.taskActionId = taskActionId;
    }

    public String getInveScopeId() {
        return inveScopeId;
    }

    public void setInveScopeId(String inveScopeId) {
        this.inveScopeId = inveScopeId;
    }

    public String getInveCondId() {
        return inveCondId;
    }

    public void setInveCondId(String inveCondId) {
        this.inveCondId = inveCondId;
    }

    public String getInvestTimes() {
        return investTimes;
    }

    public void setInvestTimes(String investTimes) {
        this.investTimes = investTimes;
    }

    public String getFrontVisibleId() {
        return frontVisibleId;
    }

    public void setFrontVisibleId(String frontVisibleId) {
        this.frontVisibleId = frontVisibleId;
    }

    public String getUnitCondition() {
        return unitCondition;
    }

    public void setUnitCondition(String unitCondition) {
        this.unitCondition = unitCondition;
    }

    public String getUnitAwardPoint() {
        return unitAwardPoint;
    }

    public void setUnitAwardPoint(String unitAwardPoint) {
        this.unitAwardPoint = unitAwardPoint;
    }

    public List<UnitAwardRuleVo> getAccAwardRules() {
        return accAwardRules;
    }

    public void setAccAwardRules(List<UnitAwardRuleVo> accAwardRules) {
        this.accAwardRules = accAwardRules;
    }
}
