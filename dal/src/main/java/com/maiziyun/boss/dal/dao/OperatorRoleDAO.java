package com.maiziyun.boss.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.maiziyun.boss.dal.dataobject.OperatorRoleDO;
import java.lang.Integer;
import java.util.List;
import com.maiziyun.boss.dal.mapper.OperatorRoleDOMapper;

/**
* The Table BOSS_OPERATOR_ROLE.
* BOSS_OPERATOR_ROLE
*/
@Repository
public class OperatorRoleDAO{

    @Autowired
    private OperatorRoleDOMapper operatorRoleDOMapper;

    /**
     * desc:插入表:BOSS_OPERATOR_ROLE.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO BOSS_OPERATOR_ROLE( ROLE_ID ,CREATE_TIME ,OPERATOR_ID ,UPDATE_TIME )VALUES( #{roleId,jdbcType=INTEGER} , sysdate() , #{operatorId,jdbcType=INTEGER} , sysdate() )
     * @param entity entity
     * @return Long
     */
    public Long insert(OperatorRoleDO entity){
        return operatorRoleDOMapper.insert(entity);
    }
    /**
     * desc:更新表:BOSS_OPERATOR_ROLE.<br/>
     * descSql =  UPDATE BOSS_OPERATOR_ROLE SET ROLE_ID = #{roleId,jdbcType=INTEGER} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,OPERATOR_ID = #{operatorId,jdbcType=INTEGER} ,UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    public Long update(OperatorRoleDO entity){
        return operatorRoleDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:BOSS_OPERATOR_ROLE.<br/>
     * descSql =  DELETE FROM BOSS_OPERATOR_ROLE WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return Long
     */
    public Long deleteByPrimary(Integer id){
        return operatorRoleDOMapper.deleteByPrimary(id);
    }
    /**
     * desc:根据操作员Id删除对应的关联信息：BOSS_OPERATOR_ROLE.<br/>
     * descSql =  DELETE FROM BOSS_OPERATOR_ROLE WHERE operator_id = #{id,jdbcType=INTEGER}
     * @param id id
     * @return Long
     */
    public Long deleteByOperatorId(Integer id){
        return operatorRoleDOMapper.deleteByOperatorId(id);
    }
    /**
     * desc:根据主键获取数据:BOSS_OPERATOR_ROLE.<br/>
     * descSql =  SELECT * FROM BOSS_OPERATOR_ROLE WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return OperatorRoleDO
     */
    public OperatorRoleDO getByPrimary(Integer id){
        return operatorRoleDOMapper.getByPrimary(id);
    }
    /**
     * desc:修改操作员的角色:BOSS_OPERATOR_ROLE.<br/>
     * descSql =  update BOSS_OPERATOR_ROLE set update_time=sysdate(), role_id=#{roleId,jdbcType=INTEGER} where operator_id=#{operatorId,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    public Long updateRoleByOperatorId(OperatorRoleDO entity){
        return operatorRoleDOMapper.updateRoleByOperatorId(entity);
    }
    /**
     * desc:根据操作员id获取角色列表：BOSS_OPERATOR_ROLE.<br/>
     * descSql =  select role_id as roleId from BOSS_OPERATOR_ROLE where operator_id=#{operatorId,jdbcType=INTEGER}
     * @param operatorId operatorId
     * @return List<Integer>
     */
    public List<Integer> selectRolesByOperId(Integer operatorId){
        return operatorRoleDOMapper.selectRolesByOperId(operatorId);
    }
}
