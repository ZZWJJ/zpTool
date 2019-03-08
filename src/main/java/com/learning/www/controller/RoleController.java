package com.learning.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.www.entity.Node;
import com.learning.www.entity.Role;
import com.learning.www.service.RoleService;

@Controller
@RequestMapping("role")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	/***
	 * 树结构
	 * @return
	 */
	@RequestMapping("getTree")
	@ResponseBody
	public List<Node> getTree(){
		
		List<Node> nodeList = roleService.getTree();		
		return nodeList;
		
	}
	
	/***
	 * 页面：role
	 * @return
	 */
	@RequestMapping("toRole")
	public String toRole() {		
		return "admin/Role";				
	}
	/***
	 * 获取角色列表
	 * @return
	 */
	@RequestMapping("getRole")
	@ResponseBody
	public List<Role> getRole(){
		List<Role> roleList = roleService.getRoleList();		
		return roleList;		
	}
	
	/***
	 * 新增角色、绑定角色和权限
	 * @param role_name
	 * @param role_desc
	 * @param _list
	 * @return
	 */
	@RequestMapping("postRole")
	@ResponseBody
	public int postRole(String role_name,String role_desc,@RequestParam("_list[]") int[] _list) {
		int ret = 0;	//返回参数  0：失败，1：成功，2：已存在
		List<Integer> isExist = roleService.getRoleByNameAndDesc(role_name,role_desc);
		if(!isExist.isEmpty()) {
			ret = 2;
			return ret;
		}else {
			//新增角色
			ret = roleService.postRole(role_name, role_desc);
			if(ret == 1) {
				int role_id = roleService.getRoleByName(role_name);
				// 绑定权限
				for (int perm_id : _list) {
					ret = roleService.postRolePerm(role_id, perm_id);
					if(ret == 0) {
						return ret;
					}
				}				
			}
		}
		
		return ret;
	}
	
	
	/***
	 * 权限树结构回显
	 * @return
	 */
	@RequestMapping("getRoleTree")
	@ResponseBody
	public List<Node> getRoleTreeById(int role_id){
		List<Node> permIdList = roleService.getPermIdByRoleID(role_id);
		return permIdList;		
	}
	
	/***
	 * 更新角色权限信息
	 * @param role_id
	 * @param role_name
	 * @param role_desc
	 * @param _list
	 * @return
	 */
	@RequestMapping("putRolePerm")
	@ResponseBody
	public int putRolePerm(String id,String role_name,String role_desc,@RequestParam("_list[]") int[] _list) {
		int role_id = Integer.parseInt(id);
		int ret = roleService.putRolePermByRoleId(role_id, role_name, role_desc);
		roleService.deleteRolePerm(role_id);
		if(ret==1) {
			for (int perm_id : _list) {
				ret = roleService.postRolePerm(role_id, perm_id);
				if(ret == 0) {
					return ret;
				}
			}
		}
		return ret;		
	}
	
	/***
	 * 删除角色
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteRole")
	@ResponseBody
	public int deleteRole(String id) {
		int ret = 0;
		int role_id = Integer.parseInt(id);
		boolean flag1 = (roleService.deleteRolePerm(role_id)>=0)?true:false;
		boolean flag2 = (roleService.deleteRole(role_id)>=0)?true:false;
		if(flag1 && flag2) {
			ret = 1;
		}
		return ret;
	}
	
	
	
	
	
	
	
}
