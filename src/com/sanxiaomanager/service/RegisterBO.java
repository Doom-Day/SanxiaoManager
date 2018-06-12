package com.sanxiaomanager.service;

import com.sanxiaomanager.ACSingleton;
import com.sanxiaomanager.RepositorySingleton;
import com.sanxiaomanager.repository.UserDO;

public class RegisterBO {
	public static String register(
			String id, String pwd, String name, String age, String sex,
			String ac, String ps, String add, String tel, int ch) {
		
		//if user already exist
		if(RepositorySingleton.getUserRepositoryImpl().selectById(Integer.valueOf(id)) != null) {
			return "exist";
		}
		
		UserDO user = (UserDO)ACSingleton.getAC().getBean("userDO");
		user.setId(Integer.valueOf(id));
		user.setPwd(pwd);
		user.setName(name);
		user.setAge(Integer.valueOf(age));
		user.setSex(sex);
		user.setAc(ac);
		user.setPs(ps);
		user.setAdd(add);
		user.setTel(tel);
		user.setCh(ch);
		
		System.out.println(user.toString());
		
		if(RepositorySingleton.getUserRepositoryImpl().insert(user))
			return "success";
		else
			return "fail";
	}
}
