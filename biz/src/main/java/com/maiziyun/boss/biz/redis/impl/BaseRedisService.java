package com.maiziyun.boss.biz.redis.impl;

import com.maiziyun.boss.biz.redis.IBaseRedisService;
import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.solar.framework.core.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


/**
 * Created by zhangshihang on 2017/3/6.
 */
@Service("boss.BaseRedisService")
public class BaseRedisService<V> implements IBaseRedisService<V> {


    private static final Logger LOGGER = LoggerFactory.getLogger(BaseRedisService.class);

    @Autowired
    private RedisTemplate<String, V> redisTemplate;

    @Override
    public boolean cacheValue(String key, V V, long time) {
        LOGGER.info("接收请求:{}", key + "-" + V);
        try {
            ValueOperations<String, V> valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key, V);
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.DAYS);
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("redis存储数据失败", e);
            throw new BizException(BossBizCode.RedisCache,BossBizCode.RedisCache.desc(), e);
        }
        return false;
    }

    @Override
    public boolean cantainsKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            LOGGER.error("redis存储数据失败", e);
        }
        return false;
    }

    @Override
    public V getValue(String key) {
        try {
            ValueOperations valueOperations = redisTemplate.opsForValue();
            return (V) valueOperations.get(key);
        } catch (Exception e) {
            LOGGER.error("redis存储数据失败", e);
        }
        return null;
    }

    @Override
    public boolean remove(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Exception e) {
            LOGGER.error("redis存储数据失败", e);
        }
        return false;
    }

    public RedisTemplate<String, V> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
