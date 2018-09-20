package com.maiziyun.boss.facade.jysmng.model.vo;

import com.solar.framework.core.base.AbstractModel;

import java.util.List;

/**
 * Created by admin on 2017/11/6.
 */
public class ProjectConfQueryVo extends AbstractModel {
    private String exchangeProjectId;   //项目编号
    private String exchangeId;   //交易所id
    private String exchangeName;    //交易所名称
    private String projectName;   //项目名称
    private String productCycle;   //产品周期
    private String annualRate;   //年化收益率

    private String repayTypeId;    //还款方式
    private String repayTypeName;
    private String releasemanId;   //发行人
    private String releasemanName;
    private String deadlineTypeId;       //期限
    private String deadlineTypeName;
    private String interestUnitId;     //计息单位
    private String interestUnitName;
    private String receiveAccount;  //收款账户
    private String projectAmount;    //项目总额度

    private String createTime;   //创建时间
    private String modifyTime;  //更新时间
    private String statusId;   //状态
    private String operator;//操作人
    private List<ProjectProtocolVo> protocolList; //项目协议

    public List<ProjectProtocolVo> getProtocolList() {
        return protocolList;
    }

    public void setProtocolList(List<ProjectProtocolVo> protocolList) {
        this.protocolList = protocolList;
    }

    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getReceiveAccount() {
        return receiveAccount;
    }

    public void setReceiveAccount(String receiveAccount) {
        this.receiveAccount = receiveAccount;
    }

    public String getRepayTypeId() {
        return repayTypeId;
    }

    public void setRepayTypeId(String repayTypeId) {
        this.repayTypeId = repayTypeId;
    }

    public String getRepayTypeName() {
        return repayTypeName;
    }

    public void setRepayTypeName(String repayTypeName) {
        this.repayTypeName = repayTypeName;
    }

    public String getReleasemanId() {
        return releasemanId;
    }

    public void setReleasemanId(String releasemanId) {
        this.releasemanId = releasemanId;
    }

    public String getReleasemanName() {
        return releasemanName;
    }

    public void setReleasemanName(String releasemanName) {
        this.releasemanName = releasemanName;
    }

    public String getDeadlineTypeId() {
        return deadlineTypeId;
    }

    public void setDeadlineTypeId(String deadlineTypeId) {
        this.deadlineTypeId = deadlineTypeId;
    }

    public String getDeadlineTypeName() {
        return deadlineTypeName;
    }

    public void setDeadlineTypeName(String deadlineTypeName) {
        this.deadlineTypeName = deadlineTypeName;
    }

    public String getInterestUnitId() {
        return interestUnitId;
    }

    public void setInterestUnitId(String interestUnitId) {
        this.interestUnitId = interestUnitId;
    }

    public String getInterestUnitName() {
        return interestUnitName;
    }

    public void setInterestUnitName(String interestUnitName) {
        this.interestUnitName = interestUnitName;
    }

    public String getProjectAmount() {
        return projectAmount;
    }

    public void setProjectAmount(String projectAmount) {
        this.projectAmount = projectAmount;
    }

    public String getExchangeProjectId() {
        return exchangeProjectId;
    }

    public void setExchangeProjectId(String exchangeProjectId) {
        this.exchangeProjectId = exchangeProjectId;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
