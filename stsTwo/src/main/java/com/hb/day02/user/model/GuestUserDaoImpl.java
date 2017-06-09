package com.hb.day02.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class GuestUserDaoImpl implements GuestUserDao<GuestUserVo> {
	@Autowired
	private DataSource dataSource;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void closeAll() throws SQLException {
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
	
	@Override
	public List<GuestUserVo> selectAll() throws SQLException {
		String sql="SELECT * FROM GUEST_USER ORDER BY NUM";
		List<GuestUserVo> list=null;
		try{
			conn=dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list=new ArrayList<GuestUserVo>();
			while(rs.next()){
				list.add(new GuestUserVo(
						rs.getInt("num")
						,rs.getInt("sabun")
						,rs.getString("name")
						,rs.getDate("nalja")
						));
			}
		}finally {
			closeAll();
		}
		return list;
	}


	@Override
	public GuestUserVo selectOne(int idx) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOne(GuestUserVo bean) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int updateOne(GuestUserVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int idx) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}