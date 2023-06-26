package com.oa.project.entity.lt;

import java.io.Serializable;

/**
 * @author litao
 *角色类
 */
public class Role implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6309637949527696913L;

	/**
	 * 
	 */

	private int roleId;
	
	private String roleName;
	

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	

}
