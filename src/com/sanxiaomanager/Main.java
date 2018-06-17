package com.sanxiaomanager;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.sanxiaomanager.repository.ProjectDO;
import com.sanxiaomanager.repository.UserDO;

/**
 *152061班第*组
 * 三小管理系统——测试模块
 * @author zjr
 * date:2018-06-11
 * 主要功能说明：
 * 用于测试各项功能
 */
public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
//		UserDO user = (UserDO)ac.getBean("userDO")
//		user.setId(124);
//		user.setPwd("123");
//		user.setName("xiaoming");
//		user.setAge(10);
//		user.setSex("男");
//		user.setAc("software");
//		user.setPs("dangyuan");
//		user.setAdd("haiyuan");
//		user.setTel("123123");
//		user.setCh(0);
		
//		ProjectDO project = (ProjectDO)ac.getBean("projectDO");
//		project.setId(1000);
//		project.setName("matong");
//		project.setType("important");
//		project.setProfile("this is a ma tong");
//		project.setPlan("jiayou");
//		project.setOf("food");
//		project.setFee(1500);
//		project.setState(1);
//		project.setTea("Lao li");
//		project.setTea("88888888");
//		project.setSession(0);
//		UserDO user = new UserRepositoryImpl((JdbcTemplate)ac.getBean("jdbcTemplate")).selectById(123);
//		System.out.println(user.toString());

//		UserRepository r = new UserRepositoryImpl((JdbcTemplate)ac.getBean("jdbcTemplate"));
//		if(r.delete(123))
//			System.out.println("Delete success");
//		else
//			System.out.println("Delete fail");
		
//		ProjectRepository p = new ProjectRepositoryImpl((JdbcTemplate)ac.getBean("jdbcTemplate"));
//		if(p.update(project))
//			System.out.println("Update success");
//		else
//			System.out.println("Update fail");
		
//		System.out.println(p.selectById(1000).toString());
		
//		UserDO u = null;
//		try {
//			u = RepositorySingleton.getUserRepositoryImpl().selectById(125678);
//		}catch(DataAccessException ex) {
//			u = null;
//		}
//		if(u == null) {
//			System.out.println("Yes!");
//		}else {
//			System.out.println(u.toString());
//		}
		
//		String sql = "select * from PROJECTS where uid=?";
//		List<ProjectDO> list = (List<ProjectDO>)RepositorySingleton.getJdbcTemplate().query(sql, new Object[] {123},
//				new RowMapper() {
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {  
//				ProjectDO project = new ProjectDO();
//				project.setName(rs.getString("pname"));
//				return project;  
//				}  
//		});
//		
//		for(ProjectDO p : list) {
//			System.out.println(p.toString());
//		}
//		System.out.println(RepositorySingleton.getUserRepositoryImpl().selectById(15206136).toString());
//		System.out.println(RepositorySingleton.getProjectRepositoryImpl().selectById(1000).toString());
		
		RepositorySingleton.getProjectRepositoryImpl().insert(new ProjectDO("三小管理系统", "一般项目", "没有简介", "没有计划", "软件", 1000, 0, "蔡柯", "123123", 11, RepositorySingleton.getUserRepositoryImpl().selectById(15206136)));
	}

}
