package com.maiziyun.boss.integration.cache;

import java.util.List;
import java.util.Map;

/**
 * Created by yinzuolong on 2016/12/29.
 */
public interface LocalCacheClient {

    void refresh(String serviceCode, String cacheName);

    List<Map<String, Object>> getCacheInfos();

}
