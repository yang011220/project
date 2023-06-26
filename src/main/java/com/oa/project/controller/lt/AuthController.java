package com.oa.project.controller.lt;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.project.biz.lt.AuthBiz;
import com.oa.project.entity.lt.Auth;
import com.oa.project.util.AjaxMsgModel;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@Resource
	private AuthBiz authBiz;
	
	/**
	 * 预添加
	 * @return
	 */
	@RequestMapping("/preAdd")
	public String preAdd(){
		return "/auth/add";
	}
	/**
	 * 预修改
	 * @param authId
	 * @param model
	 * @return
	 */
	@RequestMapping("/preUpdate/{authId}")
	public String preUpdate(@PathVariable("authId")int authId,Model model){
		Auth auth=authBiz.findById(authId);
		model.addAttribute("auth",auth);
		return "/auth/update";
	}
	
	/**
	 * 修改
	 * @param auth
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
  public AjaxMsgModel add(Auth auth){
      try {
    	  int row=authBiz.save(auth);
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
	 * 修改权限信息
	 * @param auth
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
  public AjaxMsgModel update(Auth auth){
      try {
    		int row=authBiz.update(auth);
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
	 * 删除权限
	 * @param authId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete/{authId}")
	public AjaxMsgModel delete(@PathVariable("authId")int authId){
		try {
			int row=authBiz.delete(authId);
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
	 * 查看所有权限
	 * @param model
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model,int pageNum){
		int size=authBiz.findSize();
		List<Auth> authList=authBiz.findAllByPageNum(pageNum);
		model.addAttribute("authList",authList);
		model.addAttribute("totalPage",size);
		model.addAttribute("pageNum",pageNum);
		return "/auth/list";
	}
	
	
}
