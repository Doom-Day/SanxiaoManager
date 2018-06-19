package com.sanxiaomanager.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sanxiaomanager.RepositorySingleton;
import com.sanxiaomanager.repository.UserDO;

@Controller
public class UserController {
	@RequestMapping("/information")
	public ModelAndView information() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("information");
		mav.addObject("user", RepositorySingleton.getUser());
		return mav;
	}
	
	/**
	 * @param uidsignup
	 * @param upwdsignup
	 * @param unamesignup
	 * @param uagesignup
	 * @param usex
	 * @param utelsignup
	 * @param uacsignup
	 * @param upssignup
	 * @param uaddsignup
	 * @return
	 */
	@RequestMapping("/modify")
	public String modify(
			String uidsignup,
			String upwdsignup,
			String unamesignup,
			String uagesignup,
			String usex,
			String utelsignup,
			String uacsignup,
			String upssignup,
			String uaddsignup) {
		UserDO user = RepositorySingleton.getUser();
		user.setPwd(upwdsignup);
		user.setName(unamesignup);
		user.setAge(Integer.valueOf(uagesignup));
		user.setSex(usex);
		user.setTel(utelsignup);
		user.setAc(uacsignup);
		user.setPs(upssignup);
		user.setAdd(uaddsignup);
		
		RepositorySingleton.getUserRepositoryImpl().update(user);

		return "redirect:/log";
	}
}
