package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAOTest {
	
	private final OrdersDAO DAO = new OrdersDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Orders order = new Orders(1L, (long)1);
		assertEquals(order, DAO.create(order));
	}
	@Test
	public void testReadAll() {
		List<Orders> order = new ArrayList<>();
		order.add(new Orders(1L, (long)1));
		assertEquals(order, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Orders(1L, (long) 1), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Orders(1L, (long) 1), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		
	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
