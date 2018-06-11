package com.sanxiaomanager.repository;

/**
 * 152061班第*组
 * 三小管理系统——成员数据操作接口
 * @author zjr
 * date:2018-06-11
 * 主要功能说明：
 * 定义了需要对成员操作的方法
 */
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
