package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class ItemsDAOTest {

	private final ItemsDAO DAO = new ItemsDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	
		}
	
	@After
	public void clear() {
		DAO.delete(1L);
		DAO.delete(2L);
		DAO.delete(3L);
		DAO.delete(4L);
		DAO.delete(5L);
		
	}

//	@Test
//	public void testCreate() {
//		
//		final Items testMe = new Items("Car", 100.50);
//		assertEquals(null, DAO.create(testMe));
//	}

//	@Test
//	public void testReadAll() {
//		
//		List<Items> itemList = new ArrayList<Items>();
//		itemList.add(new Items("Dragon", 200.50));
//		assertEquals(itemList, DAO.readAll());
//	}

	@Test
	public void testRecent() {
		
		assertEquals(new Items(1L, "dragon", 200.50), DAO.readRecent());
	}

	@Test
	public void testRead() {
		
		final long Id = 1L;
		final Items testMe = new Items(Id, "dragon", 200.50);
		assertEquals(testMe, DAO.read(Id));
	}
	
	@Test
	public void testUpdate() {
		final Items items = new Items(1L, "Car", 200.50);
		assertEquals(items, DAO.update(items));
	}
	
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}

}
