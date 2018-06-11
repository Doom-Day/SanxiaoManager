package com.sanxiaomanager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
152061班第*组
* 三小管理系统
* @author zjr
* date:2018-06-11
* 主要功能说明：
* 用于获得spring aplicationContext的单例模式类
*/
public class ACSingleton {
	private static ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
	
	public static ApplicationContext getAC() {
		return ac;
	}
}
