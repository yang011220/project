package com.oa.project.dao.team;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;

import com.oa.project.entity.team.Sign;
@MapperScan
public interface SignMapper {
    @Delete({
        "delete from sign",
        "where sign_id = #{signId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer signId);

    @Insert({
        "insert into sign (sign_id, emp_id, ",
        "sign_place, sign_time, ",
        "sign_state)",
        "values (#{signId,jdbcType=INTEGER}, #{empId,jdbcType=INTEGER}, ",
        "#{signPlace,jdbcType=VARCHAR}, #{signTime,jdbcType=TIMESTAMP}, ",
        "#{signState,jdbcType=INTEGER})"
    })
    int insert(Sign record);

    @InsertProvider(type=SignSqlProvider.class, method="insertSelective")
    int insertSelective(Sign record);

    @Select({
        "select",
        "sign_id, emp_id, sign_place, sign_time, sign_state",
        "from sign",
        "where sign_id = #{signId,jdbcType=INTEGER}"
    })
    @Results(id="signMapper",value={
        @Result(column="sign_id", property="signId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="emp_id", property="empId", jdbcType=JdbcType.INTEGER),
        @Result(column="sign_place", property="signPlace", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign_time", property="signTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="sign_state", property="signState", jdbcType=JdbcType.INTEGER),
       
    })
    Sign selectByPrimaryKey(Integer signId);

    @UpdateProvider(type=SignSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Sign record);

    @Update({
        "update sign",
        "set emp_id = #{empId,jdbcType=INTEGER},",
          "sign_place = #{signPlace,jdbcType=VARCHAR},",
          "sign_time = #{signTime,jdbcType=TIMESTAMP},",
          "sign_state = #{signState,jdbcType=INTEGER},",
        
        "where sign_id = #{signId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Sign record);
    @Select({
        "select",
        "sign_id, emp_id, sign_place, sign_time, sign_state",
        "from sign",
        "where sign_id = #{signId,jdbcType=INTEGER}"
    })
    @ResultMap("signMapper")
	List<Sign> selectAll();
}