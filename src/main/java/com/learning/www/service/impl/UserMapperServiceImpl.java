package com.learning.www.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.www.entity.User;
import com.learning.www.mapper.UserMapper;
import com.learning.www.service.UserMapperService;


@Service
public class UserMapperServiceImpl implements UserMapperService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getPasswordByUsername(String username) {
//		System.out.println(username);
//		System.out.println(usermapperservice.getPasswordByUsername(username).toString());
		return userMapper.getPasswordByUsername(username);
	}
	
	
}
