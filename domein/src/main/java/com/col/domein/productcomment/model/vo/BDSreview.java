package com.col.domein.productcomment.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Builder;

@Builder
@Component
public class BDSreview {
	
	private int reviewNo;
	private String reviewContent;
	private int writerKey;
	private Date writerDate;
	private Date modifiedDate;
	private int reviewStatusNo;//상태 번호
	private int refArtecle;//상품번호
	private int refReview;//댓글 레벨 구분인자
	private int rOriginalFileName;
	private int rRenamedFileName;
	public BDSreview() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BDSreview(int reviewNo, String reviewContent, int writerKey, Date writerDate, Date modifiedDate,
			int reviewStatusNo, int refArtecle, int refReview, int rOriginalFileName, int rRenamedFileName) {
		super();
		this.reviewNo = reviewNo;
		this.reviewContent = reviewContent;
		this.writerKey = writerKey;
		this.writerDate = writerDate;
		this.modifiedDate = modifiedDate;
		this.reviewStatusNo = reviewStatusNo;
		this.refArtecle = refArtecle;
		this.refReview = refReview;
		this.rOriginalFileName = rOriginalFileName;
		this.rRenamedFileName = rRenamedFileName;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
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
	public Date getWriterDate() {
		return writerDate;
	}
	public void setWriterDate(Date writerDate) {
		this.writerDate = writerDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public int getReviewStatusNo() {
		return reviewStatusNo;
	}
	public void setReviewStatusNo(int reviewStatusNo) {
		this.reviewStatusNo = reviewStatusNo;
	}
	public int getRefArtecle() {
		return refArtecle;
	}
	public void setRefArtecle(int refArtecle) {
		this.refArtecle = refArtecle;
	}
	public int getRefReview() {
		return refReview;
	}
	public void setRefReview(int refReview) {
		this.refReview = refReview;
	}
	public int getrOriginalFileName() {
		return rOriginalFileName;
	}
	public void setrOriginalFileName(int rOriginalFileName) {
		this.rOriginalFileName = rOriginalFileName;
	}
	public int getrRenamedFileName() {
		return rRenamedFileName;
	}
	public void setrRenamedFileName(int rRenamedFileName) {
		this.rRenamedFileName = rRenamedFileName;
	}
	@Override
	public String toString() {
		return "BDSreview [reviewNo=" + reviewNo + ", reviewContent=" + reviewContent + ", writerKey=" + writerKey
				+ ", writerDate=" + writerDate + ", modifiedDate=" + modifiedDate + ", reviewStatusNo=" + reviewStatusNo
				+ ", refArtecle=" + refArtecle + ", refReview=" + refReview + ", rOriginalFileName=" + rOriginalFileName
				+ ", rRenamedFileName=" + rRenamedFileName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
		result = prime * result + rOriginalFileName;
		result = prime * result + rRenamedFileName;
		result = prime * result + refArtecle;
		result = prime * result + refReview;
		result = prime * result + ((reviewContent == null) ? 0 : reviewContent.hashCode());
		result = prime * result + reviewNo;
		result = prime * result + reviewStatusNo;
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
		BDSreview other = (BDSreview) obj;
		if (modifiedDate == null) {
			if (other.modifiedDate != null)
				return false;
		} else if (!modifiedDate.equals(other.modifiedDate))
			return false;
		if (rOriginalFileName != other.rOriginalFileName)
			return false;
		if (rRenamedFileName != other.rRenamedFileName)
			return false;
		if (refArtecle != other.refArtecle)
			return false;
		if (refReview != other.refReview)
			return false;
		if (reviewContent == null) {
			if (other.reviewContent != null)
				return false;
		} else if (!reviewContent.equals(other.reviewContent))
			return false;
		if (reviewNo != other.reviewNo)
			return false;
		if (reviewStatusNo != other.reviewStatusNo)
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
	
}
