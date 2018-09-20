package com.maiziyun.boss.facade.system.model.sysuser;

import com.solar.framework.core.base.AbstractRequest;

import java.util.List;

/**
 * Created by len.song on 2016/12/1.
 */
public class SysUserDeleteRequest extends AbstractRequest {
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
