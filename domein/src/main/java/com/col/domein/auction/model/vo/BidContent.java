package com.col.domein.auction.model.vo;

import org.springframework.stereotype.Component;

import lombok.Builder;

@Builder
@Component
public class BidContent {
	private int bidKey;
	private String productName;
	private String productQuality;
	private String productOrigin;
	private int Quantity;
	private String measureUnit;
	private int price;
	public BidContent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BidContent(int bidKey, String productName, String productQuality, String productOrigin, int quantity,
			String measureUnit, int price) {
		super();
		this.bidKey = bidKey;
		this.productName = productName;
		this.productQuality = productQuality;
		this.productOrigin = productOrigin;
		Quantity = quantity;
		this.measureUnit = measureUnit;
		this.price = price;
	}
	public int getBidKey() {
		return bidKey;
	}
	public void setBidKey(int bidKey) {
		this.bidKey = bidKey;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductQuality() {
		return productQuality;
	}
	public void setProductQuality(String productQuality) {
		this.productQuality = productQuality;
	}
	public String getProductOrigin() {
		return productOrigin;
	}
	public void setProductOrigin(String productOrigin) {
		this.productOrigin = productOrigin;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getMeasureUnit() {
		return measureUnit;
	}
	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Quantity;
		result = prime * result + bidKey;
		result = prime * result + ((measureUnit == null) ? 0 : measureUnit.hashCode());
		result = prime * result + price;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productOrigin == null) ? 0 : productOrigin.hashCode());
		result = prime * result + ((productQuality == null) ? 0 : productQuality.hashCode());
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
		BidContent other = (BidContent) obj;
		if (Quantity != other.Quantity)
			return false;
		if (bidKey != other.bidKey)
			return false;
		if (measureUnit == null) {
			if (other.measureUnit != null)
				return false;
		} else if (!measureUnit.equals(other.measureUnit))
			return false;
		if (price != other.price)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productOrigin == null) {
			if (other.productOrigin != null)
				return false;
		} else if (!productOrigin.equals(other.productOrigin))
			return false;
		if (productQuality == null) {
			if (other.productQuality != null)
				return false;
		} else if (!productQuality.equals(other.productQuality))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BidContent [bidKey=" + bidKey + ", productName=" + productName + ", productQuality=" + productQuality
				+ ", productOrigin=" + productOrigin + ", Quantity=" + Quantity + ", measureUnit=" + measureUnit
				+ ", price=" + price + "]";
	}
	
	

}
