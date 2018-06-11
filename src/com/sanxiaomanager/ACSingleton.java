package com.sanxiaomanager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
152061���*��
* ��С����ϵͳ
* @author zjr
* date:2018-06-11
* ��Ҫ����˵����
* ���ڻ��spring aplicationContext�ĵ���ģʽ��
*/
public class ACSingleton {
	private static ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
	
	public static ApplicationContext getAC() {
		return ac;
	}
}
