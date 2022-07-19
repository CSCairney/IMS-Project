package com.qa.ims.persistence.domain;

//import java.util.Objects;

public class Orders {
	private Long customerId;
	private Long orderId;
	private Long orderItemsId;
	private Long itemId;
	private Double itemPrice;
	private Double orderCost;
	
	
	
	public Orders(Long orderId) {
		this.orderId = orderId;
	}
	
	public Orders(Long orderId, Long customerId) {
		this.customerId = customerId;
		this.orderId = orderId;
	}
	
	public Orders(Long customerId, Long orderId, Long orderItemsId) {
		this.customerId = customerId;
		this.orderId = orderId;
		this.orderItemsId = orderItemsId;
	}
	
	public Orders(Long customerId, Long orderId, Long orderItemsId, Long itemId, Double itemPrice,
			Double orderCost) {
		super();
		this.customerId = customerId;
		this.orderId = orderId;
		this.orderItemsId = orderItemsId;
		this.itemId = itemId;
		this.itemPrice = itemPrice;
		this.orderCost = orderCost;
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
	public Long getOrderItemsId() {
		return orderItemsId;
	}
	public void setOrderItemsId(Long orderItemsId) {
		this.orderItemsId = orderItemsId;
	}
	
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Double getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(Double orderCost) {
		this.orderCost = orderCost;
	}

	
	@Override
	public String toString() {
		return "Orders [customerId=" + customerId + ", orderId=" + orderId + ", orderItemsId=" + orderItemsId
				+ ", itemId=" + itemId + ", itemPrice=" + itemPrice + ", orderCost=" + orderCost + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((orderItemsId == null) ? 0 : orderItemsId.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemPrice == null) ? 0 : itemPrice.hashCode());
		result = prime * result + ((orderCost == null) ? 0 : orderCost.hashCode());
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
		Orders other = (Orders) obj;
		if (getCustomerId() == null) {
			if (other.getCustomerId() != null)
				return false;
		} else if (!getCustomerId().equals(other.getCustomerId()))
			return false;
		if (getOrderId() == null) {
			if (other.getOrderId() != null)
				return false;
		} else if (!getOrderId().equals(other.getOrderId()))
			return false;
		if (getOrderItemsId() == null) {
			if (other.getOrderItemsId() != null)
				return false;
		} else if (!getOrderItemsId().equals(other.getOrderItemsId()))
			return false;
		if (getItemId() == null) {
			if (other.getItemId() != null)
				return false;
		} else if (!getItemId().equals(other.getItemId()))
			return false;
		if (getItemPrice() == null) {
			if (other.getItemPrice() != null)
				return false;
		} else if (!getItemPrice().equals(other.getItemPrice()))
			return false;
		if (getOrderCost() == null) {
			if (other.getOrderCost() != null)
				return false;
		} else if (!getOrderCost().equals(other.getOrderCost()))
			return false;
		return true;
	}


	
	
	
}
