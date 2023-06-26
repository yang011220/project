package com.oa.project.controller.hb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.project.biz.hb.CusstateBiz;
import com.oa.project.biz.hb.CustagBiz;
import com.oa.project.biz.hb.CustomerBiz;
import com.oa.project.biz.hb.CustypeBiz;
import com.oa.project.biz.hb.TagtypeBiz;
import com.oa.project.biz.lh.EmpBiz;
import com.oa.project.biz.team.TeamBiz;
import com.oa.project.entity.hb.Cusstate;
import com.oa.project.entity.hb.Custag;
import com.oa.project.entity.hb.Customer;
import com.oa.project.entity.hb.CustomerVO;
import com.oa.project.entity.hb.Custype;
import com.oa.project.entity.hb.EmpVO;
import com.oa.project.entity.lh.Emp;
import com.oa.project.entity.team.Team;
import com.oa.project.util.AjaxMsgModel;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Resource
	private CustomerBiz customerBiz;
	@Resource
	private CustypeBiz custypeBiz;
	@Resource
	private CustagBiz custagBiz;
	@Resource 
	private CusstateBiz cusstateBiz;
	@Resource
	private EmpBiz empBiz;
	@Resource
	private TeamBiz teamBiz;
	@Resource
	private TagtypeBiz tagtypeBiz;
	
	@RequestMapping("/findEmp")
	public String findEmp(HttpSession session,Model model){
		Team team=(Team)session.getAttribute("currentTeam");
		List<Emp> list=empBiz.findAll(team.getTeamId());
		model.addAttribute("list", list);
		return "/crm/customer/listemp";
	}
	
	
	@RequestMapping("/listAll")
	public String listAll2(Model model,int pageNum){
		int totalCount=customerBiz.findAll().size();
		List<Customer> list=customerBiz.findAllLimit(pageNum);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		return "/crm/customer/list";
	}
	
	@RequestMapping("/listByteamId")
	public String listByteamId(HttpSession session,int pageNum,Model model){
		Team team=(Team)session.getAttribute("currentTeam");
		int totalCount=customerBiz.findByteamId(team.getTeamId()).size();
		List<Customer> list=customerBiz.findByteamIdLimit(team.getTeamId(),pageNum);
		model.addAttribute("list", list);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageNum", pageNum);
		return "/crm/customer/list3";
	}
	
	@RequestMapping("/listByempId")
	public String listByempId(HttpSession session,int pageNum,Model model){
		Emp emp=(Emp)session.getAttribute("currentEmp");
		int totalCount=customerBiz.findByempId(emp.getEmpId()).size();
		List<Customer> list=customerBiz.findByempIdLimit(pageNum,emp.getEmpId());
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("list", list);
		return "/crm/customer/list2";
	}
	
	@RequestMapping("/findById/{id}")
	public Customer findById(@PathVariable("id")int id){
		Customer customer=customerBiz.findById(id);
		return customer;
	}
	
	@RequestMapping("/preAdd")
	public String preAdd(Model model){
		List<Custype> typelist =custypeBiz.findAll();
		List<Custag> taglist=custagBiz.findAll();
		List<Cusstate> statelist=cusstateBiz.findAll();
		List<Team> teamlist=teamBiz.selectAll();
		model.addAttribute("typelist", typelist);
		model.addAttribute("taglist", taglist);
		model.addAttribute("statelist", statelist);
		model.addAttribute("teamlist", teamlist);
		return "/crm/customer/add";
	}
	
	@RequestMapping("/preAdd2")
	public String preAdd2(HttpSession session,Model model){
		Team team=(Team)session.getAttribute("currentTeam");
		List<Emp> emplist=empBiz.findAll(team.getTeamId());
		List<Custype> typelist =custypeBiz.findAll();
		List<Custag> taglist=custagBiz.findAll();
		List<Cusstate> statelist=cusstateBiz.findAll();
		model.addAttribute("team", team);
		model.addAttribute("emplist", emplist);
		model.addAttribute("typelist", typelist);
		model.addAttribute("taglist", taglist);
		model.addAttribute("statelist", statelist);
		return "/crm/customer/add2";
	}
	
	@RequestMapping("/preAdd3")
	public String preAdd3(HttpSession session,Model model){
		Team team=(Team)session.getAttribute("currentTeam");
		List<Emp> emplist=empBiz.findAll(team.getTeamId());
		List<Custype> typelist =custypeBiz.findAll();
		List<Custag> taglist=custagBiz.findAll();
		List<Cusstate> statelist=cusstateBiz.findAll();
		model.addAttribute("team", team);
		model.addAttribute("emplist", emplist);
		model.addAttribute("typelist", typelist);
		model.addAttribute("taglist", taglist);
		model.addAttribute("statelist", statelist);
		return "/crm/customer/add3";
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
	public AjaxMsgModel doAdd(CustomerVO customerVO){
		Emp emp=empBiz.findById(customerVO.getEmpId());
		Custype custype=custypeBiz.findById(customerVO.getCusTypeId());
		Cusstate cusstate=cusstateBiz.findById(customerVO.getStateId());
		Custag custag=custagBiz.findById(customerVO.getTagId());
		Customer customer=new Customer();
		customer.setCusAge(customerVO.getCusAge());
		customer.setCusCompany(customerVO.getCusCompany());
		customer.setCusName(customerVO.getCusName());
		customer.setCusLocation(customerVO.getCusLocation());
		customer.setCusPosition(customerVO.getCusPosition());
		customer.setTeamId(customerVO.getTeamId());
		customer.setTel(customerVO.getTel());
		customer.setEmp(emp);
		customer.setCustype(custype);
		customer.setCusstate(cusstate);
		customer.setCustag(custag);
		int rows=customerBiz.save(customer);
		if(rows>0){
			return AjaxMsgModel.createSuccessModel(true);
		}else{
			return AjaxMsgModel.createfailModel(false);
		}
	}
	
	@ResponseBody
	@RequestMapping("/doDelete/{id}")
	public AjaxMsgModel doDelete(@PathVariable("id")int id){
		int rows=customerBiz.deleteById(id);
		if(rows>0){
			return AjaxMsgModel.createSuccessModel(true);
		}else{
			return AjaxMsgModel.createfailModel(false);
		}
	}
	
	@RequestMapping("/preUpdate/{id}")
	public String preUpdate(@PathVariable("id")int id,Model model){
		Customer customer=customerBiz.findById(id);
		Team team=teamBiz.selectById(customer.getTeamId());
		List<Custype> typelist =custypeBiz.findAll();
		List<Custag> taglist=custagBiz.findAll();
		List<Cusstate> statelist=cusstateBiz.findAll();
		List<Team> teamlist=teamBiz.selectAll();
		model.addAttribute("team", team);
		model.addAttribute("customer", customer);
		model.addAttribute("typelist", typelist);
		model.addAttribute("taglist", taglist);
		model.addAttribute("statelist", statelist);
		model.addAttribute("teamlist", teamlist);
		return "/crm/customer/update";
	}
	
	@RequestMapping("/preUpdate2")
	public String preUpdate2(HttpSession session,int cusId,Model model){
		Team team=(Team)session.getAttribute("currentTeam");
		List<Emp> emplist=empBiz.findAll(team.getTeamId());
		Customer customer=customerBiz.findById(cusId);
		List<Custype> typelist =custypeBiz.findAll();
		List<Custag> taglist=custagBiz.findAll();
		List<Cusstate> statelist=cusstateBiz.findAll();
		model.addAttribute("team", team);
		model.addAttribute("emplist", emplist);
		model.addAttribute("customer", customer);
		model.addAttribute("typelist", typelist);
		model.addAttribute("taglist", taglist);
		model.addAttribute("statelist", statelist);
		return "/crm/customer/update2";
	}
	
	@RequestMapping("/preUpdate3")
	public String preUpdate3(HttpSession session,int cusId,Model model){
		Team team=(Team)session.getAttribute("currentTeam");
		List<Emp> emplist=empBiz.findAll(team.getTeamId());
		Customer customer=customerBiz.findById(cusId);
		List<Custype> typelist =custypeBiz.findAll();
		List<Custag> taglist=custagBiz.findAll();
		List<Cusstate> statelist=cusstateBiz.findAll();
		model.addAttribute("team", team);
		model.addAttribute("emplist", emplist);
		model.addAttribute("customer", customer);
		model.addAttribute("typelist", typelist);
		model.addAttribute("taglist", taglist);
		model.addAttribute("statelist", statelist);
		return "/crm/customer/update3";
	}
	
	@ResponseBody
	@RequestMapping("/doUpdate")
	public AjaxMsgModel doUpdate(CustomerVO customerVO){
		Emp emp=empBiz.findById(customerVO.getEmpId());
		Custype custype=custypeBiz.findById(customerVO.getCusTypeId());
		Cusstate cusstate=cusstateBiz.findById(customerVO.getStateId());
		Custag custag=custagBiz.findById(customerVO.getTagId());
		Customer customer=new Customer();
		customer.setCusId(customerVO.getCusId());
		customer.setCusAge(customerVO.getCusAge());
		customer.setCusCompany(customerVO.getCusCompany());
		customer.setCusName(customerVO.getCusName());
		customer.setCusLocation(customerVO.getCusLocation());
		customer.setCusPosition(customerVO.getCusPosition());
		customer.setTeamId(customerVO.getTeamId());
		customer.setTel(customerVO.getTel());
		customer.setEmp(emp);
		customer.setCustype(custype);
		customer.setCusstate(cusstate);
		customer.setCustag(custag);
		int rows=customerBiz.update(customer);
		if(rows>0){
			return AjaxMsgModel.createSuccessModel(true);
		}else{
			return AjaxMsgModel.createfailModel(false);
		}
	}
	
}
