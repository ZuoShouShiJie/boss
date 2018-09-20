package com.maiziyun.boss.biz.user.convert;

import com.maiziyun.boss.common.utils.BzStringUtils;
import com.maiziyun.boss.facade.user.model.vo.UserBindCardVo;
import com.maiziyun.payment.bcdc.facade.model.signusercardrelation.vo.SignUserCardRelationVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by len.song on 2016/12/18.
 */
public class UserBindCardConverter {
    public static UserBindCardVo reConvert(SignUserCardRelationVo relationVo) {
        UserBindCardVo u = new UserBindCardVo();
        u.setBankName(relationVo.getInstName());
        u.setCardNo(BzStringUtils.proBankCard(relationVo.getCardIdxNo()));
        u.setOpeningProvince(relationVo.getInstProvince());
        u.setOpeningCity(relationVo.getInstCity());
        u.setPhone(BzStringUtils.proPhoneNum(relationVo.getMobile()));
        return u;
    }

    public static List<UserBindCardVo> reConvert(List<SignUserCardRelationVo> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<UserBindCardVo> lists = new ArrayList<UserBindCardVo>();
        for (SignUserCardRelationVo m : params) {
            UserBindCardVo u = reConvert(m);
            lists.add(u);
        }
        return lists;
    }
}
