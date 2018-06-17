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
			String pprofile, String pplan, double pfee) {
		ProjectDO project = (ProjectDO)ACSingleton.getAC().getBean("projectDO");
		project.setId(pid);
		project.setName(pname);
		project.setType(ptype);
		project.setTea(ptea);
		project.setTtel(pttel);
		project.setProfile(pprofile);
		project.setPlan(pplan);
		project.setFee(pfee);
		if(RepositorySingleton.getProjectRepositoryImpl().selectById(pid) == null)
			return false;
		else
			return RepositorySingleton.getProjectRepositoryImpl().update(project);
	}
}
