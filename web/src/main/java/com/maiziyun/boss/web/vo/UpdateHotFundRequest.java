package com.maiziyun.boss.web.vo;

import java.util.List;

/**
 * Created by admin on 2017/7/3.
 */
public class UpdateHotFundRequest extends BaseRequest {
    private List<HotFundRequestVo> hotList;
    private String type;

    public List<HotFundRequestVo> getHotList() {
        return hotList;
    }

    public void setHotList(List<HotFundRequestVo> hotList) {
        this.hotList = hotList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
