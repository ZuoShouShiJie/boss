package com.maiziyun.boss.biz.user.convert;

import com.maiziyun.boss.facade.user.model.vo.TreasureBalanceFundVo;
import com.maiziyun.fund.trade.facade.model.vo.UserWalletVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanlinglong on 2016/12/16.
 */
public class UserTreasureBalanceConverter {
    public static TreasureBalanceFundVo reConvert(UserWalletVo walletVo) {
        TreasureBalanceFundVo b = new TreasureBalanceFundVo();
        b.setTransFundCode(walletVo.getFundCode());
        b.setTransFundName(walletVo.getFundName());
        //b.setPayType();//支付方式  (机构号)
        b.setTotalShare(walletVo.getTotalAmount()==null?null:walletVo.getTotalAmount().toString());
        b.setFastWithdrawAmount(walletVo.getFastWithdrawAmount().toString());
        b.setOutputAmount(walletVo.getOutputAmount().toString());
        b.setLatestIncome(walletVo.getPreviousProfit());
        b.setAccumulatedIncome(walletVo.getAccProfit());
        return b;
    }

    public static List<TreasureBalanceFundVo> reConvert(List<UserWalletVo> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<TreasureBalanceFundVo> lists = new ArrayList<TreasureBalanceFundVo>();
        for (UserWalletVo w : params) {
            TreasureBalanceFundVo b = reConvert(w);
            lists.add(b);
        }
        return lists;
    }
}
