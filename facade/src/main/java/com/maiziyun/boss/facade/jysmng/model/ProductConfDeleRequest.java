package com.maiziyun.boss.facade.jysmng.model;

import com.maiziyun.boss.facade.common.model.BaseRequest;

/**
 * Created by admin on 2017/11/4.
 */
public class ProductConfDeleRequest extends BaseRequest {
    private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
