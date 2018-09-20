package com.maiziyun.boss.facade.product.model.vo;

import com.solar.framework.core.base.AbstractModel;

/**
 * Created by admin on 2017/7/22.
 */
public class QueryFofDetailVo extends AbstractModel {
    private String id;
    private String poCode;//组合ID
    private String lowestBugAmmount; //起购金额
    private String risk;//风险等级
    private String buyStatus;//是否可购买
    private String merchantId;//盈米组合ID
    private String[] labels;//组合标签
    private String poDesc;//组合简介
    private String poRichDesc; //组合明细说明
    private String effectFlagId; //上线架状态
    private String effectFlagName; //上下架名字
    private String buyIncrease;  //认购递增
    private String PoType;  //组合类型

    public String getBuyIncrease() {
        return buyIncrease;
    }

    public void setBuyIncrease(String buyIncrease) {
        this.buyIncrease = buyIncrease;
    }

    public String getPoType() {
        return PoType;
    }

    public void setPoType(String poType) {
        PoType = poType;
    }

    public String getEffectFlagName() {
        return effectFlagName;
    }

    public void setEffectFlagName(String effectFlagName) {
        this.effectFlagName = effectFlagName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoCode() {
        return poCode;
    }

    public void setPoCode(String poCode) {
        this.poCode = poCode;
    }

    public String getLowestBugAmmount() {
        return lowestBugAmmount;
    }

    public void setLowestBugAmmount(String lowestBugAmmount) {
        this.lowestBugAmmount = lowestBugAmmount;
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

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public String getPoDesc() {
        return poDesc;
    }

    public void setPoDesc(String poDesc) {
        this.poDesc = poDesc;
    }

    public String getPoRichDesc() {
        return poRichDesc;
    }

    public void setPoRichDesc(String poRichDesc) {
        this.poRichDesc = poRichDesc;
    }

    public String getEffectFlagId() {
        return effectFlagId;
    }

    public void setEffectFlagId(String effectFlagId) {
        this.effectFlagId = effectFlagId;
    }
}
