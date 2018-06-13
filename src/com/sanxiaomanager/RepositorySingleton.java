package com.sanxiaomanager;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sanxiaomanager.repository.MemberRepositoryImpl;
import com.sanxiaomanager.repository.ProjectRepositoryImpl;
import com.sanxiaomanager.repository.UserDO;
import com.sanxiaomanager.repository.UserRepositoryImpl;

public class RepositorySingleton {
	private static UserDO user = null;
	private static JdbcTemplate jdbcTemplate = (JdbcTemplate)ACSingleton.getAC().getBean("jdbcTemplate");
	private static UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl(jdbcTemplate);
	private static ProjectRepositoryImpl projectRepositoryImpl = new ProjectRepositoryImpl(jdbcTemplate);
	private static MemberRepositoryImpl memberRepositoryImpl = new MemberRepositoryImpl(jdbcTemplate);

	public static JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		RepositorySingleton.jdbcTemplate = jdbcTemplate;
	}
	public static UserRepositoryImpl getUserRepositoryImpl() {
		return userRepositoryImpl;
	}
	public static ProjectRepositoryImpl getProjectRepositoryImpl() {
		return projectRepositoryImpl;
	}
	public static MemberRepositoryImpl getMemberRepositoryImpl() {
		return memberRepositoryImpl;
	}
	
	public static UserDO getUser() {
		return user;
	}
	public static void setUser(UserDO user) {
		RepositorySingleton.user = user;
	}
}
