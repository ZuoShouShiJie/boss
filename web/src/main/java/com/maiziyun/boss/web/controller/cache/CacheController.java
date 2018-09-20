
package com.maiziyun.boss.web.controller.cache;

import com.maiziyun.boss.biz.cache.service.CacheService;
import com.maiziyun.boss.facade.cache.model.LocalCacheGetInfoResponse;
import com.maiziyun.boss.facade.cache.model.LocalCacheRefreshRequest;
import com.maiziyun.boss.facade.cache.model.LocalCacheRefreshResponse;
import com.maiziyun.boss.web.controller.ResponseUtil;
import com.maiziyun.boss.web.controller.ViewResponseModel;
import com.maiziyun.boss.web.controller.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 刷新缓存
 * Created by fanlinlong on 2016/12/8.
 */

@Controller
@RequestMapping("/cache")
public class CacheController extends BaseController {

    @Resource(name = "boss.CacheService")
    private CacheService cacheService;

    @RequestMapping("/cacheIndex.htm")
    public String toCardQuotaIndex(HttpServletRequest request) {
        return "cache/cachePage_index";
    }

    @RequestMapping("/getCacheInfos.do")
    public void getCacheInfos(HttpServletRequest request, HttpServletResponse response) {
        LocalCacheGetInfoResponse $response = cacheService.getCacheInfos();
        ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, $response.getList()));
    }

    @RequestMapping("/refresh.do")
    public void updateChannelQuota(String serviceCode, String cacheName, HttpServletRequest request, HttpServletResponse response) {
        LocalCacheRefreshRequest $request = new LocalCacheRefreshRequest();
        $request.setServiceCode(serviceCode);
        $request.setCacheName(cacheName);
        LocalCacheRefreshResponse $response = cacheService.refresh($request);
        ResponseUtil.writeResponse(request, response, new ViewResponseModel($response, $response));
    }
}

