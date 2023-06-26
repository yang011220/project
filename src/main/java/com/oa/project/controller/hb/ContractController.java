package com.oa.project.controller.hb;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.oa.project.biz.hb.ContractBiz;
import com.oa.project.biz.hb.CustomerBiz;
import com.oa.project.biz.lh.EmpBiz;
import com.oa.project.biz.team.TeamBiz;
import com.oa.project.entity.hb.Contract;
import com.oa.project.entity.hb.Customer;
import com.oa.project.entity.hb.EmpVO;
import com.oa.project.entity.lh.Emp;
import com.oa.project.entity.team.Team;
import com.oa.project.util.AjaxMsgModel;
import com.oa.project.util.Constants;

@Controller
@RequestMapping("/contract")
public class ContractController {
	
	@Resource
	private ContractBiz contractBiz;
	@Resource
	private EmpBiz empBiz;
	@Resource
	private TeamBiz teamBiz;
	@Resource
	private CustomerBiz customerBiz;
	
	@RequestMapping("/listAll")
	public String listAll(Model model,int pageNum){
		List<Contract> conlist=contractBiz.findAll();
		int totalCount=conlist.size();
		List<Contract> list=contractBiz.findAllLimit(pageNum);
		model.addAttribute("list", list);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageNum", pageNum);
		return "/crm/contract/list";
	}
	
	@RequestMapping("/listByteamId")
	public String listByteamId(HttpSession session,int pageNum,Model model){
		Team team=(Team)session.getAttribute("currentTeam");
		int totalCount=contractBiz.findByteamId(team.getTeamId()).size();
		List<Contract> list=contractBiz.findByteamIdLimit(team.getTeamId(),pageNum);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("list", list);
		return "/crm/contract/list2";
	}
	
	@RequestMapping("/listByempId")
	public String listByempId(HttpSession session,int pageNum,Model model){
		Emp emp=(Emp)session.getAttribute("currentEmp");
		int totalCount=contractBiz.findByempId(emp.getEmpId()).size();
		List<Contract> list=contractBiz.findByempIdLimit(emp.getEmpId(),pageNum);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		model.addAttribute("pageNum", pageNum);
		return "/crm/contract/list3";
	}
	
	@RequestMapping("/findById/{id}")
	public Contract listById(@PathVariable("id")int Id){
		Contract contract=contractBiz.findById(Id);
		return contract;
	}
	
	@RequestMapping("/preAdd")
	public String preAdd(Model model){
		List<Team> teamlist=teamBiz.selectAll();
		List<Customer> customerlist=customerBiz.findAll();
		model.addAttribute("teamlist", teamlist);
		model.addAttribute("customerlist", customerlist);
		return "/crm/contract/add";
	}
	
	@RequestMapping("/preAdd2")
	public String preAdd2(HttpSession session,Model model){
		Team team=(Team)session.getAttribute("currentTeam");
		List<Emp> emplist=empBiz.findAll(team.getTeamId());
		List<Customer> customerlist=customerBiz.findAll();
		model.addAttribute("team", team);
		model.addAttribute("customerlist", customerlist);
		model.addAttribute("emplist", emplist);
		return "/crm/contract/add2";
	}
	
	@RequestMapping("/preAdd3")
	public String preAdd3(HttpSession session,Model model){
		Team team=(Team)session.getAttribute("currentTeam");
		List<Emp> emplist=empBiz.findAll(team.getTeamId());
		List<Customer> customerlist=customerBiz.findAll();
		model.addAttribute("team", team);
		model.addAttribute("customerlist", customerlist);
		model.addAttribute("emplist", emplist);
		return "/crm/contract/add3";
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
	public AjaxMsgModel doAdd(Contract contract,int teamId,int cusId,int empId, MultipartHttpServletRequest request){
		String fileName = UUID.randomUUID().toString();
		MultipartFile file = request.getFile("file");
		File newFile = new File(Constants.IMAGE_PATH + fileName);
		try {
			file.transferTo(newFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		Team team=teamBiz.selectById(teamId);
		Customer customer=customerBiz.findById(cusId);
		Emp emp=empBiz.findById(empId);
		contract.setCustomer(customer);
		contract.setEmp(emp);
		contract.setTeam(team);
		contract.setPicPath(fileName);
		int rows=contractBiz.save(contract);
		if(rows>0){
			return AjaxMsgModel.createSuccessModel(true);
		}else{
			return AjaxMsgModel.createfailModel(false);
		}
	}
	
	@ResponseBody
	@RequestMapping("/doDelete/{id}")
	public AjaxMsgModel doDelete(@PathVariable("id")int id){
		int rows=contractBiz.delete(id);
		if(rows>0){
			return AjaxMsgModel.createSuccessModel(true);
		}else{
			return AjaxMsgModel.createfailModel(false);
		}
	}
	
	@RequestMapping("/preUpdate/{id}")
	public String preUpdate(@PathVariable("id")int id,Model model){
		Contract contract=contractBiz.findById(id);
		List<Team> teamlist=teamBiz.selectAll();
		List<Customer> customerlist=customerBiz.findAll();
		model.addAttribute("teamlist", teamlist);
		model.addAttribute("customerlist", customerlist);
		model.addAttribute("contract", contract);
		return "/crm/contract/update";
	}
	
	@RequestMapping("/preUpdate2")
	public String preUpdate2(HttpSession session,int contractId,Model model){
		Team team=(Team)session.getAttribute("currentTeam");
		Contract contract=contractBiz.findById(contractId);
		List<Emp> emplist=empBiz.findAll(team.getTeamId());
		List<Customer> customerlist=customerBiz.findAll();
		model.addAttribute("team", team);
		model.addAttribute("emplist", emplist);
		model.addAttribute("customerlist", customerlist);
		model.addAttribute("contract", contract);
		return "/crm/contract/update2";
	}
	
	@RequestMapping("/preUpdate3")
	public String preUpdate3(HttpSession session,int contractId,Model model){
		Team team=(Team)session.getAttribute("currentTeam");
		Contract contract=contractBiz.findById(contractId);
		List<Emp> emplist=empBiz.findAll(team.getTeamId());
		List<Customer> customerlist=customerBiz.findAll();
		model.addAttribute("team", team);
		model.addAttribute("emplist", emplist);
		model.addAttribute("customerlist", customerlist);
		model.addAttribute("contract", contract);
		return "/crm/contract/update3";
	}
	
	@ResponseBody
	@RequestMapping("/doUpdate")
	public AjaxMsgModel doUpdate(Contract contract,int teamId,int cusId,int empId, MultipartHttpServletRequest request){
		MultipartFile file = request.getFile("file");
		if(!file.isEmpty()){
		String fileName = UUID.randomUUID().toString();
		File newFile = new File(Constants.IMAGE_PATH + fileName);
		try {
			file.transferTo(newFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		contract.setPicPath(fileName);
		}
		Team team=teamBiz.selectById(teamId);
		Customer customer=customerBiz.findById(cusId);
		Emp emp=empBiz.findById(empId);
		contract.setCustomer(customer);
		contract.setEmp(emp);
		contract.setTeam(team);
		
		int rows=contractBiz.update(contract);
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
