package com.learning.www.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface Zph2ComService {

	/***
	 * post 新增公司参与的招聘会
	 * @param zphid
	 * @param comid
	 * @return
	 */
	@Transactional
	public int postZph2Com(int zphid, int comid);
	
	/***
	 * get 根据id查找对应关系
	 * @param zphid
	 * @return
	 */
	public int[] getZph2ComByZphId(int zphid);
	
	/***
	 * get 根据id查找对应关系
	 * @param zphid
	 * @return
	 */
	public int[] getZph2ComByComId(int comid);
	
	/***
	 * del 根据id删除对应关系
	 * @param zphid
	 * @return
	 */
	@Transactional
	public int deleteZph2ComByZphId(int zphid);
}
