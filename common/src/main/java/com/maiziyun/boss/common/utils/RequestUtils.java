package com.maiziyun.boss.common.utils;

import com.solar.framework.core.base.AbstractRequest;

/**
 * @author callie
 * @version $Id: RequestUtils.java, v 0.0.1 2016年11月02日 上午10:49 callie Exp $
 */
public class RequestUtils {

    public static <T> T castAs(AbstractRequest request,Class<T> clazz){
        if (clazz.isAssignableFrom(request.getClass())){
            return (T) request;
        }
        return null;
    }

}
