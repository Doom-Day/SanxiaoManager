package com.sanxiaomanager.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sanxiaomanager.ACSingleton;

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
		String sql = "insert into PROJECTS values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		temp = jdbcTemplate.update(sql, new Object[] {
				project.getId(),
				project.getUID(),
				project.getName(),
				project.getType(),
				project.getProfile(),
				project.getPlan(),
				project.getOf(),
				project.getFee(),
				project.getState(),
				project.getTea(),
				project.getTel(),
				project.getSession()
		});
		return temp>0?true:false;
	}

	@Override
	public boolean update(ProjectDO project) {
		int temp = 0;
		String sql = "update PROJECTS set pname=?, ptype=?, pprofile=?, pplan=?, pof=?, pfee=?, pstate=?, ptea=?, ptel=?, psession=? where pid=?";
		temp = jdbcTemplate.update(sql, new Object[] {
				project.getName(),
				project.getType(),
				project.getProfile(),
				project.getPlan(),
				project.getOf(),
				project.getFee(),
				project.getState(),
				project.getTea(),
				project.getTel(),
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
		return jdbcTemplate.queryForObject(sql, new ProjectRowMapper(), id);
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
		project.setTel(rs.getString("ptel"));
		project.setSession(rs.getInt("psession"));
		project.setUID(rs.getInt("uid"));
		
		return project;
	}
}
