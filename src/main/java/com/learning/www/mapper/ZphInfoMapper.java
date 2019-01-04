package com.learning.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.learning.www.entity.ZphInfo;

@Mapper
public interface ZphInfoMapper {
	
	@Select("select * from zphinfo order by time asc")
	public List<ZphInfo> getZphInfoList();
	
	@Select("select * from zphinfo where id = #{id}")
	public ZphInfo getZphInfoById(int id);
	
	@Select("select * from zphinfo where title = #{title}")
	public ZphInfo getZphInfoByTitle(String title);
	
//	@Insert("insert into zphinfo values(#{title},#{time},#{place},#{add})")
//	public int postZphInfo(ZphInfo zphinfo);
	@Insert("insert into zphinfo(title,time) values(#{title},#{time})")
	public int postZphInfo(ZphInfo zphinfo);
	
	@Delete("delete from zphinfo where id = #{id}")
	public int deleteZphInfo(int id);
	
	@Update("update zphinfo set title = #{title},time = #{time} where id = #{id}")
	public int putZphInfoById(ZphInfo zphinfo);
	
	@Update("update zphinfo set state = #{state} where id = #{id}")
	public int putZphStateById(ZphInfo zphinfo);
}
