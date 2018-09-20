package com.maiziyun.boss.common.utils;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Map;

/**
 * @author callie
 * @version $Id: CacheUtils.java, v 0.0.1 2016年11月02日 上午9:49 callie Exp $
 */
public class CacheUtils {

    public static String getCacheInfo(Map<String,?> caches){

        if (MapUtils.isEmpty(caches)){
            return StringUtils.EMPTY;
        }

        StringBuffer sb=new StringBuffer();
        for (String key:caches.keySet()){
            sb.append("\n");
            sb.append(key).append("=");
            sb.append(ToStringBuilder.reflectionToString(caches.get(key)));
        }
        return sb.toString();

    }

}
