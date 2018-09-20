package com.maiziyun.boss.facade.system.service;

import com.maiziyun.boss.facade.system.model.role.*;
import com.maiziyun.boss.facade.system.model.sysuser.SysUserPageRequest;
import com.maiziyun.boss.facade.system.model.sysuser.SysUserPageResponse;

/**
 * Created by len.song on 2016/11/24.
 */
public interface RoleService {
    /**
     * 按分页查询用户角色
     * @param request
     * @return
     */
    RolesPageResponse getPageRoles(RolesPageRequest request);

    /**
     * 修改角色
     * @param request
     * @return
     */
    RoleModifyResponse editorRoles(RoleModifyRequest request);

    /**
     * 删除角色
     * @param request
     * @return
     */
    RoleDeleteResponse deleteRoles(RoleDeleteRequest request);

    /**
     * 增加
     * @param request
     * @return
     */
    RoleAddResponse addRole(RoleAddRequest request);

    /**
     * 获取全部有效角色的列表
     * @param request
     * @return
     */
    RoleListResponse getListRoles(RoleListRequest request);

    /**
     * 给menu值设置菜单
     * @param request
     * @return
     */
    RoleAddMenuResponse setRoleMenu(RoleAddMenuRequest request);
}
