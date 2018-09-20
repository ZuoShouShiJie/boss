package com.maiziyun.boss.facade.common.enums;

import com.solar.framework.core.base.AbstractEnum;

/**
 * Created by len.song on 2016/11/24. 判断数据是否有效/是否删除
 */
public class IsValid extends AbstractEnum {
    public static final IsValid VALID = new IsValid("1","有效");
    public static final IsValid INVALID = new IsValid("0","无效");

    public IsValid(){

    }

    public IsValid(String code, String name){
        super(code,name);
    }

    @Override
    protected Class<? extends AbstractEnum> getEnumType() {
        return IsValid.class;
    }
}
