package com.learning.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.learning.www.entity.ZphInfo;

@Mapper
public interface ZphInfoMapper {
	
	@Select("select * from zphinfo order by time")
	public List<ZphInfo> getZphInfoList();
	
	@Select("select * from zphinfo where id = #{id}")
	public ZphInfo getZphInfoById(int id);
	
	@Insert("insert into zphinfo values(#{title},#{time},#{place},#{add})")
	public int postZphInfo(ZphInfo zphinfo);
	
	@Delete("delete from zphinfo where id = #{id}")
	public int deleteZphInfo(int id);
}
