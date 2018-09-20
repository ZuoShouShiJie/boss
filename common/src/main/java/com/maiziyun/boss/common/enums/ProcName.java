package com.maiziyun.boss.common.enums;

import com.solar.framework.core.base.AbstractEnum;

/**
 * Created by songliang on 2016/11/15.
 */
public class ProcName extends AbstractEnum {

    public static final ProcName LOGIN = new ProcName("login","登录处理器");

    public ProcName() {
    }

    public ProcName(String name, String desc) {
        super(name, desc);
    }

    @Override
    protected Class<? extends AbstractEnum> getEnumType() {
        return ProcName.class;
    }
}
