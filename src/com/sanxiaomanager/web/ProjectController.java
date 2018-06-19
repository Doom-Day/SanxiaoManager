package com.sanxiaomanager.web;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sanxiaomanager.RepositorySingleton;
import com.sanxiaomanager.service.MemberBO;
import com.sanxiaomanager.service.ProjectBO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class ProjectController {
	@RequestMapping("/project_detail")
	public ModelAndView showDetail(@RequestParam("pid") int pid) {
		ModelAndView mav = new ModelAndView();
		Map<String,Object> detail = RepositorySingleton.getProjectRepositoryImpl().selectProjectDetail(pid);
		List<Map<String,Object>> member= RepositorySingleton.getProjectRepositoryImpl().getMember(pid);
		mav.setViewName("project_detail");
		mav.addObject("user", RepositorySingleton.getUser());
		mav.addObject("project", detail);
		mav.addObject("member", member);
		return mav;
	}
	
	@RequestMapping("/changePstate")
	public ModelAndView changePstate(@RequestParam("pid") int pid,String pd_b) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", RepositorySingleton.getUser());
		if(pd_b.equals("ÐÞ¸Ä")) {
			mav.setViewName("project_revise");
			Map<String,Object> detail = RepositorySingleton.getProjectRepositoryImpl().selectProjectDetail(pid);
			List<Map<String,Object>> member= RepositorySingleton.getProjectRepositoryImpl().getMember(pid);
			mav.addObject("user", RepositorySingleton.getUser());
			mav.addObject("project", detail);
			mav.addObject("member", member);
			return mav;
		}else {
			mav.setViewName("teacher");
			ProjectBO.changePstate(pid);
			mav.addObject("projectList", RepositorySingleton.getUserRepositoryImpl().getAllProjects());
			return mav;
		}
	}
	
	@RequestMapping("/reviseProject")
	public String reviseProject(HttpServletRequest request, HttpServletResponse response) {
		
		int pid;
		String pname, ptype, ptea, pttel, pprofile, pplan, pof;
		double pfee; 
		
		int mid, mage;
		String mname, msex, mps, mac;
		
		pid = Integer.valueOf(request.getParameter("pid"));
		pname = request.getParameter("pname");
		ptype = request.getParameter("ptype");
		ptea = request.getParameter("ptea");
		pttel = request.getParameter("pttel");
		pprofile = request.getParameter("pprofile");
		pplan = request.getParameter("pplan");
		pof = request.getParameter("pof");
		pfee = Double.valueOf(request.getParameter("pfee"));
		
		mid = "".equals(request.getParameter("mid_new"))?0:Integer.valueOf(request.getParameter("mid_new"));
		mname = request.getParameter("mname_new");
		mage = "".equals(request.getParameter("mage_new"))?0:Integer.valueOf(request.getParameter("mage_new"));
		msex = request.getParameter("msex_new");
		mps = request.getParameter("mps_new");
		mac = request.getParameter("mac_new");
//		System.out.println(pname);
//		System.out.println(mname_new);
//		Map<String,Object> detail = RepositorySingleton.getProjectRepositoryImpl().selectProjectDetail(pid);
//		List<Map<String,Object>> member= RepositorySingleton.getProjectRepositoryImpl().getMember(pid);
//		mav.addObject("user", RepositorySingleton.getUser());
//		mav.addObject("project", detail);
//		mav.addObject("member", member);
		ProjectBO.projectRevise(pid, pname, ptype, ptea, pttel, pprofile, pplan, pof, pfee);
		if(mid > 0 && !mname.equals("") & mage > 0 && !msex.equals("") && !mps.equals("") && !mac.equals(""))
			MemberBO.addMember(pid, mid, mname, mage, msex, mps, mac);
		return "student";
	}
	
	@RequestMapping("/applyProject")
	public String applyProject() {
		return "project_add";
	}
	
	@RequestMapping("/addProject")
	public String addProject(HttpServletRequest request, HttpServletResponse response) {
		String pname, ptype, ptea, pttel, pprofile, pplan, pof;
		double pfee;
		int psession;
		
		pname = request.getParameter("pname");
		ptype = request.getParameter("ptype");
		ptea = request.getParameter("ptea");
		pttel = request.getParameter("pttel");
		pprofile = request.getParameter("pprofile");
		pplan = request.getParameter("pplan");
		pof = request.getParameter("pof");
		pfee = Double.valueOf(request.getParameter("pfee"));
		
		Calendar date = Calendar.getInstance();
        int year = Integer.valueOf(String.valueOf(date.get(Calendar.YEAR)));
		psession = year%100 - 5;
		
//		System.out.println(psession);
//		System.out.println(request.getParameter("members"));
		
		JSONArray members = JSONArray.fromObject(request.getParameter("members"));
		
		ProjectBO.addProject(RepositorySingleton.getUser().getId(), pname, ptype, pprofile, pplan, pof, pfee, 0, ptea, pttel, psession);
		
		int pid = RepositorySingleton.getProjectRepositoryImpl().selectByName(pname).getId();
		
		if(members.size()>0){  
			for(int i=0;i<members.size();i++){  
				JSONObject member = members.getJSONObject(i);
				MemberBO.addMember(pid, member.getInt("mid"), member.getString("mname"), member.getInt("mage"),
						member.getString("msex"), member.getString("mps"), member.getString("mac"));
			}
		}
		
		return "student";
	}
}
