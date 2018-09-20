package com.maiziyun.boss.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.maiziyun.boss.dal.dataobject.EmployeeDO;
import com.maiziyun.boss.dal.mapper.EmployeeDOMapper;

/**
* The Table BOSS_EMPLOYEE.
* BOSS_EMPLOYEE
*/
@Repository
public class EmployeeDAO{

    @Autowired
    private EmployeeDOMapper employeeDOMapper;

    /**
     * desc:插入表:BOSS_EMPLOYEE.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO BOSS_EMPLOYEE( ID ,AGE ,SEX ,STATUS ,ADDRESS ,NICK_NAME ,USER_NAME ,CREATE_TIME ,UPDATE_TIME ,ENGLISH_NAME )VALUES( #{id,jdbcType=INTEGER} , #{age,jdbcType=INTEGER} , #{sex,jdbcType=VARCHAR} , #{status,jdbcType=INTEGER} , #{address,jdbcType=VARCHAR} , #{nickName,jdbcType=VARCHAR} , #{userName,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{updateTime,jdbcType=TIMESTAMP} , #{englishName,jdbcType=VARCHAR} )
     * @param entity entity
     * @return Long
     */
    public Long insert(EmployeeDO entity){
        return employeeDOMapper.insert(entity);
    }
    /**
     * desc:更新表:BOSS_EMPLOYEE.<br/>
     * descSql =  UPDATE BOSS_EMPLOYEE SET AGE = #{age,jdbcType=INTEGER} ,SEX = #{sex,jdbcType=VARCHAR} ,STATUS = #{status,jdbcType=INTEGER} ,ADDRESS = #{address,jdbcType=VARCHAR} ,NICK_NAME = #{nickName,jdbcType=VARCHAR} ,USER_NAME = #{userName,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ,ENGLISH_NAME = #{englishName,jdbcType=VARCHAR} WHERE ID = #{id,jdbcType=INTEGER}
     * @param entity entity
     * @return Long
     */
    public Long update(EmployeeDO entity){
        return employeeDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:BOSS_EMPLOYEE.<br/>
     * descSql =  DELETE FROM BOSS_EMPLOYEE WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return Long
     */
    public Long deleteByPrimary(Integer id){
        return employeeDOMapper.deleteByPrimary(id);
    }
    /**
     * desc:根据主键获取数据:BOSS_EMPLOYEE.<br/>
     * descSql =  SELECT * FROM BOSS_EMPLOYEE WHERE ID = #{id,jdbcType=INTEGER}
     * @param id id
     * @return EmployeeDO
     */
    public EmployeeDO getByPrimary(Integer id){
        return employeeDOMapper.getByPrimary(id);
    }
}
