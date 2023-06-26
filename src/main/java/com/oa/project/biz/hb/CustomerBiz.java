package com.oa.project.biz.hb;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.project.dao.hb.CustomerMapper;
import com.oa.project.entity.hb.Customer;

@Service
public class CustomerBiz {
	@Resource
	private CustomerMapper customerMapper;
	
	/**
	 * 用于管理员查询所有客户
	 * @return
	 */
	public List<Customer> findAll(){
		return customerMapper.findAll();
	}
	
	public List<Customer> findAllLimit(int pageNum){
		int num=(pageNum-1)*20;
		return customerMapper.findAllLimit(num);
	}
	
	/**
	 * 用于团队管理员 查询该团队所有客户
	 * @param teamId
	 * @return
	 */
	public List<Customer> findByteamId(int teamId){
		return customerMapper.selectByteamId(teamId);
	}
	
	public List<Customer> findByteamIdLimit(int teamId,int pageNum){
		int num=(pageNum-1)*20;
		return customerMapper.selectByteamIdLimit(teamId,num);
	}
	
	public Customer findById(int cusId){
		return customerMapper.selectByPrimaryKey(cusId);
	}
	
	public int deleteById(int cusId){
		return customerMapper.deleteByPrimaryKey(cusId);
	}
	
	public int save(Customer customer){
		return customerMapper.insertSelective(customer);
	}
	
	public int update(Customer customer){
		return customerMapper.updateByPrimaryKeySelective(customer);
	}
	
	/**
	 * 用于查询某员工（业务员）拉了多少客户
	 * @param empId
	 * @return
	 */
	public List<Customer> findByempId(int empId){
		return customerMapper.findByempId(empId);
	}
	
	public List<Customer> findByempIdLimit(int pageNum,int empId){
		int num=(pageNum-1)*20;
		return customerMapper.findByempIdLimit(empId,num);
	}
}
