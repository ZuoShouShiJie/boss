package com.maiziyun.boss.facade.system.model.menu;

import com.solar.framework.core.base.AbstractRequest;
/**
 * Created by len.song on 2016/11/21.
 */
public class MenuGPSRequest extends AbstractRequest {
    private Integer operatorId;//操作员id

    private String userName;//操作员姓名

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
