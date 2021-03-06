package com.learning.www.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.www.entity.User;
import com.learning.www.mapper.UserMapper;
import com.learning.www.service.UserMapperService;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 登陆 Controller
 * @Date 2018-04-03
 * @Time 22:28
 */
@Controller
@RequestMapping("/admin")
public class LoginController {
    private final ResultMap resultMap;
    //private final UserMapper userMapper;

    @Autowired
    private UserMapperService userservice;
    
    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping()
    public String toLogin() {
        return "login";
    }
    
    @Autowired
    public LoginController(ResultMap resultMap, UserMapper userMapper) {
        this.resultMap = resultMap;
    }
    @RequestMapping("index")
    public String test() {
        return "index";
    }


    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public String notLogin() {
        return "login";
    }


    @RequestMapping(value = "/notRole", method = RequestMethod.GET)
    @ResponseBody
    public ResultMap notRole() {    
        return resultMap.success().message("您没有权限！");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

    /**
     * 登陆
     *
     * @param username 用户名
     * @param password 密码
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(String username, String password) {
    	
//    	User user01 = new User();
//    	user01.setUsername("admin01");
//    	user01.setPassword("123456");
//    	userservice.postUserInfo(user01);
    	
    	
    	log.info("username:"+username+"===="+"password:"+password);
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
			// 执行认证登陆
			subject.login(token);
		} catch (AccountException e) {
			// 账户或密码错误
			e.printStackTrace();
			log.info(e.getMessage());
			return "error";
		}
        //根据权限，指定返回数据
        User user = userservice.getPasswordByUsername(username);
        if (null != user) {
            return "ok";
        }
        return "error";
    }
}


