package com.maiziyun.boss.facade.user.service;

import com.maiziyun.boss.facade.user.model.*;

/**
 * Created by fanlinglong on 2016/11/16.
 */
public interface UserService {
    /**
     * 查询用户列表信息
     *
     * @param request
     * @return
     */
    UserPageResponse getPageUsers(UserPageRequest request);

    /**
     * 查询用户交易列表信息
     * @param request
     * @return
     */
    UserTransPageResponse getPageUserTrans(UserTransPageRequest request);

    /**
     * 查询财神宝余额
     * @param request
     * @return
     */
    UserTreasureBalanceResponse getUserWalletLists(UserTreasureBalanceRequest request);

    /**
     * 查询用户持有基金
     * @param request
     * @return
     */
    UserHoldQueryResponse getUserHoldLists(UserHoldQueryRequest request);

    /**
     * 查询用户绑卡信息
     * @param request
     * @return
     */
    UserBindCardResponse queryUserBindCards(UserBindCardRequest request);
}
