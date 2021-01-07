package com.col.domein.board.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;


@Component
public class Board {
	
	private int articleNo;
	private int threadKey;
	private String threadTitle;
	private String articleContent;
	private int writerKey;
	private int actorKey;
	private Date writtenDate;
	private Date modifiedDate;
	private int readCount;
	private int threadStatusNo;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int articleNo, int threadKey, String threadTitle, String articleContent, int writerKey, int actorKey,
			Date writtenDate, Date modifiedDate, int readCount, int threadStatusNo) {
		super();
		this.articleNo = articleNo;
		this.threadKey = threadKey;
		this.threadTitle = threadTitle;
		this.articleContent = articleContent;
		this.writerKey = writerKey;
		this.actorKey = actorKey;
		this.writtenDate = writtenDate;
		this.modifiedDate = modifiedDate;
		this.readCount = readCount;
		this.threadStatusNo = threadStatusNo;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public int getThreadKey() {
		return threadKey;
	}

	public void setThreadKey(int threadKey) {
		this.threadKey = threadKey;
	}

	public String getThreadTitle() {
		return threadTitle;
	}

	public void setThreadTitle(String threadTitle) {
		this.threadTitle = threadTitle;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public int getWriterKey() {
		return writerKey;
	}

	public void setWriterKey(int writerKey) {
		this.writerKey = writerKey;
	}

	public int getActorKey() {
		return actorKey;
	}

	public void setActorKey(int actorKey) {
		this.actorKey = actorKey;
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

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getThreadStatusNo() {
		return threadStatusNo;
	}

	public void setThreadStatusNo(int threadStatusNo) {
		this.threadStatusNo = threadStatusNo;
	}

	
	@Override
	public String toString() {
		return "Board [articleNo=" + articleNo + ", threadKey=" + threadKey + ", threadTitle=" + threadTitle
				+ ", articleContent=" + articleContent + ", writerKey=" + writerKey + ", actorKey=" + actorKey
				+ ", writtenDate=" + writtenDate + ", modifiedDate=" + modifiedDate + ", readCount=" + readCount
				+ ", threadStatusNo=" + threadStatusNo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actorKey;
		result = prime * result + ((articleContent == null) ? 0 : articleContent.hashCode());
		result = prime * result + articleNo;
		result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
		result = prime * result + readCount;
		result = prime * result + threadKey;
		result = prime * result + threadStatusNo;
		result = prime * result + ((threadTitle == null) ? 0 : threadTitle.hashCode());
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
		Board other = (Board) obj;
		if (actorKey != other.actorKey)
			return false;
		if (articleContent == null) {
			if (other.articleContent != null)
				return false;
		} else if (!articleContent.equals(other.articleContent))
			return false;
		if (articleNo != other.articleNo)
			return false;
		if (modifiedDate == null) {
			if (other.modifiedDate != null)
				return false;
		} else if (!modifiedDate.equals(other.modifiedDate))
			return false;
		if (readCount != other.readCount)
			return false;
		if (threadKey != other.threadKey)
			return false;
		if (threadStatusNo != other.threadStatusNo)
			return false;
		if (threadTitle == null) {
			if (other.threadTitle != null)
				return false;
		} else if (!threadTitle.equals(other.threadTitle))
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
	
	
}