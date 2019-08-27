package com.learning.www.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.www.entity.Node;
import com.learning.www.entity.Role;

public interface RoleService {
	
	public List<Node> getTree();
	
	public List<Role> getRoleList(@Param("name") String name, @Param("desc")String desc);
	
	public String getRoleNmae(int id);
	
	public int getRoleByName(String role_name);
	
	public List<Integer> getRoleByNameAndDesc(String role_name,String role_desc);
	
	@Transactional
	public int postRole(String role_name,String role_desc);
	
	@Transactional
	public int postRolePerm(int role_id,int perm_id);
	
	public List<Node> getPermIdByRoleID(int role_id);
	
	@Transactional
	public int putRolePermByRoleId(int id,String role_name,String role_desc);
	
	@Transactional
	public int deleteRolePerm(int role_id);
	
	@Transactional
	public int deleteRole(int id);
	
	public List<String> getPermTokenByRoleID(int role_id);
}
