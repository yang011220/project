package com.oa.project.biz.team;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.project.dao.team.ScaleMapper;
import com.oa.project.entity.team.Scale;

@Service
public class ScaleBiz {
	@Resource
	private ScaleMapper scaleDao;
	public int save(Scale scale){
		return scaleDao.insertSelective(scale);
	}
	public int update(Scale scale){
		return scaleDao.updateByPrimaryKeySelective(scale);
	}
	public int delete(int scaleId){
		return scaleDao.deleteByPrimaryKey(scaleId);
	}
	public Scale selectById(int id){
		return scaleDao.selectByPrimaryKey(id);
	}
	public List<Scale> selectAll(){
		return scaleDao.selectAll();
	}
}
