package com.oa.project.dao.team;

import org.apache.ibatis.jdbc.SQL;

import com.oa.project.entity.team.Dept;

public class DeptSqlProvider {

    public String insertSelective(Dept record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("dept");
        
        if (record.getDeptId() != null) {
            sql.VALUES("dept_id", "#{deptId,jdbcType=INTEGER}");
        }
        
        if (record.getDeptName() != null) {
            sql.VALUES("dept_name", "#{deptName,jdbcType=VARCHAR}");
        }
        
        if (record.getLeveldeptId() != null) {
            sql.VALUES("leveldept_id", "#{leveldeptId,jdbcType=INTEGER}");
        }
        if (record.getTeamId() != null) {
            sql.VALUES("team_id", "#{teamId,jdbcType=INTEGER}");
        }
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Dept record) {
        SQL sql = new SQL();
        sql.UPDATE("dept");
        
        if (record.getDeptName() != null) {
            sql.SET("dept_name = #{deptName,jdbcType=VARCHAR}");
        }
        
        if (record.getLeveldeptId() != null) {
            sql.SET("leveldept_id = #{leveldeptId,jdbcType=INTEGER}");
        }
        if (record.getTeamId() != null) {
            sql.SET("team_id = #{teamId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("dept_id = #{deptId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}