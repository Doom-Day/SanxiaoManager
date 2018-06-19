package com.sanxiaomanager.service;

import com.sanxiaomanager.ACSingleton;
import com.sanxiaomanager.RepositorySingleton;
import com.sanxiaomanager.repository.ProjectDO;

public class ProjectBO {
	
	//修改项目状态
	public static boolean changePstate(int pid) {
		ProjectDO project = RepositorySingleton.getProjectRepositoryImpl().selectById(pid);
		if(project == null)
			return false;
		
		project.setState(project.getState()+1);
		
		if(RepositorySingleton.getProjectRepositoryImpl().update(project))
			return true;
		else
			return false;
	}
	
	//修改项目信息
	public static boolean projectRevise(int pid, String pname, String ptype,
			String ptea, String pttel,
			String pprofile, String pplan,
			String pof, double pfee) {
		ProjectDO project = RepositorySingleton.getProjectRepositoryImpl().selectById(pid);
		project.setId(pid);
		project.setName(pname);
		project.setType(ptype);
		project.setTea(ptea);
		project.setTtel(pttel);
		project.setProfile(pprofile);
		project.setPlan(pplan);
		project.setOf(pof);
		project.setFee(pfee);
		if(RepositorySingleton.getProjectRepositoryImpl().selectById(pid) == null)
			return false;
		else
			return RepositorySingleton.getProjectRepositoryImpl().update(project);
	}
	
	//添加项目
	public static boolean addProject(
			int uid,
			String pname, String ptype,
			String pprofile, String pplan,
			String pof, double pfee,
			int pstate, String ptea,
			String pttel, int psession) {
		
		ProjectDO project = (ProjectDO)ACSingleton.getAC().getBean("projectDO");
		project.setUID(uid);
		project.setName(pname);
		project.setType(ptype);
		project.setProfile(pprofile);
		project.setPlan(pplan);
		project.setOf(pof);
		project.setFee(pfee);
		project.setState(pstate);
		project.setTea(ptea);
		project.setTtel(pttel);
		project.setSession(psession);
		
		RepositorySingleton.getProjectRepositoryImpl().insert(project);
		
		return false;
	}
}
