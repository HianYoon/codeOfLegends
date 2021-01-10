package com.col.domein.board.model.vo;

import org.springframework.stereotype.Component;

import lombok.Builder;

@Component
@Builder
public class Attachment {
	
	private int fileKey;
	private int imageKey;
	private int articleNo;
	private String originalFilename;
	private String renamedFilename;

	public Attachment() {
		// TODO Auto-generated constructor stub
	}

	public Attachment(int fileKey, int imageKey, int articleNo, String originalFilename, String renamedFilename) {
		super();
		this.fileKey = fileKey;
		this.imageKey = imageKey;
		this.articleNo = articleNo;
		this.originalFilename = originalFilename;
		this.renamedFilename = renamedFilename;
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

	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public String getRenamedFilename() {
		return renamedFilename;
	}

	public void setRenamedFilename(String renamedFilename) {
		this.renamedFilename = renamedFilename;
	}

	@Override
	public String toString() {
		return "Attachement [fileKey=" + fileKey + ", imageKey=" + imageKey + ", articleNo=" + articleNo
				+ ", originalFilename=" + originalFilename + ", renamedFilename=" + renamedFilename + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + articleNo;
		result = prime * result + fileKey;
		result = prime * result + imageKey;
		result = prime * result + ((originalFilename == null) ? 0 : originalFilename.hashCode());
		result = prime * result + ((renamedFilename == null) ? 0 : renamedFilename.hashCode());
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
		if (originalFilename == null) {
			if (other.originalFilename != null)
				return false;
		} else if (!originalFilename.equals(other.originalFilename))
			return false;
		if (renamedFilename == null) {
			if (other.renamedFilename != null)
				return false;
		} else if (!renamedFilename.equals(other.renamedFilename))
			return false;
		return true;
	}
	public Object originFilename(String originalName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}