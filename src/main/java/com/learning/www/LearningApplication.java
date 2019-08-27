package com.learning.www;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.github.pagehelper.PageHelper;
import com.learning.www.entity.FriendUrl;
import com.learning.www.service.FriendUrlService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.google.zxing.WriterException;
import com.learning.www.entity.User;
import com.learning.www.mapper.UserMapper;
import com.learning.www.service.UserMapperService;
import com.learning.www.shiro.config.ShiroEncryption;
import com.learning.www.utils.PrintImage;
import com.learning.www.utils.PrintJobToImg;
import com.learning.www.utils.QrCodeUtil;
import com.learning.www.utils.Quartz;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@MapperScan("com.learning.www.mapper")
@RestController
public class LearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningApplication.class, args);		
//	      PrintImage tt = new PrintImage();
//	      BufferedImage d = tt.loadImageLocal("D:\\test\\muban.jpg");
//	      String title = "撒大大是多少有限公司";
//	      int x = title.length() * 96;
//	      // 公司标题 72号字体==96px
//	      tt.setFont(new Font("造字工房力黑（非商用）常规体", Font.BOLD, 76));
//	      //tt.modifyImage(d, title, (1920-x)/2-960, -420, new Color(65,105,225));
//	      //tt.modifyShapImg(d, title, (1920-x)/2-960, -420);
//	      tt.modifyShapImg(d, title, (1920-x)/2, 130);
//	      
//	      //公司简介，限定字数
//	      tt.setFont(new Font("黑体",Font.PLAIN, 30));
//	      String str = "功能：可以实现在图片模板上写内容并保存"+"功能：可以实现在图片模板上写内容并保存"+"功能：可以实现在图片模板上写内容并保存"
//	      +"功能：可以实现在图片模板上写内容并保存"+"功能：可以实现在图片模板上写内容并保存"+"功能：可以实现在图片模板上写内容并保存"+"功能：可以实现在图片模板上写内容并保存"+"功能：可以实现在图片模板上写内容并保存"
//	      +"功能：可以实现在图片模板上写内容并保存"+"功能：可以实现在图片模板上写内容并保存"+"功能：可以实现在图片模板上写内容并保存"+"功能：可以实现在图片模板上写内容并保存"+"功能：可以实现在图片模板上写内容并保存"
//	      +"功能：可以实现在图片模板上写内容并保存"+"功能：可以实现在图片模板上写内容并保存"+"功能：可以实现在图片模板上写内容并保存"+"功能：可以实现在图片模板上写内容并保存"+"功能：可以实现在图片模板上写内容并保存";
//	      System.out.println(str.length());
//	      //计算字符串长度
//	      int strleth=str.length();
//	      //计算循环次数
//	      int num = strleth/20;
//	      //字符串截取第一位
//	      int subindex = 0;
//	      //字符串截取第二位
//    	  int j = 20;
//    	  //距离y轴的位置
//    	  int y = -350;
//	      String[] s = new String[num+1];
//	      if(num < 1 )	{
//	    	  System.out.println(num);
//	    	  tt.modifyImage(d, str, -830, y,new Color(0,0,0));
//	      }else {
//		      for(int i = 0;i<num;i++) {
//		    	  s[i] = str.substring(subindex, j);
//		    	  tt.modifyImage(d, s[i], -830, y,new Color(0,0,0));
//		    	  subindex=j;
//		    	  j+=20;
//		    	  y+=35;
//		      }
//		      if(strleth%20 != 0) {
//		    	  //System.out.println("不等于0");
//		    	  s[num] = str.substring(num * 20);
//		    	  tt.modifyImage(d, s[num], -830, y,new Color(0,0,0));
//		      }
//	      }
//	      // 公司岗位6个
//	      String job1 = "普工";
//	      String amount1 = "3人";
//	      String salary1 = "4000元/月";
//	      String need1 = "吃苦耐劳，具有专业的技术能力。吃苦耐劳，具有专业的技术能力。吃苦耐劳，具有专业的技术能力。吃苦耐劳，具有专业的技术能力。吃苦耐劳，具有专业的技术能力。"
//	      		+ "吃苦耐劳，具有专业的技术能力。";
//	      y = -350;
//	      PrintJobToImg.printJobToImg(tt, d, job1, need1, amount1, salary1, y);
//	      PrintJobToImg.printJobToImg(tt, d, job1, need1, amount1, salary1, y+110);
//	      PrintJobToImg.printJobToImg(tt, d, job1, need1, amount1, salary1, y+220);
//	      PrintJobToImg.printJobToImg(tt, d, job1, need1, amount1, salary1, y+330);
//	      PrintJobToImg.printJobToImg(tt, d, job1, need1, amount1, salary1, y+440);
//	      PrintJobToImg.printJobToImg(tt, d, job1, need1, amount1, salary1, y+550);
//	      
//	      // 联系方式和抵地址
//	      String name = "张先生";
//	      String tel = "12334343443";
//	      String company = "盐都区高新区振兴路汇鑫大厦";
//	      tt.setFont(new Font("黑体",Font.BOLD, 40));
//	      tt.modifyImage(d, name, -650, 360,new Color(0,0,0));
//	      tt.modifyImage(d, tel, -450, 360,new Color(0,0,0));
//	      tt.modifyImage(d, company, -650, 440,new Color(0,0,0));
//	      
//	      
//	      //tt.modifyImage(d, str, -830, -100);
//	      tt.writeImageLocal("D:\\test\\cc_1.jpg", d);
//	      System.out.println("success");
//	      System.out.println(s[0]);
//	      System.out.println(s[0].length());
	      //查阅本地的字体库
//          GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//          String[] fontList = ge.getAvailableFontFamilyNames();
//          for(int i=0;i<fontList.length;i++)
//          {
//               System.out.println("字体："+fontList[i]);
//          }
//		try {
//			QrCodeUtil.createQrCode("D:\\test\\qrcode.jpg","https://mp.weixin.qq.com/mp/homepage?__biz=MjM5MjQ4MzQ5MQ==&hid=10&sn=4032d989520470d264438402090f4dfd&scene=18\r\n" + 
//					"",1500,"JPEG");
//		} catch (WriterException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		// shiro 自带的工具类生成salt	
	}

	@Bean
	public PageHelper pageHelper(){
		         PageHelper pageHelper = new PageHelper();
		         Properties properties = new Properties();
		         properties.setProperty("offsetAsPageNum","true");
		         properties.setProperty("rowBoundsWithCount","true");
		         properties.setProperty("reasonable","true");
		         properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
		         pageHelper.setProperties(properties);
		        return pageHelper;
	}

	@Configuration
	public class WebMvcConfiguration extends WebMvcConfigurationSupport {
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			//addResourceHandler是指你想在url请求的路径
			//addResourceLocations是图片存放的真实路径
			registry.addResourceHandler("/image/**").addResourceLocations("file:D://upload/");
			registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
			super.addResourceHandlers(registry);
		}
	}

}
