package com.hb.spring2.model;

import java.sql.SQLException;
import java.util.List;

public interface DaoImpl {

	   List<SimpleVo> selectAll() throws SQLException;
	   void insertOne(SimpleVo vo) throws SQLException;
	   SimpleVo selectOne(int parseInt) throws SQLException;
	   
	}