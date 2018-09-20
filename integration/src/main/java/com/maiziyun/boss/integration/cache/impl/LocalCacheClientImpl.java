package com.maiziyun.boss.integration.cache.impl;

import com.maiziyun.boss.integration.cache.LocalCacheClient;
import com.maiziyun.common.enums.MyServiceCode;
import com.solar.framework.core.enums.BizCode;
import com.solar.framework.core.enums.SourceCode;
import com.solar.framework.core.exception.BizException;
import com.solar.framework.core.exception.RemoteException;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.reflect.MethodUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yinzuolong on 2016/12/29.
 */
public class LocalCacheClientImpl implements LocalCacheClient {
    private static final Logger logger = LoggerFactory.getLogger(LocalCacheClientImpl.class);

    private Map<String, Object> localCacheRefreshServiceMap;

    public void refresh(String serviceCode, String cacheName) {
        Object cacheService = localCacheRefreshServiceMap.get(serviceCode);
        if (cacheService == null) {
            throw new BizException(BizCode.DataNotExist, "服务缓存不存在");
        }
        Map<String, Object> request = new HashedMap();
        request.put("name", cacheName);
        request.put("service", MyServiceCode.Boss);
        request.put("source", SourceCode.OpenApi);
        logger.info("发送请求：{}", request);
        Map<String, Object> response = (Map<String, Object>) invoke(cacheService, "refresh", request);
        logger.info("接收响应：{}", response);
        BizCode bizCode = (BizCode) response.get("bizCode");
        if (BizCode.Success != bizCode) {
            throw new RemoteException(bizCode, (String) response.get("message"));
        }
    }

    private Object invoke(Object target, String methodName, Map<String, Object> request) {
        try {
            return MethodUtils.invokeMethod(target, methodName, request);
        } catch (Exception e) {
            throw new BizException(BizCode.ParamError, "调用方法异常", e);
        }
    }

    public List<Map<String, Object>> getCacheInfos() {
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (Object cacheService : localCacheRefreshServiceMap.values()) {
            Map<String, Object> request = new HashedMap();
            request.put("service", MyServiceCode.Boss);
            request.put("source", SourceCode.OpenApi);
            logger.info("发送请求：{}", request);
            Map<String, Object> response = (Map<String, Object>) invoke(cacheService, "getCacheInfos", request);
            logger.info("接收响应：{}", response);
            BizCode bizCode = (BizCode) response.get("bizCode");
            if (BizCode.Success != bizCode) {
                throw new RemoteException(bizCode, (String) response.get("message"));
            }
            List<Map<String, Object>> rs = (List<Map<String, Object>>) response.get("data");
            resultList.addAll(rs);
        }
        return resultList;
    }

    public Map<String, Object> getLocalCacheRefreshServiceMap() {
        return localCacheRefreshServiceMap;
    }

    public void setLocalCacheRefreshServiceMap(Map<String, Object> localCacheRefreshServiceMap) {
        this.localCacheRefreshServiceMap = localCacheRefreshServiceMap;
    }
}
