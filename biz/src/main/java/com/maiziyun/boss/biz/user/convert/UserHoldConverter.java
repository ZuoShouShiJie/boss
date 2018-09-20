package com.maiziyun.boss.biz.user.convert;


import com.maiziyun.boss.facade.user.model.vo.HoldingFundVo;
import com.maiziyun.common.enums.FeeType;
import com.maiziyun.fund.trade.facade.model.vo.UserAssetVo;
import com.maiziyun.product.facade.enums.FundType;
import com.solar.framework.core.model.Money;
import com.solar.framework.core.model.Quty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanlinglong on 2016/12/16.
 */
public class UserHoldConverter {
    public static HoldingFundVo reConvert(UserAssetVo assetVo) {
        HoldingFundVo h = new HoldingFundVo();
        h.setProductName(assetVo.getProductName());
        h.setTransFundCode(assetVo.getFundCode());
        h.setTransFundName(assetVo.getFundName());
        //h.setPayType();//支付方式  (机构号)
        h.setLatestNetWorth(assetVo.getNav().toString());
        h.setFundType(assetVo.getFundType()==null?"": FundType.valueOf(FundType.class,assetVo.getFundType()).desc());
        h.setChargeMethod(assetVo.getFeeType()==null?"": assetVo.getFeeType().desc());
        h.setTotalShare(assetVo.getTotalQuty()==null?null:assetVo.getTotalQuty().toString());
        h.setAvailableShare(assetVo.getAvaiQuty()==null?null:assetVo.getAvaiQuty().toString());
        h.setFundValue(assetVo.getTotalShareAsset().toString());// 基金市值（元）
        h.setFundDividendType(assetVo.getMelonType()==null?null:assetVo.getMelonType().desc());//基金分红方式
        h.setAccumulatedIncome(assetVo.getAccProfit()==null?null:assetVo.getAccProfit().toString());
        h.setLatestOfficialIncome(assetVo.getPreviousProfit()==null?null:assetVo.getPreviousProfit().toString());
        h.setLatestOfficialIncomeDate(assetVo.getPreviousProfitTradeDate());
        h.setLatestEstimatesIncome(assetVo.getPreviousEstimatedProfit()==null?null:assetVo.getPreviousEstimatedProfit().toString());
        h.setLatestEstimatesIncomeDate(assetVo.getPreviousEstimatedProfitTradeDate());
        return h;
    }

    public static List<HoldingFundVo> reConvert(List<UserAssetVo> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<HoldingFundVo> lists = new ArrayList<HoldingFundVo>();
        for (UserAssetVo m : params) {
            HoldingFundVo h = reConvert(m);
            lists.add(h);
        }
        return lists;
    }
}
