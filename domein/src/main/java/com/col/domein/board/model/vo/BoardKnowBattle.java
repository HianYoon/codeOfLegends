package com.col.domein.board.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;


@Component
public class BoardKnowBattle {
	
	private int threadKey;
	private String threadTitle;
	private int writerKey;
	private Date writtenDate;
	private Date modifiedDate;
	private int readCount;
	private int threadStatusNo;

	 
	public BoardKnowBattle() {
	// TODO Auto-generated constructor stub
	}


	public BoardKnowBattle(int threadKey, String threadTitle, int writerKey, Date writtenDate, Date modifiedDate,
			int readCount, int threadStatusNo) {
		super();
		this.threadKey = threadKey;
		this.threadTitle = threadTitle;
		this.writerKey = writerKey;
		this.writtenDate = writtenDate;
		this.modifiedDate = modifiedDate;
		this.readCount = readCount;
		this.threadStatusNo = threadStatusNo;
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
		return "BoardKnowBattle [threadKey=" + threadKey + ", threadTitle=" + threadTitle + ", writerKey=" + writerKey
				+ ", writtenDate=" + writtenDate + ", modifiedDate=" + modifiedDate + ", readCount=" + readCount
				+ ", threadStatusNo=" + threadStatusNo + "]";
	}
}


