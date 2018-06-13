package com.sanxiaomanager.service;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sanxiaomanager.RepositorySingleton;
import com.sanxiaomanager.repository.UserDO;

//@SessionAttributes(value={"user"},types={UserDO.class})
@Controller
public class LoginController {
	@RequestMapping("/")
	public String welcome() {
		RepositorySingleton.setUser(null);
		return "login";
	}
	
	@RequestMapping("/log")
	public ModelAndView login(String uid, String upwd) {
//		System.out.println(uid + " " + upwd);
		
		ModelAndView mav = new ModelAndView();
		
		UserDO user = LoginBO.login(uid, upwd);
		
		if(user == null) {
			//User not exist
			mav.addObject("message", "ÓÃ»§²»´æÔÚ£¬Çë×¢²á");
			mav.setViewName("login");
			return mav;
		}
		
		RepositorySingleton.setUser(user);
		
		mav.addObject("user", user);
		if(user.getCh() == 0) {
			//User is student = 0
			mav.addObject("projectList", RepositorySingleton.getUserRepositoryImpl().getMyProjects(user.getId()));
			mav.setViewName("student");
		}else {
			//User is teacher = 1
			mav.addObject("projectList", RepositorySingleton.getUserRepositoryImpl().getAllProjects());
			mav.setViewName("teacher");
		}
		
		return mav;
	}
	
	@RequestMapping("/register")
	public ModelAndView register(
			String uidsignup,
			String upwdsignup,
			String upwdsignup_confirm,
			String unamesignup,
			String uagesignup,
			String usex,
			String utelsignup,
			String uacsignup,
			String upssignup,
			String uaddsignup
			) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		
		int ch = uidsignup.length()==5?1:0;
		String result = RegisterBO.register(uidsignup, upwdsignup, unamesignup, uagesignup, usex, uacsignup, upssignup, uaddsignup, utelsignup, ch);
		if("success".equals(result)) {
			mav.addObject("message", "");
		}else if("fail".equals(result)){
			mav.addObject("message", "×¢²áÊ§°Ü");
		}else {
			mav.addObject("message", "×¢²á³É¹¦");
		}
		
		return mav;
	}
}