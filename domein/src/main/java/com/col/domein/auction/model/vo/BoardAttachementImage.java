package com.col.domein.auction.model.vo;

import org.springframework.stereotype.Component;

import lombok.Builder;
@Builder
@Component
public class BoardAttachementImage {
	private int imageKey;
	private int articleNo;
	private String imgOriginalFileName;
	private String imgRenamedFileName;
	public BoardAttachementImage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardAttachementImage(int imageKey, int articleNo, String imgOriginalFileName, String imgRenamedFileName) {
		super();
		this.imageKey = imageKey;
		this.articleNo = articleNo;
		this.imgOriginalFileName = imgOriginalFileName;
		this.imgRenamedFileName = imgRenamedFileName;
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
	public String getImgOriginalFileName() {
		return imgOriginalFileName;
	}
	public void setImgOriginalFileName(String imgOriginalFileName) {
		this.imgOriginalFileName = imgOriginalFileName;
	}
	public String getImgRenamedFileName() {
		return imgRenamedFileName;
	}
	public void setImgRenamedFileName(String imgRenamedFileName) {
		this.imgRenamedFileName = imgRenamedFileName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + articleNo;
		result = prime * result + imageKey;
		result = prime * result + ((imgOriginalFileName == null) ? 0 : imgOriginalFileName.hashCode());
		result = prime * result + ((imgRenamedFileName == null) ? 0 : imgRenamedFileName.hashCode());
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
		BoardAttachementImage other = (BoardAttachementImage) obj;
		if (articleNo != other.articleNo)
			return false;
		if (imageKey != other.imageKey)
			return false;
		if (imgOriginalFileName == null) {
			if (other.imgOriginalFileName != null)
				return false;
		} else if (!imgOriginalFileName.equals(other.imgOriginalFileName))
			return false;
		if (imgRenamedFileName == null) {
			if (other.imgRenamedFileName != null)
				return false;
		} else if (!imgRenamedFileName.equals(other.imgRenamedFileName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BoardAttachementImage [imageKey=" + imageKey + ", articleNo=" + articleNo + ", imgOriginalFileName="
				+ imgOriginalFileName + ", imgRenamedFileName=" + imgRenamedFileName + "]";
	}
	
	
	

}
