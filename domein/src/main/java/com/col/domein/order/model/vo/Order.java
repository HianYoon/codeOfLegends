package com.col.domein.order.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Builder;
@Builder
@Component
public class Order {
	
	private int orderNo;
	private int buyerKey;
	private Date orderedDate;
	private Date lastModifiedDate;
	private String payMentMethod;
	private int orderStatusNo;
	private String applyNum;
	private String merchantUid;
	private String buyerTel;
	private String receiverName;
	private String receiverTel; 
	private int receiverPostcode;
	private String receiverAddr1;
	private String receiverAddr2;
	private String recieverComment;
	private int dicount;
	private int totalPrice;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderNo, int buyerKey, Date orderedDate, Date lastModifiedDate, String payMentMethod,
			int orderStatusNo, String applyNum, String merchantUid, String buyerTel, String receiverName,
			String receiverTel, int receiverPostcode, String receiverAddr1, String receiverAddr2,
			String recieverComment, int dicount, int totalPrice) {
		super();
		this.orderNo = orderNo;
		this.buyerKey = buyerKey;
		this.orderedDate = orderedDate;
		this.lastModifiedDate = lastModifiedDate;
		this.payMentMethod = payMentMethod;
		this.orderStatusNo = orderStatusNo;
		this.applyNum = applyNum;
		this.merchantUid = merchantUid;
		this.buyerTel = buyerTel;
		this.receiverName = receiverName;
		this.receiverTel = receiverTel;
		this.receiverPostcode = receiverPostcode;
		this.receiverAddr1 = receiverAddr1;
		this.receiverAddr2 = receiverAddr2;
		this.recieverComment = recieverComment;
		this.dicount = dicount;
		this.totalPrice = totalPrice;
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

	public String getPayMentMethod() {
		return payMentMethod;
	}

	public void setPayMentMethod(String payMentMethod) {
		this.payMentMethod = payMentMethod;
	}

	public int getOrderStatusNo() {
		return orderStatusNo;
	}

	public void setOrderStatusNo(int orderStatusNo) {
		this.orderStatusNo = orderStatusNo;
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

	public int getReceiverPostcode() {
		return receiverPostcode;
	}

	public void setReceiverPostcode(int receiverPostcode) {
		this.receiverPostcode = receiverPostcode;
	}

	public String getReceiverAddr1() {
		return receiverAddr1;
	}

	public void setReceiverAddr1(String receiverAddr1) {
		this.receiverAddr1 = receiverAddr1;
	}

	public String getReceiverAddr2() {
		return receiverAddr2;
	}

	public void setReceiverAddr2(String receiverAddr2) {
		this.receiverAddr2 = receiverAddr2;
	}

	public String getRecieverComment() {
		return recieverComment;
	}

	public void setRecieverComment(String recieverComment) {
		this.recieverComment = recieverComment;
	}

	public int getDicount() {
		return dicount;
	}

	public void setDicount(int dicount) {
		this.dicount = dicount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applyNum == null) ? 0 : applyNum.hashCode());
		result = prime * result + buyerKey;
		result = prime * result + ((buyerTel == null) ? 0 : buyerTel.hashCode());
		result = prime * result + dicount;
		result = prime * result + ((lastModifiedDate == null) ? 0 : lastModifiedDate.hashCode());
		result = prime * result + ((merchantUid == null) ? 0 : merchantUid.hashCode());
		result = prime * result + orderNo;
		result = prime * result + orderStatusNo;
		result = prime * result + ((orderedDate == null) ? 0 : orderedDate.hashCode());
		result = prime * result + ((payMentMethod == null) ? 0 : payMentMethod.hashCode());
		result = prime * result + ((receiverAddr1 == null) ? 0 : receiverAddr1.hashCode());
		result = prime * result + ((receiverAddr2 == null) ? 0 : receiverAddr2.hashCode());
		result = prime * result + ((receiverName == null) ? 0 : receiverName.hashCode());
		result = prime * result + receiverPostcode;
		result = prime * result + ((receiverTel == null) ? 0 : receiverTel.hashCode());
		result = prime * result + ((recieverComment == null) ? 0 : recieverComment.hashCode());
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
		if (dicount != other.dicount)
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
		if (payMentMethod == null) {
			if (other.payMentMethod != null)
				return false;
		} else if (!payMentMethod.equals(other.payMentMethod))
			return false;
		if (receiverAddr1 == null) {
			if (other.receiverAddr1 != null)
				return false;
		} else if (!receiverAddr1.equals(other.receiverAddr1))
			return false;
		if (receiverAddr2 == null) {
			if (other.receiverAddr2 != null)
				return false;
		} else if (!receiverAddr2.equals(other.receiverAddr2))
			return false;
		if (receiverName == null) {
			if (other.receiverName != null)
				return false;
		} else if (!receiverName.equals(other.receiverName))
			return false;
		if (receiverPostcode != other.receiverPostcode)
			return false;
		if (receiverTel == null) {
			if (other.receiverTel != null)
				return false;
		} else if (!receiverTel.equals(other.receiverTel))
			return false;
		if (recieverComment == null) {
			if (other.recieverComment != null)
				return false;
		} else if (!recieverComment.equals(other.recieverComment))
			return false;
		if (totalPrice != other.totalPrice)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", buyerKey=" + buyerKey + ", orderedDate=" + orderedDate
				+ ", lastModifiedDate=" + lastModifiedDate + ", payMentMethod=" + payMentMethod + ", orderStatusNo="
				+ orderStatusNo + ", applyNum=" + applyNum + ", merchantUid=" + merchantUid + ", buyerTel=" + buyerTel
				+ ", receiverName=" + receiverName + ", receiverTel=" + receiverTel + ", receiverPostcode="
				+ receiverPostcode + ", receiverAddr1=" + receiverAddr1 + ", receiverAddr2=" + receiverAddr2
				+ ", recieverComment=" + recieverComment + ", dicount=" + dicount + ", totalPrice=" + totalPrice + "]";
	}
	
	
	
	
	

}
