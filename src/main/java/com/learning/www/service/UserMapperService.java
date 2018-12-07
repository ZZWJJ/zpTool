package com.learning.www.service;


import org.springframework.stereotype.Service;

import com.learning.www.entity.User;

@Service
public interface UserMapperService {
	
	public User getPasswordByUsername(String username);
	
}
