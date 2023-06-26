package com.oa.project.dao.team;

import org.apache.ibatis.jdbc.SQL;

import com.oa.project.entity.team.Teamtype1;

public class Teamtype1SqlProvider {

    public String insertSelective(Teamtype1 record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("team_type1");
        
        if (record.getTeamType1Id() != null) {
            sql.VALUES("team_type1_id", "#{teamType1Id,jdbcType=INTEGER}");
        }
        
        if (record.getTeamType1Name() != null) {
            sql.VALUES("team_type1_name", "#{teamType1Name,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Teamtype1 record) {
        SQL sql = new SQL();
        sql.UPDATE("team_type1");
        
        if (record.getTeamType1Name() != null) {
            sql.SET("team_type1_name = #{teamType1Name,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("team_type1_id = #{teamType1Id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}