package com.learning.www.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.www.entity.Node;
import com.learning.www.entity.Role;
import com.learning.www.mapper.RoleMapper;
import com.learning.www.service.RoleService;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl implements RoleService{

	@Resource
	RoleMapper roleMapper;
	
	@Override
	public List<Node> getTree() {
		return roleMapper.getTree();
	}

	@Override
	public List<Role> getRoleList( String name, String desc) {
		return roleMapper.getRoleList(name,desc);
	}

	@Override
	public String getRoleNmae(int id) {
		return roleMapper.getRoleNmae(id);
	}

	@Override
	public List<Integer> getRoleByNameAndDesc(String role_name, String role_desc) {
		// TODO Auto-generated method stub
		return roleMapper.getRoleByNameAndDesc(role_name, role_desc);
	}

	@Override
	public int postRole(String role_name, String role_desc) {
		// TODO Auto-generated method stub
		return roleMapper.postRole(role_name, role_desc);
	}

	@Override
	public int postRolePerm(int role_id, int perm_id) {
		// TODO Auto-generated method stub
		return roleMapper.postRolePerm(role_id, perm_id);
	}

	@Override
	public int getRoleByName(String role_name) {
		// TODO Auto-generated method stub
		return roleMapper.getRoleByName(role_name);
	}

	@Override
	public List<Node> getPermIdByRoleID(int role_id) {
		return roleMapper.getPermIdByRoleID(role_id);
	}

	@Override
	public int putRolePermByRoleId(int id, String role_name, String role_desc) {
		// TODO Auto-generated method stub
		return roleMapper.putRolePermByRoleId(id, role_name, role_desc);
	}

	@Override
	public int deleteRolePerm(int role_id) {
		// TODO Auto-generated method stub
		return roleMapper.deleteRolePerm(role_id);
	}

	@Override
	public int deleteRole(int id) {
		// TODO Auto-generated method stub
		return roleMapper.deleteRole(id);
	}

	@Override
	public List<String> getPermTokenByRoleID(int role_id) {
		// TODO Auto-generated method stub
		return roleMapper.getPermTokenByRoleID(role_id);
	}


}
