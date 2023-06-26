package com.oa.project.biz.lh;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.project.dao.lh.EmpDao;
import com.oa.project.entity.lh.Emp;
import com.oa.project.entity.lt.Role;
import com.oa.project.entity.lt.User;
import com.oa.project.entity.team.Team;

@Service
public class EmpBiz {
	@Resource
	private EmpDao empDao;
	
	public int save(Team team,int userId,String empName,int roleId){
		Emp emp = new Emp();
		User user = new User();
		Role role = new Role();
		role.setRoleId(roleId);
		user.setUserId(userId);
		emp.setTeam(team);
		emp.setUser(user);
		emp.setEmpName(empName);
		role.setRoleId(roleId);
		emp.setRole(role);
		return empDao.save(emp);
	}

	
	public Emp findByTUId(int teamId,int userId){
		return empDao.findByTUId(teamId, userId);
	}
	
	public int deleteById(int emp){
		return empDao.deleteById(emp);
	}
	
	public int update(Emp emp){
		return empDao.updateById(emp);
	}
	
	public List<Emp> findAll(int teamId){
		return empDao.findAll(teamId);
	}

	public List<Emp> findAllLimit(int teamId,int PageNum){
		int num = (PageNum-1)*20;
		return empDao.findAllLimit(teamId,num);
	}
	public Emp findById(int id){
		return empDao.findById(id);
	}
	
	public List<Emp> findAllByDeptId(Emp emp){
		return empDao.findAllByDeptId(emp);
	}
	
	
	public int deleteByTeamId(int teamId){
		return empDao.deleteByTeamId(teamId);
	}
}
