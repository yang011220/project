package com.oa.project.biz.lt;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.oa.project.dao.lt.RoleAuthDAO;
import com.oa.project.dao.lt.RoleDAO;
import com.oa.project.dao.lt.RoleUserDAO;
import com.oa.project.dao.lt.UserAuthDAO;
import com.oa.project.dao.lt.UserDAO;
import com.oa.project.entity.lt.Auth;
import com.oa.project.entity.lt.Role;
import com.oa.project.entity.lt.RoleUser;
import com.oa.project.entity.lt.User;
import com.oa.project.entity.lt.UserAuth;
import com.oa.project.entity.lt.UserAuths;
import com.oa.project.entity.team.Team;

@Service
public class UserBiz {
	
	@Resource
	private UserDAO userDAO;
	
	@Resource
	private RoleUserDAO roleUserDAO;
	
	@Resource
	private RoleAuthDAO roleAuthDAO;
	
	@Resource
	private UserAuthDAO userAuthDAO;
	
	@Resource
	private RoleDAO roleDAO;
	/**
	 * 注册方法
	 * @param user
	 * @return 改变的行数
	 */
	public int save(User user){
		User ur=userDAO.findUserByUserName(user.getUserName());
		if(ur!=null){
			return 0;
		}
		RoleUser roleUser=new RoleUser();
		roleUser.setUserName(user.getUserName());
		roleUser.setRoleId(3);
		roleUserDAO.save(roleUser);
		user.setCreator(user.getUserName());
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		user.setUpdator(user.getUserName());
		return userDAO.saveUser(user);
	}
	
	/**
	 * 登录方法
	 * @param user
	 * @return
	 */
	public User login(User user){
		return userDAO.findByUserNameAndPwd(user);
	}

	/**
	 * 通过用户名在在role_user表查询某个用户的所有的角色
	 * @param userName
	 * @return
	 */
	public Set<String> findRoles(String userName,Team team ) {
		Set<String> set=new HashSet<>();
		if("admin".equals(userName)){
			set.add("管理员");
			return set;
		}
		if(team!=null){
			List<RoleUser> role=roleUserDAO.findRolesByUserNameAndTeamId(userName,team.getTeamId());
			if(role!=null && role.size()!=0){
				for(RoleUser str:role){
					Role ro=roleDAO.findById(str.getRoleId());
					set.add(ro.getRoleName());
					}
			}
		}
		set.add("普通用户");
		return  set;
	}

	/**
	 * 通过用户名查询他所有的权限
	 * @param userName
	 * @return
	 */
	public Set<String> findAuths(String userName) {
		List<Role> roleUser=roleUserDAO.findRoles(userName);
		if(roleUser==null){
			return null;
		}
		Set<String> set=new HashSet<>();
		for(Role str:roleUser){
			List<Auth> authSet=roleAuthDAO.findAuth(str.getRoleId());
			if(authSet!=null && authSet.size()!=0){
				for(Auth auth:authSet){
					set.add(auth.getAuthName());
				}
			}
			}
		List<Auth> auths=userAuthDAO.findByUserName(userName);
		if(auths!=null && auths.size()!=0){
			for(Auth a:auths){
				set.add(a.getAuthName());
			}
		}
		return  set;
		
	}

	/**
	 * 通过用户名查询用户信息
	 * @param userName
	 * @return
	 */
	public User findUserByUsername(String userName) {
		return userDAO.findUserByUserName(userName);
	}
	
	public List<UserAuth> findAllUserAuth(){
		return userAuthDAO.findAll();
	}
	
	/**
	 * 查询所有的用户
	 * @return
	 */
	public List<User> findAll(int pageNum){
		pageNum=(pageNum-1)*20;
		return userDAO.findAll(pageNum);
	}
	
	
	
	public List<User> findAll(){
		return userDAO.findAllUser();
	}


	/**
	 * 通过用户id查询用户信息
	 * @param userId
	 * @return
	 */
	public User findByUserId(int userId) {
		return userDAO.findById(userId);
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	public int update(User user) {
		return userDAO.update(user);
	}
	
	public int findSize(){
		return userDAO.findSize()-1;
	}

	public int delete(int userId){
		User user=userDAO.findById(userId);
		List<RoleUser> roleUser=roleUserDAO.findRolesByUserName(user.getUserName());
		if(roleUser!=null && roleUser.size()!=0){
			int row=roleUserDAO.deleteByUserName(user.getUserName());
			if(row<1){
				return 0;
			}
		}
		List<UserAuth> userAuthList=userAuthDAO.findAllByUserName(user.getUserName());
		if(userAuthList!=null && userAuthList.size()!=0){
			int rows=userAuthDAO.deleteByUserName(user.getUserName());
			if(rows<1){
				return 0;
			}
		}
		return userDAO.delete(userId);
	}

	public User findById(int userId) {
		
		return userDAO.findById(userId);
	}

	public int saveAll(UserAuths userAuths) {
		String userName=userAuths.getUserName();
		List<Auth> authList=userAuths.getAuthList();
		int num=0;
		for(Auth au:authList){
			UserAuth userAuth=new UserAuth();
			userAuth.setUserName(userName);
			userAuth.setAuthId(au.getAuthId());
			userAuthDAO.save(userAuth);
			num++;
		}
		if(num==authList.size()){
			return num;
		}
		return 0;
	}

	
	
	 
}
