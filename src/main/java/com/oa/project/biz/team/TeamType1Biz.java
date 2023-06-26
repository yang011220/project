package com.oa.project.biz.team;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.project.dao.team.Teamtype1Mapper;
import com.oa.project.entity.team.Scale;
import com.oa.project.entity.team.Teamtype1;
import com.oa.project.entity.team.vo.TeamType1Vo;

@Service
public class TeamType1Biz {
	@Resource
	private Teamtype1Mapper teamtype1Mapper;
	public int save(Teamtype1 teamtype1){
		return teamtype1Mapper.insertSelective(teamtype1);
	}
	public int update(Teamtype1 teamtype1){
		return teamtype1Mapper.updateByPrimaryKeySelective(teamtype1);
	}
	public int delete(int id){
		return teamtype1Mapper.deleteByPrimaryKey(id);
	}
	public Teamtype1 selectById(int id){
		return teamtype1Mapper.selectByPrimaryKey(id);
	}
	public List<Teamtype1> selectAll(){
		return teamtype1Mapper.selectAll();
	}
	public List<TeamType1Vo> selectType1Vo(){
		return teamtype1Mapper.slectVo();
	}
}
