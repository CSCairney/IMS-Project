package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
//import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Test;

//import nl.jqno.equalsverifier.EqualsVerifier;


//import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {
	
	Items item;
	Long id = (long) 2;
	String itemName = "Spade";
	Double Price = 12.50;
	
	@Test
	public void oneConstructor() {
		item = new Items(id);
	}
	
	@Test
	public void twoConstructor() {
		item = new Items(itemName, Price);
	}
	
	@Test
	public void testToString() {
		item = new Items(id, itemName, Price);
		assertEquals(("Items [id=" + item.getId() + ", itemName=" + item.getItemName() + ", Price=" + item.getPrice() + "]"), item.toString());
	}

	@Test
	public void testGetId() {
		item = new Items(id, itemName, Price);
		assertEquals(id, item.getId());
	}
	
	@Test
	public void testGetItemName() {
		item = new Items(id, itemName, Price);
		assertEquals(itemName, item.getItemName());
	}
	
	@Test
	public void testGetPrice() {
		item = new Items(id, itemName, Price);
		assertEquals(Price, item.getPrice());
	}
	
	
	//Here the assertEquals with a third element which is the delta meaning it passes if the values are within 0.0001 of each other
	@Test
	public void testSetId() {
		item = new Items(id, itemName, Price);
		item.setId((long)6);
		assertEquals(6, item.getId(), 0.0001);
	}
	
	@Test
	public void testSetItemName() {
		item = new Items(id, itemName, Price);
		item.setItemName("Manga");
		assertEquals("Manga", item.getItemName());
		
	}
	
	//Here the assertEquals with a third element which is the delta meaning it passes if the values are within 0.0001 of each other
	@Test
	public void testSetPrice() {
		item = new Items(id, itemName, Price);
		item.setPrice((double) 8.50);
		assertEquals(8.50, item.getPrice(), 0.0001);
	}
	
	@Test
	public void testHashCodeAndEquals() {
		Items x = new Items((long) 9, "Car", 1000.60);
		Items y = new Items((long) 4, "Van", 2000.60);
		
		Assert.assertFalse(x.equals(y) && y.equals(x));
		Assert.assertFalse(x.hashCode() == y.hashCode());
	}
	
	//@Test
	//public void testEqualsClass() {
		//Customer x = new Customer("Charlie", "Cairney");
		//EqualsVerifier.simple().forClass(Customer.class).verify();
	//}
}
