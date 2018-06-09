package com.sanxiaomanager.repository;

public interface UserRepository {
	//����û���Ϣ
	public boolean insert(UserDO user);
	
	//�����û���Ϣ
	public boolean update(UserDO user);
	
	//����IDɾ���û���Ϣ
	public boolean delete(UserDO user);
	
	//����ID�����û�
	public UserDO selectById(int id);
}
