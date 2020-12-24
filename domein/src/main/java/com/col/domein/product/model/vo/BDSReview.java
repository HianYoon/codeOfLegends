package com.col.domein.product.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Builder;



@Builder
@Component
public class BDSReview implements Comparable<BDSReview> {
	private int reivewNo;
	private String reviewContent;
	private int writerKey;
	private Date writtenDate;
	private Date modifiedDate;
	private int refArticle;//bds articleNo
	private int refReview;
	private String rOriginalFileName;
	private String rRenamedFileName;
	
	public BDSReview() {
		
	}

	public BDSReview(int reivewNo, String reviewContent, int writerKey, Date writtenDate, Date modifiedDate,
			int refArticle, int refReview, String rOriginalFileName, String rRenamedFileName) {
		super();
		this.reivewNo = reivewNo;
		this.reviewContent = reviewContent;
		this.writerKey = writerKey;
		this.writtenDate = writtenDate;
		this.modifiedDate = modifiedDate;
		this.refArticle = refArticle;
		this.refReview = refReview;
		this.rOriginalFileName = rOriginalFileName;
		this.rRenamedFileName = rRenamedFileName;
	}

	public int getReivewNo() {
		return reivewNo;
	}

	public void setReivewNo(int reivewNo) {
		this.reivewNo = reivewNo;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getWriterKey() {
		return writerKey;
	}

	public void setWriterKey(int writerKey) {
		this.writerKey = writerKey;
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

	public int getRefArticle() {
		return refArticle;
	}

	public void setRefArticle(int refArticle) {
		this.refArticle = refArticle;
	}

	public int getRefReview() {
		return refReview;
	}

	public void setRefReview(int refReview) {
		this.refReview = refReview;
	}

	public String getrOriginalFileName() {
		return rOriginalFileName;
	}

	public void setrOriginalFileName(String rOriginalFileName) {
		this.rOriginalFileName = rOriginalFileName;
	}

	public String getrRenamedFileName() {
		return rRenamedFileName;
	}

	public void setrRenamedFileName(String rRenamedFileName) {
		this.rRenamedFileName = rRenamedFileName;
	}

	@Override
	public String toString() {
		return "BDSReview [reivewNo=" + reivewNo + ", reviewContent=" + reviewContent + ", writerKey=" + writerKey
				+ ", writtenDate=" + writtenDate + ", modifiedDate=" + modifiedDate + ", refArticle=" + refArticle
				+ ", refReview=" + refReview + ", rOriginalFileName=" + rOriginalFileName + ", rRenamedFileName="
				+ rRenamedFileName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
		result = prime * result + ((rOriginalFileName == null) ? 0 : rOriginalFileName.hashCode());
		result = prime * result + ((rRenamedFileName == null) ? 0 : rRenamedFileName.hashCode());
		result = prime * result + refArticle;
		result = prime * result + refReview;
		result = prime * result + reivewNo;
		result = prime * result + ((reviewContent == null) ? 0 : reviewContent.hashCode());
		result = prime * result + writerKey;
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
		BDSReview other = (BDSReview) obj;
		if (modifiedDate == null) {
			if (other.modifiedDate != null)
				return false;
		} else if (!modifiedDate.equals(other.modifiedDate))
			return false;
		if (rOriginalFileName == null) {
			if (other.rOriginalFileName != null)
				return false;
		} else if (!rOriginalFileName.equals(other.rOriginalFileName))
			return false;
		if (rRenamedFileName == null) {
			if (other.rRenamedFileName != null)
				return false;
		} else if (!rRenamedFileName.equals(other.rRenamedFileName))
			return false;
		if (refArticle != other.refArticle)
			return false;
		if (refReview != other.refReview)
			return false;
		if (reivewNo != other.reivewNo)
			return false;
		if (reviewContent == null) {
			if (other.reviewContent != null)
				return false;
		} else if (!reviewContent.equals(other.reviewContent))
			return false;
		if (writerKey != other.writerKey)
			return false;
		if (writtenDate == null) {
			if (other.writtenDate != null)
				return false;
		} else if (!writtenDate.equals(other.writtenDate))
			return false;
		return true;
	}

	@Override
	public int compareTo(BDSReview o) {
		// TODO Auto-generated method stub
		return this.refArticle-o.getRefArticle();
	}
	
}
