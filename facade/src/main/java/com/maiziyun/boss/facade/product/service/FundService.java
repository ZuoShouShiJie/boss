package com.maiziyun.boss.facade.product.service;

import com.maiziyun.boss.facade.product.model.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by admin on 2017/6/2.
 */
public interface FundService {

    /**
     * 查询热门专题
     *
     * @param request
     * @return
     */
    public FundItemQueryResponse getItemList(FundItemQueryRequest request);


    /**
     * 查询热门专题全部
     */
    public FundItemQueryResponse getAllItemList(FundItemQueryRequest request);

    /**
     * 热门专题修改
     */
    public FundItemModifyResponse fundItemModify(List<FundItemQueryRequest> request);

    /**
     * 热门专题详情查询
     * @return
     */
    public FundItemQueryResponse querySubDetail(FundItemQueryRequest request);

    /**
     * 热门专题详情修改
     */
    public FundItemModifyResponse updateSubDetail(FundItemQueryRequest request);

    /**
     * 热门基金查询(选中)
     */
    public HotFundQueryResponse queryHotFund(HotFundQueryRequest request);

    /**
     * 热门基金查询（未选中）
     */
    public HotFundQueryResponse queryAllHotFund(HotFundQueryRequest request);

    /**
     * 热门基金修改
     */

    public HotFundModifyResponse HotFundModify(List<HotFundModifyRequest> requests);

    /**
     * 新增一个概念
     */
    public  HotFundModifyResponse addHotItem(HotFundQueryRequest request);

    /**
     * 删除概念
     */
    public HotFundModifyResponse deleteHotItem(HotFundQueryRequest request);

    /**
     * 查询基金配置（未分页）
     */
    public HotFundQueryResponse queryFundConf(QueryFundConfRequest request);

    /**
     * 查询基金配置（分页）
     */
    public HotFundQueryResponse queryAllFundConf(QueryFundConfRequest request);

    /**
     * 更改基金配置
     */
public HotFundModifyResponse updateFundConf(UpdateFundConfRequest request);

}
