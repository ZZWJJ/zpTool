package com.learning.www.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
	private int id;
	private String role_name;
	private String role_desc;
	private List<Integer> permissions;
}
