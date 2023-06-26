package com.oa.project.biz.team;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.oa.project.dao.team.Teamtype2Mapper;

import com.oa.project.entity.team.Teamtype2;

@Service
public class TeamType2Biz {
	@Resource
	private Teamtype2Mapper teamtype2Mapper;
	
	public int save(Teamtype2 teamtype2){
		return teamtype2Mapper.insertSelective(teamtype2);
	}
	public int update(Teamtype2 teamtype2){
		return teamtype2Mapper.updateByPrimaryKeySelective(teamtype2);
	}
	public int delete(int id){
		return teamtype2Mapper.deleteByPrimaryKey(id);
	}
	public Teamtype2 selectById(int id){
		return teamtype2Mapper.selectByPrimaryKey(id);
	}
	public List<Teamtype2> selectAll(){
		return teamtype2Mapper.selectAll();
	}
	public List<Teamtype2> selectByType1Id(int id){
		return teamtype2Mapper.selectByType1Id(id);
	}
	public List<Teamtype2> selectAllLimit(int pagenum) {
		int num=(pagenum-1)*20;
		return teamtype2Mapper.selectAllLimit(num);
	}
	
}
