package com.maiziyun.boss.facade.system.service;

import com.maiziyun.boss.facade.system.model.menu.*;

/**
 * Created by len.song on 2016/11/21.
 */
public interface MenuService {
    /**
     * 获取用户的菜单
     * @return
     */
   MenuGPSResponse getMenusByUser(MenuGPSRequest request);

    MenusPageResponse getPagesMenu(MenusPageRequest request);

    /**
     * 添加
     * @param request
     * @return
     */
    MenuAddResponse addMenu(MenuAddRequest request);

    /**
     * 修改
     * @param request
     * @return
     */
    MenuModifyResponse editMenu(MenuModifyRequest request);

    /**
     * 删除
     * @param request
     * @return
     */
    MenuDeleteResponse deleteMenu(MenuDeleteRequest request);

    /**
     * 获取角色下的所有菜单
     * @param request
     * @return
     */
    MenuQueryResponse getMenusByRoleId(MenuQueryRequest request);

    /**
     * 查找所有的有效菜单列表
     * @param request
     * @return
     */
    MenuGPSResponse getMenusList(MenuGPSRequest request);
}
