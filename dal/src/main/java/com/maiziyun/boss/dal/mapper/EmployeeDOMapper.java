package com.maiziyun.boss.dal.mapper;

import com.maiziyun.boss.dal.dataobject.EmployeeDO;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table BOSS_EMPLOYEE.
 * BOSS_EMPLOYEE
 */
public interface EmployeeDOMapper{

    /**
     * desc:插入表:BOSS_EMPLOYEE.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO BOSS_EMPLOYEE( ID ,AGE ,SEX ,STATUS ,ADDRESS ,NICK_NAME ,USER_NAME ,CREATE_TIME ,UPDATE_TIME ,ENGLISH_NAME )VALUES( #{id,jdbcType=INTEGER} , #{age,jdbcType=INTEGER} , #{sex,jdbcType=VARCHAR} , #{status,jdbcType=INTEGER} , #{address,jdbcType=VARCHAR} , #{nickName,jdbcType=VARCHAR} , #{userName,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{updateTime,jdbcType=TIMESTAMP} , #{englishName,jdbcType=VARCHAR} )
     * @param entity entity
     * @return Long
     */
    Long insert(EmployeeDO entity);
    /**
     * desc:更新表:BOSS_EMPLOYEE.<br/>
     * descSql =  UPDATE BOSS_EMPLOYEE SET AGE = #{age,jdbcType=INTEGER} ,SEX = #{sex,jdbcType=VARCHAR} ,STATUS = #{status,jdbcType=INTEGER} ,ADDRESS = #{address,jdbcType=VARCHAR} ,NICK_NAME = #{nickName,jdbcType=VARCHAR} ,USER_NAME = #{userName,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ,ENGLISH_NAME = #{englishName,jdbcType=VARCHAR} WHERE ID = #{id,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    Long update(EmployeeDO entity);
    /**
     * desc:根据主键删除数据:BOSS_EMPLOYEE.<br/>
     * descSql =  DELETE FROM BOSS_EMPLOYEE WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return Long
     */
    Long deleteByPrimary(Integer id);
    /**
     * desc:根据主键获取数据:BOSS_EMPLOYEE.<br/>
     * descSql =  SELECT * FROM BOSS_EMPLOYEE WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return EmployeeDO
     */
    EmployeeDO getByPrimary(Integer id);
}
