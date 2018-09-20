package com.maiziyun.boss.facade.cache.model;

import com.maiziyun.boss.facade.cache.model.vo.CacheInfoVo;
import com.solar.framework.core.base.AbstractResponse;

import java.util.List;

/**
 * Created by fanlinlong on 2016/12/29.
 */
public class LocalCacheGetInfoResponse extends AbstractResponse {
    private List<CacheInfoVo> list;

    public List<CacheInfoVo> getList() {
        return list;
    }

    public void setList(List<CacheInfoVo> list) {
        this.list = list;
    }
}
