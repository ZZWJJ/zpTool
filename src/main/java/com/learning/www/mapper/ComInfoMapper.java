package com.learning.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.learning.www.entity.ComInfo;

@Mapper
public interface ComInfoMapper {
	
	/***
	 * 获取所有公司信息
	 * @return
	 */
	@Select("select * from company order by id asc")
	public List<ComInfo> getComInfoList();
	
	/***
	 * 根据id获取对应公司信息
	 * @param id
	 * @return
	 */
	@Select("select * from company where id = #{id}")
	public ComInfo getComInfoById(int id);
	
	/***
	 * 根据uid获取对应公司信息
	 * @param uid
	 * @return
	 */
	@Select("select * from company where uid = #{uid}")
	public List<ComInfo> getComInfoByUid(int uid);
	
	@Insert("insert into company(uid,cname,contactor,phone,addinfo) values(#{uid},#{cname},#{contactor},#{phone},#{addinfo})")
	public int postComInfo(ComInfo cominfo);
	
	@Delete("delete from company where id = #{id}")
	public int deleteComInfo(int id);
	
	@Update("update company set uid=#{uid},cname=#{cname},contactor=#{contactor},phone=#{phone},addinfo=#{addinfo} where id=#{id}")
	public int putComInfoById(ComInfo cominfo);
		
}
