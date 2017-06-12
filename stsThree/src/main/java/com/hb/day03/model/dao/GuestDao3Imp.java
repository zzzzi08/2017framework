package com.hb.day03.model.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.nativejdbc.Jdbc4NativeJdbcExtractor;

import com.hb.day03.model.dto.GuestVo;

public class GuestDao3Imp implements GuestDao {
	@Autowired
	private JdbcOperations jdbcOperation;

	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		
		return jdbcOperation.query("SELECT * FROM GUEST_DAY03 ORDER BY SABUN"
				, new RowMapper<GuestVo>(){

					@Override
					public GuestVo mapRow(ResultSet rs, int idx) throws SQLException {
						GuestVo bean = new GuestVo();
						bean.setSabun(rs.getInt("sabun"));
						bean.setName(rs.getString("name"));
						bean.setNalja(rs.getString("nalja"));
						bean.setPay(rs.getInt("pay"));
						return bean;
					}
					
				});
	}

	@Override
	public GuestVo selectOne(int sabun) throws SQLException {
		// TODO Auto-generated method stub
		return (GuestVo)jdbcOperation.queryForObject("SELECT * FROM GUEST_DAY03 WHERE SABUN=?"
				,new Object[]{sabun}
				,new RowMapper() {

					@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						GuestVo bean=new GuestVo(
								rs.getInt("sabun")
								,rs.getString("name")
								,rs.getString("nalja")
								,rs.getInt("pay")
								);
						return bean;
					}
					
				}
				);
	}

	@Override
	public void insertOne(GuestVo bean) throws SQLException {
		// TODO Auto-generated method stub
		Object[] obj={bean.getSabun(),bean.getName(),bean.getPay()};
		jdbcOperation.update("INSERT INTO GUEST_DAY03 "
				+ "VALUES (?,?,TO_CHAR(SYSDATE,'YYYY/MM/DD'),?)",obj);
	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return jdbcOperation.update("UPDATE GUEST_DAY03 SET NAME=?,PAY=? WHERE SABUN=?"
				,new Object[]{bean.getName(),bean.getPay(),bean.getSabun()}
				);
	}

	@Override
	public int deleteOne(int sabun) throws SQLException {
		// TODO Auto-generated method stub
		return jdbcOperation.update("DELETE FROM GUEST_DAY03 WHERE SABUN=?",sabun);
	}

	@Override
	public int payPlus(int sabun) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}