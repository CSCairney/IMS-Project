package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.DBUtils;

public class CustomerDAOTest {

	private final CustomerDAO DAO = new CustomerDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Customer customer = new Customer(2L, "charles", "cairney");
		assertEquals(customer, DAO.create(customer));
			}
	

	@Test
	public void testReadAll() {
		List<Customer> expected = new ArrayList<Customer>();
		expected.add(new Customer((long) 1, "jordan", "harrison"));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Customer(1L, "jordan", "harrison"), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Customer(ID, "jordan", "harrison"), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final long Id = 1L;
		final Customer updated = new Customer(Id, "jordan", "harrison");
		assertEquals(DAO.read(updated.getId()), DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
