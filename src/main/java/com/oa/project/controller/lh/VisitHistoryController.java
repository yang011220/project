package com.oa.project.controller.lh;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.project.biz.hb.CustomerBiz;
import com.oa.project.biz.lh.VisitHistoryBiz;
import com.oa.project.entity.hb.Customer;
import com.oa.project.entity.lh.Emp;
import com.oa.project.entity.lh.VisitHistory;
import com.oa.project.util.AjaxMsgModel;

@Controller
@RequestMapping("/history")
public class VisitHistoryController {
	
	@Resource
	private VisitHistoryBiz visitHistoryBiz;
	
	@Resource
	private CustomerBiz customerBiz;
	
	@RequestMapping("/historyList")
	public String findAllhistory(Model model,HttpServletRequest request){
		Emp currentEmp =(Emp)request.getSession().getAttribute("currentEmp");
		List<VisitHistory> hisList = visitHistoryBiz.findAll(currentEmp);
		model.addAttribute("hisList", hisList);
		return "/visit/historylist";
	}
	
	//预添加拜访计划
		@RequestMapping("/historyPreAdd")
		public String PreAdd(HttpServletRequest request){
			Emp emp =(Emp)request.getSession().getAttribute("currentEmp");
			List<Customer> list=customerBiz.findAll();
			request.setAttribute("custList", list);
			request.setAttribute("currentEmp", emp);
			return "/visit/historypreadd";
		}
		
		//添加新员工
		@ResponseBody
		@RequestMapping("/historyDoAdd")
		public AjaxMsgModel DoAdd(VisitHistory visitHistory){
			try{
				int row = visitHistoryBiz.save(visitHistory);
				if(row <=0){
					return AjaxMsgModel.createfailModel(false);
				}
			}catch (Exception e) {
				return AjaxMsgModel.createfailModel(false);
			}
			return AjaxMsgModel.createSuccessModel(true);
		}
		
		//预修改计划
		@RequestMapping("/historyPreUpdate/{id}")
		public String PreUpdate(@PathVariable("id")int visitId,Model model,HttpServletRequest request){
			VisitHistory visitHistory = visitHistoryBiz.findById(visitId);
			List<Customer> custList = customerBiz.findByempId(visitHistory.getEmp().getEmpId());
			model.addAttribute("visitHistory", visitHistory);
			model.addAttribute("mycust", custList);
			return "/visit/historypreupdate";
		}
		
		//修改
		@ResponseBody
		@RequestMapping("/historyDoUpdate")
		public AjaxMsgModel DoUpdate(VisitHistory visitHistory){
			try{
				int row = visitHistoryBiz.update(visitHistory);
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
		@RequestMapping("/historyDelete/{id}")
		public AjaxMsgModel DoDelete(@PathVariable("id")int visitHistoryId){
			try{
				int row = visitHistoryBiz.delete(visitHistoryId);
				if(row <=0){
					return AjaxMsgModel.createfailModel(false);
				}
			}catch (Exception e) {
				e.printStackTrace();
				return AjaxMsgModel.createfailModel(false);
			}
			return AjaxMsgModel.createSuccessModel(true);
		}
	
		@InitBinder
	    public void initBinder(ServletRequestDataBinder binder){
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
	                true));
	    }

}
