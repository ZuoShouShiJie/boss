package com.maiziyun.boss.facade.jysmng.service;

import com.maiziyun.boss.facade.common.model.ResponseNewData;
import com.maiziyun.boss.facade.jysmng.model.*;

/**
 * Created by admin on 2017/11/4.
 */
public interface JYSMngService {
    //用户投资列表查询
    ResponseNewData userInvestListQuery(UserInvestListQueryRequest request);

    //第一步：查用户信息
    ResponseNewData queryUserMsg(FundsRecordQueryRequest request);

    //第二步：查资金记录
    ResponseNewData fundsRecordQuery(FundsRecordQueryRequest request);

    //交易所项目配置查询
    ResponseNewData projectConfQuery(ProjectConfQueryRequest request);

    //交易所项目配置新增/修改
    ResponseNewData projectConfUpdate(ProjectConfUpdateRequest request);

    //理财产品配置查询
    ResponseNewData productConfQuery(ProductConfQueryRequest request);

    //通过交易所查询项目
    ResponseNewData queryProjectByExchange(QueryProjectAllRequest request);

    //理财产品配置新增/修改
    ResponseNewData productConfUpdate(ProductConfUpdateRequest request);

    //理财产品配置新增/修改
    ResponseNewData productUpdateStatus(ProductConfUpdateRequest request);

    //产品发布
    ResponseNewData releaseProd(ReleaseProdRequest request);

    //理财产品配置删除
    ResponseNewData productConfDele(ProductConfDeleRequest request);


    //产品还款列表查询
    ResponseNewData productRepayQueryList(ProductRepayQueryRequest request);

    //查询还款详情
    ResponseNewData productRepayQueryById(ProductRepayQueryRequest request);

    //点击还款进行还款
    ResponseNewData productRepay(ProductRepayQueryRequest request);

    //还款用户下载
    ResponseNewData productRepayLoad(ProductRepayQueryRequest request);

    //还款用户查询列表
    ResponseNewData productRepayUserList(ProductRepayQueryRequest request);

}
