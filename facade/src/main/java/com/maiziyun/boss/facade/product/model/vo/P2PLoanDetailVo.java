package com.maiziyun.boss.facade.product.model.vo;

import com.solar.framework.core.base.AbstractModel;

/**
 * Created by admin on 2017/9/1.
 */
public class P2PLoanDetailVo extends AbstractModel {
    private String productId;
    private String status;//上下线状态
    private String wheatValue;//赠送麦子

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

    public String getWheatValue() {
        return wheatValue;
    }

    public void setWheatValue(String wheatValue) {
        this.wheatValue = wheatValue;
    }
}
