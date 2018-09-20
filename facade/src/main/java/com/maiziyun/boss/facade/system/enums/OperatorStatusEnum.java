package com.maiziyun.boss.facade.system.enums;

import com.solar.framework.core.base.AbstractEnum;

/**
 * Created by songliang on 2016/11/15.
 */
public class OperatorStatusEnum extends AbstractEnum {
    public static final OperatorStatusEnum VALID=new OperatorStatusEnum("01","用户有效");
    public static final OperatorStatusEnum LOGOFF=new OperatorStatusEnum("02","用户注销");

    public OperatorStatusEnum() {
    }

    public OperatorStatusEnum(String value, String name) {
        super(value, name);
    }

    @Override
    protected Class<? extends AbstractEnum> getEnumType() {
        return OperatorStatusEnum.class;
    }

}
