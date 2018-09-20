package com.maiziyun.boss.integration.finance.impl;

import com.maiziyun.boss.integration.finance.NoticeClient;
import com.maiziyun.cms.facade.model.QueryAdvertisementManagerResponse;
import com.maiziyun.common.enums.MyServiceCode;
import com.maiziyun.mdc.facade.NoticeManagerService;
import com.maiziyun.mdc.facade.model.*;
import com.solar.framework.core.enums.SourceCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 2017/6/26.
 */
public class NoticeClientImpl implements NoticeClient {
    private Logger logger = LoggerFactory.getLogger(NoticeClient.class);

    private NoticeManagerService noticeService;

    public void setNoticeService(NoticeManagerService noticeService) {
        this.noticeService = noticeService;
    }

    @Override
    public QueryNoticeManagerResponse queryAllNotice(QueryNoticeManagerRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向mdc发送请求：{}", request);
        QueryNoticeManagerResponse response = noticeService.queryNotice(request);
        logger.info("mdc返回数据：{}", response);
        return response;
    }

    @Override
    public QueryNoticeManagerResponse queryNoticeById(QueryNoticeManagerRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向mdc发送请求：{}", request);
        QueryNoticeManagerResponse response = noticeService.queryNotice(request);
        logger.info("mdc返回数据：{}", response);
        return response;
    }

    @Override
    public CreateNoticeManagerResponse createNotice(CreateNoticeManagerRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向mdc发送请求：{}", request);
        CreateNoticeManagerResponse response = noticeService.createNotice(request);
        logger.info("mdc返回数据：{}", response);
        return response;
    }

    @Override
    public UpdateNoticeManagerResponse updateState(UpdateNoticeManagerRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向mdc发送请求：{}", request);
        UpdateNoticeManagerResponse response = noticeService.updateNotice(request);
        logger.info("mdc返回数据：{}", response);
        return response;
    }

    @Override
    public UpdateNoticeManagerResponse updateNotice(UpdateNoticeManagerRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向mdc发送请求：{}", request);
        UpdateNoticeManagerResponse response = noticeService.updateNotice(request);
        logger.info("mdc返回数据：{}", response);
        return response;
    }

    @Override
    public DeleteNoticeResponse deleteNotice(DeleteNoticeRequest  request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向mdc发送请求：{}", request);
        DeleteNoticeResponse  response = noticeService.deleteNotice(request);
        logger.info("mdc返回数据：{}", response);
        return response;
    }

    @Override
    public QueryNoticeManagerResponse queryHomepageNotice(QueryNoticeManagerRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向mdc发送请求：{}", request);
        QueryNoticeManagerResponse  response = noticeService.queryNotice(request);
        logger.info("mdc返回数据：{}", response);
        return response;
    }

    @Override
    public CreateNoticeManagerResponse createHomepageNotice(CreateNoticeManagerRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向mdc发送请求：{}", request);
        CreateNoticeManagerResponse  response = noticeService.createNotice(request);
        logger.info("mdc返回数据：{}", response);
        return response;
    }

    @Override
    public UpdateNoticeManagerResponse updateHomepageNotice(UpdateNoticeManagerRequest request) {
        request.setService(MyServiceCode.Boss);
        request.setSource(SourceCode.OpenApi);
        logger.info("向mdc发送请求：{}", request);
        UpdateNoticeManagerResponse  response = noticeService.updateNotice(request);
        logger.info("mdc返回数据：{}", response);
        return response;
    }
}
