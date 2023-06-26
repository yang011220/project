package com.oa.project.biz.hb;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.project.dao.hb.ContractMapper;
import com.oa.project.entity.hb.Contract;

@Service
public class ContractBiz {
	@Resource
	private ContractMapper contractMapper;
	
	/**
	 * 用于管理员查询所有合同
	 * @return
	 */
	public List<Contract> findAll(){
		return contractMapper.selectAll();
	}
	
	public List<Contract> findAllLimit(int pageNum){
		int num=(pageNum-1)*20;
		return contractMapper.selectAllLimit(num);
	}
	
	/**
	 * 用于团队管理员查询该团队所有的合同
	 * @param teamId
	 * @return
	 */
	public List<Contract> findByteamId(int teamId){
		return contractMapper.selectByteamId(teamId);
	}
	
	public List<Contract> findByteamIdLimit(int teamId,int pageNum){
		int num=(pageNum-1)*20;
		return contractMapper.selectByteamIdLimit(teamId,num);
	}
	
	public Contract findById(int contractId){
		return contractMapper.selectByPrimaryKey(contractId);
	}
	
	/**
	 * 用于查询某员工（业务员）签了多少业务合同
	 * @param empId
	 * @return
	 */
	public List<Contract> findByempId(int empId){
		return contractMapper.selectByempId(empId);
	}
	
	public List<Contract> findByempIdLimit(int empId,int pageNum){
		int num=(pageNum-1)*20;
		return contractMapper.selectByempIdLimit(empId,num);
	}
	
	public int save(Contract contract){
		return contractMapper.insertSelective(contract);
	}
	
	public int delete(int contractId){
		return contractMapper.deleteByPrimaryKey(contractId);
	}
	
	public int update(Contract contract){
		return contractMapper.updateByPrimaryKeySelective(contract);
	}
}
