package com.oa.project.controller.hb;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.project.biz.hb.CustagBiz;
import com.oa.project.biz.hb.TagtypeBiz;
import com.oa.project.entity.hb.Custag;
import com.oa.project.entity.hb.Tagtype;
import com.oa.project.util.AjaxMsgModel;

@Controller
@RequestMapping("/custag")
public class CustagController {
	
	@Resource
	private CustagBiz custagBiz;
	@Resource
	private TagtypeBiz tagtypeBiz;
	
	@RequestMapping("/list")
	public String list(Model model){
		List<Custag> list=custagBiz.findAll();
		model.addAttribute("list", list);
		return "/crm/custag/list";
	}
	
	@RequestMapping("/findById/{id}")
	public Custag findById(@PathVariable("id")int id){
		return custagBiz.findById(id);
	}
	
	@RequestMapping("/preAdd")
	public String preAdd(Model model){
		List<Tagtype> list=tagtypeBiz.findAll();
		model.addAttribute("list", list);
		return "/crm/custag/add";
	}
	
	@ResponseBody
	@RequestMapping("/doAdd")
	public AjaxMsgModel doAdd(Custag custag,int tagtypeId){
		Tagtype tagtype=tagtypeBiz.findById(tagtypeId);
		custag.setTagtype(tagtype);
		int rows=custagBiz.save(custag);
		if(rows>0){
			return AjaxMsgModel.createSuccessModel(true);
		}else{
			return AjaxMsgModel.createfailModel(false);
		}
	}
	
	@ResponseBody
	@RequestMapping("/doDelete/{id}")
	public AjaxMsgModel doDelete(@PathVariable("id")int id){
		int rows=custagBiz.delete(id);
		if(rows>0){
			return AjaxMsgModel.createSuccessModel(true);
		}else{
			return AjaxMsgModel.createfailModel(false);
		}
	}
	
}
