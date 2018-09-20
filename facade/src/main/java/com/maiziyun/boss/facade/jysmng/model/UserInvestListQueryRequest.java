package com.maiziyun.boss.facade.jysmng.model;

import com.maiziyun.boss.facade.common.model.BaseRequest;

/**
 * Created by admin on 2017/11/4.
 */
public class UserInvestListQueryRequest extends BaseRequest {
    private String userName;
    private String mobile;
    private String investStartTime;
    private String investEndTime;
    private String pageNo;
    private String pageSize;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getInvestStartTime() {
        return investStartTime;
    }

    public void setInvestStartTime(String investStartTime) {
        this.investStartTime = investStartTime;
    }

    public String getInvestEndTime() {
        return investEndTime;
    }

    public void setInvestEndTime(String investEndTime) {
        this.investEndTime = investEndTime;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
