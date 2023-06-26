package com.oa.project.biz.lt;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.project.dao.lt.AuthDAO;
import com.oa.project.dao.lt.RoleAuthDAO;
import com.oa.project.dao.lt.UserAuthDAO;
import com.oa.project.entity.lt.Auth;
import com.oa.project.entity.lt.RoleAuth;
import com.oa.project.entity.lt.UserAuth;

@Service
public class AuthBiz {

	@Resource
	private AuthDAO authDAO;
	
	@Resource
	private UserAuthDAO userAuthDAO;
	
	@Resource
	private RoleAuthDAO roleAuthDAO;
	
	/**
	 * 添加权限
	 * @param auth
	 * @return 受影响的行数
	 */
	public int save(Auth auth){
		Auth au=authDAO.findByAuthName(auth.getAuthName());
		if(au!=null){
			return 0;
		}
		return authDAO.save(auth); 
	}
	
	/**
	 * 通过权限的id删除某个权限
	 * @param authId
	 * @return 受影响的行数
	 */
	public int delete(int authId){
		List<UserAuth> uaList=userAuthDAO.findByAuthId(authId);
		if(uaList!=null && uaList.size()!=0){
			int row=userAuthDAO.deleteByAuthId(authId);
			if(row<1){
				return row;
			}
		}
		
		List<RoleAuth> raList=roleAuthDAO.findByAuthId(authId);
		if(raList!=null && raList.size()!=0){
			int row=roleAuthDAO.deleteByAuthId(authId);
			if(row<1){
				return row;
			}
		}
		return authDAO.delete(authId); 
	}
	
	/**
	 * 修改权限
	 * @param auth
	 * @return 受影响的行数
	 */
	public int update(Auth auth){
		return authDAO.update(auth);
	}
	
	/**
	 * 通过某个权限的id查询权限信息
	 * @param authId
	 * @return 权限对象
	 */
	public Auth findById(int authId){
		return authDAO.findById(authId);
	}
	
	/**
	 * 查询所有的权限
	 * @return 权限的列表
	 */
	public List<Auth> findAll(){
		return authDAO.findAll();
	}

	public int findSize() {
		
		 return authDAO.findSize();
	}

	public List<Auth> findAllByPageNum(int pageNum) {
		pageNum=(pageNum-1)*20;
		return authDAO.findByPageNum(pageNum);
	}
}
