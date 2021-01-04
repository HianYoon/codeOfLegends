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
	private int refArticle;//상품번호
	private int refReview;//댓글 레벨 구분인자
	private String rOriginalFileName;
	private String rRenamedFileName;
	private int BDSreviewLevel;//레벨 1은 부모 레벨 2는 자식 
	public BDSreview() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BDSreview(int reviewNo, String reviewContent, int writerKey, Date writerDate, Date modifiedDate,
			int reviewStatusNo, int refArticle, int refReview, String rOriginalFileName, String rRenamedFileName,
			int bDSreviewLevel) {
		super();
		this.reviewNo = reviewNo;
		this.reviewContent = reviewContent;
		this.writerKey = writerKey;
		this.writerDate = writerDate;
		this.modifiedDate = modifiedDate;
		this.reviewStatusNo = reviewStatusNo;
		this.refArticle = refArticle;
		this.refReview = refReview;
		this.rOriginalFileName = rOriginalFileName;
		this.rRenamedFileName = rRenamedFileName;
		BDSreviewLevel = bDSreviewLevel;
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
	public int getBDSreviewLevel() {
		return BDSreviewLevel;
	}
	public void setBDSreviewLevel(int bDSreviewLevel) {
		BDSreviewLevel = bDSreviewLevel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + BDSreviewLevel;
		result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
		result = prime * result + ((rOriginalFileName == null) ? 0 : rOriginalFileName.hashCode());
		result = prime * result + ((rRenamedFileName == null) ? 0 : rRenamedFileName.hashCode());
		result = prime * result + refArticle;
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
		if (BDSreviewLevel != other.BDSreviewLevel)
			return false;
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
	@Override
	public String toString() {
		return "BDSreview [reviewNo=" + reviewNo + ", reviewContent=" + reviewContent + ", writerKey=" + writerKey
				+ ", writerDate=" + writerDate + ", modifiedDate=" + modifiedDate + ", reviewStatusNo=" + reviewStatusNo
				+ ", refArticle=" + refArticle + ", refReview=" + refReview + ", rOriginalFileName=" + rOriginalFileName
				+ ", rRenamedFileName=" + rRenamedFileName + ", BDSreviewLevel=" + BDSreviewLevel + "]";
	}

}
