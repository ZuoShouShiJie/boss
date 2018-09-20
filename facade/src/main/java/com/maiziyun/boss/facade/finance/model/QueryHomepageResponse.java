package com.maiziyun.boss.facade.finance.model;

import com.maiziyun.boss.facade.finance.model.vo.HomepageNoticeVo;
import com.solar.framework.core.base.AbstractResponse;

/**
 * Created by admin on 2017/8/31.
 */
public class QueryHomepageResponse extends AbstractResponse {
    private HomepageNoticeVo noticeVo;

    public HomepageNoticeVo getNoticeVo() {
        return noticeVo;
    }

    public void setNoticeVo(HomepageNoticeVo noticeVo) {
        this.noticeVo = noticeVo;
    }
}
