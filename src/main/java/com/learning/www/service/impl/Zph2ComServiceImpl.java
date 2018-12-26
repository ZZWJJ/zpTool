package com.learning.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.www.mapper.Zph2ComMapper;
import com.learning.www.service.Zph2ComService;

@Service
public class Zph2ComServiceImpl implements Zph2ComService{

	@Autowired
	Zph2ComMapper zphcommapper;
	
	
	@Override
	public int postZph2Com(int zphid, int comid) {
		return zphcommapper.postZph2Com(zphid, comid);
	}

	@Override
	public int[] getZph2ComByZphId(int zphid) {
		return zphcommapper.getZph2ComByZphId(zphid);
	}

	@Override
	public int[] getZph2ComByComId(int comid) {
		return zphcommapper.getZph2ComByComId(comid);
	}

	@Override
	public int deleteZph2ComByZphId(int zphid) {
		return zphcommapper.deleteZph2ComByZphId(zphid);
	}

}
