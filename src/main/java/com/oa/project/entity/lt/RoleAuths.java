package com.oa.project.entity.lt;

import java.io.Serializable;
import java.util.List;

public class RoleAuths implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6603950967379138393L;

	private int roleId;
	
	private List<String> authName;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public List<String> getAuthName() {
		return authName;
	}

	public void setAuthName(List<String> authName) {
		this.authName = authName;
	}

	
}
