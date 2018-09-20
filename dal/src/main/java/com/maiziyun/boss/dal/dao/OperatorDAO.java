package com.maiziyun.boss.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.maiziyun.boss.dal.dataobject.OperatorDO;
import com.maiziyun.boss.dal.paging.OperatorPageQueryPage;
import java.util.List;
import java.lang.Integer;
import com.maiziyun.boss.dal.resultmap.MenuListDO;
import com.maiziyun.boss.dal.mapper.OperatorDOMapper;

/**
* The Table BOSS_OPERATOR.
* BOSS_OPERATOR
*/
@Repository
public class OperatorDAO{

    @Autowired
    private OperatorDOMapper operatorDOMapper;

    /**
     * desc:插入表:BOSS_OPERATOR.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO BOSS_OPERATOR( STATUS ,PASSWORD ,USER_NAME ,REAL_NAME ,CREATE_TIME ,EMPLOYEE_ID ,UPDATE_TIME ,isvalid )VALUES( #{status,jdbcType=INTEGER} , #{password,jdbcType=VARCHAR} , #{userName,jdbcType=VARCHAR} , #{realName,jdbcType=VARCHAR} ,sysdate() , #{employeeId,jdbcType=INTEGER} ,sysdate() ,'1' )
     * @param entity entity
     * @return Long
     */
    public Long insert(OperatorDO entity){
        return operatorDOMapper.insert(entity);
    }
    /**
     * desc:更新表:BOSS_OPERATOR.<br/>
     * descSql =  UPDATE BOSS_OPERATOR SET ROLE_ID = #{roleId,jdbcType=INTEGER} ,STATUS = #{status,jdbcType=INTEGER} ,PASSWORD = #{password,jdbcType=VARCHAR} ,USER_NAME = #{userName,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,EMPLOYEE_ID = #{employeeId,jdbcType=INTEGER} ,UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ,LAST_LOGIN_IP = #{lastLoginIp,jdbcType=VARCHAR} ,LAST_LOGIN_TIME = #{lastLoginTime,jdbcType=TIMESTAMP} ,FIRST_LOGIN_TIME = #{firstLoginTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    public Long update(OperatorDO entity){
        return operatorDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:BOSS_OPERATOR.<br/>
     * descSql =  DELETE FROM BOSS_OPERATOR WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return Long
     */
    public Long deleteByPrimary(Integer id){
        return operatorDOMapper.deleteByPrimary(id);
    }
    /**
     * desc:根据主键获取数据:BOSS_OPERATOR.<br/>
     * descSql =  SELECT * FROM BOSS_OPERATOR WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return OperatorDO
     */
    public OperatorDO getByPrimary(Integer id){
        return operatorDOMapper.getByPrimary(id);
    }
    /**
     * desc:根据用户名获取用户:BOSS_OPERATOR.<br/>
     * descSql =  SELECT * FROM BOSS_OPERATOR WHERE user_name = #{userName,jdbcType=VARCHAR} and isvalid='1'
     * @param userName userName
     * @return OperatorDO
     */
    public OperatorDO getByUserName(String userName){
        return operatorDOMapper.getByUserName(userName);
    }
    /**
     * desc:查询出有效分页角色:BOSS_OPERATOR.<br/>
     * descSql =  SELECT * FROM BOSS_OPERATOR WHERE isvalid='1' and user_name = #{nameQuery,jdbcType=VARCHAR} and status = #{statusQuery,jdbcType=VARCHAR} and realName=#{realName,jdbcType=VARCHAR} and id in( select operator_id from boss_operator_role where role_id=#{roleId,jdbcType=INTEGER} ) and user_name != #{loginUserName,jdbcType=VARCHAR} order by update_time desc
     * @param operatorPageQuery operatorPageQuery
     * @return OperatorPageQueryPage
     */
    public OperatorPageQueryPage getPageOperators(OperatorPageQueryPage operatorPageQuery){
        int total = operatorDOMapper.getPageOperatorsCount(operatorPageQuery);
        if(total>0){
            operatorPageQuery.setDatas(operatorDOMapper.getPageOperatorsResult(operatorPageQuery));
        }
        operatorPageQuery.setTotal(total);
        return operatorPageQuery;
    }
    /**
     * desc:更新表:BOSS_OPERATOR.<br/>
     * descSql =  UPDATE BOSS_OPERATOR SET isvalid='0', update_time = sysdate() where id in #{Id,jdbcType=INTEGER} 
     * @param list list
     * @return Long
     */
    public Long deleteByIds(List<Integer> list){
        return operatorDOMapper.deleteByIds(list);
    }
    /**
     * desc:更新表:BOSS_OPERATOR.<br/>
     * descSql =  UPDATE BOSS_OPERATOR SET update_time = sysdate() ,user_name=#{userName,jdbcType=VARCHAR} ,password=#{password,jdbcType=VARCHAR} ,status=#{status,jdbcType=VARCHAR} ,real_name=#{realName,jdbcType=VARCHAR} where id = #{id,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    public Long updateById(OperatorDO entity){
        return operatorDOMapper.updateById(entity);
    }
    /**
     * desc:查询某名称下有效用户是否存在:BOSS_OPERATOR.<br/>
     * descSql =  select id from BOSS_OPERATOR where isvalid='1' and user_name=#{userName,jdbcType=VARCHAR} and id !=#{id,jdbcType=INTEGER} 
     * @param userName userName
     * @param id id
     * @return Integer
     */
    public Integer selectByUserNameValid(String userName,Integer id){
        return operatorDOMapper.selectByUserNameValid(userName, id);
    }
    /**
     * desc:查询用户是否存在:BOSS_OPERATOR.<br/>
     * descSql =  SELECT * FROM BOSS_OPERATOR WHERE user_name = #{userName,jdbcType=VARCHAR} and password = #{password,jdbcType=VARCHAR} and isvalid='1'
     * @param password password
     * @param userName userName
     * @return OperatorDO
     */
    public OperatorDO getByUserNamePass(String password,String userName){
        return operatorDOMapper.getByUserNamePass(password, userName);
    }
    /**
     * desc:查询菜单.<br/>
     * descSql =  select DISTINCT op.level,me.id,me.name,me.url,me.reload,me.module_code,me.parent_code from boss_operator op inner join boss_operator_role opro on op.employee_id = opro.operator_id INNER JOIN boss_role ro on opro.role_id=ro.id INNER JOIN boss_role_menu rome on opro.role_id=rome.role_id INNER join boss_menu me on rome.menu_id = me.id where op.user_name = #{userName,jdbcType=VARCHAR} and op.isvalid='1' and ro.isvalid='1'
     * @param userName userName
     * @return List<MenuListDO>
     */
    public List<MenuListDO> getMenuList(String userName){
        return operatorDOMapper.getMenuList(userName);
    }
}
