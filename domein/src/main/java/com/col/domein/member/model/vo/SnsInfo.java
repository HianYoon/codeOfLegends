package com.col.domein.member.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class SnsInfo implements Comparable<SnsInfo>{
	
	private int memberKey;
	private int loginSourceNo;
	private String sourceDesc;
	private String snsId;
	private String snsName;
	private String snsProfilePic;
	private Date snsConnectDate;
	
	public SnsInfo() {
		// TODO Auto-generated constructor stub
	}

	public SnsInfo(int memberKey, int loginSourceNo, String sourceDesc, String snsId, String snsName,
			String snsProfilePic, Date snsConnectDate) {
		super();
		this.memberKey = memberKey;
		this.loginSourceNo = loginSourceNo;
		this.sourceDesc = sourceDesc;
		this.snsId = snsId;
		this.snsName = snsName;
		this.snsProfilePic = snsProfilePic;
		this.snsConnectDate = snsConnectDate;
	}

	@Override
	public int compareTo(SnsInfo o) {
		// TODO Auto-generated method stub
		int result = this.memberKey-o.getMemberKey();
		if(result==0) result = this.loginSourceNo - o.getLoginSourceNo();
		return result;
	}

	public int getMemberKey() {
		return memberKey;
	}

	public void setMemberKey(int memberKey) {
		this.memberKey = memberKey;
	}

	public int getLoginSourceNo() {
		return loginSourceNo;
	}

	public void setLoginSourceNo(int loginSourceNo) {
		this.loginSourceNo = loginSourceNo;
	}

	public String getSourceDesc() {
		return sourceDesc;
	}

	public void setSourceDesc(String sourceDesc) {
		this.sourceDesc = sourceDesc;
	}

	public String getSnsId() {
		return snsId;
	}

	public void setSnsId(String snsId) {
		this.snsId = snsId;
	}

	public String getSnsName() {
		return snsName;
	}

	public void setSnsName(String snsName) {
		this.snsName = snsName;
	}

	public String getSnsProfilePic() {
		return snsProfilePic;
	}

	public void setSnsProfilePic(String snsProfilePic) {
		this.snsProfilePic = snsProfilePic;
	}

	public Date getSnsConnectDate() {
		return snsConnectDate;
	}

	public void setSnsConnectDate(Date snsConnectDate) {
		this.snsConnectDate = snsConnectDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + loginSourceNo;
		result = prime * result + memberKey;
		result = prime * result + ((snsConnectDate == null) ? 0 : snsConnectDate.hashCode());
		result = prime * result + ((snsId == null) ? 0 : snsId.hashCode());
		result = prime * result + ((snsName == null) ? 0 : snsName.hashCode());
		result = prime * result + ((snsProfilePic == null) ? 0 : snsProfilePic.hashCode());
		result = prime * result + ((sourceDesc == null) ? 0 : sourceDesc.hashCode());
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
		SnsInfo other = (SnsInfo) obj;
		if (loginSourceNo != other.loginSourceNo)
			return false;
		if (memberKey != other.memberKey)
			return false;
		if (snsConnectDate == null) {
			if (other.snsConnectDate != null)
				return false;
		} else if (!snsConnectDate.equals(other.snsConnectDate))
			return false;
		if (snsId == null) {
			if (other.snsId != null)
				return false;
		} else if (!snsId.equals(other.snsId))
			return false;
		if (snsName == null) {
			if (other.snsName != null)
				return false;
		} else if (!snsName.equals(other.snsName))
			return false;
		if (snsProfilePic == null) {
			if (other.snsProfilePic != null)
				return false;
		} else if (!snsProfilePic.equals(other.snsProfilePic))
			return false;
		if (sourceDesc == null) {
			if (other.sourceDesc != null)
				return false;
		} else if (!sourceDesc.equals(other.sourceDesc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SnsInfo [memberKey=" + memberKey + ", loginSourceNo=" + loginSourceNo + ", sourceDesc=" + sourceDesc
				+ ", snsId=" + snsId + ", snsName=" + snsName + ", snsProfilePic=" + snsProfilePic + ", snsConnectDate="
				+ snsConnectDate + "]";
	}
	
}
