package com.maiziyun.boss.biz.system.convert;

import com.maiziyun.boss.common.utils.DateUtils;
import com.maiziyun.boss.dal.dataobject.MenuDO;
import com.maiziyun.boss.dal.dataobject.OperatorDO;
import com.maiziyun.boss.facade.system.model.vo.MenuVo;
import com.maiziyun.boss.facade.system.model.vo.SysUserVo;

import java.util.ArrayList;
import java.util.List;

import static com.maiziyun.boss.common.utils.DateUtils.SIMPLE_DATE_HOURS_PATTERN;

/**
 * Created by len.song on 2016/12/1.
 */
public class SysUserConverter {
    public static SysUserVo reConvert(OperatorDO operatorDO){
        SysUserVo oper = new SysUserVo();
        oper.setFirstLoginTime(DateUtils.format(operatorDO.getFirstLoginTime(),SIMPLE_DATE_HOURS_PATTERN));
        oper.setLastLoginIp(operatorDO.getLastLoginIp());
        oper.setLastLoginTime(DateUtils.format(operatorDO.getLastLoginTime(),SIMPLE_DATE_HOURS_PATTERN));
        oper.setStatus(operatorDO.getStatus());
        oper.setUserId(operatorDO.getId());
        oper.setUserName(operatorDO.getUserName());
        oper.setRealName(operatorDO.getRealName());
        oper.setCreateTime(DateUtils.format(operatorDO.getCreateTime(),SIMPLE_DATE_HOURS_PATTERN));
        oper.setUpdateTime(DateUtils.format(operatorDO.getUpdateTime(),SIMPLE_DATE_HOURS_PATTERN));
        return oper;
    }

    public static List<SysUserVo> reConvert(List<OperatorDO> params){
        if(params==null || params.size()==0){
            return null;
        }
        List<SysUserVo> lists = new ArrayList<SysUserVo>();
        for(OperatorDO m : params){
            SysUserVo oper = reConvert(m);
            lists.add(oper);
        }
        return lists;
    }
}
