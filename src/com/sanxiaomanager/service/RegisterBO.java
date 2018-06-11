package com.sanxiaomanager.service;

import com.sanxiaomanager.ACSingleton;
import com.sanxiaomanager.RepositorySingleton;
import com.sanxiaomanager.repository.UserDO;

public class RegisterBO {
	public static String register(
			int id, String pwd, String name, int age, String sex,
			String ac, String ps, String add, String tel, int ch) {
		UserDO user = (UserDO)ACSingleton.getAC().getBean("userDO");
		user.setId(id);
		user.setPwd(pwd);
		user.setName(name);
		user.setAge(age);
		user.setSex(sex);
		user.setAc(ac);
		user.setPs(ps);
		user.setAdd(add);
		user.setTel(tel);
		user.setCh(ch);
		
		if(RepositorySingleton.getUserRepositoryImpl().insert(user))
			return "success";
		else
			return "fail";
	}
}
