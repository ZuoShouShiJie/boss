
package com.maiziyun.boss.biz.cache.service.impl;


import com.maiziyun.boss.biz.cache.convert.CacheInfoConvert;
import com.maiziyun.boss.biz.cache.service.CacheService;
import com.maiziyun.boss.facade.cache.model.LocalCacheGetInfoResponse;
import com.maiziyun.boss.facade.cache.model.LocalCacheRefreshRequest;
import com.maiziyun.boss.facade.cache.model.LocalCacheRefreshResponse;
import com.maiziyun.boss.facade.cache.model.vo.CacheInfoVo;
import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.boss.integration.cache.LocalCacheClient;
import com.solar.framework.core.enums.BizCode;
import com.solar.framework.core.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by fanlinlong on 2016/12/29.
 */

@Service("boss.CacheService")
public class CacheServiceImpl implements CacheService {
    private static Logger logger = LoggerFactory.getLogger(CacheServiceImpl.class);

    @Autowired
    private LocalCacheClient localCacheClient;

    @Override
    public LocalCacheRefreshResponse refresh(LocalCacheRefreshRequest request) {
        logger.info("接收请求{}", request);
        if (request == null || StringUtils.isBlank(request.getCacheName()) || StringUtils.isBlank(request.getServiceCode())) {
            throw new BizException(BizCode.ParamError, BizCode.ParamError.desc());
        }
        String serviceCode = "".equals(request.getService()) ? null : request.getServiceCode().trim();
        String cacheName = "".equals(request.getCacheName()) ? null : request.getCacheName().trim();

        LocalCacheRefreshResponse response = new LocalCacheRefreshResponse();
        try {
            localCacheClient.refresh(serviceCode, cacheName);
        } catch (BizException e) {
            logger.error("刷新缓存异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("刷新缓存异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        response.setCode(BizCode.Success);
        response.setMessage("刷新缓存成功");
        logger.info("返回结果{}", response);
        return response;
    }

    @Override
    public LocalCacheGetInfoResponse getCacheInfos() {
        logger.info("接收请求{}");
        LocalCacheGetInfoResponse response = new LocalCacheGetInfoResponse();
        try {
            List<Map<String, Object>> cacheInfos = localCacheClient.getCacheInfos();
            List<CacheInfoVo> cacheInfoVos = CacheInfoConvert.convert(cacheInfos);
            response.setList(cacheInfoVos);
            response.setCode(BizCode.Success);
            response.setMessage("查询异常列表成功");
        } catch (BizException e) {
            logger.error("查询异常列表异常", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            logger.error("查询异常列表异常", e);
            response.setCode(BossBizCode.Unknown);
            response.setMessage(e.getMessage());
        }
        logger.info("返回结果{}", response);
        return response;
    }
}

