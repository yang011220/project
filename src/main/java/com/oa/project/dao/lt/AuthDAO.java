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

@MapperScan
public interface AuthDAO {
	
	/**
	 * 增加权限
	 * @param auth
	 * @return
	 */
	@Insert({"insert into auth (auth_id,auth_name) values(#{authId},#{authName})"})
	int save(Auth auth);
	
	/**
	 * 修改权限
	 * @param auth
	 * @return
	 */
	@Update({"update auth set auth_name=#{authName} where auth_id=#{authId}"})
	int update(Auth auth);
	
	/**
	 * 通过权限表主键删除权限
	 * @param authId
	 * @return
	 */
	@Delete({"delete from auth where auth_id=#{authId}"})
	int delete(int authId);
	
	
	/**
	 * 通过权限表id查询权限
	 * @param authId
	 * @return
	 */
	@Results(id="authMapper",value={
			@Result(column="auth_id",property="authId"),
			@Result(column="auth_name",property="authName")
	})
	@Select({"select auth_id,auth_name from auth where auth_id=#{authId}"})
	Auth findById(int authId);
	
	/**
	 * 查询所有权限
	 * @return
	 */
	@ResultMap("authMapper")
	@Select({"select auth_id,auth_name from auth"})
	List<Auth> findAll();

	@Select({"select count(auth_id) from auth"})
	int findSize();

	@ResultMap("authMapper")
	@Select({"select auth_id,auth_name from auth limit #{pageNum},20"})
	List<Auth> findByPageNum(int pageNum);
	
	@ResultMap("authMapper")
	@Select({"select auth_id,auth_name from auth where auth_name=#{authName}"})
	Auth findByAuthName(String authName);

}
