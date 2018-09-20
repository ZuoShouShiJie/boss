package com.maiziyun.boss.facade.product.model;

import com.maiziyun.boss.facade.common.model.BaseRequest;

/**
 * Created by admin on 2017/8/31.
 */
public class UpdateP2PLoanRequest extends BaseRequest {
    private String productId; //产品ID
    private String status; //上下线状态
    private String wheatKey;  //赠送麦子
    private String wheatValue; //赠送麦子

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWheatKey() {
        return wheatKey;
    }

    public void setWheatKey(String wheatKey) {
        this.wheatKey = wheatKey;
    }

    public String getWheatValue() {
        return wheatValue;
    }

    public void setWheatValue(String wheatValue) {
        this.wheatValue = wheatValue;
    }
}
