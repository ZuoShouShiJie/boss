package com.maiziyun.boss.facade.product.model;

import com.solar.framework.core.base.AbstractRequest;
import org.omg.CORBA.PRIVATE_MEMBER;


/**
 * Created by admin on 2017/6/2.
 */
public class FundItemQueryRequest extends AbstractRequest{

    private String id;
    private String name;
    private String label;
    private String info;
    private String detail;
    private String coverImgPath;
    private String themeImgPath;

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCoverImgPath() {
        return coverImgPath;
    }

    public void setCoverImgPath(String coverImgPath) {
        this.coverImgPath = coverImgPath;
    }

    public String getThemeImgPath() {
        return themeImgPath;
    }

    public void setThemeImgPath(String themeImgPath) {
        this.themeImgPath = themeImgPath;
    }
}
