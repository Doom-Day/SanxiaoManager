package com.sanxiaomanager.service;

import com.sanxiaomanager.RepositorySingleton;
import com.sanxiaomanager.repository.UserDO;

public class LoginBO {
	public static UserDO login(String account, String password, String character) {
		int id = Integer.valueOf(account);
		UserDO user = RepositorySingleton.getUserRepositoryImpl().selectById(id, Integer.valueOf(character));
		
		if(user != null && password.equals(user.getPwd())) {
			return user;
		}else {
			return null;
		}
	}
}
