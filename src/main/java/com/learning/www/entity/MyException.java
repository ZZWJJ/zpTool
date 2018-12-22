package com.learning.www.entity;

import lombok.Getter;
import lombok.Setter;

/***
 * 自定义异常处理类
 * @author Administrator
 *
 */
@Getter
@Setter
public class MyException extends RuntimeException{

	private Integer code;
	

	   public MyException(String msg){
	 
	       super(msg);
	 
	   }
	   
	   public MyException(Integer code,String msg){
		   
	       super(msg);
	 
	       this.code=code;
	 
	   }
}
