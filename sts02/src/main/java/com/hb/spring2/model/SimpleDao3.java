package com.hb.spring2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import com.hb.spring2.util.MyOracle;

public class SimpleDao3 implements DaoImpl{
	private ResultSet rs;
	private PreparedStatement pstmt;
	private Connection conn;
	private DataSource ds;
	public SimpleDao3() {
//		BasicDataSource bds = new BasicDataSource();
//		bds.setDriverClassName("oracle.jdbc.OracleDriver");
//		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//		bds.setUsername("scott");
//		bds.setPassword("tiger");
//		bds.setMaxActive(50);
//		bds.setMaxWait(-1);
//		bds.setMaxIdle(10);
		
//		ds = bds;
	}
	
	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	

	@Override
	public List<SimpleVo> selectAll() throws SQLException {
		String sql = "select * from simple03 order by sabun";
		List<SimpleVo> list = null;
		try{
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list = new ArrayList<>();	
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
			conn=ds.getConnection();
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
			conn=ds.getConnection();
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

	@Override
	public int updateOne(SimpleVo bean) throws SQLException {
		String sql = "update simple03 set name=?, pay=? where sabun=?";
		try{
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getPay());
			pstmt.setInt(3, bean.getSabun());
			return pstmt.executeUpdate();
		}finally {
			closeAll();
		}
	}

}
