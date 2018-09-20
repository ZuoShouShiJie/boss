package com.maiziyun.boss.facade.product.model.vo;

import com.solar.framework.core.base.AbstractModel;

/**
 * Created by admin on 2017/7/22.
 */
public class QueryFofListVo extends AbstractModel {
    private String id; //
    private String productName; //组合名称
    private String poCode; //组合ID
    private String merchantId;//盈米ID
    private String risk; //风险等级
    private String buyStatus;//状态
    private String  sort;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
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

    public String getPoCode() {
        return poCode;
    }

    public void setPoCode(String poCode) {
        this.poCode = poCode;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getBuyStatus() {
        return buyStatus;
    }

    public void setBuyStatus(String buyStatus) {
        this.buyStatus = buyStatus;
    }
}
