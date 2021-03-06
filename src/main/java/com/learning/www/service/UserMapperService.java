package com.learning.www.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.www.entity.User;

public interface UserMapperService {
	
	/***
	 * get 得到所有用户的信息
	 * @return
	 */
	public List<User> getUserInfo(@Param("username") String username, @Param("phone")String phone);
	
	/***
	 * get 根据id得到用户的信息
	 * @param id
	 * @return
	 */
	public User getUserdById(int id);
	
	/***
	 * get 根据username得到password
	 * @param username
	 * @return
	 */
	public User getPasswordByUsername(String username);
	
	/***
	 * post 新增用户
	 * @param user
	 * @return
	 */
	@Transactional
	public int postUserInfo(User user);
	
	/***
	 * del 删除用户信息
	 * @param id
	 * @return
	 */
	@Transactional
	public int deleteUserInfo(int id);
	
	/***
	 * put 更新用户信息
	 * @param user
	 * @return
	 */
	@Transactional
	public int putUserInfoById(User user);
	
	/***
	 * put 重置pasword
	 * @param id
	 * @return
	 */
	@Transactional
	public int putUserPasswordById(int id,String password,String salt);
	
}
