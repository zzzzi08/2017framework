package com.hb.struts.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

public class SimpleDao {

   private Connection conn;
   private PreparedStatement pstmt;
   private ResultSet rs;

   public SimpleDao() {
	  String url="jdbc:oracle:thin:@localhost:1521:xe";
	  String user="scott";
	  String password="tiger";
	  
      try {
    	 Class.forName("oracle.jdbc.driver.OracleDriver");
         conn=DriverManager.getConnection(url,user,password);
         
      } catch (SQLException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
   }
   public List<SimpleVo> selectAll() throws SQLException{
      List<SimpleVo> list = new ArrayList<SimpleVo>();
      String sql = "select * from simple03 order by sabun";
      try{
	      pstmt=conn.prepareStatement(sql);
	      rs=pstmt.executeQuery();
	      
	      while(rs.next()){
	         list.add(new SimpleVo(rs.getInt("sabun"),
	               rs.getString("name"),
	               rs.getDate("nalja"),
	               rs.getInt("pay")
	               ));
	      }
      }finally{
    	  closeAll();
      }
      return list;
      
   }
   
	private void closeAll() throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
		
	}
   
   
}