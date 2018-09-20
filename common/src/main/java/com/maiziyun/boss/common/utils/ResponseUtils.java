package com.maiziyun.boss.common.utils;

import com.maiziyun.boss.facade.common.model.SuccessResponse;
import com.solar.framework.core.base.AbstractResponse;
import com.solar.framework.core.enums.BizCode;

/**
 * @author callie
 * @version $Id: ResponseUtils.java, v 0.0.1 2016年11月02日 下午2:24 callie Exp $
 */
public class ResponseUtils {
    public static <T> T castAs(AbstractResponse response, Class<T> clazz){
        if (clazz.isAssignableFrom(response.getClass())){
            return (T) response;
        }
        return null;
    }
}
