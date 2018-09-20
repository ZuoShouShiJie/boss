package com.maiziyun.boss.facade.product.model.vo;

import com.solar.framework.core.base.AbstractModel;


/**
 * Created by fanlinlong on 2016/12/14.
 */
public class QueryProdListVo extends AbstractModel {
    private String productId;//产品编号
    private String productName;//产品名称
    private String productType;//产品类型
    private String fundCode;//基金代码
    private String fundName;//基金名称
    private String fundShortName;//基金名称
    private String fundType;//基金类型
    private String riskLevel;//风险等级
    private String putAwaySign;//上架标志
    private String chargeType;//收费类型
    private String establishmentDate;//成立日期
    private String manager;//管理人
    private String trustee;//托管人
    private String fundManager;//基金经理

    public String getFundCode() {
        return fundCode;
    }

    public QueryProdListVo setFundCode(String fundCode) {
        this.fundCode = fundCode;
        return this;
    }

    public String getFundName() {
        return fundName;
    }

    public QueryProdListVo setFundName(String fundName) {
        this.fundName = fundName;
        return this;
    }

    public String getFundShortName() {
        return fundShortName;
    }

    public QueryProdListVo setFundShortName(String fundShortName) {
        this.fundShortName = fundShortName;
        return this;
    }

    public String getFundType() {
        return fundType;
    }

    public QueryProdListVo setFundType(String fundType) {
        this.fundType = fundType;
        return this;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public QueryProdListVo setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
        return this;
    }

    public String getPutAwaySign() {
        return putAwaySign;
    }

    public QueryProdListVo setPutAwaySign(String putAwaySign) {
        this.putAwaySign = putAwaySign;
        return this;
    }

    public String getChargeType() {
        return chargeType;
    }

    public QueryProdListVo setChargeType(String chargeType) {
        this.chargeType = chargeType;
        return this;
    }

    public String getEstablishmentDate() {
        return establishmentDate;
    }

    public QueryProdListVo setEstablishmentDate(String establishmentDate) {
        this.establishmentDate = establishmentDate;
        return this;
    }

    public String getManager() {
        return manager;
    }

    public QueryProdListVo setManager(String manager) {
        this.manager = manager;
        return this;
    }

    public String getTrustee() {
        return trustee;
    }

    public QueryProdListVo setTrustee(String trustee) {
        this.trustee = trustee;
        return this;
    }

    public String getFundManager() {
        return fundManager;
    }

    public QueryProdListVo setFundManager(String fundManager) {
        this.fundManager = fundManager;
        return this;
    }

    public String getProductType() {
        return productType;
    }

    public QueryProdListVo setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public String getProductId() {
        return productId;
    }

    public QueryProdListVo setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
