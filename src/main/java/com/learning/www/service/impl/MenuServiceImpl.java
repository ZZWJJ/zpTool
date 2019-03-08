package com.learning.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.www.entity.Permission;
import com.learning.www.mapper.MenuMapper;
import com.learning.www.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	MenuMapper menuMapper;
	
	@Override
	public int postMenuTree(Permission perm) {
		return menuMapper.postMenuTree(perm);
	}

	@Override
	public int putPermById(Permission perm) {
		return menuMapper.putPermById(perm);
	}

	@Override
	public int deletePermById(int id) {
		return menuMapper.deletePermById(id);
	}

}
