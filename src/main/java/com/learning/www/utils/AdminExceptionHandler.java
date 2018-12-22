package com.learning.www.utils;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.www.entity.MyException;

@ControllerAdvice
public class AdminExceptionHandler {
    
	private static final Logger logger = LoggerFactory.getLogger(AdminExceptionHandler.class);
	
    /***
     * 全局异常
     * @param ex
     * @return
     */
	@ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map javaExceptionHandler(Exception ex) {
        logger.error("捕获到Exception异常",ex);
        //异常日志入库
        Map map = new HashMap<>();
        map.put("code", 100);
        map.put("msg", ex.getMessage());
        return map;
    }

	/***
	 * 自定义异常捕获处理
	 * @param ex
	 * @return
	 */
   @ResponseBody
   @ExceptionHandler(value = MyException.class)
   public Map myErrorHandler(MyException ex) {
       logger.error("捕获到MyException异常",ex);
       //异常日志入库
       Map map = new HashMap<>();
       map.put("code", ex.getCode());
       map.put("msg", ex.getMessage());
       return map;
   }


}
