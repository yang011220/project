package com.oa.project.biz.hb;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.project.dao.hb.TagtypeMapper;
import com.oa.project.entity.hb.Tagtype;

@Service
public class TagtypeBiz {
	@Resource
	private TagtypeMapper tagtypeMapper;
	
	public List<Tagtype> findAll(){
		return tagtypeMapper.findAll();
	}
	
	public Tagtype findById(int tagtypeId){
		return tagtypeMapper.selectByPrimaryKey(tagtypeId);
	}
	
	public int save(Tagtype tagtype){
		return tagtypeMapper.insertSelective(tagtype);
	}
	
	public int delete(int cusTypeId){
		return tagtypeMapper.deleteByPrimaryKey(cusTypeId);
	}
	
	public int update(Tagtype tagtype){
		return tagtypeMapper.updateByPrimaryKeySelective(tagtype);
	}

}
