package com.learning.www.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface Zph2ComMapper {

	@Insert("insert into zph_com values(#{zphid},#{comid})")
	public int postZph2Com(@Param("zphid") int zphid, @Param("comid") int comid);
	
	@Select("select comid from zph_com where zphid = #{zphid}")
	public int[] getZph2ComByZphId(int zphid);
	
	@Select("select zphid from zph_com where comid = #{comid}")
	public int[] getZph2ComByComId(int comid);
	
	@Delete("delete from zph_com where zphid = #{zphid}")
	public int deleteZph2ComByZphId(int zphid);
}
