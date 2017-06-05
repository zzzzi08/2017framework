package com.hb.spring2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.hb.spring2.util.MyOracle;

public class SimpleDao2 implements DaoImpl{
	private ResultSet rs;
	private PreparedStatement pstmt;
	private Connection conn;
	private DataSource ds;
	
	public SimpleDao2() {
		try {
			InitialContext context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
//			conn=ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<SimpleVo> selectAll() throws SQLException {
		String sql = "select * from simple03 order by sabun";
		List<SimpleVo> list = null;
		try{
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list = new ArrayList<>();	//DB 접속 정상적으로 이루어졌을때 list객체 생성해서 add
			while(rs.next()){
				list.add(new SimpleVo(rs.getInt("sabun"), rs.getString("name"), rs.getDate("nalja"), rs.getInt("pay")));
			}
		}finally {
			closeAll();
		}
		return list;
	}
	
	@Override
	public void insertOne(SimpleVo simpleVo) throws SQLException {
		String sql = "insert into simple03 values (?,?,sysdate,?)";
		try{
			conn=MyOracle.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, simpleVo.getSabun());
			pstmt.setString(2, simpleVo.getName());
			pstmt.setInt(3, simpleVo.getPay());
			pstmt.executeUpdate();
		}finally{
			closeAll();
		}
	}

	@Override
	public SimpleVo selectOne(int sabun) throws SQLException {
		String sql = "select * from simple03 where sabun=?";
		SimpleVo bean = null;
		try{
			conn=MyOracle.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs = pstmt.executeQuery();
			if(rs.next()){
				bean=new SimpleVo(rs.getInt("sabun"), rs.getString("name"), rs.getDate("nalja"), rs.getInt("pay"));
			}
		}finally{
			closeAll();
		}
		return bean;
	}
	
	private void closeAll() throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}

}
