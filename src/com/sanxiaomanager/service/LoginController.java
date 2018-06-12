package com.sanxiaomanager.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sanxiaomanager.repository.UserDO;

@Controller
public class LoginController {
	@RequestMapping("/")
	public String welcome() {
		return "login";
	}
	
	@RequestMapping("/log")
	public ModelAndView login(String uid, String upwd, Model model) {
//		System.out.println(uid + " " + upwd);
		
		ModelAndView mav = new ModelAndView();
		
		UserDO user = LoginBO.login(uid, upwd);
		
		if(user == null) {
			//User not exist
			mav.addObject("message", "’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
			mav.setViewName("login");
			return mav;
		}
		
		model.addAttribute(user);
		if(user.getCh() == 0) {
			//User is student = 0
			mav.setViewName("student");
		}else {
			//User is teacher = 1
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
			mav.addObject("message", "◊¢≤· ß∞‹£°");
		}else {
			mav.addObject("message", "’À∫≈“—±ª◊¢≤·£¨«Î÷±Ω”µ«¬º");
		}
		
		return mav;
	}
}