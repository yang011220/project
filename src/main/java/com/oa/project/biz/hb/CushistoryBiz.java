package com.oa.project.biz.hb;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.project.dao.hb.CushistoryMapper;
import com.oa.project.entity.hb.Cushistory;

@Service
public class CushistoryBiz {
	@Resource
	private CushistoryMapper cushistoryMapper;
	
	public List<Cushistory> findAll(){
		return cushistoryMapper.findAll();
	}
	
	public List<Cushistory> findAllLimit(int pageNum){
		int num=(pageNum-1)*20;
		return cushistoryMapper.findAllLimit(num);
	}
	
	public Cushistory findById(int historyId){
		return cushistoryMapper.selectByPrimaryKey(historyId);
	}
	
	public List<Cushistory> findByteamId(int teamId){
		return cushistoryMapper.selectByteamId(teamId);
	}
	
	public List<Cushistory> findByteamIdLimit(int teamId,int pageNum){
		int num=(pageNum-1)*20;
		return cushistoryMapper.selectByteamIdLimit(teamId,num);
	}
	
	public List<Cushistory> findByempId(int empId){
		return cushistoryMapper.selectByempId(empId);
	}
	
	public List<Cushistory> findByempIdLimit(int empId,int pageNum){
		int num=(pageNum-1)*20;
		return cushistoryMapper.selectByempIdLimit(empId,num);
	}
	
	public int save(Cushistory cushistory){
		return cushistoryMapper.insertSelective(cushistory);
	}
	
	public int delete(int id){
		return cushistoryMapper.deleteByPrimaryKey(id);
	}
	
	public int update(Cushistory cushistory){
		return cushistoryMapper.updateByPrimaryKeySelective(cushistory);
	}

}
