package com.maiziyun.boss.biz.redis;

/**
 * Created by zhangshihang on 2017/3/6.
 */
public interface IBaseRedisService<V> {
    /**
     * 缓存value
     *
     * @param key
     * @param V
     * @param time
     * @return
     */
    boolean cacheValue(String key, V V, long time);

    /**
     * 判断缓存是否存在key
     *
     * @param key
     * @return
     */
    boolean cantainsKey(String key);

    /**
     * 获取缓存
     *
     * @param key
     * @return
     */
    V getValue(String key);

    /**
     * 删除缓存
     *
     * @param key
     * @return
     */
    boolean remove(String key);

}
