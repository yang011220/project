package com.oa.project.entity.lh;

import com.oa.project.entity.lt.User;

public class Friend {
	
	private int id;
	
	private User friend;
	
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public User getFriend() {
		return friend;
	}

	public void setFriend(User friend) {
		this.friend = friend;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Friend [id=" + id + ", friend=" + friend + ", userId=" + userId + "]";
	}


	
	

}
