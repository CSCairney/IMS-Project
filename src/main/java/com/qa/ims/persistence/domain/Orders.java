package com.qa.ims.persistence.domain;

//import java.util.Objects;

public class Orders {
	private Long customerId;
	private Long orderId;
	private Long orderItemsId;
	
	
	
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

	@Override
	public String toString() {
		return "Orders [customerId=" + customerId + ", orderId=" + orderId + ", orderItemsId=" + orderItemsId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((orderItemsId == null) ? 0 : orderItemsId.hashCode());
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
		return true;
	}
	
	
	
}
