package com.maiziyun.boss.dal.mapper;

import com.maiziyun.boss.dal.dataobject.OperatorRoleDO;
import java.lang.Integer;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table BOSS_OPERATOR_ROLE.
 * BOSS_OPERATOR_ROLE
 */
public interface OperatorRoleDOMapper{

    /**
     * desc:插入表:BOSS_OPERATOR_ROLE.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO BOSS_OPERATOR_ROLE( ROLE_ID ,CREATE_TIME ,OPERATOR_ID ,UPDATE_TIME )VALUES( #{roleId,jdbcType=INTEGER} , sysdate() , #{operatorId,jdbcType=INTEGER} , sysdate() )
     * @param entity entity
     * @return Long
     */
    Long insert(OperatorRoleDO entity);
    /**
     * desc:更新表:BOSS_OPERATOR_ROLE.<br/>
     * descSql =  UPDATE BOSS_OPERATOR_ROLE SET ROLE_ID = #{roleId,jdbcType=INTEGER} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,OPERATOR_ID = #{operatorId,jdbcType=INTEGER} ,UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    Long update(OperatorRoleDO entity);
    /**
     * desc:根据主键删除数据:BOSS_OPERATOR_ROLE.<br/>
     * descSql =  DELETE FROM BOSS_OPERATOR_ROLE WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return Long
     */
    Long deleteByPrimary(Integer id);
    /**
     * desc:根据操作员Id删除对应的关联信息：BOSS_OPERATOR_ROLE.<br/>
     * descSql =  DELETE FROM BOSS_OPERATOR_ROLE WHERE operator_id = #{id,jdbcType=INTEGER}
     * @param id id
     * @return Long
     */
    Long deleteByOperatorId(Integer id);
    /**
     * desc:根据主键获取数据:BOSS_OPERATOR_ROLE.<br/>
     * descSql =  SELECT * FROM BOSS_OPERATOR_ROLE WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return OperatorRoleDO
     */
    OperatorRoleDO getByPrimary(Integer id);
    /**
     * desc:修改操作员的角色:BOSS_OPERATOR_ROLE.<br/>
     * descSql =  update BOSS_OPERATOR_ROLE set update_time=sysdate(), role_id=#{roleId,jdbcType=INTEGER} where operator_id=#{operatorId,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    Long updateRoleByOperatorId(OperatorRoleDO entity);
    /**
     * desc:根据操作员id获取角色列表：BOSS_OPERATOR_ROLE.<br/>
     * descSql =  select role_id as roleId from BOSS_OPERATOR_ROLE where operator_id=#{operatorId,jdbcType=INTEGER}
     * @param operatorId operatorId
     * @return List<Integer>
     */
    List<Integer> selectRolesByOperId(Integer operatorId);
}
