package com.sanxiaomanager;


import com.sanxiaomanager.repository.ProjectDO;
import com.sanxiaomanager.repository.UserDO;

/**
 *152061���*��
 * ��С����ϵͳ��������ģ��
 * @author zjr
 * date:2018-06-11
 * ��Ҫ����˵����
 * ���ڲ��Ը����
 */
public class Main {

	public static void main(String[] args) {
//		UserDO user = (UserDO)ac.getBean("userDO")
//		user.setId(124);
//		user.setPwd("123");
//		user.setName("xiaoming");
//		user.setAge(10);
//		user.setSex("��");
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
		
		UserDO u = RepositorySingleton.getUserRepositoryImpl().selectById(12345678);
		System.out.println(u.toString());
	}

}
