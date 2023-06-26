package com.oa.project.dao.lt;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import com.oa.project.entity.lt.User;

/**
 * @author Administrator
 *用户
 */
@MapperScan
public interface UserDAO {

	/**
	 * 注册的时候，用户只有用户名和密码
	 * @param user
	 * @return
	 */
	@Insert({"insert into user (user_name,user_pwd,salt) values(#{userName},#{userPwd},#{salt})"})
	int saveUser(User user);
	
	/**
	 * 通过用户id删除用户
	 * @param userId
	 * @return
	 */
	@Delete({"delete from user where user_id=#{userId}"})
	int delete(int userId);
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	int update(User user);
	
	/**
	 * 通过用户id查询用户信息
	 * @param userId
	 * @return
	 */
	@Results(id="userMapper",value={
			@Result(column="user_id",property="userId"),
		    @Result(column="user_nickname",property="userNickname"),
		    @Result(column="user_name", property="userName"),
		    @Result(column="create_time" , property="createTime"),
		    @Result(column="creator", property="creator" ),
		    @Result(column="update_time", property="updateTime"),
		    @Result( column="updator" ,property="updator"),
		    @Result( column="sex" , property="sex"),
		    @Result( column="birthday" , property="birthday" ),
		    @Result( column="minpian" , property="minpian"),
		    @Result( column="ID_card", property="idCard"),
		    @Result( column="user_pwd" , property="userPwd"),
			@Result(column="salt",property="salt")
		   
	})
	
	@Select({"select  user_id, user_nickname, user_name, create_time, creator, update_time, updator, sex,birthday, minpian, ID_card, user_pwd from user where user_id=#{userId}"})
	User findById(int userId);
	
	/**
	 * 查询所有的用户
	 * @return
	 */
	@ResultMap(value="userMapper")
	@Select({"select  user_id, user_nickname, user_name, create_time, creator, update_time, updator, sex,birthday, minpian, ID_card, user_pwd,salt from user where user_id > 1 limit #{pageNum},20"})
	List<User> findAll(int pageNum);

	
	/**
	 * 查询所有的用户
	 * @return
	 */
	@ResultMap(value="userMapper")
	@Select({"select  user_id, user_nickname, user_name, create_time, creator, update_time, updator, sex,birthday, minpian, ID_card, user_pwd,salt from user where user_id > 1"})
	List<User> findAllUser();
	
	@ResultMap(value="userMapper")
	@Select({"select  user_id, user_nickname, user_name, create_time, creator, update_time, updator, sex,birthday, minpian, ID_card, user_pwd,salt from user where user_name=#{userName} and user_pwd=#{userPwd}"})
	User findByUserNameAndPwd(User user);
	
	/**
	 * 通过用户名查询用户信息
	 * @param userName
	 * @return
	 */
	@ResultMap(value="userMapper")
	@Select({"select  user_id, user_nickname, user_name, create_time, creator, update_time, updator, sex,birthday, minpian, ID_card, user_pwd,salt from user where user_name=#{userName}"})
	User findUserByUserName(String userName);
	
	@Select({"select count(user_id) from user"})
	int findSize();
}
