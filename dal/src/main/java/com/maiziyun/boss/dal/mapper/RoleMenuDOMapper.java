package com.maiziyun.boss.dal.mapper;

import com.maiziyun.boss.dal.dataobject.RoleMenuDO;
import java.util.List;
import java.lang.Integer;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table BOSS_ROLE_MENU.
 * BOSS_ROLE_MENU
 */
public interface RoleMenuDOMapper{

    /**
     * desc:插入表:BOSS_ROLE_MENU.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO BOSS_ROLE_MENU( MENU_ID ,ROLE_ID ,CREATE_TIME ,UPDATE_TIME )VALUES( #{menuId,jdbcType=INTEGER} , #{roleId,jdbcType=INTEGER} , sysdate() , sysdate() )
     * @param entity entity
     * @return Long
     */
    Long insert(RoleMenuDO entity);
    /**
     * desc:更新表:BOSS_ROLE_MENU.<br/>
     * descSql =  UPDATE BOSS_ROLE_MENU SET MENU_ID = #{menuId,jdbcType=INTEGER} ,ROLE_ID = #{roleId,jdbcType=INTEGER} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    Long update(RoleMenuDO entity);
    /**
     * desc:根据主键删除数据:BOSS_ROLE_MENU.<br/>
     * descSql =  DELETE FROM BOSS_ROLE_MENU WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return Long
     */
    Long deleteByPrimary(Integer id);
    /**
     * desc:根据主键删除数据:BOSS_ROLE_MENU.<br/>
     * descSql =  DELETE FROM BOSS_ROLE_MENU WHERE 1=1 and MENU_ID in #{menuId} and ROLE_ID = #{roleId,jdbcType=INTEGER}
     * @param roleId roleId
     * @param list list
     * @return Long
     */
    Long deleteByMenuAndRole(@Param("roleId")Integer roleId,@Param("list")List<Integer> list);
    /**
     * desc:根据主键获取数据:BOSS_ROLE_MENU.<br/>
     * descSql =  SELECT * FROM BOSS_ROLE_MENU WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return RoleMenuDO
     */
    RoleMenuDO getByPrimary(Integer id);
    /**
     * desc:根据角色id获取基础的菜单列表:BOSS_ROLE_MENU.<br/>
     * descSql =  SELECT n.menu_id as menuId FROM BOSS_ROLE_MENU n WHERE exists(select '' from BOSS_MENU m where m.id=n.menu_id and m.isvalid='1' and m.url is not null) and role_id=#{roleId,jdbcType=INTEGER}
     * @param roleId roleId
     * @return List<Integer>
     */
    List<Integer> getBaseMenusByRoleId(Integer roleId);
    /**
     * desc:根据角色id获取所有菜单列表数据:BOSS_ROLE_MENU.<br/>
     * descSql =  SELECT n.menu_id as menuId FROM BOSS_ROLE_MENU n WHERE exists(select '' from BOSS_MENU m where m.id=n.menu_id and m.isvalid='1') and role_id=#{roleId,jdbcType=INTEGER}
     * @param roleId roleId
     * @return List<Integer>
     */
    List<Integer> getMenusByRoleId(Integer roleId);
}
