package com.oa.project.controller.lh;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.project.biz.lh.EmpBiz;
import com.oa.project.biz.lt.RoleBiz;
import com.oa.project.biz.lt.UserBiz;
import com.oa.project.biz.team.DeptBiz;
import com.oa.project.entity.lh.Emp;
import com.oa.project.entity.lt.Role;
import com.oa.project.entity.lt.User;
import com.oa.project.entity.team.Dept;
import com.oa.project.entity.team.Team;
import com.oa.project.util.AjaxMsgModel;

@Controller
@RequestMapping("/emp")
//@ResponseBody
public class EmpController {
	
	@Resource
	private EmpBiz empBiz;
	
	@Resource
	private DeptBiz deptBiz;
	
	@Resource
	private UserBiz userBiz;
	
	@Resource
	private RoleBiz roleBiz;
	//根据teamid查询所有员工
	@RequestMapping("/list")
	public String findAll(HttpServletRequest request){
		Team team=(Team)request.getSession().getAttribute("currentTeam");
		List<Emp> empList =empBiz.findAll(team.getTeamId());
		request.setAttribute("empList", empList);
		return "/emp/list";
	}
	
	//预添加新员工
	@RequestMapping("/empPreAdd")
	public String PreAdd(HttpServletRequest request){
		List<User> list=userBiz.findAll();
		request.setAttribute("userList", list);
		return "/emp/preadd";
	}
	
	//添加新员工
	@ResponseBody
	@RequestMapping("/empDoAdd")
	public AjaxMsgModel DoAdd(HttpServletRequest request,int userId,String empName){
		try{
			Team teamId = (Team)request.getSession().getAttribute("currentTeam");
			int row = empBiz.save(teamId,userId,empName,4);
			if(row <=0){
				return AjaxMsgModel.createfailModel(false);
			}
		}catch (Exception e) {
			return AjaxMsgModel.createfailModel(false);
		}
		return AjaxMsgModel.createSuccessModel(true);
	}
	
	//预修改员工信息
	@RequestMapping("/empPreUpdate/{id}")
	public String PreUpdate(@PathVariable("id")int empId,Model model){
		Emp changeemp = empBiz.findById(empId);
		List<Role> roleList = roleBiz.findAll();
		List<Dept> deptList = deptBiz.selectByTeamId(changeemp.getTeam().getTeamId());
		model.addAttribute("emp", changeemp);
		model.addAttribute("roleList", roleList);
		model.addAttribute("deptList", deptList);
		return "/emp/preupdate";
	}
	
	//修改
	@ResponseBody
	@RequestMapping("/empDoUpdate")
	public AjaxMsgModel DoUpdate(Emp emp){
		try{
			int row = empBiz.update(emp);
			if(row <=0){
				return AjaxMsgModel.createfailModel(false);
			}
		}catch (Exception e) {
			e.printStackTrace();
			return AjaxMsgModel.createfailModel(false);
		}
		return AjaxMsgModel.createSuccessModel(true);
	}
	
	//删除员工
	@ResponseBody
	@RequestMapping("/empDelete/{id}")
	public AjaxMsgModel DoDelete(@PathVariable("id")int emp){
		try{
				int row = empBiz.deleteById(emp);
				if(row <=0){
					return AjaxMsgModel.createfailModel(false);
	    	}
		}catch (Exception e) {
			e.printStackTrace();
			return AjaxMsgModel.createfailModel(false);
		}
		return AjaxMsgModel.createSuccessModel(true);
	}
 }
