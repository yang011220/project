package com.oa.project.controller.team;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.oa.project.biz.team.TeamType1Biz;
import com.oa.project.entity.team.Scale;
import com.oa.project.entity.team.Teamtype1;
import com.oa.project.util.AjaxMsgModel;;

@Controller
@RequestMapping("/team/type1")
public class TeamType1Controller {
	@Resource
	private TeamType1Biz teamType1Biz;
	@RequestMapping("/presave")
	public String presave() {
		 return "/team/type1/add";
	}
	@ResponseBody
    @RequestMapping("/save")
    public AjaxMsgModel add(Teamtype1 scale) {
        try {
        	teamType1Biz.save(scale);
        } catch (Exception e) {
            AjaxMsgModel.createfailModel(false);
        }
       return AjaxMsgModel.createSuccessModel(true);
    }
//	@RequestMapping("/save")
//	public String save(Teamtype1 scale) {
//		 teamType1Biz.save(scale);
//		 return "redirect:/team/type1/list";
//	}
	@RequestMapping("/preupdate")
	public String preupdate(int id,Model model) {
		Teamtype1 teamtype1=teamType1Biz.selectById(id);
		model.addAttribute("type1", teamtype1);
		 return "/team/type1/update";
	}
	@ResponseBody
    @RequestMapping("/update")
    public AjaxMsgModel update(Teamtype1 scale) {
        try {
        	teamType1Biz.update(scale);
        } catch (Exception e) {
            AjaxMsgModel.createfailModel(false);
        }
       return AjaxMsgModel.createSuccessModel(true);
    }
//	@RequestMapping("/update")
//	public String update(Teamtype1 scale){
//		 teamType1Biz.update(scale);
//		 return "redirect:/team/type1/list";
//	}
	@ResponseBody
    @RequestMapping("/delete")
    public AjaxMsgModel delete(int id) {
        try {
        	 teamType1Biz.delete(id);
        } catch (Exception e) {
            AjaxMsgModel.createfailModel(false);
        }
       return AjaxMsgModel.createSuccessModel(true);
    }
//	@RequestMapping("/delete")
//	public String delete(int id){
//		 teamType1Biz.delete(id);
//		 return "redirect:/team/type1/list";
//	}
	public Teamtype1 selectById(int id){
		return teamType1Biz.selectById(id);
	}
	@RequestMapping("/list")
	public String selectAll(Model model){
		List<Teamtype1>list= teamType1Biz.selectAll();
		model.addAttribute("list",list);
		return "/team/type1/list";
	}
	@ResponseBody
	@RequestMapping("/list2")
	public List<Teamtype1> selectAll(){
		List<Teamtype1>list= teamType1Biz.selectAll();
		return list;
	}
	
	
}
