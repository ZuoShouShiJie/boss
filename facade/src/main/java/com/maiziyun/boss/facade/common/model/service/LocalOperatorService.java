package com.maiziyun.boss.facade.common.model.service;

import com.maiziyun.boss.facade.common.model.MenuResponse;
import com.maiziyun.boss.facade.common.model.OperatorRequest;
import com.maiziyun.boss.facade.common.model.OperatorResponse;
import com.maiziyun.boss.facade.common.model.vo.OperatorVo;

/**
 * Created by len.song on 2016/11/21.
 */
public interface LocalOperatorService {
    /**
     * 根据操作员用户名查找操作员详情
     * @param request
     * @return
     */
    OperatorResponse getByOperName(OperatorRequest request);

    /**
     *  根据操作员id查找操作员详情
     * @param request
     * @return
     */
    OperatorResponse getByOperId(OperatorRequest request);

    OperatorResponse getByUserNamePass(OperatorRequest request);

    MenuResponse getMenuList(OperatorRequest request);
}

