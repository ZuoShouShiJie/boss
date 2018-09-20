package com.maiziyun.boss.facade.product.model.vo;

import com.solar.framework.core.base.AbstractModel;

/**
 * Created by admin on 2017/9/1.
 */
public class P2PLoanListVo extends AbstractModel {
    private String id;
    private String productName;//产品名称
    private String productId;//产品ID
    private String deadline;//产品期限
    private String lowestBugAmmount;//起购金额
    private String balance;//剩余额度
    private String createTime;//成立日
    private String status;//状态
    private String deadLineId;
    private String deadLineName;
    private String statusId;

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getLowestBugAmmount() {
        return lowestBugAmmount;
    }

    public void setLowestBugAmmount(String lowestBugAmmount) {
        this.lowestBugAmmount = lowestBugAmmount;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeadLineId() {
        return deadLineId;
    }

    public void setDeadLineId(String deadLineId) {
        this.deadLineId = deadLineId;
    }

    public String getDeadLineName() {
        return deadLineName;
    }

    public void setDeadLineName(String deadLineName) {
        this.deadLineName = deadLineName;
    }
}
