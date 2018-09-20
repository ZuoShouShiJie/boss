package com.maiziyun.boss.facade.user.model;

import com.maiziyun.boss.facade.user.model.vo.UserBindCardVo;
import com.solar.framework.core.base.AbstractPagedResponse;

import java.util.List;

/**
 * Created by len.song on 2016/11/24.
 */
public class UserBindCardResponse extends AbstractPagedResponse<UserBindCardVo> {
    @Override
    public void setDatas(List<UserBindCardVo> datas) {
        super.setDatas(datas);
        if (datas != null && getTotal() == null) {
            super.setTotal(datas.size());
        }
    }
}
