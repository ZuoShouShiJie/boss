package com.maiziyun.boss.facade.cache.service;

import com.maiziyun.boss.facade.cache.model.LocalCacheGetInfoResponse;
import com.maiziyun.boss.facade.cache.model.LocalCacheRefreshRequest;
import com.maiziyun.boss.facade.cache.model.LocalCacheRefreshResponse;

import java.util.List;
import java.util.Map;

/**
 * Created by fanlinlong on 2016/12/29.
 */
public interface LocalCacheService {

    LocalCacheRefreshResponse refresh(LocalCacheRefreshRequest request);

    LocalCacheGetInfoResponse getCacheInfos( );
}
