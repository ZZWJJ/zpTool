package com.learning.www.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.www.entity.Role;
import com.learning.www.entity.User;
import com.learning.www.service.RoleService;
import com.learning.www.service.UserMapperService;

/***
 * 管理员Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UserMapperService userservice;
	@Autowired
	RoleService roleService;
	
	@Value("${MyUser.password}")
	private String password;
	
	private static Logger logger = LoggerFactory.getLogger(ZphInfoController.class);
	
	/***
	 * 错误页面
	 * @return
	 */
	@RequestMapping("403")
	public String to403() {
		return "403";
	}
	
	@RequestMapping("/toAdmin")
	public String toAdmin(Model model) {
		List<Role> roleList = roleService.getRoleList();
		model.addAttribute("roleList", roleList);
		return "admin/admin_list";
	}
    	
	/***
	 * GET：查询	用户信息
	 * @param model
	 * @return
	 */
	@RequestMapping("getUserInfo")
	@ResponseBody
	public List<User> getUserInfo(Model model) {              
		List<User> userList = new ArrayList<User>();
		userList = userservice.getUserInfo();
		logger.info("取得所有用户信息："+userList.toString());
		return userList; 		
	} 
	
	/***
	 * 得到单个用户信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("getUserInfoById")
	@ResponseBody
	public User getUserInfoById(int id,Model model) {              
		User user = new User();
		user = userservice.getUserdById(id);
		if(null != user) {
			model.addAttribute("user", user);
			logger.info("取得用户信息："+user.toString());	
		}					
		return user; 		
	} 
	
	/***
	 * POST：新增  用户信息
	 * @return
	 */
	@RequestMapping("postUserInfo")
	@ResponseBody
	@RequiresPermissions (value={"userManagerAdd"})
	public int postUserInfo(User user ) { 
		
		int ret = userservice.postUserInfo(user);		
		logger.info("新增用户的id："+user.getId());
		return ret;				
	}
	
	/***
	 * DELETE：删除	指定ID的用户
	 * @param id
	 * @return
	 */
	@RequestMapping("delUserInfo")
	@ResponseBody
	@RequiresPermissions (value={"userManagerDelete"})
	public int deleteUserInfo(@RequestParam("ids[]") int[] ids) { 
		int flag = 1;
		for (int id : ids) {
			int ret = userservice.deleteUserInfo(id);
			if(ret == 0) {
				flag = 0;
				logger.info("删除用户信息失败：用户id为"+id);
				return flag;
			}
			logger.info("删除用户信息：用户id为"+id);
		}						
		return flag;		
	}
	
	
	/***
	 * PUT：更新	用户信息
	 * @param zphinfo
	 * @return
	 */
	@RequestMapping("putUserInfoById")
	@ResponseBody
	@RequiresPermissions (value={"userManagerUpdate"})
	public int putUserInfoById(User user) { 
		
		int ret = userservice.putUserInfoById(user);
		logger.info("已经更新用户信息，id为："+user.getId());
		
		return ret;
	}
	
	
	@RequestMapping("putUserPasswordById")
	@ResponseBody
	@RequiresPermissions (value={"userManagerUpdatePassword"})
	public int putUserPasswordById(int uid) {
		
		int ret = userservice.putUserPasswordById(uid, password,"");
		
		return ret;
	}	
}
