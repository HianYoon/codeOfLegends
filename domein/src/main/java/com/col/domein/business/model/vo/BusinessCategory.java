package com.col.domein.business.model.vo;

import org.springframework.stereotype.Component;

@Component
public class BusinessCategory implements Comparable<BusinessCategory>{

	private int businessCategoryNo;
	private String categoryDesc;
	
	public BusinessCategory() {
		// TODO Auto-generated constructor stub
	}
	


	public BusinessCategory(int businessCategoryNo, String categoryDesc) {
		super();
		this.businessCategoryNo = businessCategoryNo;
		this.categoryDesc = categoryDesc;
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
	}



	public String getCategoryDesc() {
		return categoryDesc;
	}



	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
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