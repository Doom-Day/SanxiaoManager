package com.sanxiaomanager.repository;

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
