package com.sanxiaomanager.repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * 152061���*��
 * ��С����ϵͳ�����û����ݲ����ӿ�
 * @author zjr
 * date:2018-06-11
 * ��Ҫ����˵����
 * ��������Ҫ���û������ķ���
 */
public interface UserRepository {
	//����û���Ϣ
	public boolean insert(UserDO user);
	
	//�����û���Ϣ
	public boolean update(UserDO user);
	
	//����IDɾ���û���Ϣ
	public boolean delete(int id);
	
	//����ID�����û�
	public UserDO selectById(int id);
	
	//����ID����ָ����ݵ��û�
	public UserDO selectById(int id, int ch);
	
	//�����û�ID������Ŀ
	public List<ProjectDO> getMyProjects(int uid);
	
	//��ʦ��ѯ������Ŀ�͸�������Ϣ
	public List<Map<String,Object>> getAllProjects();
}
