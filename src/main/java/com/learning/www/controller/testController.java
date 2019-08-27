//package com.learning.www.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.learning.www.redis.RedisUtil;
//import com.learning.www.service.UserMapperService;
//
//@RestController
//public class testController {
//
//
//    @Autowired
//    private UserMapperService userService;
//
//    @Autowired
//    private RedisUtil redisTemplate;
//
//    @RequestMapping("test")
//    public String test() {
//
//    	return userService.getPasswordByUsername("joke").toString();
//    }
//
//    @RequestMapping("testredis")
//    public boolean set() {
//    	boolean ret = redisTemplate.set("test1", "ok");
//    	boolean ret1 = redisTemplate.set("test2", "good!");
//    	return ret;
//    }
//
//    @RequestMapping("testredis1")
//    public String get() {
//    	String ret = (String) redisTemplate.get("test1");
//    	String ret1 = (String) redisTemplate.get("test2");
//    	System.out.println(ret+ret1);
//    	return ret+"+"+ret1;
//    }
//}
