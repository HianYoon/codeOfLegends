package com.col.domein.product.model.vo;

import org.springframework.stereotype.Component;

import lombok.Builder;


@Builder
@Component

public class Attachement implements Comparable<Attachement> {
	
	private int productNo;//상품 넘버
	private int productImageNo;//이미지 넘버
	private String originFileName;//찐 파일 이름
	private String renamedFileName;//저장된 이름

	public  Attachement() {
		
	}
	public Attachement(int productNo, int productImageNo, String originFileName, String renamedFileName) {
		super();
		this.productNo = productNo;
		this.productImageNo = productImageNo;
		this.originFileName = originFileName;
		this.renamedFileName = renamedFileName;
	}
	
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getProductImageNo() {
		return productImageNo;
	}
	public void setProductImageNo(int productImageNo) {
		this.productImageNo = productImageNo;
	}
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	public String getRenamedFileName() {
		return renamedFileName;
	}
	public void setRenamedFileName(String renamedFileName) {
		this.renamedFileName = renamedFileName;
	}
	@Override
	public String toString() {
		return "Attachement [productNo=" + productNo + ", productImageNo=" + productImageNo + ", originFileName="
				+ originFileName + ", renamedFileName=" + renamedFileName + ", getProductNo()=" + getProductNo()
				+ ", getProductImageNo()=" + getProductImageNo() + ", getOriginFileName()=" + getOriginFileName()
				+ ", getRenamedFileName()=" + getRenamedFileName() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((originFileName == null) ? 0 : originFileName.hashCode());
		result = prime * result + productImageNo;
		result = prime * result + productNo;
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
		Attachement other = (Attachement) obj;
		if (originFileName == null) {
			if (other.originFileName != null)
				return false;
		} else if (!originFileName.equals(other.originFileName))
			return false;
		if (productImageNo != other.productImageNo)
			return false;
		if (productNo != other.productNo)
			return false;
		if (renamedFileName == null) {
			if (other.renamedFileName != null)
				return false;
		} else if (!renamedFileName.equals(other.renamedFileName))
			return false;
		return true;
	}
	@Override
	public int compareTo(Attachement o) {
		// TODO Auto-generated method stub
		return this.productNo-o.getProductNo();
	}
	


	
	
	
	

}
