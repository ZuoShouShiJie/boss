package com.maiziyun.boss.biz.user.convert;

import com.maiziyun.boss.common.utils.BzStringUtils;
import com.maiziyun.boss.facade.user.model.vo.UserVo;
import com.maiziyun.cif.facade.model.vo.UserManagerInfoVo;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanlinglong on 2016/12/16.
 */
public class UserConverter {
    public static UserVo reConvert(UserManagerInfoVo userMng) {
        UserVo u = new UserVo();
        u.setUserId(userMng.getUserId());
        u.setUserName(userMng.getName());
        u.setPhone(BzStringUtils.proPhoneNum(userMng.getMobile()));
        u.setCert("是");
        u.setBindCard("是");
        u.setRiskInves(StringUtils.isBlank(userMng.getLevelName()) ? "未评估过" : userMng.getLevelName());
        u.setRegDate(userMng.getRegisterTime());
        u.setCertNO(userMng.getCertNO());
        return u;
    }

    public static List<UserVo> reConvert(List<UserManagerInfoVo> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        List<UserVo> lists = new ArrayList<UserVo>();
        for (UserManagerInfoVo m : params) {
            UserVo u = reConvert(m);
            lists.add(u);
        }
        return lists;
    }
}
