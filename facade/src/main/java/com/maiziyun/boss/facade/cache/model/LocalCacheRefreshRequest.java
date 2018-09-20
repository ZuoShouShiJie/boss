package com.maiziyun.boss.facade.cache.model;

import com.solar.framework.core.base.AbstractRequest;

/**
 * Created by fanlinlong on 2016/12/29.
 */
public class LocalCacheRefreshRequest extends AbstractRequest {
    private String serviceCode;
    private String cacheName;

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getCacheName() {
        return cacheName;
    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }
}
