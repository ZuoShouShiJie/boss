package com.maiziyun.boss.biz.cache.convert;

import com.maiziyun.boss.facade.cache.model.vo.CacheInfoVo;
import com.solar.framework.core.enums.ServiceCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by fanlinlong on 2016/12/29.
 */
public class CacheInfoConvert {
    public static CacheInfoVo convert(Map<String, Object> cacheInfo) {
        String name = (String) cacheInfo.get("name");
        String desc = (String) cacheInfo.get("desc");
        ServiceCode serviceCode = (ServiceCode) cacheInfo.get("serviceCode");

        CacheInfoVo vo = new CacheInfoVo();
        vo.setCacheCode(name);
        vo.setCacheDesc(desc);
        vo.setServiceCode(serviceCode.name());
        vo.setServiceDesc(serviceCode.desc());
        return vo;
    }

    public static List<CacheInfoVo> convert(List<Map<String, Object>> bos) {
        if (bos == null || bos.size() == 0) {
            return null;
        }
        List<CacheInfoVo> voList = new ArrayList<>(bos.size());
        for (Map<String, Object> bo : bos) {
            CacheInfoVo vo = convert(bo);
            voList.add(vo);
        }
        return voList;
    }
}
