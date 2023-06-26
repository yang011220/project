package com.oa.project.entity.lt;

import java.io.Serializable;
import java.util.List;

public class UserAuths implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4867417618926613319L;

	
	private String userName;
	
	List<Auth> authList;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Auth> getAuthList() {
		return authList;
	}

	public void setAuthList(List<Auth> authList) {
		this.authList = authList;
	}
	
	
}
