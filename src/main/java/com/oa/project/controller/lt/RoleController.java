package com.oa.project.controller.lt;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.project.biz.lt.AuthBiz;
import com.oa.project.biz.lt.RoleBiz;
import com.oa.project.entity.lt.Auth;
import com.oa.project.entity.lt.Role;
import com.oa.project.entity.lt.RoleAuths;
import com.oa.project.util.AjaxMsgModel;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Resource
	private RoleBiz roleBiz;
	
	@Resource
	private AuthBiz authBiz;
	
	/**
	 * 预添加角色
	 * @return
	 */
	@RequestMapping("/preAdd")
	public String preAdd(){
		return "/role/add";
	}
	/**
	 * 预修改角色
	 * @param roleId 用户id
	 * @param model 
	 * @return 
	 */
	@RequestMapping("/preUpdate/{roleId}")
	public String preUpdate(@PathVariable("roleId")int roleId,Model model){
		Role role=roleBiz.findById(roleId);
		model.addAttribute("role",role);
		return "/role/update";
	}
	
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public AjaxMsgModel add(Role role){
		try{
		int row=roleBiz.save(role);
		  if(row<=0){
        	  return AjaxMsgModel.createfailModel(false);
          }
      }catch (Exception e) {
          e.printStackTrace();
          return AjaxMsgModel.createfailModel(false);
      }
      return AjaxMsgModel.createSuccessModel(true);
	}
	
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public AjaxMsgModel update(Role role){
		try{
		int row=roleBiz.update(role);
		  if(row<=0){
        	  return AjaxMsgModel.createfailModel(false);
          }
      }catch (Exception e) {
          e.printStackTrace();
          return AjaxMsgModel.createfailModel(false);
      }
      return AjaxMsgModel.createSuccessModel(true);
	}
	
	/**
	 * 删除角色
	 * @param roleId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete/{roleId}")
	public AjaxMsgModel delete(@PathVariable("roleId")int roleId){
		try {
			int row=roleBiz.delete(roleId);
          if(row<=0){
        	  return AjaxMsgModel.createfailModel(false);
          }
      }catch (Exception e) {
          e.printStackTrace();
          return AjaxMsgModel.createfailModel(false);
      }
      return AjaxMsgModel.createSuccessModel(true);
	}
	
	/**
	 * 查询所有角色
	 * @param model
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model,int pageNum){
		int size=roleBiz.findSize();
		List<Role> roleList=roleBiz.findByPageNum(pageNum);
		model.addAttribute("roleList",roleList);
		model.addAttribute("totalPage",size);
		model.addAttribute("pageNum",pageNum);
		return "/role/list";
	}
	
	/**
	 * 给角色授权
	 * @param model
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/preAddAuth/{roleId}")
	public String preAddAuth(Model model,@PathVariable("roleId")int roleId){
		List<Auth> authList=authBiz.findAll();
		Role role=roleBiz.findById(roleId);
		model.addAttribute("authList",authList);
		model.addAttribute("role",role);
		return "/role/addAuth";
	}
	
	
	@ResponseBody
	@RequestMapping("/addAuth")
	public AjaxMsgModel addAuth(RoleAuths roleAuths){
		try {
			int row=roleBiz.saveAll(roleAuths);
          if(row<=0){
        	  return AjaxMsgModel.createfailModel(false);
          }
      }catch (Exception e) {
          e.printStackTrace();
          return AjaxMsgModel.createfailModel(false);
      }
      return AjaxMsgModel.createSuccessModel(true);
	}
	
	
	@RequestMapping("/preUpdateAuth/{roleId}")
	public String preUpdateAuth(Model model,@PathVariable("roleId")int roleId){
		Role role=roleBiz.findById(roleId);
		List<Auth> authList=authBiz.findAll();
		List<Auth> auths=roleBiz.findAllAuthByRoleId(roleId);
		model.addAttribute("authList",authList);
		model.addAttribute("role",role);
		model.addAttribute("auths",auths);
		return "/role/addAuth";
	}
	
	
	@ResponseBody
	@RequestMapping("/updateAuth")
	public AjaxMsgModel updateAuth(Role role,int [] authId){
		try {
			int row=roleBiz.updateAuth(role,authId);
			
          if(row<=0){
        	  return AjaxMsgModel.createfailModel(false);
          }
      }catch (Exception e) {
          e.printStackTrace();
          return AjaxMsgModel.createfailModel(false);
      }
      return AjaxMsgModel.createSuccessModel(true);
	}
	
	
}
