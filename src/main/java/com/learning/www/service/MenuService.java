package com.learning.www.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.www.entity.Permission;

public interface MenuService {

	@Transactional
	public int postMenuTree(Permission perm);
	
	@Transactional
	public int putPermById(Permission perm);
	
	@Transactional
	public int deletePermById(int id);
	
}
