package com.qa.ims.persistence.domain;

import java.util.Objects;

//import java.util.Objects;

/**
 * Initial class for items constructor and getters/setters. Containing item attributes
 * @author charlesCairney
 *
 */
public class Items {
	
	private Long id;
	private String itemName;
	private Double Price;
	
	/**
	 * Constructor with one value
	 * @param id
	 */
	public Items(Long id) {
		this.id = id;
	}
	
	/**
	 * Constructor with two values
	 * @param itemName
	 * @param Price
	 */
	public Items(String itemName, Double Price) {
		this.itemName = itemName;
		this.Price = Price;
	}
	
	/**
	 * Constructor with all three values
	 * @param id
	 * @param itemName
	 * @param Price
	 */
	public Items(Long id, String itemName, Double Price) {
		this.id = id;
		this.itemName = itemName;
		this.Price = Price;
	}
	
	/**
	 * Gets the ID of the item
	 * @return value of the ID
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Sets the id long for the id selected
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Gets the item name
	 * @return the value of the item name
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * Sets the item name for the item selected
	 * @param itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	/**
	 * Gets the price of item
	 * @return
	 */
	public Double getPrice() {
		return Price;
	}
	
	/**
	 * Sets the price for the item selected
	 * @param price
	 */
	public void setPrice(Double price) {
		Price = price;
	}

	/**
	 * Generates a full string for an item with all attributes present
	 */
	@Override
	public String toString() {
		return "Items [id=" + id + ", itemName=" + itemName + ", Price=" + Price + "]";
	}

	/**
	 * Generates a specific hash code for the item
	 */
	@Override
	public int hashCode() {
		return Objects.hash(Price, id, itemName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		return Objects.equals(Price, other.Price) && Objects.equals(id, other.id)
				&& Objects.equals(itemName, other.itemName);
	}

	
	
}
