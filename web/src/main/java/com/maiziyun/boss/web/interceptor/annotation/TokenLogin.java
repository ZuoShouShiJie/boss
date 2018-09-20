package com.maiziyun.boss.web.interceptor.annotation;

import java.lang.annotation.*;

/**
 * Created by admin on 2017/6/1.
 */

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface TokenLogin {

    /**
     * 默认进行安全拦截
     *
     * @return
     */
    boolean validate() default true;
}