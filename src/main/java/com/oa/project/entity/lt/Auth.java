package com.oa.project.entity.lt;

import java.io.Serializable;

/**
 * @author litao
 *权限类
 */
public class Auth implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4073654851991661535L;

	/**
	 * 
	 */

	private int authId;
	
	private String authName;
	

	public int getAuthId() {
		return authId;
	}

	public void setAuthId(int authId) {
		this.authId = authId;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}
	
	

}
