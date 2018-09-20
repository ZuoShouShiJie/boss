package com.maiziyun.boss.facade.product.model.vo;

import com.solar.framework.core.base.AbstractModel;

/**
 * Created by len.song on 2016/12/21.
 */
public class ProHisNavVo extends AbstractModel {
    private String productId;//产品
    private String accNav;//累计净值
    private String navDate;//净值日期
    private String unitNav;//单位净值
    private String unitYield;//万份收益
    private String yearlyRoe;//七日年化收益率


    public String getProductId() {
        return productId;
    }

    public ProHisNavVo setProductId(String productId) {
        this.productId = productId;
        return this;
    }


    public String getAccNav() {
        return accNav;
    }

    public ProHisNavVo setAccNav(String accNav) {
        this.accNav = accNav;
        return this;
    }

    public String getNavDate() {
        return navDate;
    }

    public ProHisNavVo setNavDate(String navDate) {
        this.navDate = navDate;
        return this;
    }

    public String getUnitYield() {
        return unitYield;
    }

    public ProHisNavVo setUnitYield(String unitYield) {
        this.unitYield = unitYield;
        return this;
    }

    public String getYearlyRoe() {
        return yearlyRoe;
    }

    public ProHisNavVo setYearlyRoe(String yearlyRoe) {
        this.yearlyRoe = yearlyRoe;
        return this;
    }

    public String getUnitNav() {
        return unitNav;
    }

    public ProHisNavVo setUnitNav(String unitNav) {
        this.unitNav = unitNav;
        return this;
    }
}
