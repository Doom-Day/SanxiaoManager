package com.sanxiaomanager.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanxiaomanager.ACSingleton;
import com.sanxiaomanager.repository.UserDO;

@Controller
public class LoginController {
	@RequestMapping("/")
	public String welcome() {
		return "login";
	}
	
	@RequestMapping("/log")
	public String login(String uid, String upwd, Model model) {
		System.out.println(uid + " " + upwd);
		
		UserDO user = LoginBO.login(uid, upwd);
//		model.addAttribute(user);
		if(user == null) {
			//User not exist
			return "login";
		}if(user.getCh() == 0) {
			//User is student = 0
			return "student";
		}else {
			//User is teacher = 1
			return "teacher";
		}
	}
}