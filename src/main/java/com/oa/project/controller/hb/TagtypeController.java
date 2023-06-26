package com.oa.project.controller.hb;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.project.biz.hb.TagtypeBiz;
import com.oa.project.entity.hb.Tagtype;
import com.oa.project.util.AjaxMsgModel;

@Controller
@RequestMapping("/tagtype")
public class TagtypeController {
	
	@Resource
	private TagtypeBiz tagtypeBiz;
	
	@RequestMapping("/list")
	public String list(Model model){
		List<Tagtype> list=tagtypeBiz.findAll();
		model.addAttribute("list", list);
		return "/crm/tagtype/list";
	}
	
	@RequestMapping("/findById/{id}")
	public Tagtype findById(@PathVariable("id")int id){
		return tagtypeBiz.findById(id);
	}
	
	@RequestMapping("/preAdd")
	public String preAdd(){
		return "/crm/tagtype/add";
	}
	
	@ResponseBody
	@RequestMapping("/doAdd")
	public AjaxMsgModel doAdd(Tagtype tagtype){
		int rows=tagtypeBiz.save(tagtype);
		if(rows>0){
			return AjaxMsgModel.createSuccessModel(true);
		}else{
			return AjaxMsgModel.createfailModel(false);
		}
	}
	
	@ResponseBody
	@RequestMapping("/doDelete/{id}")
	public AjaxMsgModel doDelete(@PathVariable("id")int id){
		int rows=tagtypeBiz.delete(id);
		if(rows>0){
			return AjaxMsgModel.createSuccessModel(true);
		}else{
			return AjaxMsgModel.createfailModel(false);
		}
	}
	
}
