package com.maiziyun.boss.web.vo;

import java.util.List;

/**
 * Created by admin on 2017/6/30.
 */
public class UpdateHotSubRequest extends BaseRequest {

    private List<HotSubRequest> hotList;

    public List<HotSubRequest> getHotList() {
        return hotList;
    }

    public void setHotList(List<HotSubRequest> hotList) {
        this.hotList = hotList;
    }
}
