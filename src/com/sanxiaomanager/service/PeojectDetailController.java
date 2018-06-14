package com.sanxiaomanager.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sanxiaomanager.RepositorySingleton;

@Controller
public class PeojectDetailController {
	@RequestMapping("/project_detail")
	public ModelAndView showDetail(@RequestParam("pid") int pid) {
		ModelAndView mav = new ModelAndView();
		Map<String,Object> detail = RepositorySingleton.getProjectRepositoryImpl().selectProjectDetail(pid);
		List<Map<String,Object>> member= RepositorySingleton.getProjectRepositoryImpl().getMember(pid);
		mav.setViewName("project_detail");
		mav.addObject("project", detail);
		mav.addObject("member", member);
		return mav;
	}
	
}