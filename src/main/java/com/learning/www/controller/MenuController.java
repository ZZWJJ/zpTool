package com.learning.www.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.www.entity.Node;
import com.learning.www.entity.Permission;
import com.learning.www.service.MenuService;
import com.learning.www.service.RoleService;

@Controller
@RequestMapping("menu")
public class MenuController {
	
	@Autowired
	RoleService roleService;
	@Autowired
	MenuService menuService;
	
	private static Logger logger = LoggerFactory.getLogger(ZphInfoController.class);
	/***
	 * 页面：菜单管理
	 * @return
	 */
	@RequestMapping("toMenu")
	public String toMenu() {		
		return "admin/menu";				
	}
	
	/***
	 * 树结构
	 * @return
	 */
	@RequestMapping("getMenu")
	@ResponseBody
	public List<Node> getTree(){
		
		List<Node> nodeList = roleService.getTree();		
		return nodeList;
		
	}
	
	/***
	 * 添加菜单权限
	 * @param perm
	 * @return
	 */
	@RequestMapping("postPermMenu")
	@ResponseBody
	public int postPermMenu(Permission perm) {
		
		logger.info(perm.toString());
		int ret = menuService.postMenuTree(perm);
		
		return ret;		
	}
	
	/***
	 * 菜单权限更新
	 * @param perm
	 * @return
	 */
	@RequestMapping("putPermMenu")
	@ResponseBody
	public int putPermMenu(Permission perm) {
		
		int ret = menuService.putPermById(perm);
		
		return ret;		
	}
	
	@RequestMapping("deletePerm")
	@ResponseBody
	public int deletePerm(int id) {
		
		int ret = menuService.deletePermById(id);
		
		return ret;		
	}
	
}
