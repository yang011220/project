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
import com.oa.project.biz.lh.VisitPlanBiz;
import com.oa.project.entity.hb.Customer;
import com.oa.project.entity.lh.Emp;
import com.oa.project.entity.lh.VisitPlan;
import com.oa.project.util.AjaxMsgModel;

@Controller
@RequestMapping("/plan")
public class VisitPlanController {
	@Resource
	private VisitPlanBiz visitPlanBiz;
	
	@Resource
	private CustomerBiz customerBiz;
	
	@RequestMapping("/planList")
	public String findAllPlan(Model model,HttpServletRequest request){
		Emp currentEmp =(Emp)request.getSession().getAttribute("currentEmp");
		List<VisitPlan> planList = visitPlanBiz.findAll(currentEmp);
		model.addAttribute("planList", planList);
		return "/visit/planlist";
	}
	
	//预添加拜访计划
		@RequestMapping("/planPreAdd")
		public String PreAdd(HttpServletRequest request){
			Emp emp =(Emp)request.getSession().getAttribute("currentEmp");
			List<Customer> list=customerBiz.findAll();
			request.setAttribute("custList", list);
			request.setAttribute("currentEmp", emp);
			return "/visit/planpreadd";
		}
		
		//添加新员工
		@ResponseBody
		@RequestMapping("/planDoAdd")
		public AjaxMsgModel DoAdd(VisitPlan visitPlan){
			try{
				int row = visitPlanBiz.save(visitPlan);
				if(row <=0){
					return AjaxMsgModel.createfailModel(false);
				}
			}catch (Exception e) {
				return AjaxMsgModel.createfailModel(false);
			}
			return AjaxMsgModel.createSuccessModel(true);
		}
		
		//预修改计划
		@RequestMapping("/planPreUpdate/{id}")
		public String PreUpdate(@PathVariable("id")int visitId,HttpServletRequest request){
			VisitPlan visitPlan = visitPlanBiz.findById(visitId);
			List<Customer> cust = customerBiz.findByempId(visitPlan.getEmp().getEmpId());
			request.setAttribute("visitPlan", visitPlan);
			request.setAttribute("mycust", cust);
			
			return "/visit/planpreupdate";
		}
		
		//修改
		@ResponseBody
		@RequestMapping("/planDoUpdate")
		public AjaxMsgModel DoUpdate(VisitPlan visitPlan){
			try{
				int row = visitPlanBiz.update(visitPlan);
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
		@RequestMapping("/planDelete/{id}")
		public AjaxMsgModel DoDelete(@PathVariable("id")int visitPlanId){
			try{
				int row = visitPlanBiz.delete(visitPlanId);
				if(row <=0){
					return AjaxMsgModel.createfailModel(false);
				}
			}catch (Exception e) {
				e.printStackTrace();
				return AjaxMsgModel.createfailModel(false);
			}
			return AjaxMsgModel.createSuccessModel(true);
		}
		
		//批量删除员工
				@ResponseBody
				@RequestMapping("/planBatchDelete/{id}")
				public AjaxMsgModel DoBatchDelete(@PathVariable("id")int[] visitPlanId){
					try{
						for(int i:visitPlanId){
							int row = visitPlanBiz.delete(i);
							if(row <=0){
								return AjaxMsgModel.createfailModel(false);
							}
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
