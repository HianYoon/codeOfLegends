package com.col.domein.product.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Builder;


@Builder
@Component
public class BoardProductSaleContent implements Comparable<BoardProductSaleContent> {
	
	private int articleNo;
	private String title;
	private int businessKey;
	private Date writtenDate;
	private Date modifiedDate;
	private String saleContent;
	private int orderCount;
	private int saleStatusNo;

	@Override
	public int compareTo(BoardProductSaleContent o) {
		// TODO Auto-generated method stub
		return this.articleNo-o.getArticleNo();
	}
	
	public BoardProductSaleContent() {
		
	}

	public BoardProductSaleContent(int articleNo, String title, int businessKey, Date writtenDate, Date modifiedDate,
			String saleContent, int orderCount, int saleStatusNo) {
		super();
		this.articleNo = articleNo;
		this.title = title;
		this.businessKey = businessKey;
		this.writtenDate = writtenDate;
		this.modifiedDate = modifiedDate;
		this.saleContent = saleContent;
		this.orderCount = orderCount;
		this.saleStatusNo = saleStatusNo;
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

	@Override
	public String toString() {
		return "BoardProductSaleContent [articleNo=" + articleNo + ", title=" + title + ", businessKey=" + businessKey
				+ ", writtenDate=" + writtenDate + ", modifiedDate=" + modifiedDate + ", saleContent=" + saleContent
				+ ", orderCount=" + orderCount + ", saleStatusNo=" + saleStatusNo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + articleNo;
		result = prime * result + businessKey;
		result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
		result = prime * result + orderCount;
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
		BoardProductSaleContent other = (BoardProductSaleContent) obj;
		if (articleNo != other.articleNo)
			return false;
		if (businessKey != other.businessKey)
			return false;
		if (modifiedDate == null) {
			if (other.modifiedDate != null)
				return false;
		} else if (!modifiedDate.equals(other.modifiedDate))
			return false;
		if (orderCount != other.orderCount)
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

	

}
