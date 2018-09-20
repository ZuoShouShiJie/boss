package com.maiziyun.boss.biz.user.convert;

import com.maiziyun.boss.common.utils.BzStringUtils;
import com.maiziyun.boss.facade.common.model.vo.UserTransVo;
import com.maiziyun.fund.trade.facade.enums.ConfirmStatus;
import com.maiziyun.fund.trade.facade.enums.TransFlag;
import com.maiziyun.fund.trade.facade.model.vo.OrderVo;
import com.maiziyun.payment.bcdc.facade.model.signusercardrelation.vo.SignUserCardRelationVo;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by len.song on 2016/12/18.
 */
public class UserTransConverter {
    public static UserTransVo reConvert(OrderVo orderVo) {
        UserTransVo ut = new UserTransVo();
        ut.setTransId(orderVo.getTransId());
        ut.setOrderNo(orderVo.getOrderNo());
        if(orderVo.getApplyDate()!=null && orderVo.getApplyTime()!=null){
            ut.setOrderCreateTime(orderVo.getApplyDate()+" "+ orderVo.getApplyTime());
        }
        ut.setOrderAreTradingDay(orderVo.getPayDate());
        ut.setOrderAreConfirmDate(orderVo.getConfirmDate());
        //支付方式   (机构号)
        ut.setTransFundName(orderVo.getFundName());
        ut.setTransFundCode(orderVo.getFundCode());
        ut.setProductName(orderVo.getProductName());
        ut.setTransType(orderVo.getSubTransCode().desc());//交易类型名称
        //交易金额（元）
        ut.setTransAmount(orderVo.getAmount()==null?null:orderVo.getAmount().toString());
        //交易份额
        ut.setTransShare(orderVo.getQuty()==null?null:orderVo.getQuty().toString());
        //实际成功成交份额
        ut.setActualSucTransShare(orderVo.getConfirmQuty()==null?null:orderVo.getConfirmQuty().toString());
        //交易费用
        ut.setTransCost(orderVo.getFee()==null?null:orderVo.getFee().toString());
        //实际成成功成交金额(?)

        //转换目标基金名称
        //转换目标基金代码
        //目标付费类型
        //成功转换的金额
        //成功转换的份额

        ut.setChargeMethod(orderVo.getFeeType()==null?null:orderVo.getFeeType().desc());
        ut.setOrderPaymentStatus(orderVo.getTransStatus()==null?null:orderVo.getTransStatus().desc());
        ut.setOrderConfirmStatus(orderVo.getAssertLastConfirm()==null?null:ConfirmStatus.valueOf(
                ConfirmStatus.class,orderVo.getAssertLastConfirm()).desc());
        //交易标识
        ut.setTransFlag(orderVo.getTransFlag().desc());
        return ut;
    }

    public static List<UserTransVo> reConvert(List<OrderVo> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<UserTransVo> lists = new ArrayList<UserTransVo>();
        for (OrderVo m : params) {
            UserTransVo u = reConvert(m);
            lists.add(u);
        }
        return lists;
    }


    public static UserTransVo setOrderPayType(OrderVo orderVo, List<SignUserCardRelationVo> userCardRelationVos){
        UserTransVo userTransVo = reConvert(orderVo);
        for (SignUserCardRelationVo signUserCardRelationVo : userCardRelationVos) {
            if (StringUtils.equals(signUserCardRelationVo.getCardIdxNo(), orderVo.getCardIdxNo())) {
                userTransVo.setOrderPayType(signUserCardRelationVo.getInstId().desc());
                userTransVo.setCardTailNo(BzStringUtils.getHideCard(signUserCardRelationVo.getCardIdxNo()));
            }
        }
        return userTransVo;
    }


}
