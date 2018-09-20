package com.maiziyun.boss.facade.finance.service;

import com.maiziyun.boss.facade.finance.model.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2017/6/26.
 */
public interface NoticeService {

    public QueryNoticeResponse queryAllNotice(QueryNoticeRequest request);

    public QueryNoticeResponse queryNoticeById(QueryNoticeRequest request);

    public UpdateNoticeResponse createNotice(UpdateNoticeRequest request);

    public UpdateNoticeResponse updateNotice(UpdateNoticeRequest request);

    public UpdateNoticeResponse updateState(UpdateNoticeRequest request);

    public UpdateNoticeResponse deleteNotice(UpdateNoticeRequest request);

    public List<String>  uploadFiles(List<MultipartFile> files, String PreImgUrl, String sufImgUrl, String httpUrl) throws IOException;

    public QueryHomepageResponse queryHomepageNotice(QueryHomepageRequest request);

    public UpdateHomepageResponse updateHomepageNotice(UpdateHomepageRequest request);


}
