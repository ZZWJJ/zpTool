package com.learning.www.controller;

import java.util.ArrayList;
import java.util.List;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.www.entity.ComInfo;
import com.learning.www.entity.User;
import com.learning.www.entity.ZphInfo;
import com.learning.www.service.CompanyInfoService;
import com.learning.www.service.UserMapperService;
import com.learning.www.service.Zph2ComService;
import com.learning.www.service.ZphInfoService;

@RequestMapping("com")
@Controller
public class CompanyInfoController {

	@Autowired
	CompanyInfoService companyinfoservice;
	
	@Autowired
	ZphInfoService zphinfoservice;
	
	@Autowired
	UserMapperService userservice;
	
	@Autowired
	Zph2ComService zphcomservice;
	
	private static Logger logger = LoggerFactory.getLogger(ZphInfoController.class);
	
	
	@RequestMapping("toCom")
	public String toCom() {
		return "company/com_list";
	}
	
	@RequestMapping("toMyCom")
	public String toMyCom() {
		return "user/user_com";
	}
	/***
	 * GET：查询	招聘会信息
	 * @param model
	 * @return
	 */
	@RequestMapping("getComInfo")
	@ResponseBody
	public List<ComInfo> getComInfo(Model model) {
		List<ComInfo> comList = new ArrayList<ComInfo>();
		comList = companyinfoservice.getComInfoList();
		logger.info("取得所有企业信息："+comList.toString());
		return comList; 		
	} 
	
	/***
	 * GET：查询	根据id查找公司信息
	 * @param id
	 * @return
	 */
	@RequestMapping("getComInfoById")
	@ResponseBody
	public List<ComInfo> getComInfoById(int id) {
		List<ComInfo> comList = new ArrayList<ComInfo>();
		ComInfo com = new ComInfo();
		com = companyinfoservice.getComInfoById(id);
		comList.add(com);
		
		return comList;
	}
	
	/***
	 * GET：查询	根据公司id查找招聘会信息
	 * @param comid
	 * @return
	 */
	@RequestMapping("getZphComById")
	@ResponseBody
	public List<ZphInfo> getZphComById(int id) {
		int [] Zphid = zphcomservice.getZph2ComByComId(id);
		ZphInfo zph = new ZphInfo();
		List<ZphInfo> zphList = new ArrayList<ZphInfo>();
		
		for (int zphid : Zphid) {
			zph = zphinfoservice.getZphInfoById(zphid);
			logger.info(zphList.toString());
			zphList.add(zph);
		}
		logger.info(zphList.toString());
		
		return zphList;
	}
	
	/***
	 * GET：查询	根据uid查找公司信息
	 * @param uid
	 * @return
	 */
	@RequestMapping("getComInfoByUid")
	@ResponseBody
	public List<ComInfo> getComInfoByUid() {
		
		Subject sub = SecurityUtils.getSubject();
		String loginName = (String) sub.getPrincipal();
		logger.info(loginName);
		User user = userservice.getPasswordByUsername(loginName);
		List<ComInfo> comList = new ArrayList<ComInfo>();
		comList = companyinfoservice.getComInfoByUid(user.getId());
		
		
		return comList;
	}
	
	/***
	 * POST：新增  公司信息
	 * @return
	 */
	@RequestMapping("postComInfo")
	@ResponseBody
	public int postComInfo(ComInfo cominfo ) { 
		
		int ret = companyinfoservice.postComInfo(cominfo);		
		logger.info("新增公司的id："+cominfo.getId());
		return ret;				
	}
	
	
	/***
	 * DELETE：删除	指定ID的招聘会
	 * @param id
	 * @return
	 */
	@RequestMapping("delComInfo")
	@ResponseBody
	public int deleteComInfo(@RequestParam("ids[]") int[] ids) {
		int flag = 1;
		//int Id = Integer.parseInt(id);
		for (int id : ids) {
			//int Id = Integer.parseInt(id);
			int ret = companyinfoservice.deleteComInfo(id);
			if(ret == 0) {
				flag = 0;
				logger.info("删除公司信息失败：公司id为"+id);
				return flag;
			}
			logger.info("删除公司信息：公司id为"+id);
		}						
		return flag;		
	}
	
	/***
	 * PUT：更新	招聘会信息
	 * @param zphinfo
	 * @return
	 */
	@RequestMapping("putComInfoById")
	@ResponseBody
	public int putZphInfoById(ComInfo cominfo) { 
		
		logger.info(cominfo.toString());
		Subject sub = SecurityUtils.getSubject();
		String loginName = (String) sub.getPrincipal();
		cominfo.setUid(1);
		
		int ret = companyinfoservice.putComInfoById(cominfo);
		logger.info("已经更新公司信息，id为："+cominfo.getId());
		
		return ret;
	}
	
	/***
	 * post 增加对应id公司参与的招聘会id
	 * @param com
	 * @param zph
	 * @return
	 */
	@RequestMapping("getZphComid")
	@ResponseBody
	public int getZphComid(@RequestParam("comid[]") int[] com,@RequestParam("zphid[]") int[] zph) {		
//		logger.info("com:"+com[0]);
//		logger.info("zph:"+zph[0]);
		
		int ret = 1;
		for (int i = 0; i < zph.length; i++) {
			ret = zphcomservice.postZph2Com(zph[i], com[0]);
			if(ret == 0) {
				return 0;
			}
		}		
		
		return ret;
	}
	
	@RequestMapping("deleteZph2ComByZphId")
	@ResponseBody
	public int deleteZph2ComByZphId(int zphid) {		
		
		int ret = zphcomservice.deleteZph2ComByZphId(zphid);
		
		return ret;
	}
	
	
	
	
	
	
	
	
	
}
