package com.sanxiaomanager.repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * 152061班第*组
 * 三小管理系统——用户数据操作接口
 * @author zjr
 * date:2018-06-11
 * 主要功能说明：
 * 定义了需要对用户操作的方法
 */
public interface UserRepository {
	//添加用户信息
	public boolean insert(UserDO user);
	
	//更新用户信息
	public boolean update(UserDO user);
	
	//根据ID删除用户信息
	public boolean delete(int id);
	
	//根据ID查找用户
	public UserDO selectById(int id);
	
	//根据ID查找指定身份的用户
	public UserDO selectById(int id, int ch);
	
	//根据用户ID查找项目
	public List<ProjectDO> getMyProjects(int uid);
	
	//老师查询所有项目和负责人信息
	public List<Map<String,Object>> getAllProjects();
}
