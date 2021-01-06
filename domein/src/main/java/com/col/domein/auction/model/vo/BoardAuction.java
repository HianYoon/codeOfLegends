package com.col.domein.auction.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Builder;

@Builder
@Component
public class BoardAuction {
	                           
		private int articleNo;                                
		private String title;                                 
		private int writerKey;                                
		private Date writtenDate;                             
		private Date ModifiedDate;  
		private Date startDate;
		private Date endDate;
		private int ReadCount;                                
		private int auctionStatusNo;                          
		private String content;                               
		public BoardAuction() {                               
			super();                                          
			// TODO Auto-generated constructor stub           
		}
		public BoardAuction(int articleNo, String title, int writerKey, Date writtenDate, Date modifiedDate,
				Date startDate, Date endDate, int readCount, int auctionStatusNo, String content) {
			super();
			this.articleNo = articleNo;
			this.title = title;
			this.writerKey = writerKey;
			this.writtenDate = writtenDate;
			ModifiedDate = modifiedDate;
			this.startDate = startDate;
			this.endDate = endDate;
			ReadCount = readCount;
			this.auctionStatusNo = auctionStatusNo;
			this.content = content;
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
			return ModifiedDate;
		}
		public void setModifiedDate(Date modifiedDate) {
			ModifiedDate = modifiedDate;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		public int getReadCount() {
			return ReadCount;
		}
		public void setReadCount(int readCount) {
			ReadCount = readCount;
		}
		public int getAuctionStatusNo() {
			return auctionStatusNo;
		}
		public void setAuctionStatusNo(int auctionStatusNo) {
			this.auctionStatusNo = auctionStatusNo;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((ModifiedDate == null) ? 0 : ModifiedDate.hashCode());
			result = prime * result + ReadCount;
			result = prime * result + articleNo;
			result = prime * result + auctionStatusNo;
			result = prime * result + ((content == null) ? 0 : content.hashCode());
			result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
			result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
			result = prime * result + ((title == null) ? 0 : title.hashCode());
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
			BoardAuction other = (BoardAuction) obj;
			if (ModifiedDate == null) {
				if (other.ModifiedDate != null)
					return false;
			} else if (!ModifiedDate.equals(other.ModifiedDate))
				return false;
			if (ReadCount != other.ReadCount)
				return false;
			if (articleNo != other.articleNo)
				return false;
			if (auctionStatusNo != other.auctionStatusNo)
				return false;
			if (content == null) {
				if (other.content != null)
					return false;
			} else if (!content.equals(other.content))
				return false;
			if (endDate == null) {
				if (other.endDate != null)
					return false;
			} else if (!endDate.equals(other.endDate))
				return false;
			if (startDate == null) {
				if (other.startDate != null)
					return false;
			} else if (!startDate.equals(other.startDate))
				return false;
			if (title == null) {
				if (other.title != null)
					return false;
			} else if (!title.equals(other.title))
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
		public String toString() {
			return "BoardAuction [articleNo=" + articleNo + ", title=" + title + ", writerKey=" + writerKey
					+ ", writtenDate=" + writtenDate + ", ModifiedDate=" + ModifiedDate + ", startDate=" + startDate
					+ ", endDate=" + endDate + ", ReadCount=" + ReadCount + ", auctionStatusNo=" + auctionStatusNo
					+ ", content=" + content + "]";
		}         
		
		
	                                                          
	   
}
