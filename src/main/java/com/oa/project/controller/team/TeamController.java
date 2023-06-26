package com.oa.project.controller.team;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.project.biz.lh.EmpBiz;
import com.oa.project.biz.team.DeptBiz;
import com.oa.project.biz.team.ScaleBiz;
import com.oa.project.biz.team.TeamBiz;
import com.oa.project.biz.team.TeamType1Biz;
import com.oa.project.biz.team.TeamType2Biz;
import com.oa.project.entity.lh.Emp;
import com.oa.project.entity.lt.User;
import com.oa.project.entity.team.Dept;
import com.oa.project.entity.team.Scale;
import com.oa.project.entity.team.Team;

import com.oa.project.entity.team.Teamtype1;
import com.oa.project.entity.team.Teamtype2;
import com.oa.project.entity.team.vo.TeamVo;
import com.oa.project.entity.team.vo.TeamVoMake;

import com.oa.project.util.AjaxMsgModel;
@Controller
@RequestMapping("/team/tuandui")
public class TeamController {
	@Resource
	private TeamBiz teamBiz;
	@Resource
	private TeamType1Biz teamType1Biz;
	@Resource
	private TeamType2Biz teamType2Biz;
	@Resource
	private ScaleBiz scaleBiz;
	@Resource
	private DeptBiz deptBiz;
	@Resource
	private EmpBiz empBiz;

//	登陆后根据用户id查找到其加入的所有团队
	@RequestMapping("/list")
	public String selectAll(Model model,HttpSession session){
		User user =(User)session.getAttribute("users");
		List<Team>list= teamBiz.selectByUserId(user.getUserId());
//		int size=list.size();
		model.addAttribute("list",list);
//		model.addAttribute("totalPage",size);
//		model.addAttribute("pageNum",pageNum);
		return "/team/tuandui/list";
	}
	@RequestMapping("/presave")
	public String presave(Model model) {
		TeamVoMake teamVoMake=teamBiz.teamMake();
		model.addAttribute("list", teamVoMake);
		 return "/team/tuandui/add";
	}
//	返回一个对象，属性为规模列表和行业列表
	@ResponseBody
	@RequestMapping("/pipi")
	public TeamVoMake teamVo() {
		TeamVoMake teamVoMake=teamBiz.teamMake();	
		 return teamVoMake;
	}

	@RequestMapping("/preupdate")
	public String preupdate(int id,Model model) {
		Team scale=teamBiz.selectById(id);
		model.addAttribute("team", scale);
		 return "/team/tuandui/update";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	  public AjaxMsgModel update(Team scale){
		
		 try {
			 teamBiz.update(scale);
	        } catch (Exception e) {
	            AjaxMsgModel.createfailModel(false);
	        }
	       return AjaxMsgModel.createSuccessModel(true);
	}
//	@RequestMapping("/update")
//	public String update(Team scale){
//		 teamBiz.update(scale);
//		 return "redirect:/team/tuandui/list";
//	}
//	彻底删除团队，团队下属部门，部门下属员工,为完成
	@ResponseBody
	@RequestMapping("/delete")
	  public AjaxMsgModel delete(int id){
		
		 try {
				teamBiz.delete(id);
				 deptBiz.deleteByTeamId(id);
				 empBiz.deleteByTeamId(id);
	        } catch (Exception e) {
	            AjaxMsgModel.createfailModel(false);
	        }
	       return AjaxMsgModel.createSuccessModel(true);
	}
//	退出团队
	@ResponseBody
	@RequestMapping("/getout")
	public AjaxMsgModel getOut(HttpSession session){
		try{
			Emp emp =(Emp)session.getAttribute("currentEmp");
			int row = empBiz.deleteById(emp.getEmpId());
			if(row <=0){
				return AjaxMsgModel.createfailModel(false);
			}
		}catch (Exception e) {
			e.printStackTrace();
			return AjaxMsgModel.createfailModel(false);
		}
		return AjaxMsgModel.createSuccessModel(true);
	}
	
//	展示所有团队
	@RequestMapping("/listAll")
	public String selectAllTeam(Model model,int pageNum){
		int size=teamBiz.selectAll().size();
		List<Team>listLimit= teamBiz.selectAllLimit(pageNum);
		model.addAttribute("list",listLimit);
		model.addAttribute("totalCount",size);
		model.addAttribute("pageNum",pageNum);
		return "/team/guanli/list";
	}
	
	
//	获取所有团队
	@ResponseBody
	@RequestMapping("/list2")
	public List<Team> selectAll(){
	
		List<Team>list= teamBiz.selectAll();
		return list;
		
	}
	
//	获取某个用户的所有团队
	@ResponseBody
	@RequestMapping("/listByUserId")
	public List<Team> selectAllBy(int userId){
		List<Team>list= teamBiz.selectByUserId(userId);
		
		return list;
	}
	@ResponseBody
	@RequestMapping("/save")
    public AjaxMsgModel add(Team team,HttpSession session,HttpServletRequest request) {
        try {
        	User user =(User)session.getAttribute("users");
        	teamBiz.save(team, user);
        	int id=teamBiz.selectLast();
        	Team currentTeam=teamBiz.selectById(id);
        	Emp emp=empBiz.findByTUId(id, user.getUserId());
        	request.getSession().setAttribute("currentTeam",currentTeam);	
        	request.getSession().setAttribute("currentEmp",emp);
        } catch (Exception e) {
            AjaxMsgModel.createfailModel(false);
        }
       return AjaxMsgModel.createSuccessModel(true);
    }
//	@ResponseBody
//	@RequestMapping("/save")
//    public AjaxMsgModel add(TeamVo teamVo,HttpSession session) {
//        try {
//        	Team team=new Team();
//        	team.setScaleId(teamVo.getScaleId());
//        	team.setTeamType2Id(teamVo.getTeamType2Id());
//        	team.setTeamName(teamVo.getTeamName());
//        	teamBiz.save(team, session);
//        } catch (Exception e) {
//            AjaxMsgModel.createfailModel(false);
//        }
//       return AjaxMsgModel.createSuccessModel(true);
//    }
//	@RequestMapping("/save")
//	public String saveBy(Team team,Model model,HttpSession session) {
//		User user =(User)session.getAttribute("users");
//		Date createDate=new Date();
//		team.setCreator(user.getUserName());
//		team.setCreateTime(createDate);
//		team.setUpdator(user.getUserName());
//		team.setUpdateTime(new Date());
//		team.setUserId(user.getUserId());
//		teamBiz.save(team);
//		int id=teamBiz.selectLast();
//		team.setTeamId(id);
//		modelDept(id);
//		Emp emp=new Emp();
//		empBiz.save(team,user.getUserId());
//		 return "redirect:/team/tuandui/list";
//	}

	
	
}
