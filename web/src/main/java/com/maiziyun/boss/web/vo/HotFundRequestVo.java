package com.maiziyun.boss.web.vo;

import java.util.List;

/**
 * Created by admin on 2017/7/3.
 */
public class HotFundRequestVo extends BaseRequest{
    private String id;
    private List<String> labels;
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
