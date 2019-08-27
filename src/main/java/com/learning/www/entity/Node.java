package com.learning.www.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node {
	 
	// 节点id
	private Integer id;
	// 父节点id
	@JsonProperty
	private Integer pId;
	// 节点名称
	private String name;
	//排序序号 用于栏目
	private int sortnum;
	//是否展示 用于栏目
	private int isshow;
	// 需要自定义图片时，使用该属性
	private String iconSkin;
	// 需要自定义图片时，使用该属性
	private String token;
	// 通过该属性，设置图片
	private Integer level;
	// 当需要设置某个节点被选中的时候，通过该属性定义
	private Boolean checked;
}

