package com.oa.project.controller.team;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.project.biz.team.ScaleBiz;
import com.oa.project.entity.team.Scale;
import com.oa.project.util.AjaxMsgModel;

@Controller
@RequestMapping("/team/scale")
public class ScaleController {
	@Resource
	private ScaleBiz scaleBiz;
	@RequestMapping("/presave")
	public String presave() {
		 return "/team/scale/add";
	}
	
	@ResponseBody
    @RequestMapping("/save")
    public AjaxMsgModel add(Scale scale) {
        try {
        	scaleBiz.save(scale);
        } catch (Exception e) {
            AjaxMsgModel.createfailModel(false);
        }
       return AjaxMsgModel.createSuccessModel(true);
    }
//	@RequestMapping("/save")
//	public String save(Scale scale) {
//		 scaleBiz.save(scale);
//		 return "redirect:/team/scale/list";
//	}
	@RequestMapping("/preupdate")
	public String preupdate(int id,Model model) {
		Scale scale=scaleBiz.selectById(id);
		model.addAttribute("scale", scale);
		 return "/team/scale/update";
	}
	@ResponseBody
    @RequestMapping("/update")
    public AjaxMsgModel update(Scale scale) {
        try {
        	scaleBiz.update(scale);
        } catch (Exception e) {
            AjaxMsgModel.createfailModel(false);
        }
       return AjaxMsgModel.createSuccessModel(true);
    }
//	@RequestMapping("/update")
//	public String update(Scale scale){
//		 scaleBiz.update(scale);
//		 return "redirect:/team/scale/list";
//	}
	@ResponseBody
    @RequestMapping("/delete")
    public AjaxMsgModel delete(int id) {
        try {
        	 scaleBiz.delete(id);
        } catch (Exception e) {
            AjaxMsgModel.createfailModel(false);
        }
       return AjaxMsgModel.createSuccessModel(true);
    }
//	@RequestMapping("/delete")
//	public String delete(int id){
//		 scaleBiz.delete(id);
//		 return "redirect:/team/scale/list";
//	}
	@RequestMapping("/selectById")
	public Scale selectById(int id){
		return scaleBiz.selectById(id);
	}
	@RequestMapping("/list")
	public String selectAll(Model model){
		List<Scale>list= scaleBiz.selectAll();
		model.addAttribute("list",list);
		return "/team/scale/list";
	}
	@ResponseBody
	@RequestMapping("/list2")
	public List<Scale> selectAll(){
		List<Scale>list= scaleBiz.selectAll();
		return list;
	}
	
}
