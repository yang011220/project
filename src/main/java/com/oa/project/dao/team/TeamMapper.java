package com.oa.project.dao.team;

import com.oa.project.entity.team.Team;

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

public interface TeamMapper {
    @Delete({
        "delete from team",
        "where team_id = #{teamId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer teamId);

//    @Delete({
//        "delete from team",
//        "where team_id = #{teamId,jdbcType=INTEGER}",
//        "and user_id = #{userId,jdbcType=INTEGER}"
//    })
//    void getOutTeam(int teamId,int userId);
    @Insert({
        "insert into team (team_id, team_name, ",
        "create_time, creator, ",
        "update_time, updator, ",
        "scale_id, team_type2_id)",
        "values (#{teamId,jdbcType=INTEGER}, #{teamName,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=DATE}, #{creator,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=DATE}, #{updator,jdbcType=VARCHAR}, ",
        "#{scaleId,jdbcType=INTEGER}, #{teamType2Id,jdbcType=INTEGER} "
  
    })
    int insert(Team record);

    @InsertProvider(type=TeamSqlProvider.class, method="insertSelective")
    int insertSelective(Team record);

    @Select({
        "select",
        "team_id, team_name, create_time, creator, update_time, updator, scale_id, team_type2_id, ",
        "user_id",
        "from team",
        "where team_id = #{teamId,jdbcType=INTEGER}"
    })
    @Results(id="teamMapper",value={
        @Result(column="team_id", property="teamId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="team_name", property="teamName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="creator", property="creator", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE),
        @Result(column="updator", property="updator", jdbcType=JdbcType.VARCHAR),
        @Result(column="scale_id", property="scaleId", jdbcType=JdbcType.INTEGER),
        @Result(column="team_type2_id", property="teamType2Id", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    Team selectByPrimaryKey(Integer teamId);

    @UpdateProvider(type=TeamSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Team record);

    @Update({
        "update team",
        "set team_name = #{teamName,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=DATE},",
          "creator = #{creator,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=DATE},",
          "updator = #{updator,jdbcType=VARCHAR},",
          "scale_id = #{scaleId,jdbcType=INTEGER},",
          "team_type2_id = #{teamType2Id,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER}",
        "where team_id = #{teamId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Team record);
    @Select({
        "select",
        "team_id, team_name, create_time, creator, update_time, updator, scale_id, team_type2_id,user_id",
        "from team","order by team_id"
    })
    @ResultMap("teamMapper")
    List<Team> selectAll();
    @Select({
        "select",
        "team_id, team_name, create_time, creator, update_time, updator, scale_id, team_type2_id,user_id",
        "from team","order by team_id","limit #{num},20"
    })
    @ResultMap("teamMapper")
    List<Team> selectAllLimit(int num);
//    @Select({
//        "select",
//        "team_id, team_name, create_time, creator, update_time, updator, scale_id, team_type2_id,user_id",
//        "from team",
//        "where user_id = #{userId,jdbcType=INTEGER}"
//    })
//    @ResultMap("teamMapper")
//    List<Team> selectTeamByUserId(int userId);
    
//    插入后获取插入的id
    @Select("select LAST_INSERT_ID()")
    int selectLat();
    
  
//    登陆后根据用户id查找到其对应的团队列表/
    @Select({
        "SELECT eee.team_id,ttt.create_time,ttt.creator,ttt.scale_id,ttt.team_name,ttt.team_type2_id,ttt.update_time,ttt.updator,uuu.user_id FROM `user` uuu",
"INNER JOIN emp eee ON uuu.user_id = eee.user_id",

"INNER JOIN team ttt on eee.team_id=ttt.team_id",
"WHERE uuu.user_id=#{userId，jdbcType=INTEGER} "   
    })
    @ResultMap("teamMapper")
    List<Team> selectByUser(Integer userId);
}