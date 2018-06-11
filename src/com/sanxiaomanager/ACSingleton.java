package com.sanxiaomanager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ACSingleton {
	private static ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
	
	public static ApplicationContext getAC() {
		return ac;
	}
}
