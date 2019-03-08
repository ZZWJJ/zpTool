package com.learning.www.service;

import org.springframework.stereotype.Service;

import com.learning.www.entity.Permission;

@Service
public interface MenuService {

	public int postMenuTree(Permission perm);
	
	public int putPermById(Permission perm);
	
	public int deletePermById(int id);
	
}
