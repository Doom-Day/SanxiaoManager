package com.sanxiaomanager.service;

import com.sanxiaomanager.RepositorySingleton;
import com.sanxiaomanager.repository.ProjectDO;

public class ProjectBO {
	
	//ÐÞ¸ÄÏîÄ¿×´Ì¬
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
}
