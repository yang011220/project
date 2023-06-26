package com.oa.project.userBiz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oa.project.dao.lt.RoleDAO;
import com.oa.project.entity.lt.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestUserBiz {
	
//	@Autowired
//	private RoleDAO roleDao;
//	@Test
//	public void test(){
//		Role role = roleDao.findById(4);
//		System.out.println(role.getRoleId());
//	}
}
