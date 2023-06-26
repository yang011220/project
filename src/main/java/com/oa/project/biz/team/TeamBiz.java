package com.oa.project.biz.team;

import com.oa.project.biz.lh.EmpBiz;
import com.oa.project.dao.lt.RoleUserDAO;
import com.oa.project.dao.team.ScaleMapper;
import com.oa.project.dao.team.TeamMapper;
import com.oa.project.dao.team.Teamtype1Mapper;
import com.oa.project.dao.team.Teamtype2Mapper;
import com.oa.project.entity.lt.RoleUser;
import com.oa.project.entity.lt.User;
import com.oa.project.entity.team.Dept;
import com.oa.project.entity.team.Scale;
import com.oa.project.entity.team.Team;
import com.oa.project.entity.team.vo.TeamType1Vo;
import com.oa.project.entity.team.vo.TeamVoMake;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class TeamBiz {
	@Resource
	private TeamMapper teamMapper;
	@Resource
	private Teamtype1Mapper teamtype1Mapper;
	@Resource
	private Teamtype2Mapper teamtype2Mapper;
	@Resource
	private ScaleMapper scaleMapper;
	@Resource private DeptBiz deptBiz;
	@Resource private EmpBiz empBiz;
	@Resource private RoleUserDAO roleUserDAO;
	public int save(Team team,User user){
		Date createDate=new Date();
		team.setCreator(user.getUserName());
		team.setCreateTime(createDate);
		team.setUpdator(user.getUserName());
		team.setUpdateTime(new Date());
		team.setUserId(user.getUserId());
		teamMapper.insertSelective(team);
		int teamId=teamMapper.selectLat();
		team.setTeamId(teamId);
		modelDept(teamId);
		RoleUser roleUser=new RoleUser();
		roleUser.setRoleId(2);
		roleUser.setTeamId(teamId);
		roleUser.setUserName(user.getUserName());
		int id=empBiz.save(team,user.getUserId(),user.getUserName(),2);
		roleUserDAO.save(roleUser);

		return id;
	}
//	所有团队
	public List<Team> selectAll(){
		return teamMapper.selectAll();
	}
//	所有团队
	public List<Team> selectAllLimit(int pageNum){
		int num=(pageNum-1)*20;
		return teamMapper.selectAllLimit(num);
	}
	public Team selectById(int id) {
		// TODO Auto-generated method stub
		return teamMapper.selectByPrimaryKey(id);
	}
	public int update(Team team) {
		return teamMapper.updateByPrimaryKeySelective(team);
		
	}
	public int delete(int id) {
		return teamMapper.deleteByPrimaryKey(id);
	}
	public int selectLast() {
		return teamMapper.selectLat();
	}
//	返回一个封装了行业和规模的对象
	public TeamVoMake teamMake(){
		TeamVoMake teamVoMake=new TeamVoMake();
		List<TeamType1Vo>type1VoList=teamtype1Mapper.slectVo();
		List<Scale>scaleList=scaleMapper.selectAll();
		teamVoMake.setType1Volist(type1VoList);
		teamVoMake.setScaleList(scaleList);
		return teamVoMake;
	}
	
//	推出团队
//	public void getOutTeam(int teamId,int userId) {
//		Emp emp=new Emp();
//		
//	}
	
//用户拥有的团队
	public List<Team> selectByUserId(int id){
		return teamMapper.selectByUser(id);
	}
	private void modelDept(int id) {
		List<Dept>list=deptBiz.selectModel();
		for(Dept dept:list){
			Dept ddd=new Dept();
			ddd.setLeveldeptId(0);
			ddd.setDeptName(dept.getDeptName());
			ddd.setTeamId(id);
			deptBiz.save(ddd);
		}
	}
}
