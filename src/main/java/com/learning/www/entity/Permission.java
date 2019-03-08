package com.learning.www.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
	private int id;
	private String perm_token;	//shiro通过保存该属性集合做权限控制
	private String perm_desc;	//权限名称用于zTree显示
	private int parent_id;		//父权限ID
	private int level;			//通过level来实现zTree的自定义图片功能
}
