package com.col.domein.product.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
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
	private int amount;
	private int memberKey;
	
	
	@Override
	public int compareTo(ProductAll o) {
		// TODO Auto-generated method stub
		return this.businessKey-o.getBusinessKey();
	}


	public ProductAll(int articleNo, String title, int businessKey, Date writtenDate, Date modifiedDate,
			String saleContent, int orderCount, int saleStatusNo, int productNo, String productName,
			String productQuality, String origin, int productQuantity, String measureUnit, int price,
			int remaningQuantity, int productStatusNo, int productImageNo, String originFileName,
			String renamedFileName, int amount, int memberKey) {
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
		this.amount = amount;
		this.memberKey = memberKey;
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


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getMemberKey() {
		return memberKey;
	}


	public void setMemberKey(int memberKey) {
		this.memberKey = memberKey;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + articleNo;
		result = prime * result + businessKey;
		result = prime * result + ((measureUnit == null) ? 0 : measureUnit.hashCode());
		result = prime * result + memberKey;
		result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
		result = prime * result + orderCount;
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((originFileName == null) ? 0 : originFileName.hashCode());
		result = prime * result + price;
		result = prime * result + productImageNo;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + productNo;
		result = prime * result + ((productQuality == null) ? 0 : productQuality.hashCode());
		result = prime * result + productQuantity;
		result = prime * result + productStatusNo;
		result = prime * result + remaningQuantity;
		result = prime * result + ((renamedFileName == null) ? 0 : renamedFileName.hashCode());
		result = prime * result + ((saleContent == null) ? 0 : saleContent.hashCode());
		result = prime * result + saleStatusNo;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((writtenDate == null) ? 0 : writtenDate.hashCode());
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
		ProductAll other = (ProductAll) obj;
		if (amount != other.amount)
			return false;
		if (articleNo != other.articleNo)
			return false;
		if (businessKey != other.businessKey)
			return false;
		if (measureUnit == null) {
			if (other.measureUnit != null)
				return false;
		} else if (!measureUnit.equals(other.measureUnit))
			return false;
		if (memberKey != other.memberKey)
			return false;
		if (modifiedDate == null) {
			if (other.modifiedDate != null)
				return false;
		} else if (!modifiedDate.equals(other.modifiedDate))
			return false;
		if (orderCount != other.orderCount)
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (originFileName == null) {
			if (other.originFileName != null)
				return false;
		} else if (!originFileName.equals(other.originFileName))
			return false;
		if (price != other.price)
			return false;
		if (productImageNo != other.productImageNo)
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
		if (renamedFileName == null) {
			if (other.renamedFileName != null)
				return false;
		} else if (!renamedFileName.equals(other.renamedFileName))
			return false;
		if (saleContent == null) {
			if (other.saleContent != null)
				return false;
		} else if (!saleContent.equals(other.saleContent))
			return false;
		if (saleStatusNo != other.saleStatusNo)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (writtenDate == null) {
			if (other.writtenDate != null)
				return false;
		} else if (!writtenDate.equals(other.writtenDate))
			return false;
		return true;
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
				+ renamedFileName + ", amount=" + amount + ", memberKey=" + memberKey + "]";
	}
	
	

	

}
