package com.maiziyun.boss.dal.mapper;

import com.maiziyun.boss.dal.dataobject.OperatorDO;
import com.maiziyun.boss.dal.paging.OperatorPageQueryPage;
import java.util.List;
import java.lang.Integer;
import com.maiziyun.boss.dal.resultmap.MenuListDO;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table BOSS_OPERATOR.
 * BOSS_OPERATOR
 */
public interface OperatorDOMapper{

    /**
     * desc:插入表:BOSS_OPERATOR.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO BOSS_OPERATOR( STATUS ,PASSWORD ,USER_NAME ,REAL_NAME ,CREATE_TIME ,EMPLOYEE_ID ,UPDATE_TIME ,isvalid )VALUES( #{status,jdbcType=INTEGER} , #{password,jdbcType=VARCHAR} , #{userName,jdbcType=VARCHAR} , #{realName,jdbcType=VARCHAR} ,sysdate() , #{employeeId,jdbcType=INTEGER} ,sysdate() ,'1' )
     * @param entity entity
     * @return Long
     */
    Long insert(OperatorDO entity);
    /**
     * desc:更新表:BOSS_OPERATOR.<br/>
     * descSql =  UPDATE BOSS_OPERATOR SET ROLE_ID = #{roleId,jdbcType=INTEGER} ,STATUS = #{status,jdbcType=INTEGER} ,PASSWORD = #{password,jdbcType=VARCHAR} ,USER_NAME = #{userName,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,EMPLOYEE_ID = #{employeeId,jdbcType=INTEGER} ,UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ,LAST_LOGIN_IP = #{lastLoginIp,jdbcType=VARCHAR} ,LAST_LOGIN_TIME = #{lastLoginTime,jdbcType=TIMESTAMP} ,FIRST_LOGIN_TIME = #{firstLoginTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    Long update(OperatorDO entity);
    /**
     * desc:根据主键删除数据:BOSS_OPERATOR.<br/>
     * descSql =  DELETE FROM BOSS_OPERATOR WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return Long
     */
    Long deleteByPrimary(Integer id);
    /**
     * desc:根据主键获取数据:BOSS_OPERATOR.<br/>
     * descSql =  SELECT * FROM BOSS_OPERATOR WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return OperatorDO
     */
    OperatorDO getByPrimary(Integer id);
    /**
     * desc:根据用户名获取用户:BOSS_OPERATOR.<br/>
     * descSql =  SELECT * FROM BOSS_OPERATOR WHERE user_name = #{userName,jdbcType=VARCHAR} and isvalid='1'
     * @param userName userName
     * @return OperatorDO
     */
    OperatorDO getByUserName(String userName);
    /**
     * desc:查询出有效分页角色:BOSS_OPERATOR.<br/>
     * descSql =  SELECT * FROM BOSS_OPERATOR WHERE isvalid='1' and user_name = #{nameQuery,jdbcType=VARCHAR} and status = #{statusQuery,jdbcType=VARCHAR} and realName=#{realName,jdbcType=VARCHAR} and id in( select operator_id from boss_operator_role where role_id=#{roleId,jdbcType=INTEGER} ) and user_name != #{loginUserName,jdbcType=VARCHAR} order by update_time desc
     * @param operatorPageQuery operatorPageQuery
     * @return int
     */
    int getPageOperatorsCount(OperatorPageQueryPage operatorPageQuery);
    /**
     * desc:查询出有效分页角色:BOSS_OPERATOR.<br/>
     * descSql =  SELECT * FROM BOSS_OPERATOR WHERE isvalid='1' and user_name = #{nameQuery,jdbcType=VARCHAR} and status = #{statusQuery,jdbcType=VARCHAR} and realName=#{realName,jdbcType=VARCHAR} and id in( select operator_id from boss_operator_role where role_id=#{roleId,jdbcType=INTEGER} ) and user_name != #{loginUserName,jdbcType=VARCHAR} order by update_time desc
     * @param operatorPageQuery operatorPageQuery
     * @return List<OperatorDO>
     */
    List<OperatorDO> getPageOperatorsResult(OperatorPageQueryPage operatorPageQuery);
    /**
     * desc:更新表:BOSS_OPERATOR.<br/>
     * descSql =  UPDATE BOSS_OPERATOR SET isvalid='0', update_time = sysdate() where id in #{Id,jdbcType=INTEGER} 
     * @param list list
     * @return Long
     */
    Long deleteByIds(List<Integer> list);
    /**
     * desc:更新表:BOSS_OPERATOR.<br/>
     * descSql =  UPDATE BOSS_OPERATOR SET update_time = sysdate() ,user_name=#{userName,jdbcType=VARCHAR} ,password=#{password,jdbcType=VARCHAR} ,status=#{status,jdbcType=VARCHAR} ,real_name=#{realName,jdbcType=VARCHAR} where id = #{id,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    Long updateById(OperatorDO entity);
    /**
     * desc:查询某名称下有效用户是否存在:BOSS_OPERATOR.<br/>
     * descSql =  select id from BOSS_OPERATOR where isvalid='1' and user_name=#{userName,jdbcType=VARCHAR} and id !=#{id,jdbcType=INTEGER} 
     * @param userName userName
     * @param id id
     * @return Integer
     */
    Integer selectByUserNameValid(@Param("userName")String userName,@Param("id")Integer id);
    /**
     * desc:查询用户是否存在:BOSS_OPERATOR.<br/>
     * descSql =  SELECT * FROM BOSS_OPERATOR WHERE user_name = #{userName,jdbcType=VARCHAR} and password = #{password,jdbcType=VARCHAR} and isvalid='1'
     * @param password password
     * @param userName userName
     * @return OperatorDO
     */
    OperatorDO getByUserNamePass(@Param("password")String password,@Param("userName")String userName);
    /**
     * desc:查询菜单.<br/>
     * descSql =  select DISTINCT op.level,me.id,me.name,me.url,me.reload,me.module_code,me.parent_code from boss_operator op inner join boss_operator_role opro on op.employee_id = opro.operator_id INNER JOIN boss_role ro on opro.role_id=ro.id INNER JOIN boss_role_menu rome on opro.role_id=rome.role_id INNER join boss_menu me on rome.menu_id = me.id where op.user_name = #{userName,jdbcType=VARCHAR} and op.isvalid='1' and ro.isvalid='1'
     * @param userName userName
     * @return List<MenuListDO>
     */
    List<MenuListDO> getMenuList(String userName);
}
