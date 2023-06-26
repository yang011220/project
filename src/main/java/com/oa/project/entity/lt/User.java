package com.oa.project.entity.lt;

import java.io.Serializable;
import java.util.Date;

/**
 * @author litao
 *用户类
 */
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1542717428304048468L;

	/**
	 * 
	 */

	private int userId;
	
	/**
	 * 昵称
	 */
	private String userNickname;
	
	/**
	 * 用户名（默认是电话号码）
	 */
	private String userName;
	
	private Date createTime;
	
	private String creator;
	
	private Date updateTime;
	
	private String updator;
	
	private char sex;
	
	private String salt;
	

	private Date birthday;
	
	private String minpian;
	
	private String idCard;
	
	private String userPwd;
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMinpian() {
		return minpian;
	}

	public void setMinpian(String minpian) {
		this.minpian = minpian;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}


	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userNickname=" + userNickname + ", userName=" + userName + ", createTime="
				+ createTime + ", creator=" + creator + ", updateTime=" + updateTime + ", updator=" + updator + ", sex="
				+ sex + ", salt=" + salt + ", birthday=" + birthday + ", minpian=" + minpian + ", idCard=" + idCard
				+ ", userPwd=" + userPwd + "]";
	}


	
	

}
