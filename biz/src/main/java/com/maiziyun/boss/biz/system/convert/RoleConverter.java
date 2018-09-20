package com.maiziyun.boss.biz.system.convert;

import com.maiziyun.boss.common.utils.DateUtils;
import com.maiziyun.boss.dal.dataobject.MenuDO;
import com.maiziyun.boss.dal.dataobject.RoleDO;
import com.maiziyun.boss.facade.system.model.vo.MenuVo;
import com.maiziyun.boss.facade.system.model.vo.RoleVo;

import java.util.ArrayList;
import java.util.List;

import static com.maiziyun.boss.common.utils.DateUtils.SIMPLE_DATE_HOURS_PATTERN;

/**
 * Created by len.song on 2016/11/24.
 */
public class RoleConverter {
    public static RoleVo reConvert(RoleDO roleDO){
        RoleVo role = new RoleVo();
        role.setRoleName(roleDO.getRoleName());
        role.setRoleId(roleDO.getId());
        role.setRoleCode(roleDO.getRoleCode());
        role.setCreateTime(DateUtils.format(roleDO.getCreateTime(),SIMPLE_DATE_HOURS_PATTERN));
        role.setUpdateTime(DateUtils.format(roleDO.getUpdateTime(),SIMPLE_DATE_HOURS_PATTERN));
        return role;
    }

    public static List<RoleVo> reConvert(List<RoleDO> params){
        if(params==null || params.size()==0){
            return null;
        }
        List<RoleVo> lists = new ArrayList<RoleVo>();
        for(RoleDO m : params){
            RoleVo mv = reConvert(m);
            lists.add(mv);
        }
        return lists;
    }
}
