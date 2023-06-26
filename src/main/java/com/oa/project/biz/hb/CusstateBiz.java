package com.oa.project.biz.hb;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.project.dao.hb.CusstateMapper;
import com.oa.project.entity.hb.Cusstate;

@Service
public class CusstateBiz {
	@Resource
	private CusstateMapper cusstateMapper;
	
	public List<Cusstate> findAll(){
		return cusstateMapper.findAll();
	}
	
	public Cusstate findById(int stateId){
		return cusstateMapper.selectByPrimaryKey(stateId);
	}
	
	public int save(Cusstate cusstate){
		return cusstateMapper.insertSelective(cusstate);
	}
	
	public int delete(int stateId){
		return cusstateMapper.deleteByPrimaryKey(stateId);
	}
	
	public int update(Cusstate cusstate){
		return cusstateMapper.updateByPrimaryKeySelective(cusstate);
	}
}
