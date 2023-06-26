package com.oa.project.dao.lh;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import com.oa.project.entity.lh.Emp;
import com.oa.project.entity.lh.VisitPlan;

@MapperScan
public interface VisitPlanDao {

	@ResultMap("com.oa.project.dao.lh.VisitPlanDao.VisitPlanResultMap")
	@Select("select visit_id,emp_id,cus_id,plan,visit_time,reason from visit_plan where emp_id=#{empId} order by visit_time desc")
	List<VisitPlan> findAll(Emp emp);
	
	@ResultMap("com.oa.project.dao.lh.VisitPlanDao.VisitPlanResultMap")
	@Select("select visit_id,emp_id,cus_id,plan,visit_time,reason from visit_plan where emp_id=#{empId} order by visit_time desc limit #{num},20")
	List<VisitPlan> findAllLimit(Emp emp,int num);
	
	//xml里动态插入
	int save(VisitPlan visitPlan);
	
	//xml动态修改
	int updateById(VisitPlan visitPlan);
	
	@Delete("delete from visit_plan where visit_id =#{visitId}")
	int deleteById(int visitId);
	
	@ResultMap("com.oa.project.dao.lh.VisitPlanDao.VisitPlanResultMap")
	@Select("select visit_id,emp_id,cus_id,plan,visit_time,reason from visit_plan where visit_id = #{visitId}")
	VisitPlan findById(int visitId);
	
	
	//通过visit_time时间查询拜访计划
	@ResultMap("com.oa.project.dao.lh.VisitPlanDao.VisitPlanResultMap")
	@Select("select visit_id,emp_id,cus_id,plan,visit_time,reason from visit_plan where visit_time like CONCAT(#{visitTime},'%')")
	List<VisitPlan> findByVisitTime(VisitPlan visitPlan);
	

}
