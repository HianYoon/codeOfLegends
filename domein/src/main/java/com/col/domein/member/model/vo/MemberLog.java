package com.col.domein.member.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class MemberLog implements Comparable<MemberLog>{

	private int memberKey;
	private Date loginDate;
	private int loginStatusNo;
	private String statusDesc;
	private int loginSourceNo;
	private String sourceDesc;
	
	public MemberLog() {
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public int compareTo(MemberLog o) {
		// TODO Auto-generated method stub
		int difference = this.memberKey - o.getMemberKey();
		if(difference == 0) difference = this.loginDate.compareTo(o.getLoginDate());
		return difference;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loginDate == null) ? 0 : loginDate.hashCode());
		result = prime * result + loginSourceNo;
		result = prime * result + loginStatusNo;
		result = prime * result + memberKey;
		result = prime * result + ((sourceDesc == null) ? 0 : sourceDesc.hashCode());
		result = prime * result + ((statusDesc == null) ? 0 : statusDesc.hashCode());
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
		MemberLog other = (MemberLog) obj;
		if (loginDate == null) {
			if (other.loginDate != null)
				return false;
		} else if (!loginDate.equals(other.loginDate))
			return false;
		if (loginSourceNo != other.loginSourceNo)
			return false;
		if (loginStatusNo != other.loginStatusNo)
			return false;
		if (memberKey != other.memberKey)
			return false;
		if (sourceDesc == null) {
			if (other.sourceDesc != null)
				return false;
		} else if (!sourceDesc.equals(other.sourceDesc))
			return false;
		if (statusDesc == null) {
			if (other.statusDesc != null)
				return false;
		} else if (!statusDesc.equals(other.statusDesc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MemberLog [memberKey=" + memberKey + ", loginDate=" + loginDate + ", loginStatusNo=" + loginStatusNo
				+ ", statusDesc=" + statusDesc + ", loginSourceNo=" + loginSourceNo + ", sourceDesc=" + sourceDesc
				+ "]";
	}

	public int getMemberKey() {
		return memberKey;
	}

	public void setMemberKey(int memberKey) {
		this.memberKey = memberKey;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public int getLoginStatusNo() {
		return loginStatusNo;
	}

	public void setLoginStatusNo(int loginStatusNo) {
		this.loginStatusNo = loginStatusNo;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
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

	public MemberLog(int memberKey, Date loginDate, int loginStatusNo, String statusDesc, int loginSourceNo,
			String sourceDesc) {
		super();
		this.memberKey = memberKey;
		this.loginDate = loginDate;
		this.loginStatusNo = loginStatusNo;
		this.statusDesc = statusDesc;
		this.loginSourceNo = loginSourceNo;
		this.sourceDesc = sourceDesc;
	}
	
}
