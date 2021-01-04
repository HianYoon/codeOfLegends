package com.col.domein.auction.model.vo;

import org.springframework.stereotype.Component;

import lombok.Builder;
@Builder
@Component
public class BoardAttachementFile {
	
	private int fileKey;
	private int articleNo;
	private String originalFileName;
	private String renamedFileName;
	public BoardAttachementFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardAttachementFile(int fileKey, int articleNo, String originalFileName, String renamedFileName) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + articleNo;
		result = prime * result + fileKey;
		result = prime * result + ((originalFileName == null) ? 0 : originalFileName.hashCode());
		result = prime * result + ((renamedFileName == null) ? 0 : renamedFileName.hashCode());
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
		BoardAttachementFile other = (BoardAttachementFile) obj;
		if (articleNo != other.articleNo)
			return false;
		if (fileKey != other.fileKey)
			return false;
		if (originalFileName == null) {
			if (other.originalFileName != null)
				return false;
		} else if (!originalFileName.equals(other.originalFileName))
			return false;
		if (renamedFileName == null) {
			if (other.renamedFileName != null)
				return false;
		} else if (!renamedFileName.equals(other.renamedFileName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BoardAttachementFile [fileKey=" + fileKey + ", articleNo=" + articleNo + ", originalFileName="
				+ originalFileName + ", renamedFileName=" + renamedFileName + "]";
	}
	
	
	 

}
