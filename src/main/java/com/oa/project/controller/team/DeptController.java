package com.oa.project.controller.team;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.project.biz.lh.EmpBiz;
import com.oa.project.biz.lt.UserBiz;
import com.oa.project.biz.team.DeptBiz;
import com.oa.project.biz.team.TeamBiz;
import com.oa.project.dao.lh.EmpDao;
import com.oa.project.dao.lt.RoleUserDAO;
import com.oa.project.entity.lh.Emp;
import com.oa.project.entity.lt.Role;
import com.oa.project.entity.lt.RoleUser;
import com.oa.project.entity.lt.User;
import com.oa.project.entity.team.Dept;
import com.oa.project.entity.team.Scale;
import com.oa.project.entity.team.Team;
import com.oa.project.util.AjaxMsgModel;
import com.oa.project.util.MyRealm;


import org.apache.shiro.authc.AuthenticationToken;

@Controller
@RequestMapping("/team/dept")
public class DeptController {
	@Resource
	private TeamBiz teamBiz;
	@Resource
	private DeptBiz deptBiz;
	@Resource
	EmpDao empDao;
	@Resource
	private RoleUserDAO roleUserDao;
	@Resource 
	private EmpBiz empBiz;
	@Resource 
	private UserBiz userBiz;
	@RequestMapping("/presave")
	public String presave() {
		 return "/team/dept/add";
	}
	@ResponseBody
    @RequestMapping("/save")
    public AjaxMsgModel add(Dept dept) {
        try {
        	dept.setLeveldeptId(0);
    		dept.setTeamId(0);
    		 deptBiz.save(dept);
        } catch (Exception e) {
            AjaxMsgModel.createfailModel(false);
        }
       return AjaxMsgModel.createSuccessModel(true);
    }
//	@RequestMapping("/save")
//	public String save(Dept dept) {
//		dept.setLeveldeptId(0);
//		dept.setTeamId(0);
//		 deptBiz.save(dept);
//		 return "redirect:/team/dept/list";
//	}
	@RequestMapping("/preupdate")
	public String preupdate(int id,Model model) {
		Dept dept=deptBiz.selectById(id);
		model.addAttribute("scale", dept);
		 return "/team/dept/update";
	}
	@ResponseBody
    @RequestMapping("/update")
    public AjaxMsgModel update(Dept dept) {
        try {
        	 deptBiz.update(dept);
        } catch (Exception e) {
            AjaxMsgModel.createfailModel(false);
        }
       return AjaxMsgModel.createSuccessModel(true);
    }
//	@RequestMapping("/update")
//	public String update(Dept dept){
//		 deptBiz.update(dept);
//			return "redirect:/team/dept/listTeam";
//	}
	@ResponseBody
    @RequestMapping("/delete")
    public AjaxMsgModel delete(int id) {
        try {
        	deptBiz.delete(id);
        } catch (Exception e) {
            AjaxMsgModel.createfailModel(false);
        }
       return AjaxMsgModel.createSuccessModel(true);
    }
//	@RequestMapping("/delete")
//	public String delete(int id){
//		 deptBiz.delete(id);
//			return "redirect:/team/dept/listTeam";
//	}
//	数据库基础部门
	@RequestMapping("/list")
	public String selectModel(Model model){
		List<Dept>list= deptBiz.selectModel();
		model.addAttribute("list",list);
		return "/team/dept/list";
	}
//	数据库所有部门
//	@RequestMapping("/listAll")
//	public String selectAll(Model model){
//		List<Dept>list= deptBiz.selectAll();
//		model.addAttribute("list",list);
//		return "/team/dept/list";
//	}
	//	数据库所有部门
//	@ResponseBody
//	@RequestMapping("/list2")
//	public List<Dept> selectAll(){
//		List<Dept>list= deptBiz.selectAll();
//		return list;
//	}
	
//	进入添加二级部门页面
	@RequestMapping("/preSaveTwo/{id}")
	public String preSaveTwo(@PathVariable("id")int id,Model model) {
		Dept dept=deptBiz.selectById(id);
		model.addAttribute("dept", dept);
		 return "/team/dept/saveTwo";
	}
	@ResponseBody
    @RequestMapping("/saveTwo")
    public AjaxMsgModel saveTwo1(Dept dept) {
        try {
    		 deptBiz.save(dept);
        } catch (Exception e) {
            AjaxMsgModel.createfailModel(false);
        }
       return AjaxMsgModel.createSuccessModel(true);
    }
//	创建下级部门
//	@RequestMapping("/saveTwo")
//	public String saveTwo(Dept dept) {
//		 deptBiz.save(dept);
//		 return "redirect:/team/dept/listTeam";
//	}
	
//	点击团队时session出去team
//	@RequiresRoles("普通用户")
	@RequestMapping("/sessionTeam")
	public String sss(int id,HttpServletRequest request,HttpSession session){
		User user =(User)session.getAttribute("users");
		Team team=teamBiz.selectById(id);
		int uuuid=team.getTeamId();
		Emp emp=empBiz.findByTUId(uuuid, user.getUserId());
		request.getSession().setAttribute("currentTeam",team);
		request.getSession().setAttribute("currentEmp",emp);
		
		RealmSecurityManager rsm = (RealmSecurityManager)SecurityUtils.getSecurityManager();
		MyRealm authRealm = (MyRealm)rsm.getRealms().iterator().next();
		authRealm.clearAuthz();
//		MyRealm myRealm=new MyRealm();
//		TestPipi testPipi=new TestPipi();
//		testPipi.reloadAuthorizing(myRealm, user.getUserName());
//		 SimpleAuthorizationInfo info = new SimpleAuthorizationInfo() ;
			
//	        Set<String> roleName = userBiz.findRoles(user.getUserName(), team) ;
//	        Set<String> permissions = userBiz.findAuths(user.getUserName()) ;
//	        info.setRoles(roleName);	
//	        info.setStringPermissions(permissions);
//	        request.getSession().setAttribute("info",info);
		return "redirect:/team/dept/listTeam";
	}
//	某个团队对应的所有部门
//	@RequiresRoles("部门负责人")	
	@RequestMapping("/listTeam")
	public String selectbyTeam(Model model,HttpSession session){
		Team team=(Team)session.getAttribute("currentTeam");
		List<Dept>list= deptBiz.selectByTeamId(team.getTeamId());
		model.addAttribute("list",list);
		return "/team/dept/list";
	}
//	某个部门对应的下级部门
	@RequestMapping("/listTeamLevel")
	public String selectbyTeamLevel(Model model,int id){
		List<Dept>list= deptBiz.selectByLevelId(id);
		Dept dept=deptBiz.selectById(id);
		model.addAttribute("dept", dept);
		model.addAttribute("list",list);
		return "/team/dept/listlevel";
	}
	
//	创建100个用户
	@RequestMapping("ccc")
	public void sss() {
		String name[]={"a","b","c","d","e","f","g","h","i","j"};
	    String secondName[]={"bb","cc","dd","jj","ik","ok","yu","it","we","rf"
	            ,"yh","dt","yu","rt","wb","th","fb","yh","ft","fw"};
	
	    for(int i=0;i<100;i++){
	       int a=(int)Math.abs(name.length*Math.random());
	       int b=(int)Math.abs(secondName.length*Math.random());
	       int c=(int)Math.abs(secondName.length*Math.random());
	        StringBuffer sb=new StringBuffer();
	        sb.append(name[a]).append(secondName[b]).append(secondName[c]);
	        User user=new User();
	        user.setUserName(sb.toString());
	        String salt="ql20ur#&dsx$od";
			String md5=new Md5Hash("123456",salt).toString();
			user.setUserPwd(md5);
			user.setSalt(salt);
	        userBiz.save(user);
	    }
	}
	
//	为每个用户创建一个团队
	@RequestMapping("ppp")
	public void ccc() {
		String name[]={"赵","钱","孙","李","周","吴","郑","王","皮","黄"};
        String secondName[]={"军","成","金","星","鑫","心","信","欣","家","佳"
                ,"河","林","琳","奥","麟","陵","玲","福","乐","连"};
		List<User>userList=userBiz.findAll();
		for(int i=0;i<userList.size();i++){
			Team team=new Team();
				Random random=new Random();
			  int a=(int)Math.abs(name.length*Math.random());
	           int b=(int)Math.abs(secondName.length*Math.random());
	           int c=(int)Math.abs(secondName.length*Math.random());
	            StringBuffer sb=new StringBuffer();
	            sb.append(name[a]).append(secondName[b]).append(secondName[c]);
	        	team.setScaleId(1);
	        	team.setTeamName(sb.toString());
	        	team.setTeamType2Id(random.nextInt(30)+1);
	        	teamBiz.save(team, userList.get(i));
		}
	}
//	给某个团队添加员工
	@RequestMapping("/kkk")
	private void pub() {
		Emp emp = new Emp();
		User user = userBiz.findById(11);
		Role role = new Role();
		role.setRoleId(4);
		Team team=teamBiz.selectById(77);
		emp.setTeam(team);
		emp.setUser(user);
		emp.setEmpName(user.getUserName());
		emp.setRole(role);
		 empDao.save(emp);
		 RoleUser roleUser=new RoleUser();
			roleUser.setRoleId(4);
			roleUser.setTeamId(77);
			roleUser.setUserName(user.getUserName());
			int id=empBiz.save(team,user.getUserId(),user.getUserName(),4);
			roleUserDao.save(roleUser);
	}
}
