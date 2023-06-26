package com.oa.project.controller.lt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.project.biz.lt.AuthBiz;
import com.oa.project.biz.lt.UserBiz;
import com.oa.project.entity.lt.Auth;
import com.oa.project.entity.lt.User;
import com.oa.project.entity.lt.UserAuths;
import com.oa.project.util.AjaxMsgModel;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserBiz userBiz; 
	@Resource
	private AuthBiz authBiz;
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/register")
	public String register(User user){
		String salt="ql20ur#&dsx$od";
		String md5=new Md5Hash(user.getUserPwd(),salt).toString();
		user.setUserPwd(md5);
		user.setSalt(salt);
		int result=userBiz.save(user);
		String str=null;
		if(result>0){
			str="success";
		}else{
			str="false";
		}
		return str;
	}
	
	
	/**
	 * 预注册
	 * @return
	 */
	@RequestMapping("/preRegister")
	public String preRegister(){
		return "user/register";
	}
	
	/**
	 * 预登陆
	 * 注销的时候清空缓存
	 * @param session
	 * @return
	 */
	@RequestMapping("preLogin")
	public String preLogin(HttpSession session){
//		User user=(User)session.getAttribute("user");
//		if(user!=null){
//			session.invalidate();
//		}
		session.removeAttribute("users");
		session.removeAttribute("currentEmp");
		session.removeAttribute("currentTeam");
		return "user/login";
	}
	
	@RequestMapping("ltindex")
	public String index(){
		return "user/ltindex";
	}
	
	@RequestMapping("/listOne")
	public String listOne(Model model,HttpSession session){
		User user=(User)session.getAttribute("users");
		model.addAttribute("user",user);
		return "/user/listOne";
	}
	
	
	
	/**
	 * 使用shiro验证登录
	 * @param user
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login")
	@RequiresRoles("普通用户")
    public String login(User user,HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getUserPwd()) ;
        try {
            subject.login(token);
            User users=userBiz.findUserByUsername(user.getUserName());
            request.getSession().setAttribute("users",users);
            return "success";
        }catch (Exception e){
            //这里将异常打印关闭是因为如果登录失败的话会自动抛异常
           e.printStackTrace();
            return "false" ;
        }
    }
	
	
//	@ResponseBody
//    @RequestMapping("/login1")
//    public AjaxMsgModel login1(User user,HttpServletRequest request) {
//		Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getUserPwd()) ;
//        try {
//        	subject.login(token);
//            User users=userBiz.findUserByUsername(user.getUserName());
//            request.getSession().setAttribute("users",users);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return AjaxMsgModel.createfailModel(false);
//        }
//        return AjaxMsgModel.createSuccessModel(true);
//    }

	@RequestMapping("/preIndex")
	public String preIndex(String userName){
		return "/index";
	}

	/**
	 * 查看用户列表
	 * @param model
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model,int pageNum){
		int size=userBiz.findSize();
		List<User> userList=userBiz.findAll(pageNum);
		model.addAttribute("userList",userList);
		model.addAttribute("totalPage",size);
		model.addAttribute("pageNum",pageNum);
		return "/user/list";
	}
	
	
	
	/**
	 * 预修改
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping("/preUpdate/{userId}")
	public String preUpdate(Model model,@PathVariable("userId")int userId){
		User user=userBiz.findByUserId(userId);
		model.addAttribute("user",user);
		return "/user/update";
	}
	
	/**
	 * 修改用户基本信息
	 * @param user
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
  public AjaxMsgModel update(Model model,User users,HttpServletRequest request){
		String birth=request.getParameter("birth");
		if(birth!=null && birth.length()!=0){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date birthday=null;
			try{
				birthday=sdf.parse(birth);
			}catch (Exception e) {
				e.printStackTrace();
			}
			users.setBirthday(birthday);
			users.setUpdateTime(new Date());
		}
      try {
          int row=userBiz.update(users);
//          User user=userBiz.findUserByUsername(users.getUserName());
//          model.addAttribute("user",user);
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
	 * 删除用户
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequiresRoles(value={"管理员"})
	@RequestMapping("/delete/{userId}")
  public AjaxMsgModel delete(@PathVariable("userId") int userId){
      try {
          int row=userBiz.delete(userId);
          if(row<=0){
        	  return AjaxMsgModel.createfailModel(false);
          }
      } catch (Exception e) {
          e.printStackTrace();
          return AjaxMsgModel.createfailModel(false);
      }
      return AjaxMsgModel.createSuccessModel(true);
  }
	
	/**
	 * 给用户授权
	 * @param model
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/preAddAuth/{userId}")
	public String preAddAuth(Model model,@PathVariable("userId")int userId){
		List<Auth> authList=authBiz.findAll();
		User user=userBiz.findById(userId);
		model.addAttribute("authList",authList);
		model.addAttribute("user",user);
		return "/role/addAuth";
	}
	
	
	@ResponseBody
	@RequestMapping("/addAuth")
	public AjaxMsgModel addAuth(UserAuths userAuths){
		try {
			int row=userBiz.saveAll(userAuths);
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
