package com.oa.project.dao.team;

import com.oa.project.entity.team.Team;
import org.apache.ibatis.jdbc.SQL;

public class TeamSqlProvider {

    public String insertSelective(Team record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("team");
        
        if (record.getTeamId() != null) {
            sql.VALUES("team_id", "#{teamId,jdbcType=INTEGER}");
        }
        
        if (record.getTeamName() != null) {
            sql.VALUES("team_name", "#{teamName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=DATE}");
        }
        
        if (record.getCreator() != null) {
            sql.VALUES("creator", "#{creator,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=DATE}");
        }
        
        if (record.getUpdator() != null) {
            sql.VALUES("updator", "#{updator,jdbcType=VARCHAR}");
        }
        
        if (record.getScaleId() != null) {
            sql.VALUES("scale_id", "#{scaleId,jdbcType=INTEGER}");
        }
        
        if (record.getTeamType2Id() != null) {
            sql.VALUES("team_type2_id", "#{teamType2Id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Team record) {
        SQL sql = new SQL();
        sql.UPDATE("team");
        
        if (record.getTeamName() != null) {
            sql.SET("team_name = #{teamName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=DATE}");
        }
        
        if (record.getCreator() != null) {
            sql.SET("creator = #{creator,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=DATE}");
        }
        
        if (record.getUpdator() != null) {
            sql.SET("updator = #{updator,jdbcType=VARCHAR}");
        }
        
        if (record.getScaleId() != null) {
            sql.SET("scale_id = #{scaleId,jdbcType=INTEGER}");
        }
        
        if (record.getTeamType2Id() != null) {
            sql.SET("team_type2_id = #{teamType2Id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
     
        }
        
        sql.WHERE("team_id = #{teamId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}