package com.maiziyun.boss.facade.product.model.vo;

import com.solar.framework.core.base.AbstractModel;

/**
 * Created by admin on 2017/6/5.
 */
public class HotFundVo extends AbstractModel {
    private String id;
    private String name; //基金名称
    private String code; //基金代码
    private String type; //基金类型
    private String visibility;
//    private String SecondLevelTag;
    private String growYear; //近一年涨幅
    private String growMonth3; //近3月涨幅
    private String growMonth1; //近1月涨幅
    private String growWeek; //近一周涨幅
    private String[] labels;  //标签
    private String desc;  //推荐描述
    private String productId;
    private Integer sort; //排序字段

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getGrowYear() {
        return growYear;
    }

    public void setGrowYear(String growYear) {
        this.growYear = growYear;
    }

    public String getGrowMonth3() {
        return growMonth3;
    }

    public void setGrowMonth3(String growMonth3) {
        this.growMonth3 = growMonth3;
    }

    public String getGrowMonth1() {
        return growMonth1;
    }

    public void setGrowMonth1(String growMonth1) {
        this.growMonth1 = growMonth1;
    }

    public String getGrowWeek() {
        return growWeek;
    }

    public void setGrowWeek(String growWeek) {
        this.growWeek = growWeek;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
