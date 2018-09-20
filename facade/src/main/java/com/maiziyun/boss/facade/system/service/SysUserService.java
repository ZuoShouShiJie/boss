package com.maiziyun.boss.facade.system.service;

import com.maiziyun.boss.facade.system.model.sysuser.*;

/**
 * Created by len.song on 2016/12/1.
 */
public interface SysUserService {
    /**
     * 查询操作员分页信息
     * @param request
     * @return
     */
    SysUserPageResponse getPageSysUsers(SysUserPageRequest request);

    /**
     * 根据编号删除操作员
     * @param request
     * @return
     */
    SysUserDeleteResponse deleteSysUsersByIds(SysUserDeleteRequest request);

    /**
     * 根据操作员id修改操作员
     * @param request
     * @return
     */
    SysUserModifyResponse modifySysUserById(SysUserModifyRequest request);

    /**
     * 增加操作员
     * @param request
     * @return
     */
    SysUserAddResponse addSysUser(SysUserAddRequest request);

    /**
     * 系统用户修改密码
     * @param request
     * @return
     */
    SysUserModifyPassResponse modifyPass(SysUserModifyPassRequest request);

}
