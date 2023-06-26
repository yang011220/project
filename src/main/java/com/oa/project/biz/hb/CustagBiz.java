package com.oa.project.biz.hb;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.project.dao.hb.CustagMapper;
import com.oa.project.entity.hb.Custag;

@Service
public class CustagBiz {
	@Resource
	private CustagMapper custagMapper;
	
	public List<Custag> findAll(){
		return custagMapper.findAll();
	}
	
	public Custag findById(int tagId){
		return custagMapper.selectByPrimaryKey(tagId);
	}
	
	public int save(Custag custag){
		return custagMapper.insertSelective(custag);
	}
	
	public int delete(int tagId){
		return custagMapper.deleteByPrimaryKey(tagId);
	}
	
	public int update(Custag custag){
		return custagMapper.updateByPrimaryKeySelective(custag);
	}
}
