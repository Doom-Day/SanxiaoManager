package com.sanxiaomanager.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sanxiaomanager.RepositorySingleton;
import com.sanxiaomanager.repository.UserDO;
import com.sanxiaomanager.service.LoginBO;
import com.sanxiaomanager.service.RegisterBO;

//@SessionAttributes(value={"user"},types={UserDO.class})
@Controller
public class LoginController {
	@RequestMapping("/")
	public String welcome() {
		RepositorySingleton.setUser(null);
		return "login";
	}
	
	@RequestMapping("/log")
	public ModelAndView login(String uid, String upwd, String uch) {
//		System.out.println("Log controller running...");
		
		ModelAndView mav = new ModelAndView();
		
		UserDO user;
		if(uid==null && upwd==null && RepositorySingleton.getUser()!=null) {
			user = RepositorySingleton.getUser();
		}else {
			user = LoginBO.login(uid, upwd, uch);
		}
		
		if(user == null) {
			//User not exist
			mav.addObject("message", "’À∫≈ªÚ√‹¬Î¥ÌŒÛ£¨«Î÷ÿ–¬ ‰»Î£°");
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
			mav.addObject("message", "◊¢≤· ß∞‹");
		}else {
			mav.addObject("message", "◊¢≤·≥…π¶");
		}
		
		return mav;
	}
}