package com.sanxiaomanager.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sanxiaomanager.ACSingleton;

/**
 * 152061班第*组
 * 三小管理系统——成员数据操作实现
 * @author zjr
 * date:2018-06-11
 * 主要功能说明：
 * 实现了需要对成员操作的方法
 */
public class MemberRepositoryImpl implements MemberRepository {
	private JdbcTemplate jdbcTemplate;
	@Override
	public boolean insert(MemberDO member) {
		int temp = 0;
		String sql = "insert into MEMBERS values(?, ?, ?, ?, ?, ?, ?)";
		temp = jdbcTemplate.update(sql, new Object[] {
				member.getId(),
				member.getPID(),
				member.getName(),
				member.getAge(),
				member.getSex(),
				member.getPs(),
				member.getAc()
		});
		return temp>0?true:false;
	}

	@Override
	public boolean update(MemberDO member) {
		int temp = 0;
		String sql = "update MEMBERS set pid=?, mname=?, mage=?, msex=?, mps=?, mac=? where mid=?";
		temp = jdbcTemplate.update(sql, new Object[] {
				member.getPID(),
				member.getName(),
				member.getAge(),
				member.getSex(),
				member.getPs(),
				member.getAc()
		});
		return temp>0?true:false;
	}

	@Override
	public boolean delete(int id) {
		int temp = 0;
		String sql = "delete from MEMBERS where mid=?";
		temp = jdbcTemplate.update(sql, id);
		return temp>0?true:false;
	}

	@Override
	public MemberDO selectById(int id) {
		String sql = "select * from MEMBERS where mid=?";
		return jdbcTemplate.queryForObject(sql, new MemberRowMapper(), id);
	}

	public MemberRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
}

final class MemberRowMapper implements RowMapper<MemberDO>{
	
	public MemberDO mapRow(ResultSet rs, int rowNum) throws SQLException{
		MemberDO member = (MemberDO)ACSingleton.getAC().getBean("memberDO");
		
		member.setId(rs.getInt("mid"));
		member.setName(rs.getString("mname"));
		member.setAge(rs.getInt("mage"));
		member.setSex(rs.getString("msex"));
		member.setPs(rs.getString("mps"));
		member.setAc(rs.getString("mac"));
		member.setPID(rs.getInt("pid"));;
		
		return member;
	}
}