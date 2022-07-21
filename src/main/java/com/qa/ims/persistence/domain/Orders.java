package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//import java.util.Objects;

public class Orders {
	private Long customerId;
	private Long orderId;
	private List<Items> itemList;
	
	
	
	public Orders(Long customerId) {
		super();
		this.customerId = customerId;
		this.itemList = new ArrayList<Items>();
	}
	
	public Orders(Long orderId, Long customerId) {
		super();
		this.customerId = customerId;
		this.orderId = orderId;
		this.itemList = new ArrayList<Items>();
	}
	
	public Orders(Long customerId, List<Items> list) {
		this.customerId = customerId;
		this.itemList = list;
	}
	
	public Orders(Long orderId, Long customerId, List<Items> list) {
		super();
		this.customerId = customerId;
		this.orderId = orderId;
		this.itemList = list;
		
	}
	
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
		
	public List<Items> getItemList() {
		return itemList;
	}

	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "Orders [customerId=" + customerId + ", orderId=" + orderId + ", itemList=" + itemList + "]";
	}

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
