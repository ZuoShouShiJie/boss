package com.maiziyun.boss.web.vo;

import java.util.List;

/**
 * Created by admin on 2017/7/6.
 */
public class UpdateFundConfVo extends BaseRequest {
    private String attrKind;
    private List<String> productId;

    public String getAttrKind() {
        return attrKind;
    }

    public void setAttrKind(String attrKind) {
        this.attrKind = attrKind;
    }

    public List<String> getProductId() {
        return productId;
    }

    public void setProductId(List<String> productId) {
        this.productId = productId;
    }
}
