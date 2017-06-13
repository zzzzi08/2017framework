package com.hb.day04am.model.dao;

import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.hb.day04am.model.dto.GuestVo;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IbatisDaoImpl implements GuestDao {
	private SqlMapClient sqlMapClient;
	
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	public IbatisDaoImpl() {
	}

	@Override
	public List<GuestVo> selectAll() throws SQLException {
		List<GuestVo> list=sqlMapClient.queryForList("selectAll");
		return list;
	}

	@Override
	public GuestVo selectOne(int sabun) throws SQLException {
		return null;
	}

	@Override
	public void insertOne(GuestVo bean) throws SQLException {
		sqlMapClient.insert("insertOne",bean);
	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		return 0;
	}

	@Override
	public int deleteOne(int sabun) throws SQLException {
		return 0;
	}
	
	

}