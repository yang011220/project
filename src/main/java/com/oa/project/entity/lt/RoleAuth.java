package com.oa.project.entity.lt;

import java.io.Serializable;

public class RoleAuth implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2683000920237261824L;

	/**
	 * 
	 */

	private int roleAuthId;
	
	private int roleId;
	
	private int authId;

	public int getRoleAuthId() {
		return roleAuthId;
	}

	public void setRoleAuthId(int roleAuthId) {
		this.roleAuthId = roleAuthId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getAuthId() {
		return authId;
	}

	public void setAuthId(int authId) {
		this.authId = authId;
	}
	
	
}
