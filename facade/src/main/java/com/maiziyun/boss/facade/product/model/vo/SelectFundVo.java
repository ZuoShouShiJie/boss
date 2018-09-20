package com.maiziyun.boss.facade.product.model.vo;

import com.solar.framework.core.base.AbstractModel;

import java.util.List;

/**
 * Created by admin on 2017/9/6.
 */
public class SelectFundVo extends AbstractModel {
    private String id; //产品id
    private List<String> labels; //标签
    private String desc; //推荐描述
    private String type; //标题类型

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
