package com.col.domein.auction.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Builder;

@Builder
@Component
public class AuctionBid implements Comparable<AuctionBid>{
	
	private int bidKey;
	private int articleNo;
	private int writerKey;
	private int bidStatusNo;
	private String statusDesc;
	private Date writerDate;
	public AuctionBid() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuctionBid(int bidKey, int articleNo, int writerKey, int bidStatusNo, String statusDesc, Date writerDate) {
		super();
		this.bidKey = bidKey;
		this.articleNo = articleNo;
		this.writerKey = writerKey;
		this.bidStatusNo = bidStatusNo;
		this.statusDesc = statusDesc;
		this.writerDate = writerDate;
	}
	public int getBidKey() {
		return bidKey;
	}
	public void setBidKey(int bidKey) {
		this.bidKey = bidKey;
	}
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public int getWriterKey() {
		return writerKey;
	}
	public void setWriterKey(int writerKey) {
		this.writerKey = writerKey;
	}
	public int getBidStatusNo() {
		return bidStatusNo;
	}
	public void setBidStatusNo(int bidStatusNo) {
		this.bidStatusNo = bidStatusNo;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	public Date getWriterDate() {
		return writerDate;
	}
	public void setWriterDate(Date writerDate) {
		this.writerDate = writerDate;
	}
	@Override
	public String toString() {
		return "AuctionBid [bidKey=" + bidKey + ", articleNo=" + articleNo + ", writerKey=" + writerKey
				+ ", bidStatusNo=" + bidStatusNo + ", statusDesc=" + statusDesc + ", writerDate=" + writerDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + articleNo;
		result = prime * result + bidKey;
		result = prime * result + bidStatusNo;
		result = prime * result + ((statusDesc == null) ? 0 : statusDesc.hashCode());
		result = prime * result + ((writerDate == null) ? 0 : writerDate.hashCode());
		result = prime * result + writerKey;
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
		AuctionBid other = (AuctionBid) obj;
		if (articleNo != other.articleNo)
			return false;
		if (bidKey != other.bidKey)
			return false;
		if (bidStatusNo != other.bidStatusNo)
			return false;
		if (statusDesc == null) {
			if (other.statusDesc != null)
				return false;
		} else if (!statusDesc.equals(other.statusDesc))
			return false;
		if (writerDate == null) {
			if (other.writerDate != null)
				return false;
		} else if (!writerDate.equals(other.writerDate))
			return false;
		if (writerKey != other.writerKey)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(AuctionBid o) {
		// TODO Auto-generated method stub
		return this.bidKey - o.getBidKey();
	}
	
	

}
