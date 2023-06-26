package com.oa.project.biz.lt;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.project.dao.lt.AuthDAO;
import com.oa.project.dao.lt.RoleAuthDAO;
import com.oa.project.dao.lt.RoleDAO;
import com.oa.project.dao.lt.RoleUserDAO;
import com.oa.project.entity.lt.Auth;
import com.oa.project.entity.lt.Role;
import com.oa.project.entity.lt.RoleAuth;
import com.oa.project.entity.lt.RoleAuths;
import com.oa.project.entity.lt.RoleUser;

/**
 * @author Administrator
 *角色业务逻辑层
 */
@Service
public class RoleBiz {

	@Resource
	private RoleDAO roleDAO;
	
	@Resource
	private RoleUserDAO roleUserDAO;
	
	@Resource
	private RoleAuthDAO roleAuthDAO;
	
	@Resource
	private AuthDAO authDAO;
	
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	public int save(Role role){
		return roleDAO.save(role);
	}
	
	/**
	 * 删除角色
	 * @param roleId
	 * @return
	 */
	public int delete(int roleId){
		Role role=roleDAO.findById(roleId);
		List<RoleUser> roleUserList=roleUserDAO.findByRoleName(role.getRoleName());
		if(roleUserList!=null && roleUserList.size()!=0){
			int row=roleUserDAO.deleteByRoleId(roleId);
			if(row<1){
				return row;
			}
		}
		
		List<RoleAuth> roleAuthList=roleAuthDAO.findByRoleId(roleId);
		if(roleAuthList!=null && roleAuthList.size()!=0){
			int row=roleAuthDAO.deleteByRoleId(roleId);
			if(row<1){
				return row;
			}
		}
		
		return roleDAO.delete(roleId); 
	}
	
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	public int update(Role role){
		return roleDAO.update(role);
	}
	
	/**
	 * 通过id查询角色对象
	 * @param roleId
	 * @return
	 */
	public Role findById(int roleId){
		return roleDAO.findById(roleId);
	}
	
	/**
	 * 查询所有角色
	 * @return 角色列表
	 */
	public List<Role> findAll(){
		return roleDAO.findAll();
	}

	/**
	 * 查询角色一共有多少个
	 * @return
	 */
	public int findSize() {
		
		return roleDAO.findSize();
	}
	/**
	 * 实现角色的分页查询
	 * @param pageNum
	 * @return
	 */
	public List<Role> findByPageNum(int pageNum) {
		pageNum=(pageNum-1)*20;
		return roleDAO.findByPageNum(pageNum);
	}

	
	public int saveAll(RoleAuths roleAuths) {
		int roleId=roleAuths.getRoleId();
		List<String> auth=roleAuths.getAuthName();
		int num=0;
		for(String au:auth){
			Auth a=authDAO.findByAuthName(au);
			RoleAuth roleAuth=new RoleAuth();
			roleAuth.setAuthId(a.getAuthId());
			roleAuth.setRoleId(roleId);
			roleAuthDAO.save(roleAuth);
			num++;
		}
		return num;
	}

	public List<Auth> findAllAuthByRoleId(int roleId) {
		
		return roleAuthDAO.findAuth(roleId);
	}

	public int updateAuth(Role role, int[] authId) {
		int row=roleAuthDAO.deleteByRoleId(role.getRoleId());
		if(row<=0){
			return 0;
		}
		int num=0;
		for(int id:authId){
			RoleAuth roleAuth=new RoleAuth();
			roleAuth.setAuthId(id);
			roleAuth.setRoleId(role.getRoleId());
			roleAuthDAO.save(roleAuth);
			num++;
		}
		if(num!=authId.length){
			return 0;
		}
		return num;
	}
	
	
}
