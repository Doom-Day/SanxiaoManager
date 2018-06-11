package com.sanxiaomanager.repository;

/**
 * 152061���*��
 * ��С����ϵͳ������Ա���ݲ����ӿ�
 * @author zjr
 * date:2018-06-11
 * ��Ҫ����˵����
 * ��������Ҫ�Գ�Ա�����ķ���
 */
public interface MemberRepository {
	//��ӳ�Ա
	public boolean insert(MemberDO member);
	
	//���³�Ա
	public boolean update(MemberDO member);
	
	//���ݳ�ԱIDɾ����Ա
	public boolean delete(int id);
	
	//���ݳ�ԱID���ҳ�Ա
	public MemberDO selectById(int id);
}
