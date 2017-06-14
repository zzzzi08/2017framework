package com.hb.day04pm.model.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GuestDaoTest {
	
	private static GuestDao guestDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String path="/config-context.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		guestDao = (GuestDao) context.getBean("guestDao");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectAll() throws SQLException {
		assertNotNull(guestDao.selectAll());
	}

}
