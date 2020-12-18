package com.col.domein.business.model.vo;

import org.springframework.stereotype.Component;

import lombok.Builder;

@Component
public class BusinessCategory implements Comparable<BusinessCategory>{

	private int businessCategoryNo;
	private String categoryDesc;
	
	public BusinessCategory() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public BusinessCategory(int businessCategoryNo) {
		super();
		this.businessCategoryNo = businessCategoryNo;
		switch (businessCategoryNo) {
		case 1: this.categoryDesc = "정육"; break;
		case 2: this.categoryDesc = "수산"; break;
		case 3: this.categoryDesc = "야채"; break;
		case 4: this.categoryDesc = "철물"; break;
		case 5: this.categoryDesc = "애견"; break;
		case 6: this.categoryDesc = "베이커리"; break;
		case 7: this.categoryDesc = "전자기기"; break;
		case 99: this.categoryDesc = "기타"; break;
		default: this.categoryDesc = ""+businessCategoryNo;
		}
	}



	@Override
	public int compareTo(BusinessCategory o) {
		// TODO Auto-generated method stub
		return this.businessCategoryNo-o.getBusinessCategoryNo();
	}



	public int getBusinessCategoryNo() {
		return businessCategoryNo;
	}



	public void setBusinessCategoryNo(int businessCategoryNo) {
		this.businessCategoryNo = businessCategoryNo;
		switch (businessCategoryNo) {
		case 1: this.categoryDesc = "정육"; break;
		case 2: this.categoryDesc = "수산"; break;
		case 3: this.categoryDesc = "야채"; break;
		case 4: this.categoryDesc = "철물"; break;
		case 5: this.categoryDesc = "애견"; break;
		case 6: this.categoryDesc = "베이커리"; break;
		case 7: this.categoryDesc = "전자기기"; break;
		case 99: this.categoryDesc = "기타"; break;
		default: this.categoryDesc = ""+businessCategoryNo;
		}
	}



	public String getCategoryDesc() {
		return categoryDesc;
	}



	@Override
	public String toString() {
		return "BusinessCategory [businessCategoryNo=" + businessCategoryNo + ", categoryDesc=" + categoryDesc + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + businessCategoryNo;
		result = prime * result + ((categoryDesc == null) ? 0 : categoryDesc.hashCode());
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
		BusinessCategory other = (BusinessCategory) obj;
		if (businessCategoryNo != other.businessCategoryNo)
			return false;
		if (categoryDesc == null) {
			if (other.categoryDesc != null)
				return false;
		} else if (!categoryDesc.equals(other.categoryDesc))
			return false;
		return true;
	}
	
	
}
