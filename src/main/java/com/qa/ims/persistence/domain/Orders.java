package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//import java.util.Objects;

/**
 * Initial class for orders containing constructors, getters/setters and all order attributes
 * @author charlesCairney
 *
 */
public class Orders {
	private Long customerId;
	private Long orderId;
	private List<Items> itemList;
	
	
	/**
	 * Constructor containing one value
	 * @param customerId
	 */
	public Orders(Long customerId) {
		super();
		this.customerId = customerId;
		this.itemList = new ArrayList<Items>();
	}
	
	/**
	 * Constructor containing two values
	 * @param orderId
	 * @param customerId
	 */
	public Orders(Long orderId, Long customerId) {
		super();
		this.customerId = customerId;
		this.orderId = orderId;
		this.itemList = new ArrayList<Items>();
	}
	
	/**
	 * Constructor containing two values and one specifically is a List of items present in Order
	 * @param customerId
	 * @param list
	 */
	public Orders(Long customerId, List<Items> list) {
		this.customerId = customerId;
		this.itemList = list;
	}
	
	/**
	 * Constructor containing three values with one as an item list
	 * @param orderId
	 * @param customerId
	 * @param list
	 */
	public Orders(Long orderId, Long customerId, List<Items> list) {
		super();
		this.customerId = customerId;
		this.orderId = orderId;
		this.itemList = list;
		
	}
	
	/**
	 * Gets the customer Id present on the order
	 * @return
	 */
	public Long getCustomerId() {
		return customerId;
	}
	
	/**
	 * Sets the customerID for order
	 * @param customerId
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	/**
	 * Gets the id number of the order
	 * @return the value of the order id
	 */
	public Long getOrderId() {
		return orderId;
	}
	
	/**
	 * sets the order id
	 * @param orderId
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
		
	/**
	 * gets the item list attached
	 * @return the list
	 */
	public List<Items> getItemList() {
		return itemList;
	}

	/**
	 * Sets the itemlist to the order
	 * @param itemList
	 */
	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}

	/**
	 * Returns a complete string with all attributes of order contained
	 */
	@Override
	public String toString() {
		return "Orders [customerId=" + customerId + ", orderId=" + orderId + ", itemList=" + itemList + "]";
	}

	/**
	 * Generates a hash code for the order
	 */
	@Override
	public int hashCode() {
		return Objects.hash(customerId, itemList, orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(itemList, other.itemList)
				&& Objects.equals(orderId, other.orderId);
	}

	


	
	
	
}
