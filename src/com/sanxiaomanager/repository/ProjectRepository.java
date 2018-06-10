package com.sanxiaomanager.repository;

public interface ProjectRepository {
	//�����Ŀ
	public boolean insert(ProjectDO project, int uid);
	
	//������Ŀ
	public boolean update(ProjectDO project);
	
	//������ĿIDɾ����Ŀ��Ϣ
	public boolean delete(int id);
	
	//������ĿID������Ŀ
	public ProjectDO selectById(int id);
}
