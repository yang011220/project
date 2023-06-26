package com.oa.project.biz.hb;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.project.dao.hb.CustypeMapper;
import com.oa.project.entity.hb.Custype;

@Service
public class CustypeBiz {
	@Resource
	private CustypeMapper custypeMapper;
	
	public List<Custype> findAll(){
		return custypeMapper.findAll();
	}
	
	public Custype findById(int cusTypeId){
		return custypeMapper.selectByPrimaryKey(cusTypeId);
	}
	
	public int save(Custype custype){
		return custypeMapper.insertSelective(custype);
	}
	
	public int delete(int cusTypeId){
		return custypeMapper.deleteByPrimaryKey(cusTypeId);
	}
	
	public int update(Custype custype){
		return custypeMapper.updateByPrimaryKeySelective(custype);
	}
}
