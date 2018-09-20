package com.maiziyun.boss.common.utils;

import org.apache.commons.lang.StringUtils;

/**
 * Created by len.song on 2016/12/19.
 */
public class BzStringUtils {
    /**
     * 将电话号码进行加密处理   例如：138 8888 8888 转换成 138 **** 8888
     *
     * @param phoneNum
     * @return
     */
    public static String proPhoneNum(String phoneNum) {
        if (StringUtils.isBlank(phoneNum) || phoneNum.length() < 8) {
            return phoneNum;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(phoneNum.substring(0, 3));
        sb.append("****");
        sb.append(phoneNum.substring(phoneNum.length() - 4));

        return sb.toString();
    }

    /**
     * 讲银行卡进行加密处理  例如 6226 1332 34324 2343 变成  622613****2343
     *
     * @param bankCard
     * @return
     */
    public static String proBankCard(String bankCard) {
        if (StringUtils.isBlank(bankCard) || bankCard.length() < 11) {
            return bankCard;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(bankCard.substring(0, 6));
        sb.append("****");
        sb.append(bankCard.substring(bankCard.length() - 4));
        return sb.toString();
    }

    /**
     * 将''转成null
     *
     * @param target
     * @return
     */
    public static String convert(String target) {
        if (StringUtils.isBlank(target)) {
            return null;
        }
        return target;
    }

    /**
     * @param cardNo
     * @return
     */
    public static String getHideCard(String cardNo) {
        if (cardNo == null || cardNo.length() < 10)
            return "--";
        return cardNo.substring(6, 10);// 前十位里的后四位
    }
}
