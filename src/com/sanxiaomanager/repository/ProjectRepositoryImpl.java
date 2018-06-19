package com.sanxiaomanager.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sanxiaomanager.ACSingleton;
import com.sanxiaomanager.RepositorySingleton;

/**
 * 152061班第*组
 * 三小管理系统——项目数据操作实现
 * @author zjr
 * date:2018-06-11
 * 主要功能说明：
 * 实现了需要对项目操作的方法
 */
public class ProjectRepositoryImpl implements ProjectRepository {
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean insert(ProjectDO project) {
		int temp = 0;
		String sql = "insert into PROJECTS values(next value for seq_pid, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		temp = jdbcTemplate.update(sql, new Object[] {
				project.getUID(),
				project.getName(),
				project.getType(),
				project.getProfile(),
				project.getPlan(),
				project.getOf(),
				project.getFee(),
				project.getState(),
				project.getTea(),
				project.getTtel(),
				project.getSession()
		});
		return temp>0?true:false;
	}

	@Override
	public boolean update(ProjectDO project) {
		int temp = 0;
		String sql = "update PROJECTS set pname=?, ptype=?, pprofile=?, pplan=?, pof=?, pfee=?, pstate=?, ptea=?, pttel=?, psession=? where pid=?";
		temp = jdbcTemplate.update(sql, new Object[] {
				project.getName(),
				project.getType(),
				project.getProfile(),
				project.getPlan(),
				project.getOf(),
				project.getFee(),
				project.getState(),
				project.getTea(),
				project.getTtel(),
				project.getSession(),
				project.getId()
		});
		return temp>0?true:false;
	}

	@Override
	public boolean delete(int id) {
		int temp = 0;
		String sql = "delete from PROJECTS where pid=?";
		temp = jdbcTemplate.update(sql, id);
		return temp>0?true:false;
	}

	@Override
	public ProjectDO selectById(int id) {
		String sql = "select * from PROJECTS where pid=?";
		ProjectDO project = null;
		
		try {
			project = jdbcTemplate.queryForObject(sql, new ProjectRowMapper(), id);
		}catch(DataAccessException e) {
			project = null;
		}
		
		return project;
	}
	
	@Override
	public ProjectDO selectByName(String name) {
		String sql = "select * from PROJECTS where pname=?";
		ProjectDO project = null;
		
		try {
			project = jdbcTemplate.queryForObject(sql, new ProjectRowMapper(), name);
		}catch(DataAccessException e) {
			project = null;
		}
		
		return project;
	}
	
	@Override
	public Map<String,Object> selectProjectDetail(int id){
		String sql = "select * from PROJECTS, USERS where pid=? and PROJECTS.uid=USERS.uid";
		
		Map<String,Object> map = jdbcTemplate.queryForObject(sql,
				new RowMapper<Map<String, Object>>() {
			public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map<String, Object> rsMap = new LinkedHashMap<String, Object>();
					rsMap.put("pid", rs.getInt("pid"));
					rsMap.put("pname", rs.getString("pname"));
					rsMap.put("uname", rs.getString("uname"));
					rsMap.put("ups", rs.getString("ups"));
					rsMap.put("uage", rs.getInt("uage"));
					rsMap.put("uac", rs.getString("uac"));
					rsMap.put("uadd", rs.getString("uadd"));
					rsMap.put("utel", rs.getString("utel"));
					rsMap.put("ptea", rs.getString("ptea"));
					rsMap.put("pttel", rs.getString("pttel"));
					rsMap.put("pprofile", rs.getString("pprofile"));
					rsMap.put("pplan", rs.getString("pplan"));
					rsMap.put("pfee", rs.getDouble("pfee"));
					rsMap.put("ptype", rs.getString("ptype"));
					rsMap.put("pof", rs.getString("pof"));
					rsMap.put("pstate", rs.getInt("pstate"));
					rsMap.put("psession", rs.getInt("psession"));
					
				return rsMap;
			}
		}, id);
		
		return map;
	}
	
	@Override
	public List<Map<String,Object>> getMember(int id){
		String sql = "select * from MEMBERS where pid=?";
		
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> list = (List<Map<String,Object>>)RepositorySingleton.getJdbcTemplate().query(sql,
				new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map<String, Object> rsMap = new LinkedHashMap<String, Object>();
					rsMap.put("mid", rs.getInt("mid"));
					rsMap.put("mname", rs.getString("mname"));
					rsMap.put("mage", rs.getInt("mage"));
					rsMap.put("msex", rs.getString("msex"));
					rsMap.put("mps", rs.getString("mps"));
					rsMap.put("mac", rs.getString("mac"));
					
				return rsMap;
			}
		}, id);
		
		return list;
	}

	public ProjectRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
}

final class ProjectRowMapper implements RowMapper<ProjectDO>{
	
	public ProjectDO mapRow(ResultSet rs, int rowNum) throws SQLException{
		ProjectDO project = (ProjectDO)ACSingleton.getAC().getBean("projectDO");
		
		project.setId(rs.getInt("pid"));
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
		project.setUID(rs.getInt("uid"));
		
		return project;
	}
}
