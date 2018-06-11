package com.sanxiaomanager.service;

import com.sanxiaomanager.RepositorySingleton;
import com.sanxiaomanager.repository.UserDO;

public class LoginBO {
	public static String login(String account, String password) {
		int id = Integer.valueOf(account);
		UserDO user = RepositorySingleton.getUserRepositoryImpl().selectById(id);
		
		if(user == null)
			return "user not exist";
		
		if(password.equals(user.getPwd())) {
			if(user.getCh() == 0) {
				return "student";
			}else {
				return "teacher";
			}
		}else {
			return "password wrong";
		}
	}
}
