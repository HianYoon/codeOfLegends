package com.col.domein.auctionComment.model.vo;

import java.sql.Date;

public class AuctionComment {
	private int commentNo;
	private String commentContent;
	private int writerKey;
	private Date writerDate;
	private Date modifiedDate;
	private int articleStatusNo;
	private int refArticle;
	private String refComment;
	private String originalFileName;
	private String renamedFileName;
	public AuctionComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuctionComment(int commentNo, String commentContent, int writerKey, Date writerDate, Date modifiedDate,
			int articleStatusNo, int refArticle, String refComment, String originalFileName, String renamedFileName) {
		super();
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.writerKey = writerKey;
		this.writerDate = writerDate;
		this.modifiedDate = modifiedDate;
		this.articleStatusNo = articleStatusNo;
		this.refArticle = refArticle;
		this.refComment = refComment;
		this.originalFileName = originalFileName;
		this.renamedFileName = renamedFileName;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
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
	public int getArticleStatusNo() {
		return articleStatusNo;
	}
	public void setArticleStatusNo(int articleStatusNo) {
		this.articleStatusNo = articleStatusNo;
	}
	public int getRefArticle() {
		return refArticle;
	}
	public void setRefArticle(int refArticle) {
		this.refArticle = refArticle;
	}
	public String getRefComment() {
		return refComment;
	}
	public void setRefComment(String refComment) {
		this.refComment = refComment;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getRenamedFileName() {
		return renamedFileName;
	}
	public void setRenamedFileName(String renamedFileName) {
		this.renamedFileName = renamedFileName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + articleStatusNo;
		result = prime * result + ((commentContent == null) ? 0 : commentContent.hashCode());
		result = prime * result + commentNo;
		result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
		result = prime * result + ((originalFileName == null) ? 0 : originalFileName.hashCode());
		result = prime * result + refArticle;
		result = prime * result + ((refComment == null) ? 0 : refComment.hashCode());
		result = prime * result + ((renamedFileName == null) ? 0 : renamedFileName.hashCode());
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
		AuctionComment other = (AuctionComment) obj;
		if (articleStatusNo != other.articleStatusNo)
			return false;
		if (commentContent == null) {
			if (other.commentContent != null)
				return false;
		} else if (!commentContent.equals(other.commentContent))
			return false;
		if (commentNo != other.commentNo)
			return false;
		if (modifiedDate == null) {
			if (other.modifiedDate != null)
				return false;
		} else if (!modifiedDate.equals(other.modifiedDate))
			return false;
		if (originalFileName == null) {
			if (other.originalFileName != null)
				return false;
		} else if (!originalFileName.equals(other.originalFileName))
			return false;
		if (refArticle != other.refArticle)
			return false;
		if (refComment == null) {
			if (other.refComment != null)
				return false;
		} else if (!refComment.equals(other.refComment))
			return false;
		if (renamedFileName == null) {
			if (other.renamedFileName != null)
				return false;
		} else if (!renamedFileName.equals(other.renamedFileName))
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
		return "AuctionComment [commentNo=" + commentNo + ", commentContent=" + commentContent + ", writerKey="
				+ writerKey + ", writerDate=" + writerDate + ", modifiedDate=" + modifiedDate + ", articleStatusNo="
				+ articleStatusNo + ", refArticle=" + refArticle + ", refComment=" + refComment + ", originalFileName="
				+ originalFileName + ", renamedFileName=" + renamedFileName + "]";
	}
	
}
