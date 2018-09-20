package com.maiziyun.boss.biz.common;

import com.maiziyun.boss.facade.common.enums.BossBizCode;
import com.maiziyun.common.enums.MyServiceCode;
import com.solar.framework.core.exception.BizException;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2017/6/9.
 */
public class CommonUtils {

    /**
     * 文件上传
     *
     * @param path
     * @param fileName
     * @param mFile
     * @return
     * @throws IOException
     */
    public static String uploadFile(String path, String fileName, String suffix, MultipartFile mFile)
            throws IOException {
        if (!mFile.isEmpty()) {
            if (mFile.getSize() > 2*1024*1024){
                throw new BizException(BossBizCode.PicFileSize,"上传图片大于2M,不能上传");
            }
        }
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePath =path + "/" + fileName + suffix;
        File pic = new File(filePath);
        InputStream stream = mFile.getInputStream();
        FileOutputStream outputStream = new FileOutputStream(pic);
        try {
            int byteCount;
            byte[] bytes = new byte[1024];
            while ((byteCount = stream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, byteCount);
            }
        } finally {
            outputStream.close();
            stream.close();
        }
        return filePath;
    }

    public static String genRand(String str) {
        String bossCode = MyServiceCode.Boss.code();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmsss");
        String s1 = sdf.format(date);
        String b = str+bossCode+s1;
        return b;
    }

    public static String getSuffxi(MultipartFile coverImg){
        String name = coverImg.getOriginalFilename();
        String suffix = name.substring(name.lastIndexOf("."));
        return suffix;
    }

    public static String GetImageStr(String file)
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
//        String imgFile = "d://test.testjpg";//待处理的图片
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try
        {
            in = new FileInputStream(file);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//返回Base64编码过的字节数组字符串
    }

    public static Date parseToDate(String s) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(s);

    }

    public static String parseDate(Date s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(s);

    }

    public static String parseDateDay(Date s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(s);

    }

}
