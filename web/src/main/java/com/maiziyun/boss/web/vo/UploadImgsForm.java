package com.maiziyun.boss.web.vo;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by admin on 2017/7/8.
 */
public class UploadImgsForm  extends  BaseRequest{

    private MultipartFile[] fieldName;

    public MultipartFile[]  getFieldName() {
        return fieldName;
    }

    public void setFieldName(MultipartFile[]  fieldName) {
        this.fieldName = fieldName;
    }
}
