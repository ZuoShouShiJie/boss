package com.maiziyun.boss.dal.mapper;

import com.maiziyun.boss.dal.dataobject.MenuDO;
import java.util.List;
import com.maiziyun.boss.dal.paging.MenuPageQueryPage;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table BOSS_MENU.
 * BOSS_MENU
 */
public interface MenuDOMapper{

    /**
     * desc:插入表:BOSS_MENU.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO BOSS_MENU( ID ,NAME ,SORT ,LEVEL ,CREATE_TIME ,MODULE_CODE ,PARENT_CODE ,UPDATE_TIME ,DESCRIPTION )VALUES( #{id,jdbcType=INTEGER} , #{name,jdbcType=VARCHAR} , #{sort,jdbcType=INTEGER} , #{level,jdbcType=INTEGER} , #{createTime,jdbcType=TIMESTAMP} , #{moduleCode,jdbcType=VARCHAR} , #{parentCode,jdbcType=VARCHAR} , #{updateTime,jdbcType=TIMESTAMP} , #{description,jdbcType=VARCHAR} )
     * @param entity entity
     * @return Long
     */
    Long insert(MenuDO entity);
    /**
     * desc:更新表:BOSS_MENU.<br/>
     * descSql =  UPDATE BOSS_MENU SET NAME = #{name,jdbcType=VARCHAR} ,SORT = #{sort,jdbcType=INTEGER} ,LEVEL = #{level,jdbcType=INTEGER} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,MODULE_CODE = #{moduleCode,jdbcType=VARCHAR} ,PARENT_CODE = #{parentCode,jdbcType=VARCHAR} ,UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ,DESCRIPTION = #{description,jdbcType=VARCHAR} WHERE ID = #{id,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    Long update(MenuDO entity);
    /**
     * desc:根据主键删除数据:BOSS_MENU.<br/>
     * descSql =  DELETE FROM BOSS_MENU WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return Long
     */
    Long deleteByPrimary(Integer id);
    /**
     * desc:根据主键获取数据:BOSS_MENU.<br/>
     * descSql =  SELECT * FROM BOSS_MENU WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return MenuDO
     */
    MenuDO getByPrimary(Integer id);
    /**
     * desc:根据角色号获取数据：BOSS_MENU.<br/>
     * descSql =  select * from boss_menu bm where exists( select '' from boss_role_menu brm where bm.id = brm.menu_id and brm.role_id in #{roleId,jdbcType=INTEGER} ) and bm.isvalid='1'
     * @param list list
     * @return List<MenuDO>
     */
    List<MenuDO> getMenuByRoleId(List<Integer> list);
    /**
     * desc:获取菜单分页数据：BOSS_MENU.<br/>
     * descSql =  SELECT * FROM BOSS_MENU WHERE isvalid='1' order by level, sort
     * @param menuPageQuery menuPageQuery
     * @return int
     */
    int getMenuParamsPageCount(MenuPageQueryPage menuPageQuery);
    /**
     * desc:获取菜单分页数据：BOSS_MENU.<br/>
     * descSql =  SELECT * FROM BOSS_MENU WHERE isvalid='1' order by level, sort
     * @param menuPageQuery menuPageQuery
     * @return List<MenuDO>
     */
    List<MenuDO> getMenuParamsPageResult(MenuPageQueryPage menuPageQuery);
    /**
     * desc:获取所有有效菜单列表：BOSS_MENU.<br/>
     * descSql =  SELECT * FROM BOSS_MENU WHERE isvalid='1' order by level, sort
     * @return List<MenuDO>
     */
    List<MenuDO> getMenusList();
}
