package com.maiziyun.boss.facade.system.model.role;

import com.maiziyun.boss.facade.common.model.ListResponse;
import com.maiziyun.boss.facade.system.model.vo.RoleVo;

import java.util.List;

/**
 * Created by len.song on 2016/12/2.
 */
public class RoleListResponse extends ListResponse {
    private List<RoleVo> list;

    public List<RoleVo> getList() {
        return list;
    }

    public void setList(List<RoleVo> list) {
        this.list = list;
    }
}
