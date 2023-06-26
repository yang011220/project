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

import com.oa.project.entity.team.Dept;
import com.oa.project.entity.team.Scale;
@MapperScan
public interface DeptMapper {
    @Delete({
        "delete from dept",
        "where dept_id = #{deptId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer deptId);
    @Delete({
        "delete from dept",
        "where team_id = #{teamId,jdbcType=INTEGER}"
    })
    int deleteByTeamId(Integer teamId);
    @Insert({
        "insert into dept (dept_id, dept_name, team_id",
        "leveldept_id)",
        "values (#{deptId,jdbcType=INTEGER}, #{deptName,jdbcType=VARCHAR}, {teamId,jdbcType=INTEGER},",
        "#{leveldeptId,jdbcType=INTEGER})"
    })
    int insert(Dept record);

    @InsertProvider(type=DeptSqlProvider.class, method="insertSelective")
    int insertSelective(Dept record);

    @Select({
        "select",
        "dept_id, dept_name, leveldept_id,team_id",
        "from dept",
        "where dept_id = #{deptId,jdbcType=INTEGER}"
    })
    @Results(id="deptMapper",value={
        @Result(column="dept_id", property="deptId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="dept_name", property="deptName", jdbcType=JdbcType.VARCHAR),
        @Result(column="leveldept_id", property="leveldeptId", jdbcType=JdbcType.INTEGER),
        @Result(column="team_id", property="teamId", jdbcType=JdbcType.INTEGER)
    })
    Dept selectByPrimaryKey(Integer deptId);

    @UpdateProvider(type=DeptSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Dept record);

    @Update({
        "update dept",
        "set dept_name = #{deptName,jdbcType=VARCHAR},",
          "leveldept_id = #{leveldeptId,jdbcType=INTEGER}",
          "teamId = #{teamId,jdbcType=INTEGER}",
        "where dept_id = #{deptId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Dept record);
    
    @Select({
        "select",
        "dept_id, dept_name, leveldept_id,team_id",
        "from dept"
    })
    @ResultMap("deptMapper")
    List<Dept> selectAll();
    
    @Select({
        "select",
        "dept_id, dept_name, leveldept_id,team_id",
        "from dept",
        "where team_id = #{teamId,jdbcType=INTEGER} and leveldept_id= 0 "
    })
    @ResultMap("deptMapper")
    List<Dept> selectDeptByTeamId(int teamId);
    
    @Select({
        "select",
        "dept_id, dept_name, leveldept_id,team_id",
        "from dept",
        "where leveldept_id = #{leveldeptId,jdbcType=INTEGER}"
    })
    @ResultMap("deptMapper")
    List<Dept> selectDeptByLevelId(int levelId);
    
    @Select({
        "select",
        "dept_id, dept_name, leveldept_id,team_id",
        "from dept",
        "where team_id = 0"
    })
    @ResultMap("deptMapper")
    List<Dept> model();
}