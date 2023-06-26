package com.oa.project.entity.lt;

import java.io.Serializable;

public class RoleUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6509862021926185957L;

	/**
	 * 
	 */

	private int roleUserId;
	
	private int roleId;
	
	private String userName;
	
	private int teamId;

	public int getRoleUserId() {
		return roleUserId;
	}

	public void setRoleUserId(int roleUserId) {
		this.roleUserId = roleUserId;
	}


	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	

	
	
	

}
