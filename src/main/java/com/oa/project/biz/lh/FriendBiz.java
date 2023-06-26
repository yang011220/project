package com.oa.project.biz.lh;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.project.dao.lh.FriendDao;
import com.oa.project.entity.lh.Friend;
import com.oa.project.entity.lt.User;

@Service
public class FriendBiz {
	@Resource
	private FriendDao friendDao;

	public int save(Friend friend) {
		return friendDao.save(friend);
	}
	
	public int delete(int friendId){
		return friendDao.deleteMyFriend(friendId);
	}
	
	public Friend findById(int id){
		return friendDao.findById(id);
	}

	public List<Friend> findAll(User user) {
		List<Friend> list = friendDao.find(user);
		return list;
	}

}
