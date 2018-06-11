package com.sanxiaomanager.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanxiaomanager.ACSingleton;
import com.sanxiaomanager.repository.UserDO;

@Controller
public class LoginController {
	@RequestMapping("/")
	public String login(String account,String password,Model model) {
		UserDO user= (UserDO)ACSingleton.getAC().getBean("userDO");
		user.setId(Integer.valueOf(account));
		user.setPwd(password);
		model.addAttribute(user);
		return "login";
	}
	
	@RequestMapping("/checklogin")
	public String login(@Validated UserDO user, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "login";
		}else {
			return "welcome";
		}
	}
}
