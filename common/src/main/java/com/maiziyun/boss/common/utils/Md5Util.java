package com.maiziyun.boss.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by len.song on 2016/11/27.
 */
public class Md5Util {
    private static final Logger logger = LoggerFactory.getLogger(Md5Util.class);
    //静态方法，便于作为工具类
    public static String getMd5(String plainText) {
        try {
            if(StringUtils.isEmpty(plainText)){
                return null;
            }
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(),e);
            return null;
        }

    }

    public static void main(String[] args) {
        //测试
        System.out.println(Md5Util.getMd5("admin"));
    }

}
