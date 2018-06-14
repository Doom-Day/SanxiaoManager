package com.sanxiaomanager.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.sanxiaomanager.ACSingleton;
import com.sanxiaomanager.RepositorySingleton;

/**
 * 152061班第*组
 * 三小管理系统——用户数据操作实现
 * @author zjr
 * date:2018-06-11
 * 主要功能说明：
 * 实现了需要对用户操作的方法
 */
public class UserRepositoryImpl extends JdbcDaoSupport implements UserRepository {
	private JdbcTemplate jdbcTemplate;
	
	@Override 
	public boolean insert(UserDO user) {
		int temp = 0;
		String sql = "insert into USERS values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		temp = jdbcTemplate.update(sql, new Object[] {
				user.getId(),
				user.getPwd(),
				user.getName(),
				user.getAge(),
				user.getSex(),
				user.getAc(),
				user.getPs(),
				user.getAdd(),
				user.getTel(),
				user.getCh()
		});
		return temp>0?true:false;
	}

	@Override
	public boolean update(UserDO user) {
		int temp = 0;
		String sql = "update USERS set upwd=?, uname=?, uage=?, usex=?, uac=?, ups=?, uadd=?, utel=?, uch=? where uid=?";
		temp = jdbcTemplate.update(sql, new Object[] {
				user.getPwd(),
				user.getName(),
				user.getAge(),
				user.getSex(),
				user.getAc(),
				user.getPs(),
				user.getAdd(),
				user.getTel(),
				user.getCh(),
				user.getId()
		});
		return temp>0?true:false;
	}

	@Override
	public boolean delete(int id) {
		int temp = 0;
		String sql = "delete from USERS where uid=?";
		temp = jdbcTemplate.update(sql, id);
		return temp>0?true:false;
	}

	@Override
	public UserDO selectById(int id) {
		String sql = "select * from USERS where uid=?";
		UserDO user = null;
		
		try {
			user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
		}catch(DataAccessException e) {
			user = null;
		}
		
		return user;
	}
	
	@Override
	public UserDO selectById(int id, int ch) {
		String sql = "select * from USERS where uid=? and uch=?";
		UserDO user = null;
		
		try {
			user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), new Object[] {id, ch});
		}catch(DataAccessException e) {
			user = null;
		}
		
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectDO> getMyProjects(int uid){
		String sql = "select * from PROJECTS where uid=?";
//		Map<String, Object> map = (Map<String, Object>)RepositorySingleton.getJdbcTemplate().query(sql, new Object[] {uid},
//				new ResultSetExtractor() {
//			public Object extractData(ResultSet rs) throws SQLException {  
//				Map<String, Object> map = new LinkedHashMap<String, Object>();  
//				while (rs.next()) {  
//					map.put("projectId", pid);
//				}  
//				return map;  
//				}; 
//		});
		
		List<ProjectDO> list = (List<ProjectDO>)jdbcTemplate.query(sql, new Object[] {uid},
				new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {  
				ProjectDO project = (ProjectDO)ACSingleton.getAC().getBean("projectDO");
				project.setId(rs.getInt("pid"));
				project.setUID(rs.getInt("uid"));
				project.setName(rs.getString("pname"));
				project.setType(rs.getString("ptype"));
				project.setProfile(rs.getString("pprofile"));
				project.setPlan(rs.getString("pplan"));
				project.setOf(rs.getString("pof"));
				project.setFee(rs.getDouble("pfee"));
				project.setState(rs.getInt("pstate"));
				project.setTea(rs.getString("ptea"));
				project.setTtel(rs.getString("pttel"));
				project.setSession(rs.getInt("psession"));
				
				return project;
			}
		});
		
		return list;
	}
	
	public List<Map<String,Object>> getAllProjects(){
		String sql = "select * from USERS, PROJECTS where USERS.uid=PROJECTS.uid";
		
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> list = (List<Map<String,Object>>)RepositorySingleton.getJdbcTemplate().query(sql,
				new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map<String, Object> rsMap = new LinkedHashMap<String, Object>();
					rsMap.put("pid", rs.getInt("pid"));
					rsMap.put("pname", rs.getString("pname"));
					rsMap.put("uname", rs.getString("uname"));
					rsMap.put("uid", rs.getInt("uid"));
					rsMap.put("utel", rs.getString("utel"));
					rsMap.put("ptea", rs.getString("ptea"));
					rsMap.put("pof", rs.getString("pof"));
					rsMap.put("pfee", rs.getDouble("pfee"));
					rsMap.put("pstate", rs.getInt("pstate"));
					
				return rsMap;
			}
		});
		
		return list;
	}
	
	public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
}

final class UserRowMapper implements RowMapper<UserDO>{
	public UserDO mapRow(ResultSet rs, int rowNum) throws SQLException{
		return new UserDO(
				rs.getInt("uid"),
				rs.getString("upwd"),
				rs.getString("uname"),
				rs.getInt("uage"),
				rs.getString("usex"),
				rs.getString("uac"),
				rs.getString("ups"),
				rs.getString("uadd"),
				rs.getString("utel"),
				rs.getInt("uch"));
	}
}
