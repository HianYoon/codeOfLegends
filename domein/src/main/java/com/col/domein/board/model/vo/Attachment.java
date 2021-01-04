package com.col.domein.board.model.vo;

import org.springframework.stereotype.Component;


@Component
public class Attachment {
	
	private int fileKey;
	private int articleNo;
	private String originalFileName;
	private String renamedFileName;

	public Attachment() {
		// TODO Auto-generated constructor stub
	}

	public Attachment(int fileKey, int articleNo, String originalFileName, String renamedFileName) {
		super();
		this.fileKey = fileKey;
		this.articleNo = articleNo;
		this.originalFileName = originalFileName;
		this.renamedFileName = renamedFileName;
	}

	public int getFileKey() {
		return fileKey;
	}

	public void setFileKey(int fileKey) {
		this.fileKey = fileKey;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
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
	public String toString() {
		return "Attachment [fileKey=" + fileKey + ", articleNo=" + articleNo + ", originalFileName=" + originalFileName
				+ ", renamedFileName=" + renamedFileName + "]";
	}
	
	
}


