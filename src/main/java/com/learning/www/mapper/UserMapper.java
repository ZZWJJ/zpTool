package com.learning.www.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.learning.www.entity.User;

@Repository
@Mapper
public interface UserMapper {

	@Select("select username,password,role from user where username=#{username}")
	public User getPasswordByUsername(String username);
	
}
