package com.oa.project.dao.lh;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import com.oa.project.entity.lh.Emp;

@MapperScan
public interface EmpDao{
	
	//插入员工
	int save(Emp emp);
	
	//根据工号删除员工
	@Delete("delete from emp where emp_id = #{empId}")
	int deleteById(int empId);
	
	//根据id修改员工的信息
	int updateById(Emp emp);
	
	@ResultMap("com.oa.project.dao.lh.EmpDao.EmpResultMap")
	@Select("select emp_id,emp_name,dept_id,role_id,emp_job,user_id,team_id from emp where team_id = #{teamId}")
	//根据团队Id查询该团队的所有员工
	List<Emp> findAll(int teamId);
	
	@ResultMap("com.oa.project.dao.lh.EmpDao.EmpResultMap")
	@Select("select emp_id,emp_name,dept_id,role_id,emp_job,user_id,team_id from emp where team_id = #{teamId} limit #{num},20")
	//根据团队Id查询该团队的所有员工
	List<Emp> findAllLimit(@Param("teamId")int teamId,@Param("num")int num);
	
	@ResultMap("com.oa.project.dao.lh.EmpDao.EmpResultMap")
	@Select("select emp_id,emp_name,dept_id,role_id,emp_job,user_id,team_id from emp where team_id = #{teamId} and user_id=#{userId}")
	//根据团队Id查询该团队的所有员工
	Emp findByTUId(@Param("teamId")int teamId,@Param("userId")int userId);
	
	@ResultMap(value="com.oa.project.dao.lh.EmpDao.EmpResultMap")
	@Select("select emp_id,emp_name,dept_id,role_id,emp_job,user_id,team_id from emp where emp_id=#{empId}")
	//查询某一个员工的详细资料
	Emp findById(int id);
	
	@ResultMap("com.oa.project.dao.lh.EmpDao.EmpResultMap")
	@Select("select emp_id,emp_name,dept_id,role_id,emp_job,user_id,team_id from emp where dept_id = #{dept.deptId}")
	//根据部门Id查询该团队的某个部门所有员工
	List<Emp> findAllByDeptId(Emp emp);
	
	//根据团队id删除所有员工
		@Delete("delete from emp where team_id = #{teamId}")
		int deleteByTeamId(int teamId);
	
}
