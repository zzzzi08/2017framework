package com.hb.day03.support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateJDBC {
	private Connection conn;
	private PreparedStatement pstmt;
	
	public UpdateJDBC() {
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

	public int executeUpdate(String sql,Object[] objs) throws SQLException {
		pstmt=conn.prepareStatement(sql);
		for(int i=0; i<objs.length; i++){
			pstmt.setObject(i+1, objs[i]);
		}
		
		int result=pstmt.executeUpdate();
		close();
		return result;
	}
	
	private void close() throws SQLException{
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
	
//	public void 
}