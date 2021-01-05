package com.col.domein.board.model.vo;

import org.springframework.stereotype.Component;


@Component
public class Attachment {
	
	private int fileKey;
	private int imageKey;
	private int articleNo;
	private String originalFileName;
	private String renamedFileName;

	public Attachment() {
		// TODO Auto-generated constructor stub
	}

	public Attachment(int fileKey, int imageKey, int articleNo, String originalFileName, String renamedFileName) {
		super();
		this.fileKey = fileKey;
		this.imageKey = imageKey;
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

	public int getImageKey() {
		return imageKey;
	}

	public void setImageKey(int imageKey) {
		this.imageKey = imageKey;
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
		result = prime * result + imageKey;
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
		Attachment other = (Attachment) obj;
		if (articleNo != other.articleNo)
			return false;
		if (fileKey != other.fileKey)
			return false;
		if (imageKey != other.imageKey)
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
	
	
}


