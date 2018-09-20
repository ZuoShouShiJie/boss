package com.maiziyun.boss.integration.finance;

import com.maiziyun.boss.facade.finance.model.UpdateAdverResponse;
import com.maiziyun.boss.facade.finance.model.UpdateNoticeResponse;
import com.maiziyun.mdc.facade.model.*;

/**
 * Created by admin on 2017/6/26.
 */
public interface NoticeClient {

    public QueryNoticeManagerResponse queryAllNotice(QueryNoticeManagerRequest request);

    public QueryNoticeManagerResponse queryNoticeById(QueryNoticeManagerRequest request);

    public CreateNoticeManagerResponse createNotice(CreateNoticeManagerRequest request);

    public UpdateNoticeManagerResponse updateNotice(UpdateNoticeManagerRequest request);

    public UpdateNoticeManagerResponse updateState(UpdateNoticeManagerRequest request);

    public DeleteNoticeResponse  deleteNotice(DeleteNoticeRequest  request);

    public QueryNoticeManagerResponse queryHomepageNotice(QueryNoticeManagerRequest request);

    public CreateNoticeManagerResponse createHomepageNotice(CreateNoticeManagerRequest request);

    public UpdateNoticeManagerResponse updateHomepageNotice(UpdateNoticeManagerRequest request);


}
