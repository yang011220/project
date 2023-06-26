package com.oa.project.biz.team;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.project.biz.lh.EmpBiz;
import com.oa.project.dao.team.DeptMapper;
import com.oa.project.entity.lh.Emp;
import com.oa.project.entity.team.Dept;
import com.oa.project.entity.team.Teamtype2;
import com.oa.project.entity.team.Dept;

@Service
public class DeptBiz {
	@Resource
	private DeptMapper deptMapper;
	@Resource private EmpBiz empBiz;

	public int save(Dept dept){
		return deptMapper.insertSelective(dept);
	}
	public int update(Dept dept){
		return deptMapper.updateByPrimaryKeySelective(dept);
	}
	public int delete(int id){
//		Emp emp=new Emp();
//		emp.set
//		empBiz.findAllByDeptId(emp);
		return deptMapper.deleteByPrimaryKey(id);
	}
	public Dept selectById(int id){
		return deptMapper.selectByPrimaryKey(id);
	}
//	public List<Dept> selectAll(){
//		return deptMapper.selectAll();
//	}
//	查找团队下所有部门，包括一级部门和下级部门
	public List<Dept> selectByTeamId(int teamId){
		return deptMapper.selectDeptByTeamId(teamId);
	}
//	查找当前部门的下级部门，不包括下下级，还需继续点击
	public List<Dept> selectByLevelId(int levelId){
		return deptMapper.selectDeptByLevelId(levelId);
	}
//	获取基础部门
	public List<Dept> selectModel(){
		return deptMapper.model();
	}
//	解散团队时根据团队id清除所有部门
	public int deleteByTeamId(int id){
		return deptMapper.deleteByTeamId(id);
	}
}
