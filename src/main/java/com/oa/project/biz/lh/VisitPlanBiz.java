package com.oa.project.biz.lh;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.project.dao.lh.VisitPlanDao;
import com.oa.project.entity.lh.Emp;
import com.oa.project.entity.lh.VisitPlan;

@Service
public class VisitPlanBiz {
	
	@Resource
	private VisitPlanDao visitPlanDao;
	
	
	public int save(VisitPlan visitPlan){
		return visitPlanDao.save(visitPlan);	
	}
	
	public int update(VisitPlan visitPlan){
		return visitPlanDao.updateById(visitPlan);
	}
	
	public int delete(int visitPlanId){
		return visitPlanDao.deleteById(visitPlanId);
	}
	
	public List<VisitPlan> findAll(Emp emp){
		return visitPlanDao.findAll(emp);
	}
	
	public List<VisitPlan> findAllLimit(Emp emp,int pageNum){
		int num = (pageNum-1)*20;
		return visitPlanDao.findAllLimit(emp,pageNum);
	}
	
	public VisitPlan findById(int visitPlanId){
		return visitPlanDao.findById(visitPlanId);
	}
	
	public List<VisitPlan> findByVisitTime(VisitPlan visitPlan){
		return visitPlanDao.findByVisitTime(visitPlan);
	}
}
