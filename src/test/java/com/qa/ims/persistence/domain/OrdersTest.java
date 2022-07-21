package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class OrdersTest {

	Orders order;
	Items item;
	Long customerId = (long) 1;
	Long orderId = (long) 2;
	List<Items> itemList = new ArrayList<Items>();
	List<Items> itemList2 = new ArrayList<Items>();

	@Test
	public void toStringTest() {
		order = new Orders(orderId, customerId, itemList);
		assertEquals(("Orders [customerId=" + order.getCustomerId() + ", orderId=" + order.getOrderId() + ", itemList="
				+ order.getItemList() + "]"), order.toString());
	}

	@Test
	public void oneConstructorTest() {
		order = new Orders(customerId);
	}

	@Test
	public void twoConstructorTest() {
		order = new Orders(orderId, customerId);
	}
	
	@Test
	public void twoContructorWithArrayListTest() {
		order = new Orders(customerId, itemList);
	}

	@Test
	public void threeConstructorTest() {
		order = new Orders(orderId, customerId, itemList);
	}

	@Test
	public void testGetCustomerId() {
		order = new Orders(orderId, customerId, itemList);
		assertEquals(customerId, order.getCustomerId());
	}

	@Test
	public void testGetOrderId() {
		order = new Orders(orderId, customerId, itemList);
		assertEquals(orderId, order.getOrderId());
	}

	@Test
	public void testGetItemList() {
		order = new Orders(orderId, customerId, itemList);
		assertEquals(itemList, order.getItemList());
	}

	@Test
	public void testSetCustomerId() {
		order = new Orders(orderId, customerId, itemList);
		order.setCustomerId((long) 13);
		assertEquals((long) 13, order.getCustomerId(), 0.0001);

	}

	@Test
	public void testSetOrderId() {
		order = new Orders(orderId, customerId, itemList);
		order.setOrderId((long) 16);
		assertEquals((long) 16, order.getOrderId(), 0.0001);

	}

	@Test
	public void testSetItemList() {
		order = new Orders(orderId, customerId, itemList);
		order.setItemList(itemList2);
		assertEquals(itemList2, order.getItemList());

	}
	
	@Test
	public void testHashCodeAndEquals() {
		Orders x = new Orders((long) 9, (long) 10, itemList);
		Orders y = new Orders((long) 4, (long) 5, itemList2);
		
		Assert.assertFalse(x.equals(y) && y.equals(x));
		Assert.assertFalse(x.hashCode() == y.hashCode());
	}
}
