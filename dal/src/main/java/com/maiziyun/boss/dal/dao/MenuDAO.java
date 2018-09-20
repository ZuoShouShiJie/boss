package com.maiziyun.boss.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.maiziyun.boss.dal.dataobject.MenuDO;
import java.util.List;
import com.maiziyun.boss.dal.paging.MenuPageQueryPage;
import com.maiziyun.boss.dal.mapper.MenuDOMapper;

/**
* The Table BOSS_MENU.
* BOSS_MENU
*/
@Repository
public class MenuDAO{

    @Autowired
    private MenuDOMapper menuDOMapper;

    /**
     * desc:插入表:BOSS_MENU.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO BOSS_MENU( ID ,NAME ,SORT ,LEVEL ,CREATE_TIME ,MODULE_CODE ,PARENT_CODE ,UPDATE_TIME ,DESCRIPTION )VALUES( #{id,jdbcType=INTEGER} , #{name,jdbcType=VARCHAR} , #{sort,jdbcType=INTEGER} , #{level,jdbcType=INTEGER} , #{createTime,jdbcType=TIMESTAMP} , #{moduleCode,jdbcType=VARCHAR} , #{parentCode,jdbcType=VARCHAR} , #{updateTime,jdbcType=TIMESTAMP} , #{description,jdbcType=VARCHAR} )
     * @param entity entity
     * @return Long
     */
    public Long insert(MenuDO entity){
        return menuDOMapper.insert(entity);
    }
    /**
     * desc:更新表:BOSS_MENU.<br/>
     * descSql =  UPDATE BOSS_MENU SET NAME = #{name,jdbcType=VARCHAR} ,SORT = #{sort,jdbcType=INTEGER} ,LEVEL = #{level,jdbcType=INTEGER} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,MODULE_CODE = #{moduleCode,jdbcType=VARCHAR} ,PARENT_CODE = #{parentCode,jdbcType=VARCHAR} ,UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ,DESCRIPTION = #{description,jdbcType=VARCHAR} WHERE ID = #{id,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    public Long update(MenuDO entity){
        return menuDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:BOSS_MENU.<br/>
     * descSql =  DELETE FROM BOSS_MENU WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return Long
     */
    public Long deleteByPrimary(Integer id){
        return menuDOMapper.deleteByPrimary(id);
    }
    /**
     * desc:根据主键获取数据:BOSS_MENU.<br/>
     * descSql =  SELECT * FROM BOSS_MENU WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return MenuDO
     */
    public MenuDO getByPrimary(Integer id){
        return menuDOMapper.getByPrimary(id);
    }
    /**
     * desc:根据角色号获取数据：BOSS_MENU.<br/>
     * descSql =  select * from boss_menu bm where exists( select '' from boss_role_menu brm where bm.id = brm.menu_id and brm.role_id in #{roleId,jdbcType=INTEGER} ) and bm.isvalid='1'
     * @param list list
     * @return List<MenuDO>
     */
    public List<MenuDO> getMenuByRoleId(List<Integer> list){
        return menuDOMapper.getMenuByRoleId(list);
    }
    /**
     * desc:获取菜单分页数据：BOSS_MENU.<br/>
     * descSql =  SELECT * FROM BOSS_MENU WHERE isvalid='1' order by level, sort
     * @param menuPageQuery menuPageQuery
     * @return MenuPageQueryPage
     */
    public MenuPageQueryPage getMenuParamsPage(MenuPageQueryPage menuPageQuery){
        int total = menuDOMapper.getMenuParamsPageCount(menuPageQuery);
        if(total>0){
            menuPageQuery.setDatas(menuDOMapper.getMenuParamsPageResult(menuPageQuery));
        }
        menuPageQuery.setTotal(total);
        return menuPageQuery;
    }
    /**
     * desc:获取所有有效菜单列表：BOSS_MENU.<br/>
     * descSql =  SELECT * FROM BOSS_MENU WHERE isvalid='1' order by level, sort
     * @return List<MenuDO>
     */
    public List<MenuDO> getMenusList(){
        return menuDOMapper.getMenusList();
    }
}
