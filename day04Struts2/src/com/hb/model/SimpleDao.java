package com.hb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hb.util.MyOracle;

public class SimpleDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public List selectAll() throws SQLException{
		String sql = "select * from simple02 order by sabun";
		List list = new ArrayList<>();	// 데이터베이스에 접속해서 리스트 채워넣음
		
		try{
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Map<String,Object> map = new HashMap<>();
				map.put("sabun", rs.getInt("sabun"));
				map.put("name", rs.getString("name"));
				map.put("nalja", rs.getString("nalja"));
				map.put("cnt", rs.getInt("cnt"));
				list.add(map);
			}
		}finally{
			closeAll();
		}
		return list;
	}
	
	
	public Map<String, Object> selectOne(int sabun) throws SQLException{
		String sql ="select * from simple02 where sabun=?";
		
		Map<String, Object> map = new HashMap<>();
		
		try{
			conn = MyOracle.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				map.put("sabun", rs.getInt("sabun"));
				map.put("name", rs.getString("name"));
				map.put("nalja", rs.getString("nalja"));
				map.put("cnt", rs.getInt("cnt"));
			}
		}finally{
			closeAll();
		}
		return map;
	}
	
	
	private void closeAll() throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}


	public int insertOne(String name, String nalja, int cnt) throws SQLException {
		String sql = "insert into simple02 (name,nalja,cnt) values (?,?,?)";
		try{
			conn=MyOracle.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, nalja);
			pstmt.setInt(3, cnt);
			return pstmt.executeUpdate();
		}finally{
			closeAll();
		}
	}
}
