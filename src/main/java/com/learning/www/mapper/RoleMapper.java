package com.learning.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.learning.www.entity.Node;
import com.learning.www.entity.Role;

@Mapper
public interface RoleMapper {
	
	@Select("SELECT p.id id, p.parent_id pId, p.perm_desc name, p.level level, p.perm_token token FROM permission p")
	public List<Node> getTree();
	
	@Select("SELECT * FROM role")
	public List<Role> getRoleList();
	
	@Select("SELECT role_name FROM role where id=#{id}")
	public String getRoleNmae(int id);
	
	@Select("SELECT id FROM role where role_name=#{role_name} or role_desc=#{role_desc}")
	public List<Integer> getRoleByNameAndDesc(@Param("role_name") String role_name,@Param("role_desc")String role_desc);
	
	@Select("SELECT id FROM role where role_name=#{role_name}")
	public int getRoleByName(String role_name);
	
	@Insert("insert into role(role_name,role_desc) values(#{role_name},#{role_desc})")
	public int postRole(@Param("role_name") String role_name,@Param("role_desc")String role_desc);
	
	@Insert("insert into role_permission(role_id,perm_id) values(#{role_id},#{perm_id})")
	public int postRolePerm(@Param("role_id") int role_id,@Param("perm_id")int perm_id);
	
	@Select("SELECT p.id,p.parent_id pid,p.perm_desc NAME,p.level,IF (p.id IN (SELECT perm_id FROM role_permission WHERE role_id = #{role_id}), TRUE,FALSE) checked FROM permission p")
	public List<Node> getPermIdByRoleID(int role_id);
	
	@Select("select p.perm_token from permission p left join role_permission rp on p.id = rp.perm_id where rp.role_id = #{role_id};")
	public List<String> getPermTokenByRoleID(int role_id);
	
	@Update("update role set role_name = #{role_name},role_desc = #{role_desc} where id = #{id}")
	public int putRolePermByRoleId(@Param("id")int id,@Param("role_name")String role_name,@Param("role_desc")String role_desc);
	
	@Delete("delete from role_permission where role_id = #{role_id}")
	public int deleteRolePerm(int role_id);
	
	@Delete("delete from role where id = #{id}")
	public int deleteRole(int id);
	
}
