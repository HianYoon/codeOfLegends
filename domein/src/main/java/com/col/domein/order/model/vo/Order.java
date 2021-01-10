package com.col.domein.order.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;



@Component
public class Order implements Comparable<Order>{
	
	private int orderNo;
	private int buyerKey;
	private Date orderedDate;
	private Date lastModifiedDate;
	private String paymentMethod;
	private int orderStatusNo;
	private String statusDesc;
	private String applyNum;
	private String merchantUid;
	private String buyerTel;
	private String receiverName;
	private String receiverTel; 
	private String receiverPostcode;
	private String receiverAddr;
	private String receiverComment;
	private int discount;
	private int totalPrice;
	
	


	@Override
	public int compareTo(Order o) {
		// TODO Auto-generated method stub
		return this.orderNo - o.getOrderNo();
	}

	public Order() {
		super();
	}

	public Order(int orderNo, int buyerKey, Date orderedDate, Date lastModifiedDate, String paymentMethod,
			int orderStatusNo, String statusDesc, String applyNum, String merchantUid, String buyerTel,
			String receiverName, String receiverTel, String receiverPostcode, String receiverAddr,
			String receiverComment, int discount, int totalPrice) {
		super();
		this.orderNo = orderNo;
		this.buyerKey = buyerKey;
		this.orderedDate = orderedDate;
		this.lastModifiedDate = lastModifiedDate;
		this.paymentMethod = paymentMethod;
		this.orderStatusNo = orderStatusNo;
		this.statusDesc = statusDesc;
		this.applyNum = applyNum;
		this.merchantUid = merchantUid;
		this.buyerTel = buyerTel;
		this.receiverName = receiverName;
		this.receiverTel = receiverTel;
		this.receiverPostcode = receiverPostcode;
		this.receiverAddr = receiverAddr;
		this.receiverComment = receiverComment;
		this.discount = discount;
		this.totalPrice = totalPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applyNum == null) ? 0 : applyNum.hashCode());
		result = prime * result + buyerKey;
		result = prime * result + ((buyerTel == null) ? 0 : buyerTel.hashCode());
		result = prime * result + discount;
		result = prime * result + ((lastModifiedDate == null) ? 0 : lastModifiedDate.hashCode());
		result = prime * result + ((merchantUid == null) ? 0 : merchantUid.hashCode());
		result = prime * result + orderNo;
		result = prime * result + orderStatusNo;
		result = prime * result + ((orderedDate == null) ? 0 : orderedDate.hashCode());
		result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
		result = prime * result + ((receiverAddr == null) ? 0 : receiverAddr.hashCode());
		result = prime * result + ((receiverComment == null) ? 0 : receiverComment.hashCode());
		result = prime * result + ((receiverName == null) ? 0 : receiverName.hashCode());
		result = prime * result + ((receiverPostcode == null) ? 0 : receiverPostcode.hashCode());
		result = prime * result + ((receiverTel == null) ? 0 : receiverTel.hashCode());
		result = prime * result + ((statusDesc == null) ? 0 : statusDesc.hashCode());
		result = prime * result + totalPrice;
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
		Order other = (Order) obj;
		if (applyNum == null) {
			if (other.applyNum != null)
				return false;
		} else if (!applyNum.equals(other.applyNum))
			return false;
		if (buyerKey != other.buyerKey)
			return false;
		if (buyerTel == null) {
			if (other.buyerTel != null)
				return false;
		} else if (!buyerTel.equals(other.buyerTel))
			return false;
		if (discount != other.discount)
			return false;
		if (lastModifiedDate == null) {
			if (other.lastModifiedDate != null)
				return false;
		} else if (!lastModifiedDate.equals(other.lastModifiedDate))
			return false;
		if (merchantUid == null) {
			if (other.merchantUid != null)
				return false;
		} else if (!merchantUid.equals(other.merchantUid))
			return false;
		if (orderNo != other.orderNo)
			return false;
		if (orderStatusNo != other.orderStatusNo)
			return false;
		if (orderedDate == null) {
			if (other.orderedDate != null)
				return false;
		} else if (!orderedDate.equals(other.orderedDate))
			return false;
		if (paymentMethod == null) {
			if (other.paymentMethod != null)
				return false;
		} else if (!paymentMethod.equals(other.paymentMethod))
			return false;
		if (receiverAddr == null) {
			if (other.receiverAddr != null)
				return false;
		} else if (!receiverAddr.equals(other.receiverAddr))
			return false;
		if (receiverComment == null) {
			if (other.receiverComment != null)
				return false;
		} else if (!receiverComment.equals(other.receiverComment))
			return false;
		if (receiverName == null) {
			if (other.receiverName != null)
				return false;
		} else if (!receiverName.equals(other.receiverName))
			return false;
		if (receiverPostcode == null) {
			if (other.receiverPostcode != null)
				return false;
		} else if (!receiverPostcode.equals(other.receiverPostcode))
			return false;
		if (receiverTel == null) {
			if (other.receiverTel != null)
				return false;
		} else if (!receiverTel.equals(other.receiverTel))
			return false;
		if (statusDesc == null) {
			if (other.statusDesc != null)
				return false;
		} else if (!statusDesc.equals(other.statusDesc))
			return false;
		if (totalPrice != other.totalPrice)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", buyerKey=" + buyerKey + ", orderedDate=" + orderedDate
				+ ", lastModifiedDate=" + lastModifiedDate + ", paymentMethod=" + paymentMethod + ", orderStatusNo="
				+ orderStatusNo + ", statusDesc=" + statusDesc + ", applyNum=" + applyNum + ", merchantUid="
				+ merchantUid + ", buyerTel=" + buyerTel + ", receiverName=" + receiverName + ", receiverTel="
				+ receiverTel + ", receiverPostcode=" + receiverPostcode + ", receiverAddr=" + receiverAddr
				+ ", receiverComment=" + receiverComment + ", discount=" + discount + ", totalPrice=" + totalPrice
				+ "]";
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getBuyerKey() {
		return buyerKey;
	}

	public void setBuyerKey(int buyerKey) {
		this.buyerKey = buyerKey;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getOrderStatusNo() {
		return orderStatusNo;
	}

	public void setOrderStatusNo(int orderStatusNo) {
		this.orderStatusNo = orderStatusNo;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getApplyNum() {
		return applyNum;
	}

	public void setApplyNum(String applyNum) {
		this.applyNum = applyNum;
	}

	public String getMerchantUid() {
		return merchantUid;
	}

	public void setMerchantUid(String merchantUid) {
		this.merchantUid = merchantUid;
	}

	public String getBuyerTel() {
		return buyerTel;
	}

	public void setBuyerTel(String buyerTel) {
		this.buyerTel = buyerTel;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverTel() {
		return receiverTel;
	}

	public void setReceiverTel(String receiverTel) {
		this.receiverTel = receiverTel;
	}

	public String getReceiverPostcode() {
		return receiverPostcode;
	}

	public void setReceiverPostcode(String receiverPostcode) {
		this.receiverPostcode = receiverPostcode;
	}

	public String getReceiverAddr() {
		return receiverAddr;
	}

	public void setReceiverAddr(String receiverAddr) {
		this.receiverAddr = receiverAddr;
	}

	public String getReceiverComment() {
		return receiverComment;
	}

	public void setReceiverComment(String receiverComment) {
		this.receiverComment = receiverComment;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
 
	
	
	

}
