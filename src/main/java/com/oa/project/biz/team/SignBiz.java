package com.oa.project.biz.team;

import java.util.List;

import javax.annotation.Resource;

import com.oa.project.dao.team.SignMapper;
import com.oa.project.entity.team.Sign;

public class SignBiz {
	@Resource
	private SignMapper SignDao;
	public int save(Sign Sign){
		return SignDao.insertSelective(Sign);
	}
	public int update(Sign Sign){
		return SignDao.updateByPrimaryKeySelective(Sign);
	}
	public int delete(int SignId){
		return SignDao.deleteByPrimaryKey(SignId);
	}
	public Sign selectById(int id){
		return SignDao.selectByPrimaryKey(id);
	}
	public List<Sign> selectAll(){
		return SignDao.selectAll();
	}
}
