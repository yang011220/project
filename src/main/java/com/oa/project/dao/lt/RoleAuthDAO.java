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
import com.oa.project.entity.lt.RoleAuth;

/**
 * @author Administrator
 *角色权限
 */
@MapperScan
public interface RoleAuthDAO {

	/**
	 * 添加角色权限的关系
	 * @param roleAuth
	 * @return
	 */
	@Insert({"insert into role_auth (role_auth_id,role_id,auth_id) values (#{roleAuthId},#{roleId},#{authId})"})
	int save(RoleAuth roleAuth);
	
	/**
	 * 通过角色权限表的主键删除角色的权限
	 * @param roleAuthId
	 * @return
	 */
	@Delete({"delete from role_auth where role_auth_id=#{roleAuthId}"})
	int deleteByRoleAuthId(int roleAuthId);
	
	/**
	 * 通过权限id删除角色的权限
	 * @param authId
	 * @return
	 */
	@Delete({"delete from role_auth where auth_id=#{authId}"})
	int deleteByAuthId(int authId);
	
	/**
	 * 通过角色id删除角色的权限
	 * @param roleName
	 * @return
	 */
	@Delete({"delete from role_auth where role_id=#{roleId}"})
	int deleteByRoleId(int  roleId );
	
	/**
	 * 修改角色的权限
	 * @param roleAuth
	 * @return
	 */
	@Update({"update role_auth set role_id=#{roleId},auth_id=#{authId} where role_auth_id=#{roleAuthId}"})
	int update(RoleAuth roleAuth);
	
	/**
	 * 通过角色名查询该角色所有的角色权限对象
	 * @param roleName
	 * @return
	 */
	@Results(id="roleAuthMapper",value={
			@Result(column="role_auth_id",property="roleAuthId"),
			@Result(column="role_id",property="roleId"),
			@Result(column="auth_id",property="authId")
	})
	@Select({"select a.role_auth_id,a.role_id,a.auth_id from role_auth a inner join role r on a.role_id=r.role_id where r.role_name=#{roleName}"})
	List<RoleAuth> findByRoleName(String roleName);
	
	
	@ResultMap("roleAuthMapper")
	@Select({"select role_auth_id,role_id,auth_id from role_auth where role_id=#{roleId}"})
	List<RoleAuth> findByRoleId(int  roleId);
	
	/**
	 * 查询角色权限的所有记录
	 * @return
	 */
	@ResultMap("roleAuthMapper")
	@Select({"select role_auth_id,role_name,auth_Id from role_auth"})
	List<RoleAuth> findAll();

	/**
	 * 通过角色权限表和权限表连表通过角色名查询他所有的权限
	 * @param roleName
	 * @return
	 */
	@Results(id="roleAuthsMapper",value={
			@Result(column="auth_id",property="authId"),
			@Result(column="auth_name",property="authName")
	})
	@Select({"select a.auth_id,a.auth_name from auth a inner join role_auth r  on r.auth_id=a.auth_id where r.role_id=#{roleId}"})
	List<Auth> findAuth(int roleId);
	

	@ResultMap("roleAuthMapper")
	@Select({"select role_auth_id,role_id,auth_id from role_auth where auth_id=#{authId}"})
	List<RoleAuth> findByAuthId(int authId);
	
//	@ResultMap("roleAuthsMapper")
//	@Select({"select a.auth_id,a.auth_name from auth a inner join role_auth r inner join role ro on r.auth_id=a.auth_id where r.role_name=#{roleName}"})
//	Set<Auth> findAuth(String roleName);

}
