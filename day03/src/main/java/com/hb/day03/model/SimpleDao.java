package com.hb.day03.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SimpleDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public SimpleDao(){
		String url="jdbc:h2:tcp://localhost/~/test";
		String user="sa";
		String password="";
		try {
			Class.forName("org.h2.Driver");
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<SimpleVo> selectAll() throws SQLException {
		String sql="SELECT * FROM SIMPLE02";
		List<SimpleVo> list=new ArrayList<>();
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()){
			SimpleVo bean= new SimpleVo();
			bean.setSabun(rs.getInt("sabun"));
			bean.setName(rs.getString("name"));
			bean.setNalja(rs.getString("nalja"));
			bean.setCnt(rs.getInt("cnt"));
			list.add(bean);
		}
		close();

		
//		SimpleVo bean = new SimpleVo();
//		bean.setSabun(1000);
//		bean.setName("zzzz");
//		bean.setNalja(new Date().toString());
//		bean.setCnt(1111);
//		
//		list.add(bean);
		
		
		return list;
	}
	
	public void close() throws SQLException{
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}

	public int insertOne(String name, String nalja, int cnt) throws SQLException {
		String sql="insert into simple02 (name,nalja,cnt) values (?,?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, nalja);
		pstmt.setInt(3, cnt);
		int result = pstmt.executeUpdate();
		close();	
		return result;
	}
	
	
	public SimpleVo selectOne(int sabun) throws SQLException {
		String sql="SELECT * FROM SIMPLE02 where sabun=?";
		SimpleVo bean = new SimpleVo();
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, sabun);
		rs=pstmt.executeQuery();
		while(rs.next()){
			bean.setSabun(rs.getInt("sabun"));
			bean.setName(rs.getString("name"));
			bean.setNalja(rs.getString("nalja"));
			bean.setCnt(rs.getInt("cnt"));
		}
		close();
		return bean;
	}


	public int updateOne(int sabun, String name, String nalja, int cnt) throws SQLException {
		String sql ="uqdate simple02 set name=?,nalja=?,cnt=? where sabun=?";
		int result=0;
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, nalja);
		pstmt.setInt(3, cnt);
		pstmt.setInt(4, sabun);
		result=pstmt.executeUpdate();
		close();
		
		return result;
	}

}
