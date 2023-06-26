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


import com.oa.project.entity.team.Teamtype2;
@MapperScan
public interface Teamtype2Mapper {
    @Delete({
        "delete from team_type2",
        "where team_type2_id = #{teamType2Id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer teamType2Id);

    @Insert({
        "insert into team_type2 (team_type2_id, team_type2_name, ",
        "team_type1_id)",
        "values (#{teamType2Id,jdbcType=INTEGER}, #{teamType2Name,jdbcType=VARCHAR}, ",
        "#{teamType1Id,jdbcType=INTEGER})"
    })
    int insert(Teamtype2 record);

    @InsertProvider(type=Teamtype2SqlProvider.class, method="insertSelective")
    int insertSelective(Teamtype2 record);

    @Select({
        "select",
        "team_type2_id, team_type2_name, team_type1_id",
        "from team_type2",
        "where team_type2_id = #{teamType2Id,jdbcType=INTEGER}"
    })
    @Results(id="type2Mapper",value={
        @Result(column="team_type2_id", property="teamType2Id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="team_type2_name", property="teamType2Name", jdbcType=JdbcType.VARCHAR),
        @Result(column="team_type1_id", property="teamType1Id", jdbcType=JdbcType.INTEGER)
    })
    Teamtype2 selectByPrimaryKey(Integer teamType2Id);

    @UpdateProvider(type=Teamtype2SqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Teamtype2 record);

    @Update({
        "update team_type2",
        "set team_type2_name = #{teamType2Name,jdbcType=VARCHAR},",
          "team_type1_id = #{teamType1Id,jdbcType=INTEGER}",
        "where team_type2_id = #{teamType2Id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Teamtype2 record);
    @Select({
        "select",
        "team_type2_id, team_type2_name, team_type1_id",
        "from team_type2"
    })
    @ResultMap("type2Mapper")
    List<Teamtype2> selectAll();
    @Select({
        "select",
        "team_type2_id, team_type2_name, team_type1_id",
        "from team_type2",
        "where team_type1_id = #{teamType1Id,jdbcType=INTEGER}"
    })
    @ResultMap("type2Mapper")
    List<Teamtype2> selectByType1Id(int id);
    @Select({
        "select",
        "team_type2_id, team_type2_name, team_type1_id",
        "from team_type2","limit #{num},20"
    })
    @ResultMap("type2Mapper")
	List<Teamtype2> selectAllLimit(int num);
}