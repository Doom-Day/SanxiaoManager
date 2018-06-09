package com.sanxiaomanager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sanxiaomanager.repository.UserDO;
import com.sanxiaomanager.repository.UserRepositoryImpl;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
		UserDO user = new UserDO();
		user.setId(124);
		user.setPwd("123");
		user.setName("xiaoming");
		user.setAge(10);
		user.setSex("ÄÐ");
		user.setAc("software");
		user.setPs("dangyuan");
		user.setAdd("haiyuan");
		user.setTel("123123");
		user.setCh(0);
//		UserDO user = new UserRepositoryImpl((JdbcTemplate)ac.getBean("jdbcTemplate")).selectById(123);
//		System.out.println(user.toString());

		UserRepositoryImpl r = new UserRepositoryImpl((JdbcTemplate)ac.getBean("jdbcTemplate"));
		if(r.delete(123))
			System.out.println("Delete success");
		else
			System.out.println("Delete fail");
	}

}
