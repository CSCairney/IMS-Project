package com.qa.ims.persistence.domain;

import java.util.Objects;

//import java.util.Objects;

public class Items {
	
	private Long id;
	private String itemName;
	private Double Price;
	
	public Items(Long id) {
		this.id = id;
	}
	
	public Items(String itemName, Double Price) {
		this.itemName = itemName;
		this.Price = Price;
	}
	
	public Items(Long id, String itemName, Double Price) {
		this.id = id;
		this.itemName = itemName;
		this.Price = Price;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", itemName=" + itemName + ", Price=" + Price + "]";
	}

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
