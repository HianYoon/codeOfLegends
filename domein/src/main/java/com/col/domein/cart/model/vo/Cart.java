package com.col.domein.cart.model.vo;

import org.springframework.stereotype.Component;

import lombok.Builder;

@Builder
@Component
public class Cart implements Comparable<Cart> {
	private int memberKey;
	private int productNo;
	private int Amount;
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	public Cart(int memberKey, int productNo, int amount) {
		super();
		this.memberKey = memberKey;
		this.productNo = productNo;
		Amount = amount;
	}
	public int getMemberKey() {
		return memberKey;
	}
	public void setMemberKey(int memberKey) {
		this.memberKey = memberKey;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	@Override
	public String toString() {
		return "Cart [memberKey=" + memberKey + ", productNo=" + productNo + ", Amount=" + Amount + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Amount;
		result = prime * result + memberKey;
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
		Cart other = (Cart) obj;
		if (Amount != other.Amount)
			return false;
		if (memberKey != other.memberKey)
			return false;
		if (productNo != other.productNo)
			return false;
		return true;
	}
	@Override
	public int compareTo(Cart o) {
		// TODO Auto-generated method stub
		return this.memberKey-o.getMemberKey();
	}
	
	

}
