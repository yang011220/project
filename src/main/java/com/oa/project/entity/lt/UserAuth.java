package com.oa.project.entity.lt;

import java.io.Serializable;

public class UserAuth implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2570268830031668811L;

	private int userAuthId;
	
	private String userName;
	
	private int authId;

	public int getUserAuthId() {
		return userAuthId;
	}

	public void setUserAuthId(int userAuthId) {
		this.userAuthId = userAuthId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAuthId() {
		return authId;
	}

	public void setAuthId(int authId) {
		this.authId = authId;
	}
	
	
}
