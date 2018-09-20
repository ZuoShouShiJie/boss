package com.maiziyun.boss.facade.finance.model;

import com.solar.framework.core.base.AbstractRequest;

/**
 * Created by admin on 2017/6/19.
 */
public class UpdateAdverRequest extends AbstractRequest{
    private String id;
    private String title;
    private String targetUrl;
    private String position;
    private String order;
    private String imagePath;
    private String prefixImage;
    private String qudao;
    private String state;
    private String beginTime;
    private String endTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }



    public String getQudao() {
        return qudao;
    }

    public void setQudao(String qudao) {
        this.qudao = qudao;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getPrefixImage() {
        return prefixImage;
    }

    public void setPrefixImage(String prefixImage) {
        this.prefixImage = prefixImage;
    }
}
