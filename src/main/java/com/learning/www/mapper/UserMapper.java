package com.learning.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.learning.www.entity.User;

@Repository
@Mapper
public interface UserMapper {

	@Select("select * from user where username=#{username}")
	public User getPasswordByUsername(String username);
	
	@Select("select * from user where id=#{id}")
	public User getUserdById(int id);
	
	@Select("select * from user")
	public List<User> getUserInfo();
	
	@Insert("insert into user(username,password,salt,phone,role_id) values(#{username},#{password},#{salt},#{phone},#{role_id})")
	public int postUserInfo(User user);
	
	@Delete("delete from user where id = #{id}")
	public int deleteUserInfo(int id);
	
	@Update("update user set username=#{username},phone=#{phone},role_id=#{role_id} where id=#{id}")
	public int putUserInfoById(User user);
	
	@Update("update user set password=#{password},salt=#{salt} where id=#{id}")
	public int putUserPasswordById(@Param("id")int id,@Param("password")String password,@Param("salt") String salt);
}
