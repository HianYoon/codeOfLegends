package com.col.domein.order.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Builder;

@Builder
@Component
public class DirectSaleOrderHistory {
	
	private int orderNo;
	private int productNo;
	private int amount;
	private int orderStatusNo;
	private Date eventDate;
	public DirectSaleOrderHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DirectSaleOrderHistory(int orderNo, int productNo, int amount, int orderStatusNo, Date eventDate) {
		super();
		this.orderNo = orderNo;
		this.productNo = productNo;
		this.amount = amount;
		this.orderStatusNo = orderStatusNo;
		this.eventDate = eventDate;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getOrderStatusNo() {
		return orderStatusNo;
	}
	public void setOrderStatusNo(int orderStatusNo) {
		this.orderStatusNo = orderStatusNo;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	@Override
	public String toString() {
		return "DirectSaleOrderHistory [orderNo=" + orderNo + ", productNo=" + productNo + ", amount=" + amount
				+ ", orderStatusNo=" + orderStatusNo + ", eventDate=" + eventDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + orderNo;
		result = prime * result + orderStatusNo;
		result = prime * result + productNo;
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
		DirectSaleOrderHistory other = (DirectSaleOrderHistory) obj;
		if (amount != other.amount)
			return false;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (orderNo != other.orderNo)
			return false;
		if (orderStatusNo != other.orderStatusNo)
			return false;
		if (productNo != other.productNo)
			return false;
		return true;
	}
	
	

}
