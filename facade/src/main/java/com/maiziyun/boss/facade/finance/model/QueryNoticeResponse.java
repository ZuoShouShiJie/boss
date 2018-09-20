package com.maiziyun.boss.facade.finance.model;

import com.maiziyun.boss.facade.finance.model.vo.NoticeManagerVo;
import com.solar.framework.core.base.AbstractPagedResponse;

/**
 * Created by admin on 2017/6/26.
 */
public class QueryNoticeResponse extends AbstractPagedResponse<NoticeManagerVo> {
    private NoticeManagerVo vo;

    public NoticeManagerVo getVo() {
        return vo;
    }

    public void setVo(NoticeManagerVo vo) {
        this.vo = vo;
    }
}
