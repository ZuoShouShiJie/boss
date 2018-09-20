package com.maiziyun.boss.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by len.song on 2016/11/30.
 */
public class ObjectUtils {
    //将Integer数组转换成list
    public static List<Integer> IntegerConvertToList(Integer[] ints){
        List<Integer> list = new ArrayList<Integer>();
        if(ints==null || ints.length==0){
            return null;
        }
        for(Integer i : ints){
            list.add(i);
        }
        return list;
    }

    //将Integer数组转换成list
    public static List<String> StringConvertToList(String[] strs){
        List<String> list = new ArrayList<String>();
        if(strs==null || strs.length==0){
            return null;
        }
        for(String i : strs){
            list.add(i);
        }
        return list;
    }

    /**
     * 将json格式的数组转换成数组对象，例如"[13,9]"转换成[12,9]
     * @param params
     * @return
     */
    public static Integer[] toIntegerArrays(String params){
        System.out.print(params);
        if(StringUtils.isBlank(params) || "[\"\"]".equals(params) ||
                params.indexOf("[")==-1){
            return null;
        }
        JSONArray jsonArray = JSON.parseArray(params);
        Integer[] objs = new Integer[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            if(params.indexOf("[\"")>=0){
                objs[i] = Integer.parseInt((String)jsonArray.get(i));
            }else {
                objs[i] = (Integer)jsonArray.get(i);
            }

        }
        return objs;
    }


    /**
     * 将json格式的数组转换成数组对象，例如"["13","9"]"转换成["12","9"]
     * @param params
     * @return
     */
    public static String[] toStringArrays(String params){
        if(StringUtils.isBlank(params) || "[\"\"]".equals(params) ||
                params.indexOf("[")==-1){
            return null;
        }
        JSONArray jsonArray = JSON.parseArray(params);
        String[] objs = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            objs[i] = (String)jsonArray.get(i);
        }
        return objs;
    }
}
