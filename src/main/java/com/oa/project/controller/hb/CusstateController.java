package com.oa.project.controller.hb;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.project.biz.hb.CusstateBiz;
import com.oa.project.entity.hb.Cusstate;
import com.oa.project.util.AjaxMsgModel;

@Controller
@RequestMapping("/cusstate")
public class CusstateController {
	
	@Resource
	private CusstateBiz cusstateBiz;
	
	@RequestMapping("/list")
	public String list(Model model){
		List<Cusstate> list=cusstateBiz.findAll();
		model.addAttribute("list", list);
		return "/crm/cusstate/list";
	}
	
	@RequestMapping("/findById/{id}")
	public Cusstate findById(@PathVariable("id")int id){
		return cusstateBiz.findById(id);
	}
	
	@RequestMapping("/preAdd")
	public String preAdd(){
		return "/crm/cusstate/add";
	}
	
	@ResponseBody
	@RequestMapping("/doAdd")
	public AjaxMsgModel doAdd(Cusstate custate){
		int rows=cusstateBiz.save(custate);
		if(rows>0){
			return AjaxMsgModel.createSuccessModel(true);
		}else{
			return AjaxMsgModel.createfailModel(false);
		}
	}
	
	@ResponseBody
	@RequestMapping("/doDelete/{id}")
	public AjaxMsgModel doDelete(@PathVariable("id")int id){
		int rows=cusstateBiz.delete(id);
		if(rows>0){
			return AjaxMsgModel.createSuccessModel(true);
		}else{
			return AjaxMsgModel.createfailModel(false);
		}
	}
	
}
