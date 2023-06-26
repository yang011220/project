package com.oa.project.controller.lh;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.project.biz.lh.FriendBiz;
import com.oa.project.biz.lt.UserBiz;
import com.oa.project.entity.lh.Friend;
import com.oa.project.entity.lt.User;
import com.oa.project.entity.team.Team;
import com.oa.project.util.AjaxMsgModel;

@Controller
@RequestMapping("/friend")
public class FriendController {
	
	@Resource
	private FriendBiz friendBiz;
	
	@Resource
	private UserBiz userBiz;
	
	
	@RequestMapping("/preadd")
	public String preAdd(Model model)
	{
		List<User> userList = userBiz.findAll();
		model.addAttribute("userList", userList);
		return "/friend/preadd";
	}
	@ResponseBody
	@RequestMapping("/doadd")
	public AjaxMsgModel doAdd(Friend friend,HttpServletRequest request){
		try{
			friend.setUserId(((User)request.getSession().getAttribute("users")).getUserId());
			int row = friendBiz.save(friend);
			if(row <=0){
				return AjaxMsgModel.createfailModel(false);
			}
		}catch (Exception e) {
			return AjaxMsgModel.createfailModel(false);
		}
		return AjaxMsgModel.createSuccessModel(true);
		
	}
	
	@ResponseBody
	@RequestMapping("/delete/{id}")
	public AjaxMsgModel deleteMyfriend(@PathVariable("id")int friendId){
		try{
			int row = friendBiz.delete(friendId);
			if(row <=0){
				return AjaxMsgModel.createfailModel(false);
			}
		}catch (Exception e) {
			return AjaxMsgModel.createfailModel(false);
		}
		return AjaxMsgModel.createSuccessModel(true);
		
	}
	
	@RequestMapping("/findMyAllFriend")
	public String findAll(HttpServletRequest request,Model model){
		User users = (User)request.getSession().getAttribute("users");
		List<Friend> friendList = friendBiz.findAll(users);
		model.addAttribute("friendList", friendList);
		return "/friend/list";
	}
	
	
}
