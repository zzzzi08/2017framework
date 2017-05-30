package com.hb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyOracle {
	private static Connection conn;
	
	private MyOracle() {
	}
	
	public static Connection getConnection(){
		try {
			if(conn==null||conn.isClosed()){	//conn이 null이거나 닫혀있을때 conn 생성
				Class.forName("org.h2.Driver");								//서버 드라이버
				conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");	//
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
