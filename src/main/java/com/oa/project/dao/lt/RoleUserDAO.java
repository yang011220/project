package com.oa.project.dao.lt;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;

import com.oa.project.entity.lt.Role;
import com.oa.project.entity.lt.RoleUser;


/**
 * @author Administrator
 *用户角色
 */
@MapperScan
public interface RoleUserDAO {
	
	/**给用户添加角色
	 * 
	 * @param roleUser
	 * @return
	 */
	@Insert({"insert into role_user (role_id,user_name,team_id) values(#{roleId},#{userName},#{teamId})"})
	int save(RoleUser roleUser);

	/**
	 * 通过用户名查询该用户所有的角色
	 * @param userName
	 * @return
	 */
	@Results(id="rlMapper",value={
			@Result(column="role_id",property="roleId"),
			@Result(column="role_name",property="roleName")
	})
	@Select({"select r.role_id, r.role_name from role r inner join role_user u on r.role_id=u.role_id where u.user_name=#{userName}"})
	List<Role> findRoles(String userName);
	
	/**
	 * 通过角色名查询有该角色的所有用户
	 * @param roleName
	 * @return
	 */
	@Results(id="roleUserMapper",value={
			@Result(column="role_user_id",property="roleUserId"),
			@Result(column="role_Id",property="roleId"),
			@Result(column="user_name",property="userName"),
			@Result(column="team_id",property="teamId")	
	})
	@Select({"select u.role_user_id,u.user_name,u.role_id,u.team_id from role_user u inner join role r on u.role_id=r.role_id where r.role_name=#{roleName}"})
	List<RoleUser> findByRoleName(String roleName);
	
	@ResultMap("roleUserMapper")
	@Select({"select role_user_id,role_id,user_name,team_id from role_user where user_name=#{userName}"})
	List<RoleUser>findRolesByUserName(String userName);
	
	
	
	@ResultMap("roleUserMapper")
	@Select({"select ru.role_user_id,ru.role_id,ru.user_name,ru.team_id from role_user ru inner join role ro on ru.role_id=ro.role_id inner join emp ee on ru.team_id=ee.team_id where ru.user_name=#{userName} and ru.team_id=#{teamId}"})
	List<RoleUser>findRolesByUserNameAndTeamId(@Param("userName")String userName,@Param("teamId")Integer teamId);
	
	/**
	 * 通过角色Id删除用户角色
	 * @param roleName
	 * @return
	 */
	@Delete({"delete from role_user where role_id=#{roleId}"})
	int deleteByRoleId(int roleId);
	
	
	/**
	 * 删除用户角色通过团队id
	 * @param teamId
	 * @return
	 */
	@Delete({"delete from role_user where team_id=#{teamId}"})
	int deleteByTeamId(int teamId);
	
	
	/**
	 * 通过用户名删除用户角色
	 * @param userName
	 * @return
	 */
	@Delete({"delete from role_user where user_name=#{userName} "})
	int deleteByUserName(String userName);
	
	/**
	 * 通过用户名和角色id删除用户角色
	 * @param roleUser
	 * @return
	 */
	@Delete({"delete from role_user where user_name=#{userName} and role_Id=#{roleId}"})
	int deleteRoleAndUserName(RoleUser roleUser);
	
	/**
	 * 修改用户角色
	 * @param roleUser
	 * @return
	 */
	@Update({"update role_user set role_id=#{roleId},team_id=#{teamId} where user_name=#{userName}"})
	int update(RoleUser roleUser);

	
	

}
