package com.sanxiaomanager.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PeojectDetailController {
	@RequestMapping("/project_detail")
	public ModelAndView showDetail(@RequestParam("pid") int pid) {
		System.out.println(pid);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("project_detail");
		return mav;
	}
	
}
