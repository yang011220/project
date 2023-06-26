package com.oa.project.controller.hb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.project.biz.hb.CushistoryBiz;
import com.oa.project.biz.hb.CustomerBiz;
import com.oa.project.biz.lh.EmpBiz;
import com.oa.project.biz.team.TeamBiz;
import com.oa.project.entity.hb.Cushistory;
import com.oa.project.entity.hb.Customer;
import com.oa.project.entity.hb.EmpVO;
import com.oa.project.entity.lh.Emp;
import com.oa.project.entity.team.Team;
import com.oa.project.util.AjaxMsgModel;

@Controller
@RequestMapping("/cushistory")
public class CushistoryController {
	
	@Resource
	private CushistoryBiz cushistoryBiz;
	@Resource
	private TeamBiz teamBiz;
	@Resource
	private CustomerBiz customerBiz;
	@Resource
	private EmpBiz empBiz;
	
	@RequestMapping("/listAll")
	public String listAll(int pageNum,Model model){
		int totalCount=cushistoryBiz.findAll().size();
		List<Cushistory> list=cushistoryBiz.findAllLimit(pageNum);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		model.addAttribute("pageNum", pageNum);
		return "/crm/cushistory/list";
	}
	
	@RequestMapping("/listByteamId")
	public String listByteamId(HttpSession session,int pageNum,Model model){
		Team team=(Team)session.getAttribute("currentTeam");
		int totalCount=cushistoryBiz.findByteamId(team.getTeamId()).size();
		List<Cushistory> list=cushistoryBiz.findByteamIdLimit(team.getTeamId(),pageNum);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		model.addAttribute("pageNum", pageNum);
		return "/crm/cushistory/list2";
	}
	
	@RequestMapping("/listByempId")
	public String listByempId(HttpSession session,int pageNum,Model model){
		Emp emp=(Emp)session.getAttribute("currentEmp");
		int totalCount=cushistoryBiz.findByempId(emp.getEmpId()).size();
		List<Cushistory> list=cushistoryBiz.findByempIdLimit(emp.getEmpId(),pageNum);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		model.addAttribute("pageNum", pageNum);
		return "/crm/cushistory/list3";
	}
	
	@RequestMapping("/findById/{id}")
	public Cushistory findById(@PathVariable("id")int id){
		Cushistory cushistory=cushistoryBiz.findById(id);
		return cushistory;
	}
	
	@RequestMapping("/preAdd")
	public String preAdd(Model model){
		List<Team> teamlist=teamBiz.selectAll();
		List<Customer> customerlist=customerBiz.findAll();
		model.addAttribute("teamlist", teamlist);
		model.addAttribute("customerlist", customerlist);
		return "/crm/cushistory/add";
	}
	
	@RequestMapping("/preAdd2")
	public String preAdd2(HttpSession session,Model model){
		Team team=(Team)session.getAttribute("currentTeam");
		List<Emp> emplist=empBiz.findAll(team.getTeamId());
		List<Team> teamlist=teamBiz.selectAll();
		List<Customer> customerlist=customerBiz.findAll();
		model.addAttribute("team", team);
		model.addAttribute("emplist", emplist);
		model.addAttribute("teamlist", teamlist);
		model.addAttribute("customerlist", customerlist);
		return "/crm/cushistory/add2";
	}
	
	@RequestMapping("/preAdd3")
	public String preAdd3(HttpSession session,Model model){
		Team team=(Team)session.getAttribute("currentTeam");
		List<Emp> emplist=empBiz.findAll(team.getTeamId());
		List<Team> teamlist=teamBiz.selectAll();
		List<Customer> customerlist=customerBiz.findAll();
		model.addAttribute("team", team);
		model.addAttribute("emplist", emplist);
		model.addAttribute("teamlist", teamlist);
		model.addAttribute("customerlist", customerlist);
		return "/crm/cushistory/add3";
	}
	
	@ResponseBody
	@RequestMapping("/findEmplist")
	public List<EmpVO> findEmplistByTeam(int teamId){
		List<Emp> emplist=empBiz.findAll(teamId);
		List<EmpVO> list=new ArrayList<>();
		for(Emp emp:emplist){
			EmpVO empvo=new EmpVO();
			empvo.setEmpId(emp.getEmpId());
			empvo.setEmpName(emp.getEmpName());
			list.add(empvo);
		}
		return list;
	} 
	
	@ResponseBody
	@RequestMapping("/doAdd")
	public AjaxMsgModel doAdd(Cushistory cushistory,int teamId,int cusId,int empId){
		Team team=teamBiz.selectById(teamId);
		Customer customer=customerBiz.findById(cusId);
		Emp emp=empBiz.findById(empId);
		cushistory.setTeam(team);
		cushistory.setCustomer(customer);
		cushistory.setEmp(emp);
		int rows=cushistoryBiz.save(cushistory);
		if(rows>0){
			return AjaxMsgModel.createSuccessModel(true);
		}else{
			return AjaxMsgModel.createfailModel(false);
		}
	}
	
	@ResponseBody
	@RequestMapping("/doDelete/{id}")
	public AjaxMsgModel doDelete(@PathVariable("id")int id){
		int rows=cushistoryBiz.delete(id);
		if(rows>0){
			return AjaxMsgModel.createSuccessModel(true);
		}else{
			return AjaxMsgModel.createfailModel(false);
		}
	}
	
	@RequestMapping("/preUpdate/{id}")
	public String preUpdate(@PathVariable("id")int id,Model model){
		Cushistory cushistory=cushistoryBiz.findById(id);
		List<Team> teamlist=teamBiz.selectAll();
		List<Customer> customerlist=customerBiz.findAll();
		model.addAttribute("teamlist", teamlist);
		model.addAttribute("customerlist", customerlist);
		model.addAttribute("cushistory", cushistory);
		return "/crm/cushistory/update";
	}
	
	@RequestMapping("/preUpdate2")
	public String preUpdate2(HttpSession session,int historyId,Model model){
		Team team=(Team)session.getAttribute("currentTeam");
		List<Emp> emplist=empBiz.findAll(team.getTeamId());
		Cushistory cushistory=cushistoryBiz.findById(historyId);
		List<Customer> customerlist=customerBiz.findAll();
		model.addAttribute("team", team);
		model.addAttribute("emplist", emplist);
		model.addAttribute("customerlist", customerlist);
		model.addAttribute("cushistory", cushistory);
		return "/crm/cushistory/update2";
	}
	
	@RequestMapping("/preUpdate3")
	public String preUpdate3(HttpSession session,int historyId,Model model){
		Team team=(Team)session.getAttribute("currentTeam");
		List<Emp> emplist=empBiz.findAll(team.getTeamId());
		Cushistory cushistory=cushistoryBiz.findById(historyId);
		List<Customer> customerlist=customerBiz.findAll();
		model.addAttribute("team", team);
		model.addAttribute("emplist", emplist);
		model.addAttribute("customerlist", customerlist);
		model.addAttribute("cushistory", cushistory);
		return "/crm/cushistory/update3";
	}
	
	@ResponseBody
	@RequestMapping("/doUpdate")
	public AjaxMsgModel doUpdate(Cushistory cushistory,int teamId,int cusId,int empId){
		Team team=teamBiz.selectById(teamId);
		Customer customer=customerBiz.findById(cusId);
		Emp emp=empBiz.findById(empId);
		cushistory.setTeam(team);
		cushistory.setCustomer(customer);
		cushistory.setEmp(emp);
		int rows=cushistoryBiz.update(cushistory);
		if(rows>0){
			return AjaxMsgModel.createSuccessModel(true);
		}else{
			return AjaxMsgModel.createfailModel(false);
		}
	}
	
	@InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
                true));
    }
}
