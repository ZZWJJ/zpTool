package com.learning.www.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.learning.www.entity.Permission;

@Mapper
public interface MenuMapper {
	
	@Insert("insert into permission(perm_token,perm_desc,parent_id,level) values(#{perm_token},#{perm_desc},#{parent_id},#{level})")
	public int postMenuTree(Permission perm);
	
	@Update("update permission set perm_token = #{perm_token},perm_desc = #{perm_desc},parent_id = #{parent_id},level=#{level} where id = #{id}")
	public int putPermById(Permission perm);
	
	@Delete("delete from permission where id = #{id} or parent_id = #{id}")
	public int deletePermById(int id);
	

}
