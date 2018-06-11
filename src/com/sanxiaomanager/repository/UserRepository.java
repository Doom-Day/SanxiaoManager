package com.sanxiaomanager.repository;

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
}
