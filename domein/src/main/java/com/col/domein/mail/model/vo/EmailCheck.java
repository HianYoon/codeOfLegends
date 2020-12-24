package com.col.domein.mail.model.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
public class EmailCheck implements Comparable<EmailCheck>{
	
	private int memberKey;
	private String confirmationKey;
	private int dateDif;
	private int tryCount;
	
	public EmailCheck() {
		// TODO Auto-generated constructor stub
	}

	public EmailCheck(int memberKey, String confirmationKey, int dateDif, int tryCount) {
		super();
		this.memberKey = memberKey;
		this.confirmationKey = confirmationKey;
		this.dateDif = dateDif;
		this.tryCount = tryCount;
	}

	public int getMemberKey() {
		return memberKey;
	}

	public void setMemberKey(int memberKey) {
		this.memberKey = memberKey;
	}

	public String getConfirmationKey() {
		return confirmationKey;
	}

	public void setConfirmationKey(String confirmationKey) {
		this.confirmationKey = confirmationKey;
	}

	public int getDateDif() {
		return dateDif;
	}

	public void setDateDif(int dateDif) {
		this.dateDif = dateDif;
	}

	public int getTryCount() {
		return tryCount;
	}

	public void setTryCount(int tryCount) {
		this.tryCount = tryCount;
	}

	@Override
	public String toString() {
		return "EmailCheck [memberKey=" + memberKey + ", confirmationKey=" + confirmationKey + ", dateDif=" + dateDif
				+ ", tryCount=" + tryCount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((confirmationKey == null) ? 0 : confirmationKey.hashCode());
		result = prime * result + dateDif;
		result = prime * result + memberKey;
		result = prime * result + tryCount;
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
		EmailCheck other = (EmailCheck) obj;
		if (confirmationKey == null) {
			if (other.confirmationKey != null)
				return false;
		} else if (!confirmationKey.equals(other.confirmationKey))
			return false;
		if (dateDif != other.dateDif)
			return false;
		if (memberKey != other.memberKey)
			return false;
		if (tryCount != other.tryCount)
			return false;
		return true;
	}

	@Override
	public int compareTo(EmailCheck o) {
		// TODO Auto-generated method stub
		return this.memberKey-o.getMemberKey();
	}
	
}
