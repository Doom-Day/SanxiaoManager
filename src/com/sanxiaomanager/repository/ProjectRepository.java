package com.sanxiaomanager.repository;

public interface ProjectRepository {
	//添加项目
	public boolean insert(ProjectDO project);
	
	//更新项目
	public boolean update(ProjectDO project);
	
	//根据项目ID删除项目信息
	public boolean delete(int id);
	
	//根据项目ID查找项目
	public ProjectDO selectById(int id);
}
