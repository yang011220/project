package com.oa.project.controller.hb;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.project.biz.hb.CustypeBiz;
import com.oa.project.entity.hb.Custype;
import com.oa.project.util.AjaxMsgModel;

@Controller
@RequestMapping("/custype")
public class CustypeController {
	
	@Resource
	private CustypeBiz custypeBiz;
	
	@RequestMapping("/list")
	public String list(Model model){
		List<Custype> list=custypeBiz.findAll();
		model.addAttribute("list", list);
		return "/crm/custype/list";
	}
	
	@RequestMapping("/findById/{id}")
	public Custype findById(@PathVariable("id")int id){
		return custypeBiz.findById(id);
	}
	
	@RequestMapping("/preAdd")
	public String preAdd(){
		return "/crm/custype/add";
	}
	
	@ResponseBody
	@RequestMapping("/doAdd")
	public AjaxMsgModel doAdd(Custype custype){
		int rows=custypeBiz.save(custype);
		if(rows>0){
			return AjaxMsgModel.createSuccessModel(true);
		}else{
			return AjaxMsgModel.createfailModel(false);
		}
	}
	
	@ResponseBody
	@RequestMapping("/doDelete/{id}")
	public AjaxMsgModel doDelete(@PathVariable("id")int id){
		int rows=custypeBiz.delete(id);
		if(rows>0){
			return AjaxMsgModel.createSuccessModel(true);
		}else{
			return AjaxMsgModel.createfailModel(false);
		}
	}
	
	@ResponseBody
	@RequestMapping("/doUpdate")
	public AjaxMsgModel doUpdate(Custype custype){
		int rows=custypeBiz.update(custype);
		if(rows>0){
			return AjaxMsgModel.createSuccessModel(true);
		}else{
			return AjaxMsgModel.createfailModel(false);
		}
	}
}
