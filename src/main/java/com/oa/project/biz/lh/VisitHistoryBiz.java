package com.oa.project.biz.lh;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.project.dao.lh.VisitHistoryDao;
import com.oa.project.entity.lh.Emp;
import com.oa.project.entity.lh.VisitHistory;
import com.oa.project.entity.lh.VisitPlan;

@Service
public class VisitHistoryBiz {
	
	@Resource
	private VisitHistoryDao visitHistoryDao;
	
	
	public int save(VisitHistory visitHistory){
		return visitHistoryDao.save(visitHistory);
	}
	
	public int update(VisitHistory visitHistory){
		return visitHistoryDao.update(visitHistory);
	}
	
	public int delete(int visitHistoryId){
		return visitHistoryDao.delete(visitHistoryId);
	}
	
	public List<VisitHistory> findAll(Emp currentEmp){
		return visitHistoryDao.findAll(currentEmp);
	}
	
	public List<VisitHistory> findAllLimit(Emp currentEmp,int pageNum){
		int num = (pageNum-1)*20;
		return visitHistoryDao.findAllLimit(currentEmp,num);
	}
	
	public VisitHistory findById(int visitHistoryId){
		return visitHistoryDao.findById(visitHistoryId);
	}
	
	public List<VisitHistory> findByVisitTime(VisitHistory visitHistory){
		return visitHistoryDao.findByVisitTime(visitHistory);
	}
}
