package com.qa.ims.persistence.domain;

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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((Price == null) ? 0 : Price.hashCode());
		return result;
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
		if (getItemName() == null) {
			if (other.getItemName() != null)
				return false;
		} else if (!getItemName().equals(other.getItemName()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (getPrice() == null) {
			if (other.getPrice() != null)
				return false;
		} else if (!getPrice().equals(other.getPrice()))
			return false;
		return true;
	}
	
}
