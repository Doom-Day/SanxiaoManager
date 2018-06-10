package com.sanxiaomanager.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ProjectRepositoryImpl implements ProjectRepository {
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean insert(ProjectDO project, int uid) {
		int temp = 0;
		String sql = "insert into PROJECTS values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		temp = jdbcTemplate.update(sql, new Object[] {
				project.getId(),
				uid,
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
		return new ProjectDO(
				rs.getInt("pid"),
				rs.getString("pname"),
				rs.getString("ptype"),
				rs.getString("pprofile"),
				rs.getString("pplan"),
				rs.getString("pof"),
				rs.getDouble("pfee"),
				rs.getInt("pstate"),
				rs.getString("ptea"),
				rs.getString("ptel"),
				rs.getInt("psession"));
	}
}
