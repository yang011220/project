package com.oa.project.dao.team;

import java.util.List;
import com.oa.project.entity.team.Teamtype2;
import com.oa.project.entity.team.vo.TeamType1Vo;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;

import com.oa.project.entity.team.Teamtype1;
@MapperScan
public interface Teamtype1Mapper {
    @Delete({
        "delete from team_type1",
        "where team_type1_id = #{teamType1Id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer teamType1Id);

    @Insert({
        "insert into team_type1 (team_type1_id, team_type1_name)",
        "values (#{teamType1Id,jdbcType=INTEGER}, #{teamType1Name,jdbcType=VARCHAR})"
    })
    int insert(Teamtype1 record);

    @InsertProvider(type=Teamtype1SqlProvider.class, method="insertSelective")
    int insertSelective(Teamtype1 record);

    @Select({
        "select",
        "team_type1_id, team_type1_name",
        "from team_type1",
        "where team_type1_id = #{teamType1Id,jdbcType=INTEGER}"
    })
    @Results(id="Type1Mapper",value={
        @Result(column="team_type1_id", property="teamType1Id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="team_type1_name", property="teamType1Name", jdbcType=JdbcType.VARCHAR)
    })
    Teamtype1 selectByPrimaryKey(Integer teamType1Id);

    @UpdateProvider(type=Teamtype1SqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Teamtype1 record);

    @Update({
        "update team_type1",
        "set team_type1_name = #{teamType1Name,jdbcType=VARCHAR}",
        "where team_type1_id = #{teamType1Id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Teamtype1 record);
    @Select({
        "select",
        "team_type1_id, team_type1_name",
        "from team_type1"
    })
    @ResultMap("Type1Mapper")
    List<Teamtype1> selectAll();
    
    @Select({
        "select",
        "team_type1_id, team_type1_name",
        "from team_type1"
    })
    @Results(id="Type1VoMapper",value={
        @Result(column="team_type1_id", property="teamType1Id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="team_type1_name", property="teamType1Name", jdbcType=JdbcType.VARCHAR),
        @Result(column="team_type1_id", property="list", jdbcType=JdbcType.VARCHAR,
        many=@Many(select="com.oa.project.dao.team.Teamtype2Mapper.selectByType1Id",fetchType=FetchType.EAGER))
    })
    List<TeamType1Vo> slectVo();
}