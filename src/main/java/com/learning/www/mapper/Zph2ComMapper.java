package com.learning.www.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.learning.www.entity.Com_Zph;



@Mapper
public interface Zph2ComMapper {

	@Insert("insert into zph_com(zphid,comid) values(#{zphid},#{comid})")
	public int postZph2Com(@Param("zphid") int zphid, @Param("comid") int comid);
	
	@Select("select comid from zph_com where zphid = #{zphid}")
	public int[] getZph2ComByZphId(int zphid);
	
	@Select("select zphid from zph_com where comid = #{comid}")
	public int[] getZph2ComByComId(int comid);
	
	@Select("select * from zph_com where comid = #{comid} and zphid=#{zphid}")
	public Com_Zph getZph2ComByComIdZphId(@Param("comid")int comid,@Param("zphid")int zphid);
	
	@Delete("delete from zph_com where id = #{id}")
	public int deleteZph2ComByZphId(int id);
	
	@Update("update zph_com set isjoin = #{isjoin} where id = #{id}")
	public int putJoinStateByid(@Param("id")int id,@Param("isjoin")int isjoin);
	
	@Update("update zph_com set addinfo = #{addinfo} where id = #{id}")
	public int putAddInfoById(@Param("id")int id,@Param("addinfo")String addinfo);
}
