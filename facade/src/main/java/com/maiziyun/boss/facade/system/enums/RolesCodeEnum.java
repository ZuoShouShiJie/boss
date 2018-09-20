package com.maiziyun.boss.facade.system.enums;

import com.solar.framework.core.base.AbstractEnum;

/**
 * Created by songliang on 2016/11/18.
 */
public class RolesCodeEnum extends AbstractEnum {
    public static final RolesCodeEnum SADMIN = new RolesCodeEnum("SADMIN","超级管理员");
    public static final RolesCodeEnum ADMIN = new RolesCodeEnum("ADMIN","管理员");
    public static final RolesCodeEnum OPERATOR = new RolesCodeEnum("ADMIN","管理员");

    public RolesCodeEnum(String code, String name) {
        super(code, name);
    }

    RolesCodeEnum(){

    }

    @Override
    protected Class<? extends AbstractEnum> getEnumType() {
        return RolesCodeEnum.class;
    }
}
