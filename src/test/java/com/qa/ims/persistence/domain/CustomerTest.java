package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
//import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Test;


//import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

	Customer customer;
	Long id = (long) 2;
	String firstName = "Charlie";
	String surname = "Cairney";
	
	//@BeforeClass
	//static void setUp() {
		
	//}
	
	@Test
	public void testToString() {
		customer = new Customer(id, firstName, surname);
		assertEquals(("id:" + customer.getId() + " first name:" + customer.getFirstName() + " surname:" + customer.getSurname()), customer.toString());
	}
	
	@Test
	public void testGetId() {
		customer = new Customer(id, firstName, surname);
		assertEquals(id, customer.getId());
	}
	
	@Test
	public void testGetFirstName() {
		customer = new Customer(id, firstName, surname);
		assertEquals(firstName, customer.getFirstName());
	}
	
	@Test
	public void testGetSurname() {
		customer = new Customer(id, firstName, surname);
		assertEquals(surname, customer.getSurname());
	}
	
	@Test
	public void testSetId() {
		customer = new Customer(id, firstName, surname);
		customer.setId((long) 2);
		assertEquals(id, customer.getId());
	}
	
	@Test
	public void testSetFirstName() {
		customer = new Customer(id, firstName, surname);
		customer.setFirstName("Rebecca");
		assertEquals("Rebecca", customer.getFirstName());
	}
	
	@Test
	public void testSetSurname() {
		customer = new Customer(id, firstName, surname);
		customer.setSurname("Anderson");
		assertEquals("Anderson", customer.getSurname());
	}
	
	@Test
	public void testHashCodeAndEquals() {
		Customer x = new Customer((long) 9, "Car", "Heart");
		Customer y = new Customer((long) 4, "Van", "Steven");
		
		Assert.assertFalse(x.equals(y) && y.equals(x));
		Assert.assertFalse(x.hashCode() == y.hashCode());
	}
}
