package com.maiziyun.boss.facade.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by len.song on 2016/12/14.
 */
public enum ProductType {
    test1("1","测试一"),
    test2("2","测试一");

    private String code;
    private String name;

    private static final List<Map<String,String>> productType = new ArrayList<Map<String, String>>();

    public static List<Map<String,String>> getProductType() {
        return productType;
    }

    static {
        for (ProductType typeEnum : ProductType.values()) {
            Map<String,String> result = new HashMap<String,String>();
            result.put("code",typeEnum.getCode());
            result.put("name",typeEnum.getName());
            productType.add(result);
        }
    }

    ProductType(String code, String name){
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }


    public String getName() {
        return name;
    }

}
