package com.oa.project.dao.team;

import org.apache.ibatis.jdbc.SQL;

import com.oa.project.entity.team.Sign;

public class SignSqlProvider {

    public String insertSelective(Sign record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sign");
        
        if (record.getSignId() != null) {
            sql.VALUES("sign_id", "#{signId,jdbcType=INTEGER}");
        }
        
        if (record.getEmpId() != null) {
            sql.VALUES("emp_id", "#{empId,jdbcType=INTEGER}");
        }
        
        if (record.getSignPlace() != null) {
            sql.VALUES("sign_place", "#{signPlace,jdbcType=VARCHAR}");
        }
        
        if (record.getSignTime() != null) {
            sql.VALUES("sign_time", "#{signTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSignState() != null) {
            sql.VALUES("sign_state", "#{signState,jdbcType=INTEGER}");
        }
        
       
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Sign record) {
        SQL sql = new SQL();
        sql.UPDATE("sign");
        
        if (record.getEmpId() != null) {
            sql.SET("emp_id = #{empId,jdbcType=INTEGER}");
        }
        
        if (record.getSignPlace() != null) {
            sql.SET("sign_place = #{signPlace,jdbcType=VARCHAR}");
        }
        
        if (record.getSignTime() != null) {
            sql.SET("sign_time = #{signTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSignState() != null) {
            sql.SET("sign_state = #{signState,jdbcType=INTEGER}");
        }
        
        
        
        sql.WHERE("sign_id = #{signId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}