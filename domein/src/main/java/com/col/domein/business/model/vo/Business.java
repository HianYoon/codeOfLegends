package com.col.domein.business.model.vo;

import java.sql.Date;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

@Component
public class Business implements Comparable<Business> {
	
	private int businessKey;
	private int memberKey;
	private String businessNo;
	private String businessName;
	private String businessTel;
	private int bankCode;
	private String bankName;
	private String bankAccountNo;
	private String bankAccountName;
	private int isVerified;
	private Date regDate;
	private String businessNickname;
	private String businessAddress;
	private int businessStatusNo;
	private int businessStatusDesc;
	private TreeSet<BusinessCategory> businessCategories;
	
	public Business() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Business o) {
		// TODO Auto-generated method stub
		return this.businessKey - o.getBusinessKey();
	}

	public Business(int businessKey, int memberKey, String businessNo, String businessName, String businessTel,
			int bankCode, String bankName, String bankAccountNo, String bankAccountName, int isVerified, Date regDate,
			String businessNickname, String businessAddress, int businessStatusNo, int businessStatusDesc,
			TreeSet<BusinessCategory> businessCategories) {
		super();
		this.businessKey = businessKey;
		this.memberKey = memberKey;
		this.businessNo = businessNo;
		this.businessName = businessName;
		this.businessTel = businessTel;
		this.bankCode = bankCode;
		this.bankName = bankName;
		this.bankAccountNo = bankAccountNo;
		this.bankAccountName = bankAccountName;
		this.isVerified = isVerified;
		this.regDate = regDate;
		this.businessNickname = businessNickname;
		this.businessAddress = businessAddress;
		this.businessStatusNo = businessStatusNo;
		this.businessStatusDesc = businessStatusDesc;
		this.businessCategories = businessCategories;
	}

	public int getBusinessKey() {
		return businessKey;
	}

	public void setBusinessKey(int businessKey) {
		this.businessKey = businessKey;
	}

	public int getMemberKey() {
		return memberKey;
	}

	public void setMemberKey(int memberKey) {
		this.memberKey = memberKey;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessTel() {
		return businessTel;
	}

	public void setBusinessTel(String businessTel) {
		this.businessTel = businessTel;
	}

	public int getBankCode() {
		return bankCode;
	}

	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public String getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public int getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(int isVerified) {
		this.isVerified = isVerified;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getBusinessNickname() {
		return businessNickname;
	}

	public void setBusinessNickname(String businessNickname) {
		this.businessNickname = businessNickname;
	}

	public String getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}

	public int getBusinessStatusNo() {
		return businessStatusNo;
	}

	public void setBusinessStatusNo(int businessStatusNo) {
		this.businessStatusNo = businessStatusNo;
	}

	public int getBusinessStatusDesc() {
		return businessStatusDesc;
	}

	public void setBusinessStatusDesc(int businessStatusDesc) {
		this.businessStatusDesc = businessStatusDesc;
	}

	public TreeSet<BusinessCategory> getBusinessCategories() {
		return businessCategories;
	}

	public void setBusinessCategories(TreeSet<BusinessCategory> businessCategories) {
		this.businessCategories = businessCategories;
	}

	@Override
	public String toString() {
		return "Business [businessKey=" + businessKey + ", memberKey=" + memberKey + ", businessNo=" + businessNo
				+ ", businessName=" + businessName + ", businessTel=" + businessTel + ", bankCode=" + bankCode
				+ ", bankName=" + bankName + ", bankAccountNo=" + bankAccountNo + ", bankAccountName=" + bankAccountName
				+ ", isVerified=" + isVerified + ", regDate=" + regDate + ", businessNickname=" + businessNickname
				+ ", businessAddress=" + businessAddress + ", businessStatusNo=" + businessStatusNo
				+ ", businessStatusDesc=" + businessStatusDesc + ", businessCategories=" + businessCategories + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankAccountName == null) ? 0 : bankAccountName.hashCode());
		result = prime * result + ((bankAccountNo == null) ? 0 : bankAccountNo.hashCode());
		result = prime * result + bankCode;
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((businessAddress == null) ? 0 : businessAddress.hashCode());
		result = prime * result + ((businessCategories == null) ? 0 : businessCategories.hashCode());
		result = prime * result + businessKey;
		result = prime * result + ((businessName == null) ? 0 : businessName.hashCode());
		result = prime * result + ((businessNickname == null) ? 0 : businessNickname.hashCode());
		result = prime * result + ((businessNo == null) ? 0 : businessNo.hashCode());
		result = prime * result + businessStatusDesc;
		result = prime * result + businessStatusNo;
		result = prime * result + ((businessTel == null) ? 0 : businessTel.hashCode());
		result = prime * result + isVerified;
		result = prime * result + memberKey;
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
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
		Business other = (Business) obj;
		if (bankAccountName == null) {
			if (other.bankAccountName != null)
				return false;
		} else if (!bankAccountName.equals(other.bankAccountName))
			return false;
		if (bankAccountNo == null) {
			if (other.bankAccountNo != null)
				return false;
		} else if (!bankAccountNo.equals(other.bankAccountNo))
			return false;
		if (bankCode != other.bankCode)
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (businessAddress == null) {
			if (other.businessAddress != null)
				return false;
		} else if (!businessAddress.equals(other.businessAddress))
			return false;
		if (businessCategories == null) {
			if (other.businessCategories != null)
				return false;
		} else if (!businessCategories.equals(other.businessCategories))
			return false;
		if (businessKey != other.businessKey)
			return false;
		if (businessName == null) {
			if (other.businessName != null)
				return false;
		} else if (!businessName.equals(other.businessName))
			return false;
		if (businessNickname == null) {
			if (other.businessNickname != null)
				return false;
		} else if (!businessNickname.equals(other.businessNickname))
			return false;
		if (businessNo == null) {
			if (other.businessNo != null)
				return false;
		} else if (!businessNo.equals(other.businessNo))
			return false;
		if (businessStatusDesc != other.businessStatusDesc)
			return false;
		if (businessStatusNo != other.businessStatusNo)
			return false;
		if (businessTel == null) {
			if (other.businessTel != null)
				return false;
		} else if (!businessTel.equals(other.businessTel))
			return false;
		if (isVerified != other.isVerified)
			return false;
		if (memberKey != other.memberKey)
			return false;
		if (regDate == null) {
			if (other.regDate != null)
				return false;
		} else if (!regDate.equals(other.regDate))
			return false;
		return true;
	}
	
	
	
}
