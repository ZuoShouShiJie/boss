package com.maiziyun.boss.facade.jysmng.model;

import com.maiziyun.boss.facade.common.model.BaseRequest;
import com.maiziyun.boss.facade.jysmng.model.vo.ProjectProtocolVo;

import java.util.List;

/**
 * Created by admin on 2017/11/4.
 */
public class ProjectConfUpdateRequest extends BaseRequest {
    private String exchangeId;     //交易所id
    private String exchangeProjectId; //项目编号
    private String projectName; //项目名称
    private String productCycle;//产品周期
    private String annualRate;//年化收益率
    private String repayTypeId;//还款方式
    private String releasemanId;//发行人
    private String deadlineTypeId;//期限
    private String interestUnitId;//计息单位
    private String receiveAccount;//关联收款账户
    private String projectAmount;//项目总额度
    private String statusId;//状态
    private List<ProjectProtocolVo> protocolList; //项目协议

    public List<ProjectProtocolVo> getProtocolList() {
        return protocolList;
    }

    public void setProtocolList(List<ProjectProtocolVo> protocolList) {
        this.protocolList = protocolList;
    }

    public String getExchangeProjectId() {
        return exchangeProjectId;
    }

    public void setExchangeProjectId(String exchangeProjectId) {
        this.exchangeProjectId = exchangeProjectId;
    }

    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProductCycle() {
        return productCycle;
    }

    public void setProductCycle(String productCycle) {
        this.productCycle = productCycle;
    }

    public String getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(String annualRate) {
        this.annualRate = annualRate;
    }

    public String getRepayTypeId() {
        return repayTypeId;
    }

    public void setRepayTypeId(String repayTypeId) {
        this.repayTypeId = repayTypeId;
    }

    public String getReleasemanId() {
        return releasemanId;
    }

    public void setReleasemanId(String releasemanId) {
        this.releasemanId = releasemanId;
    }

    public String getDeadlineTypeId() {
        return deadlineTypeId;
    }

    public void setDeadlineTypeId(String deadlineTypeId) {
        this.deadlineTypeId = deadlineTypeId;
    }

    public String getInterestUnitId() {
        return interestUnitId;
    }

    public void setInterestUnitId(String interestUnitId) {
        this.interestUnitId = interestUnitId;
    }

    public String getReceiveAccount() {
        return receiveAccount;
    }

    public void setReceiveAccount(String receiveAccount) {
        this.receiveAccount = receiveAccount;
    }

    public String getProjectAmount() {
        return projectAmount;
    }

    public void setProjectAmount(String projectAmount) {
        this.projectAmount = projectAmount;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }
}
