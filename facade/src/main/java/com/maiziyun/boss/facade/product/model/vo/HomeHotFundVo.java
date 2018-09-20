package com.maiziyun.boss.facade.product.model.vo;

import com.solar.framework.core.base.AbstractModel;


/**
 * Created by len.song on 2016/12/14.
 */
public class HomeHotFundVo extends AbstractModel {
    private String fundCode;//基金代码
    private String fundShortName;//基金简称
    private String shelfMarking;//商家标识
    private String achievement;//业绩显示
    private String sort;//排序
    private String oneLabel;//一级标签
    private String twoLabel;//二级标签

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundShortName() {
        return fundShortName;
    }

    public void setFundShortName(String fundShortName) {
        this.fundShortName = fundShortName;
    }

    public String getShelfMarking() {
        return shelfMarking;
    }

    public void setShelfMarking(String shelfMarking) {
        this.shelfMarking = shelfMarking;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOneLabel() {
        return oneLabel;
    }

    public void setOneLabel(String oneLabel) {
        this.oneLabel = oneLabel;
    }

    public String getTwoLabel() {
        return twoLabel;
    }

    public void setTwoLabel(String twoLabel) {
        this.twoLabel = twoLabel;
    }
}
