package com.maiziyun.boss.dal.mapper;

import com.maiziyun.boss.dal.dataobject.RoleDO;
import java.util.List;
import com.maiziyun.boss.dal.paging.RolePageQueryPage;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table BOSS_ROLE.
 * BOSS_ROLE
 */
public interface RoleDOMapper{

    /**
     * desc:插入表:BOSS_ROLE.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO BOSS_ROLE( describe_context ,ROLE_NAME ,ROLE_CODE ,CREATE_TIME ,UPDATE_TIME ,isvalid )VALUES( #{describeContext,jdbcType=VARCHAR} , #{roleName,jdbcType=VARCHAR} , #{roleCode,jdbcType=VARCHAR} ,sysdate() ,sysdate() ,'1' )
     * @param entity entity
     * @return Long
     */
    Long insert(RoleDO entity);
    /**
     * desc:更新表:BOSS_ROLE.<br/>
     * descSql =  UPDATE BOSS_ROLE SET DESC = #{desc,jdbcType=VARCHAR} ,ROLE_NAME = #{roleName,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    Long update(RoleDO entity);
    /**
     * desc:根据主键删除数据:BOSS_ROLE.<br/>
     * descSql =  DELETE FROM BOSS_ROLE WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return Long
     */
    Long deleteByPrimary(Integer id);
    /**
     * desc:根据主键获取数据:BOSS_ROLE.<br/>
     * descSql =  SELECT * FROM BOSS_ROLE WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return RoleDO
     */
    RoleDO getByPrimary(Integer id);
    /**
     * desc:根据用户名获取对应的权限信息:BOSS_ROLE.<br/>
     * descSql =  SELECT BR.id,BR.role_name,BR.role_code,BR.describe_context,BR.create_time,BR.update_time FROM boss_operator_role BOR , boss_role BR, boss_operator bo WHERE BOR.ROLE_ID=br.id and bo.id = bor.operator_id and bo.user_name= #{userName,jdbcType=VARCHAR}
     * @param userName userName
     * @return List<RoleDO>
     */
    List<RoleDO> getRolesByOperatorName(String userName);
    /**
     * desc:查询出有效分页角色:BOSS_ROLE.<br/>
     * descSql =  SELECT * FROM BOSS_ROLE WHERE isvalid='1' and role_name = #{nameQuery,jdbcType=VARCHAR} and role_code = #{codeQuery,jdbcType=VARCHAR} order by update_time desc
     * @param rolePageQuery rolePageQuery
     * @return int
     */
    int getPageRolesCount(RolePageQueryPage rolePageQuery);
    /**
     * desc:查询出有效分页角色:BOSS_ROLE.<br/>
     * descSql =  SELECT * FROM BOSS_ROLE WHERE isvalid='1' and role_name = #{nameQuery,jdbcType=VARCHAR} and role_code = #{codeQuery,jdbcType=VARCHAR} order by update_time desc
     * @param rolePageQuery rolePageQuery
     * @return List<RoleDO>
     */
    List<RoleDO> getPageRolesResult(RolePageQueryPage rolePageQuery);
    /**
     * desc:查询出所有角色列表:BOSS_ROLE.<br/>
     * descSql =  SELECT * FROM BOSS_ROLE WHERE isvalid='1' order by update_time desc
     * @return List<RoleDO>
     */
    List<RoleDO> getListRoles();
    /**
     * desc:更新表:BOSS_ROLE.<br/>
     * descSql =  UPDATE BOSS_ROLE SET ROLE_NAME = #{roleName,jdbcType=VARCHAR}, ROLE_CODE = #{roleCode,jdbcType=VARCHAR}, DESCRIBE_CONTEXT = #{describeContext,jdbcType=VARCHAR}, UPDATE_TIME = sysdate() WHERE ID= #{id,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    Long updateSelective(RoleDO entity);
    /**
     * desc:更新表:BOSS_ROLE.<br/>
     * descSql =  UPDATE BOSS_ROLE SET isvalid = '0', UPDATE_TIME = sysdate() WHERE ID in #{Id,jdbcType=INTEGER} 
     * @param list list
     * @return Long
     */
    Long deleteRole(List<Integer> list);
}
