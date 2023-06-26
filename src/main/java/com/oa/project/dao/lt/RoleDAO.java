package com.oa.project.dao.lt;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.mybatis.spring.annotation.MapperScan;

import com.oa.project.entity.lt.Role;

/**
 * @author Administrator
 *角色
 */
@MapperScan
public interface RoleDAO {
	/**
	 * 通过角色id查询角色
	 * @param roleId
	 * @return
	 */
	@Results(id="roleMapper",value={
			@Result(column="role_id",property="roleId"),
			@Result(column="role_name",property="roleName")
	})
	@Select({"select role_id,role_name from role where role_id=#{roleId}"})
	Role findById(int roleId);
	
	/**
	 * 查询所有的角色
	 * @return
	 */
	@ResultMap("roleMapper")
	@Select({"select role_id,role_name from role where role_id>1"})
	List<Role> findAll();
	
	
	/**
	 * 查询所有的角色
	 * @return
	 */
	@ResultMap("roleMapper")
	@Select({"select role_id,role_name from role where"})
	List<Role> findAllRole();
	
	/**
	 * 通过角色id修改角色信息
	 * @param role
	 * @return
	 */
	@Update({"update role set role_name=#{roleName} where role_id=#{roleId}"})
	int update(Role role);
	
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	int save(Role role);
	
	/**
	 * 通过角色id删除角色
	 * @param roleId
	 * @return
	 */
	@Delete({"delete from role where role_id=#{roleId}"})
	int delete(int roleId);

	@Select({"select count(role_id) from role"})
	int findSize();
	@ResultMap("roleMapper")
	@Select({"select role_id,role_name from role limit #{pageNum},20"})
	List<Role> findByPageNum(int pageNum);
	
}
