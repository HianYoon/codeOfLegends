package com.col.domein.product.model.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Builder
public class Product implements Comparable<Product> {
	private int productNo;
	private String productName;//상품명
	private String productQuality;//등급 ,레벨
	private String origin;//원산지
	private int productQuantity;//개수또는 단위의 수(1 or 10:kg)
	private String measureUnit;//단위
	private int price;//가격
	private int remaningQuantity;//남은갯수
	private int articleNo;
	private int productStatusNo;

	
	public Product() {
		
	}


	public Product(int productNo, String productName, String productQuality, String origin, int productQuantity,
			String measureUnit, int price, int remaningQuantity, int articleNo, int productStatusNo) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productQuality = productQuality;
		this.origin = origin;
		this.productQuantity = productQuantity;
		this.measureUnit = measureUnit;
		this.price = price;
		this.remaningQuantity = remaningQuantity;
		this.articleNo = articleNo;
		this.productStatusNo = productStatusNo;
	}


	public int getProductNo() {
		return productNo;
	}


	public void setProductNo(int productNo) {
		this.productNo = productNo;
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


	public String getOrigin() {
		return origin;
	}


	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public int getProductQuantity() {
		return productQuantity;
	}


	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
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


	public int getRemaningQuantity() {
		return remaningQuantity;
	}


	public void setRemaningQuantity(int remaningQuantity) {
		this.remaningQuantity = remaningQuantity;
	}


	public int getArticleNo() {
		return articleNo;
	}


	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}


	public int getProductStatusNo() {
		return productStatusNo;
	}


	public void setProductStatusNo(int productStatusNo) {
		this.productStatusNo = productStatusNo;
	}


	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", productName=" + productName + ", productQuality=" + productQuality
				+ ", origin=" + origin + ", productQuantity=" + productQuantity + ", measureUnit=" + measureUnit
				+ ", price=" + price + ", remaningQuantity=" + remaningQuantity + ", articleNo=" + articleNo
				+ ", productStatusNo=" + productStatusNo + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + articleNo;
		result = prime * result + ((measureUnit == null) ? 0 : measureUnit.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + price;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + productNo;
		result = prime * result + ((productQuality == null) ? 0 : productQuality.hashCode());
		result = prime * result + productQuantity;
		result = prime * result + productStatusNo;
		result = prime * result + remaningQuantity;
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
		Product other = (Product) obj;
		if (articleNo != other.articleNo)
			return false;
		if (measureUnit == null) {
			if (other.measureUnit != null)
				return false;
		} else if (!measureUnit.equals(other.measureUnit))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (price != other.price)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productNo != other.productNo)
			return false;
		if (productQuality == null) {
			if (other.productQuality != null)
				return false;
		} else if (!productQuality.equals(other.productQuality))
			return false;
		if (productQuantity != other.productQuantity)
			return false;
		if (productStatusNo != other.productStatusNo)
			return false;
		if (remaningQuantity != other.remaningQuantity)
			return false;
		return true;
	}
	


	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return this.articleNo-o.getArticleNo();
	}
	
}
