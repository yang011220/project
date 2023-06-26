package com.oa.project.dao.team;

import org.apache.ibatis.jdbc.SQL;

import com.oa.project.entity.team.Scale;

public class ScaleSqlProvider {

    public String insertSelective(Scale record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("scale");
        
        if (record.getScaleId() != null) {
            sql.VALUES("scale_id", "#{scaleId,jdbcType=INTEGER}");
        }
        
        if (record.getScaleName() != null) {
            sql.VALUES("scale_name", "#{scaleName,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Scale record) {
        SQL sql = new SQL();
        sql.UPDATE("scale");
        
        if (record.getScaleName() != null) {
            sql.SET("scale_name = #{scaleName,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("scale_id = #{scaleId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}