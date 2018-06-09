package com.sanxiaomanager.repository;

public interface UserRepository {
	//添加用户信息
	public boolean insert(UserDO user);
	
	//更新用户信息
	public boolean update(UserDO user);
	
	//根据ID删除用户信息
	public boolean delete(UserDO user);
	
	//根据ID查找用户
	public UserDO selectById(int id);
}
