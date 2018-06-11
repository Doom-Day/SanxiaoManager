package com.sanxiaomanager;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sanxiaomanager.repository.MemberRepositoryImpl;
import com.sanxiaomanager.repository.ProjectRepositoryImpl;
import com.sanxiaomanager.repository.UserRepositoryImpl;

public class RepositorySingleton {
	private static JdbcTemplate jdbcTemplate = (JdbcTemplate)ACSingleton.getAC().getBean("jdbcTemplate");
	private static UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl(jdbcTemplate);
	private static ProjectRepositoryImpl projectRepositoryImpl = new ProjectRepositoryImpl(jdbcTemplate);
	private static MemberRepositoryImpl memberRepositoryImpl = new MemberRepositoryImpl(jdbcTemplate);

	public static UserRepositoryImpl getUserRepositoryImpl() {
		return userRepositoryImpl;
	}
	public static ProjectRepositoryImpl getProjectRepositoryImpl() {
		return projectRepositoryImpl;
	}
	public static MemberRepositoryImpl getMemberRepositoryImpl() {
		return memberRepositoryImpl;
	}
}
