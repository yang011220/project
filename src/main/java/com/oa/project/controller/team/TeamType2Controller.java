package com.oa.project.controller.team;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.project.biz.team.TeamType1Biz;
import com.oa.project.biz.team.TeamType2Biz;
import com.oa.project.entity.team.Team;
import com.oa.project.entity.team.Teamtype1;
import com.oa.project.entity.team.Teamtype2;
import com.oa.project.entity.team.vo.TeamType1Vo;

import com.oa.project.util.AjaxMsgModel;


@Controller
@RequestMapping("/team/type2")
public class TeamType2Controller {
	@Resource
	private TeamType2Biz teamtype2Biz;
	@Resource
	private TeamType1Biz teamtype1Biz;
	@RequestMapping("/presave")
	public String presave(Model model) {
		List<Teamtype1>list=teamtype1Biz.selectAll();
		model.addAttribute("type1List",list);
		 return "/team/type2/add";
	}
	@ResponseBody
    @RequestMapping("/save")
    public AjaxMsgModel add(Teamtype2 scale) {
        try {
        	 teamtype2Biz.save(scale);
        } catch (Exception e) {
            AjaxMsgModel.createfailModel(false);
        }
       return AjaxMsgModel.createSuccessModel(true);
    }
//	@RequestMapping("/save")
//	public String save(Teamtype2 scale) {
//		 teamtype2Biz.save(scale);
//		 return "redirect:/team/type2/list";
//	}
	@RequestMapping("/preupdate")
	public String preupdate(int id,Model model) {
		List<Teamtype1>list=teamtype1Biz.selectAll();
		model.addAttribute("type1List",list);
		Teamtype2 teamtype2=teamtype2Biz.selectById(id);
		model.addAttribute("type2", teamtype2);
		 return "/team/type2/update";
	}
	@ResponseBody
    @RequestMapping("/update")
    public AjaxMsgModel update(Teamtype2 scale) {
        try {
        	 teamtype2Biz.update(scale);
        } catch (Exception e) {
            AjaxMsgModel.createfailModel(false);
        }
       return AjaxMsgModel.createSuccessModel(true);
    }
//	@RequestMapping("/update")
//	public String update(Teamtype2 scale){
//		 teamtype2Biz.update(scale);
//		 return "redirect:/team/type2/list";
//	}
	@ResponseBody
    @RequestMapping("/delete")
    public AjaxMsgModel delete(int id) {
        try {
        	 teamtype2Biz.delete(id);
        } catch (Exception e) {
            AjaxMsgModel.createfailModel(false);
        }
       return AjaxMsgModel.createSuccessModel(true);
    }
//	@RequestMapping("/delete")
//	public String delete(int id){
//		 teamtype2Biz.delete(id);
//		 return "redirect:/team/type2/list";
//	}
	public Teamtype2 selectById(int id){
		return teamtype2Biz.selectById(id);
	}
	@RequestMapping("/list")
	public String selectAll(Model model,int pageNum){
		List<TeamType1Vo>list=teamtype1Biz.selectType1Vo();
		int size=teamtype2Biz.selectAll().size();
		List<Teamtype2>listLimit= teamtype2Biz.selectAllLimit(pageNum);
		model.addAttribute("list",list);
		model.addAttribute("totalCount",size);
		model.addAttribute("pageNum",pageNum);
		return "/team/type2/list";
	}
//	获取所有小类行业
	@ResponseBody
	@RequestMapping("/list2")
	public List<Teamtype2> selectAll(){
		List<Teamtype2>list= teamtype2Biz.selectAll();
		return list;
	}
//	获取某个大类下所有小类行业
	@ResponseBody
	@RequestMapping("/type1Id")
	public List<Teamtype2> selectByType1Id(int id){
		List<Teamtype2>list= teamtype2Biz.selectByType1Id(id);
		return list;
	}
//	将大类下的小类的集合作为Teamtype2Vo的list属性，大类对应的名称为其name属性，
//	@ResponseBody
//	@RequestMapping("/listVo")
//	public List<Teamtype2Vo> selectAllppp(){
//		List<TeamType1Vo> list = type2Make();
//		return list;
//	}

	
	
	
}
