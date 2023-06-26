package com.oa.project.dao.lh;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;

import com.oa.project.entity.lh.Friend;
import com.oa.project.entity.lt.User;

@MapperScan
public interface FriendDao {
	@Insert("insert into friend (friend_id,user_id) values (#{friend.userId},#{userId})")
	int save(Friend friend);
	
	@Results(id="FriendResultMap",value={
			@Result(column="id",property="id",jdbcType=JdbcType.INTEGER),
			@Result(column="user_id",property="userId",jdbcType=JdbcType.INTEGER),
			@Result(column="friend_id",property="friend",javaType=User.class,
			one=@One(select="com.oa.project.dao.lt.UserDAO.findById",fetchType=FetchType.LAZY))
	})
	@Select("select id,friend_id,user_id from friend where user_id = #{userId}")
	List<Friend> find(User user);
	
	@ResultMap("FriendResultMap")
	@Select("select id,friend_id,user_id from friend where id = #{id}")
	Friend findById(int id);
	
	@Delete("delete from friend where id = #{id}")
	int deleteMyFriend(int id);
	
	

}
