package com.maiziyun.boss.facade.cache.model.vo;

import com.solar.framework.core.base.AbstractModel;


/**
 * Created by fanlinlong on 2016/12/29.
 */
public class CacheInfoVo extends AbstractModel {
    private String cacheCode;
    private String cacheDesc;
    private String serviceCode;
    private String serviceDesc;

    public String getCacheCode() {
        return cacheCode;
    }

    public void setCacheCode(String cacheCode) {
        this.cacheCode = cacheCode;
    }

    public String getCacheDesc() {
        return cacheDesc;
    }

    public void setCacheDesc(String cacheDesc) {
        this.cacheDesc = cacheDesc;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }
}
