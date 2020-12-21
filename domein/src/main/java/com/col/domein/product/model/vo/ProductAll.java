package com.col.domein.product.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;


import lombok.Builder;



@Builder
@Component
public class ProductAll implements Comparable<ProductAll> {
	
	private int articleNo;
	private String title;
	private int businessKey;
	private Date writtenDate;
	private Date modifiedDate;
	private String saleContent;
	private int orderCount;
	private int saleStatusNo;
	
	private int productNo;
	private String productName;//상품명
	private String productQuality;//등급 ,레벨
	private String origin;//원산지
	private int productQuantity;//개수또는 단위의 수(1 or 10:kg)
	private String measureUnit;//단위
	private int price;//가격
	private int remaningQuantity;//남은갯수
	private int productStatusNo;//품목
	
	private int productImageNo;//이미지 넘버
	private String originFileName;//찐 파일 이름
	private String renamedFileName;//저장된 이름
	
	public ProductAll() {
		
	}

	public ProductAll(int articleNo, String title, int businessKey, Date writtenDate, Date modifiedDate,
			String saleContent, int orderCount, int saleStatusNo, int productNo, String productName,
			String productQuality, String origin, int productQuantity, String measureUnit, int price,
			int remaningQuantity, int productStatusNo, int productImageNo, String originFileName,
			String renamedFileName) {
		super();
		this.articleNo = articleNo;
		this.title = title;
		this.businessKey = businessKey;
		this.writtenDate = writtenDate;
		this.modifiedDate = modifiedDate;
		this.saleContent = saleContent;
		this.orderCount = orderCount;
		this.saleStatusNo = saleStatusNo;
		this.productNo = productNo;
		this.productName = productName;
		this.productQuality = productQuality;
		this.origin = origin;
		this.productQuantity = productQuantity;
		this.measureUnit = measureUnit;
		this.price = price;
		this.remaningQuantity = remaningQuantity;
		this.productStatusNo = productStatusNo;
		this.productImageNo = productImageNo;
		this.originFileName = originFileName;
		this.renamedFileName = renamedFileName;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBusinessKey() {
		return businessKey;
	}

	public void setBusinessKey(int businessKey) {
		this.businessKey = businessKey;
	}

	public Date getWrittenDate() {
		return writtenDate;
	}

	public void setWrittenDate(Date writtenDate) {
		this.writtenDate = writtenDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getSaleContent() {
		return saleContent;
	}

	public void setSaleContent(String saleContent) {
		this.saleContent = saleContent;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public int getSaleStatusNo() {
		return saleStatusNo;
	}

	public void setSaleStatusNo(int saleStatusNo) {
		this.saleStatusNo = saleStatusNo;
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

	public int getProductStatusNo() {
		return productStatusNo;
	}

	public void setProductStatusNo(int productStatusNo) {
		this.productStatusNo = productStatusNo;
	}

	public int getProductImageNo() {
		return productImageNo;
	}

	public void setProductImageNo(int productImageNo) {
		this.productImageNo = productImageNo;
	}

	public String getOriginFileName() {
		return originFileName;
	}

	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}

	public String getRenamedFileName() {
		return renamedFileName;
	}

	public void setRenamedFileName(String renamedFileName) {
		this.renamedFileName = renamedFileName;
	}

	@Override
	public String toString() {
		return "ProductAll [articleNo=" + articleNo + ", title=" + title + ", businessKey=" + businessKey
				+ ", writtenDate=" + writtenDate + ", modifiedDate=" + modifiedDate + ", saleContent=" + saleContent
				+ ", orderCount=" + orderCount + ", saleStatusNo=" + saleStatusNo + ", productNo=" + productNo
				+ ", productName=" + productName + ", productQuality=" + productQuality + ", origin=" + origin
				+ ", productQuantity=" + productQuantity + ", measureUnit=" + measureUnit + ", price=" + price
				+ ", remaningQuantity=" + remaningQuantity + ", productStatusNo=" + productStatusNo
				+ ", productImageNo=" + productImageNo + ", originFileName=" + originFileName + ", renamedFileName="
				+ renamedFileName + "]";
	}

	@Override
	public int compareTo(ProductAll o) {
		// TODO Auto-generated method stub
		return this.articleNo-o.getArticleNo();
	}
	

}
