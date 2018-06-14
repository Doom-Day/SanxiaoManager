package com.sanxiaomanager.repository;

import java.util.List;
import java.util.Map;

/**
 * 152061班第*组
 * 三小管理系统——项目数据操作接口
 * @author zjr
 * date:2018-06-11
 * 主要功能说明：
 * 定义了需要对项目操作的方法
 */
public interface ProjectRepository {
	//添加项目
	public boolean insert(ProjectDO project);
	
	//更新项目
	public boolean update(ProjectDO project);
	
	//根据项目ID删除项目信息
	public boolean delete(int id);
	
	//根据项目ID查找项目
	public ProjectDO selectById(int id);
	
	//根据项目ID查找项目详情
	public Map<String,Object> selectProjectDetail(int id);
	
	//根据项目ID查找成员
	public List<Map<String,Object>> getMember(int id);
}
