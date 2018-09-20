package com.maiziyun.boss.facade.product.model.vo;

import com.solar.framework.core.base.AbstractModel;

/**
 * Created by len.song on 2016/12/23.
 */
public class ProAttrRelVo extends AbstractModel {
    private String id;//主键id
    private String productName;//产品名称
    private String productId;//产品编号
    private String fundShortName;//基金名称
    private String fundCode;//基金编码
    private String shelfMarking;//上架标识名称
    private String shelfCode;//上架标识码
    private String performanceWord;//业绩文字
    private String performanceNumber;//业绩数值
    private String sort;//排序
    private String oneLabel;//一级标签
    private String twoLabel;//二级标签

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public ProAttrRelVo setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public String getFundShortName() {
        return fundShortName;
    }

    public ProAttrRelVo setFundShortName(String fundShortName) {
        this.fundShortName = fundShortName;
        return this;
    }

    public String getFundCode() {
        return fundCode;
    }

    public ProAttrRelVo setFundCode(String fundCode) {
        this.fundCode = fundCode;
        return this;
    }

    public String getShelfMarking() {
        return shelfMarking;
    }

    public ProAttrRelVo setShelfMarking(String shelfMarking) {
        this.shelfMarking = shelfMarking;
        return this;
    }

    public String getPerformanceWord() {
        return performanceWord;
    }

    public ProAttrRelVo setPerformanceWord(String performanceWord) {
        this.performanceWord = performanceWord;
        return this;
    }

    public String getPerformanceNumber() {
        return performanceNumber;
    }

    public ProAttrRelVo setPerformanceNumber(String performanceNumber) {
        this.performanceNumber = performanceNumber;
        return this;
    }

    public String getSort() {
        return sort;
    }

    public ProAttrRelVo setSort(String sort) {
        this.sort = sort;
        return this;
    }

    public String getOneLabel() {
        return oneLabel;
    }

    public ProAttrRelVo setOneLabel(String oneLabel) {
        this.oneLabel = oneLabel;
        return this;
    }

    public String getTwoLabel() {
        return twoLabel;
    }

    public ProAttrRelVo setTwoLabel(String twoLabel) {
        this.twoLabel = twoLabel;
        return this;
    }

    public String getShelfCode() {
        return shelfCode;
    }

    public ProAttrRelVo setShelfCode(String shelfCode) {
        this.shelfCode = shelfCode;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
