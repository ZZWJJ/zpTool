package com.learning.www.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.www.entity.ZphInfo;
import com.learning.www.service.ZphInfoService;

/***
 * GET：查询，POST：新增，PUT：更新，DELETE：删除
 * @author Administrator
 *
 */
@RequestMapping("zph")
@Controller
public class ZphInfoController {
	
	@Autowired
	private ZphInfoService zphservice;
	
	private static Logger logger = LoggerFactory.getLogger(ZphInfoController.class);
	/***
	 * GET：查询	招聘会信息
	 * @param model
	 * @return
	 */
	@RequestMapping("getZphInfo")
	@ResponseBody
	public String getZphInfo(Model model) { 
				
		List<ZphInfo> zphinfolist = new ArrayList<ZphInfo>();
		zphinfolist = zphservice.getZphInfoList();
		model.addAttribute("zphinfolist", zphinfolist);
		for (ZphInfo zphInfo : zphinfolist) {
			logger.info(zphInfo.toString());
		}
		
		return "查找到了招聘会信息:"+zphinfolist.size();
		
	} 
	
	@RequestMapping("getZphInfobyid")
	@ResponseBody
	public String getZphInfoById(String id) { 
		
		int zphid = Integer.parseInt(id);
		ZphInfo zphinfo = new ZphInfo();
		if(null == zphservice.getZphInfoById(zphid)) {			
			return "未查找到数据";
		}
		zphinfo = zphservice.getZphInfoById(zphid);
		return "根据查找到了招聘会信息："+zphinfo.toString(); 
		
	}
	
	/***
	 * POST：新增  招聘会信息
	 * @return
	 */
	@RequestMapping("postZphInfo")
	@ResponseBody
	public int postZphInfo(ZphInfo zphinfo) { 
		
		int ret = zphservice.postZphInfo(zphinfo);		
		logger.info("新增招聘会的id："+zphinfo.getId());
		return ret;				
	}
	
	
	/***
	 * DELETE：删除	指定ID的招聘会
	 * @param id
	 * @return
	 */
	@RequestMapping("delZphInfo")
	@ResponseBody
	public int deleteZphInfo(String id) {
		
		int Id = Integer.parseInt(id);
		int ret = zphservice.deleteZphInfo(Id);
		
		logger.info("删除缓存：招聘会id为"+id);
		return ret;		
	}
	
	/***
	 * PUT：更新	招聘会信息
	 * @param zphinfo
	 * @return
	 */
	public int putZphInfo(ZphInfo zphinfo) { 
		
		
		
		
		return 0;		
	}
	
}
