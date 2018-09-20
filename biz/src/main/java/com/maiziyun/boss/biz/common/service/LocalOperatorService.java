package com.maiziyun.boss.biz.common.service;

import com.maiziyun.boss.facade.common.model.vo.OperatorVo;

/**
 * Created by len.song on 2016/11/21.
 */
public interface LocalOperatorService extends com.maiziyun.boss.facade.common.model.service.LocalOperatorService {
    OperatorVo getLocalByOperName(String userName) throws Exception;
    OperatorVo getLocalByOperId(Integer userId) throws Exception;
    OperatorVo getLocalByUserNamePass(String userName, String passWord) throws Exception;
}
