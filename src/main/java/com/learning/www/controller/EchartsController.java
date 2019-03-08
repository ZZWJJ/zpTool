package com.learning.www.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.www.entity.EchartComAmount;
import com.learning.www.entity.EchartZphAmount;
import com.learning.www.service.Zph2ComService;

@Controller
@RequestMapping("echart")
public class EchartsController {

	@Autowired
	Zph2ComService zphcomservice;
	
	@RequestMapping("getComAmount")
	@ResponseBody
	public List<EchartComAmount> getComAmount() {
		
		List<EchartComAmount> comAmountList = new ArrayList<>();
		
		comAmountList = zphcomservice.getComAmount();
		
		return comAmountList;		
	}
	
	@RequestMapping("getZphAmount")
	@ResponseBody
	public List<EchartZphAmount> getZphAmount(){
		
		List<EchartZphAmount> zphAmountList = new ArrayList<>();
		
		zphAmountList = zphcomservice.getZphAmount();
		
		return zphAmountList;		
		
	}
	
}
