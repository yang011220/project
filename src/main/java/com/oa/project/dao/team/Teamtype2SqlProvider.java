package com.oa.project.dao.team;

import org.apache.ibatis.jdbc.SQL;

import com.oa.project.entity.team.Teamtype2;

public class Teamtype2SqlProvider {

    public String insertSelective(Teamtype2 record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("team_type2");
        
        if (record.getTeamType2Id() != null) {
            sql.VALUES("team_type2_id", "#{teamType2Id,jdbcType=INTEGER}");
        }
        
        if (record.getTeamType2Name() != null) {
            sql.VALUES("team_type2_name", "#{teamType2Name,jdbcType=VARCHAR}");
        }
        
        if (record.getTeamType1Id() != null) {
            sql.VALUES("team_type1_id", "#{teamType1Id,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Teamtype2 record) {
        SQL sql = new SQL();
        sql.UPDATE("team_type2");
        
        if (record.getTeamType2Name() != null) {
            sql.SET("team_type2_name = #{teamType2Name,jdbcType=VARCHAR}");
        }
        
        if (record.getTeamType1Id() != null) {
            sql.SET("team_type1_id = #{teamType1Id,jdbcType=INTEGER}");
        }
        
        sql.WHERE("team_type2_id = #{teamType2Id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}