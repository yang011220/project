package com.oa.project.controller.team;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oa.project.biz.team.TeamBiz;
import com.oa.project.entity.lt.User;
import com.oa.project.entity.team.Team;

@Controller
public class IndexController {
	@Resource
	private TeamBiz teamBiz;
	@RequestMapping("team/pipi/index")
	public String index(){
		return "/indexOld";
	}
	@RequestMapping("team/pipi/guanli")
	public String guanli(){
		return "/team/guanliyuan";
	}
	
}
