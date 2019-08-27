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

@Mapper
public interface UserMapper {

	@Select("select * from user where username=#{username}")
	public User getPasswordByUsername(String username);
	
	@Select("select * from user where id=#{id}")
	public User getUserdById(int id);
	
	@Select("SELECT u.id,u.username,u.phone,r.role_name role FROM user u left join role r on u.role_id = r.id" +
			" WHERE u.username LIKE CONCAT('%',#{username},'%') and u.phone LIKE CONCAT('%',#{phone},'%') order by u.id desc")
	public List<User> getUserInfo(@Param("username") String username,@Param("phone")String phone);
	
	@Insert("insert into user(username,password,salt,phone,role_id) values(#{username},#{password},#{salt},#{phone},#{role_id})")
	public int postUserInfo(User user);
	
	@Delete("delete from user where id = #{id}")
	public int deleteUserInfo(int id);
	
	@Update("update user set username=#{username},phone=#{phone},role_id=#{role_id} where id=#{id}")
	public int putUserInfoById(User user);
	
	@Update("update user set password=#{password},salt=#{salt} where id=#{id}")
	public int putUserPasswordById(@Param("id")int id,@Param("password")String password,@Param("salt") String salt);
}
