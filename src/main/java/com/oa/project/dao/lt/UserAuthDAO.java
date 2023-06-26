package com.oa.project.dao.lt;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;

import com.oa.project.entity.lt.Auth;
import com.oa.project.entity.lt.UserAuth;

@MapperScan
public interface UserAuthDAO {
	/**
	 * 添加用户和权限的对应关系
	 * @param userAuth
	 * @return
	 */
	@Insert({"insert into user_auth (user_name,auth_id) values(#{userName},#{authId})"})
	int save(UserAuth userAuth);
	/**
	 * 通过用户权限表的主键删除记录
	 * @param userAuthId
	 * @return
	 */
	@Delete({"delete from user_auth where user_auth_id=#{userAuthId}"})
	int deleteByUserAuthId(int userAuthId);
	/**
	 * 通过权限id删除用户的权限
	 * @param authId
	 * @return
	 */
	@Delete({"delete from user_auth where auth_id=#{authId}"})
	int deleteByAuthId(int authId);
	/**
	 * 通过用户名删除用户权限
	 * @param userId
	 * @return
	 */
	@Delete({"delete from user_auth where user_name=#{userName}"})
	int deleteByUserName(String userName);
	
	
	/**
	 * 修改用户权限表信息
	 * @param userAuth
	 * @return
	 */
	@Update({"update user_auth set user_name=#{userName},auth_id=#{authId} where user_auth_id=#{userAuthId}"})
	int update(UserAuth userAuth);
	
	/**
	 * 通过用户名联合权限表查询某个用户的所有权限
	 * @param userName
	 * @return
	 */
	@Results(id="userAuthsMapper",value={
			@Result(column="auth_id",property="authId"),
			@Result(column="auth_name",property="authName"),
	})
	@Select({"select a.auth_id, a.auth_name from auth a inner join user_auth u on u.auth_id=a.auth_id where u.user_name=#{userName}"})
	List<Auth> findByUserName(String userName);
	
	
	/**
	 * 查询所有的用户权限表的记录
	 * @return
	 */
	@Results(id="userAuthMapper",value={
			@Result(column="user_auth_id",property="userAuthId"),
			@Result(column="user_name",property="userName"),
			@Result(column="auth_id",property="authId")
	})
	@Select({"select user_auth_id,user_name,auth_id from user_auth"})
	List<UserAuth> findAll();
	
	
	/**
	 * 通过用户角色表的主键查询用户角色对象
	 * @param userAuthId
	 * @return
	 */
	@ResultMap("userAuthMapper")
	@Select({"select user_name,auth_id from user_auth where user_auth_id=#{userAuthId}"})
	UserAuth findByUserAuthId(int userAuthId);
	/**
	 * 通过用户名查询该用户的特有权限
	 * @param userName
	 * @return
	 */
	@ResultMap("userAuthMapper")
	@Select({"select user_auth_id,user_name,auth_id from user_auth where user_name=#{userName}"})
	List<UserAuth> findAllByUserName(String userName);
	
	/**
	 * 通过权限id查询某个权限所对应的所有用户
	 * @param authId
	 * @return
	 */
	@ResultMap("userAuthMapper")
	@Select({"select user_auth_id,user_name,auth_id from user_auth where auth_id=#{authId}"})
	List<UserAuth> findByAuthId(int authId);
}
