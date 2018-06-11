package com.sanxiaomanager.repository;

public interface MemberRepository {
	//添加成员
	public boolean insert(MemberDO member);
	
	//更新成员
	public boolean update(MemberDO member);
	
	//根据成员ID删除成员
	public boolean delete(int id);
	
	//根据成员ID查找成员
	public MemberDO selectById(int id);
}
