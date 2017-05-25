package com.hb.model;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleDaoTest {
	static Logger log = Logger.getLogger(SimpleDaoTest.class);
	static SimpleDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao = new SimpleDao(false);		//객체가 다클로즈 됐기때문에 다시 하자마자 생성해야함
	}

	@After
	public void tearDown() throws Exception {
		dao.back();		//하나의 메소드 끝나고 롤백하고 클로즈하고
	}

	@Test
	public void testSimpleDao() throws ClassNotFoundException, SQLException {
		Assert.assertNotNull(new SimpleDao());
		new SimpleDao();
	}

	@Test
	public void testSelectAll() throws ClassNotFoundException, SQLException {
		SimpleDao dao = new SimpleDao();
		List<Map<String,Object>> list = dao.selectAll();
		
		Assert.assertNotNull(list);
		Assert.assertTrue(list.size()>0);
		Assert.assertSame(5, list.size());
		
		for(Map<String,Object> map : list){
			log.debug(map.get("sabun"));
		}
	}
	
	@Test
	public void testSelectOne() throws ClassNotFoundException, SQLException{
		int sabun=1000;
		SimpleDao dao = new SimpleDao();
		Map<String, Object> map = dao.selectOne(sabun);
		Assert.assertNotNull(map);
		Assert.assertEquals(sabun, map.get("sabun"));
		Assert.assertEquals("aaaa", map.get("name"));
		Assert.assertEquals(1111, map.get("pay"));
	}

	@Test
	public void testInsert() throws SQLException {
		int sabun=4000;
		int pay=4444;
		String name="test";
		int result=dao.insertOne(sabun, name, pay);
		Assert.assertSame(1, result);
	}
}
