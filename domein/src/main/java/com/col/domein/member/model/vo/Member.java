package com.col.domein.member.model.vo;

import java.sql.Date;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

import com.col.domein.business.model.vo.Business;

@Component
public class Member implements Comparable<Member>{
	
	private int memberKey;
	private String id;
	private String password;
	private String userName;
	private String nickname;
	private String phone;
	private String email;
	private String postcode;
	private String address1;
	private String address2;
	private int levelNo;
	private String levelDesc;
	private Date enrollDate;
	private Date modifiedDate;
	private String profileUrl;
	private int isConfirmed;
	private int accountStatusNo;
	private String statusDesc;
	private int isSubscribed;
	private int totalPoint;
	private TreeSet<Business> businesses;
	
	@Override
	public int compareTo(Member o) {
		// TODO Auto-generated method stub
		return this.memberKey-o.getMemberKey();
	}

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(int memberKey, String id, String password, String userName, String nickname, String phone,
			String email, String postcode, String address1, String address2, int levelNo, String levelDesc,
			Date enrollDate, Date modifiedDate, String profileUrl, int isConfirmed, int accountStatusNo,
			String statusDesc, int isSubscribed, int totalPoint, TreeSet<Business> businesses) {
		super();
		this.memberKey = memberKey;
		this.id = id;
		this.password = password;
		this.userName = userName;
		this.nickname = nickname;
		this.phone = phone;
		this.email = email;
		this.postcode = postcode;
		this.address1 = address1;
		this.address2 = address2;
		this.levelNo = levelNo;
		this.levelDesc = levelDesc;
		this.enrollDate = enrollDate;
		this.modifiedDate = modifiedDate;
		this.profileUrl = profileUrl;
		this.isConfirmed = isConfirmed;
		this.accountStatusNo = accountStatusNo;
		this.statusDesc = statusDesc;
		this.isSubscribed = isSubscribed;
		this.totalPoint = totalPoint;
		this.businesses = businesses;
	}

	public int getMemberKey() {
		return memberKey;
	}

	public void setMemberKey(int memberKey) {
		this.memberKey = memberKey;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public int getLevelNo() {
		return levelNo;
	}

	public void setLevelNo(int levelNo) {
		this.levelNo = levelNo;
	}

	public String getLevelDesc() {
		return levelDesc;
	}

	public void setLevelDesc(String levelDesc) {
		this.levelDesc = levelDesc;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public int getIsConfirmed() {
		return isConfirmed;
	}

	public void setIsConfirmed(int isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public int getAccountStatusNo() {
		return accountStatusNo;
	}

	public void setAccountStatusNo(int accountStatusNo) {
		this.accountStatusNo = accountStatusNo;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public int getIsSubscribed() {
		return isSubscribed;
	}

	public void setIsSubscribed(int isSubscribed) {
		this.isSubscribed = isSubscribed;
	}

	public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}

	public TreeSet<Business> getBusinesses() {
		return businesses;
	}

	public void setBusinesses(TreeSet<Business> businesses) {
		this.businesses = businesses;
	}

	@Override
	public String toString() {
		return "Member [memberKey=" + memberKey + ", id=" + id + ", password=" + password + ", userName=" + userName
				+ ", nickname=" + nickname + ", phone=" + phone + ", email=" + email + ", postcode=" + postcode
				+ ", address1=" + address1 + ", address2=" + address2 + ", levelNo=" + levelNo + ", levelDesc="
				+ levelDesc + ", enrollDate=" + enrollDate + ", modifiedDate=" + modifiedDate + ", profileUrl="
				+ profileUrl + ", isConfirmed=" + isConfirmed + ", accountStatusNo=" + accountStatusNo + ", statusDesc="
				+ statusDesc + ", isSubscribed=" + isSubscribed + ", totalPoint=" + totalPoint + ", businesses="
				+ businesses + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountStatusNo;
		result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((businesses == null) ? 0 : businesses.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((enrollDate == null) ? 0 : enrollDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + isConfirmed;
		result = prime * result + isSubscribed;
		result = prime * result + ((levelDesc == null) ? 0 : levelDesc.hashCode());
		result = prime * result + levelNo;
		result = prime * result + memberKey;
		result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((profileUrl == null) ? 0 : profileUrl.hashCode());
		result = prime * result + ((statusDesc == null) ? 0 : statusDesc.hashCode());
		result = prime * result + totalPoint;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Member other = (Member) obj;
		if (accountStatusNo != other.accountStatusNo)
			return false;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (businesses == null) {
			if (other.businesses != null)
				return false;
		} else if (!businesses.equals(other.businesses))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enrollDate == null) {
			if (other.enrollDate != null)
				return false;
		} else if (!enrollDate.equals(other.enrollDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isConfirmed != other.isConfirmed)
			return false;
		if (isSubscribed != other.isSubscribed)
			return false;
		if (levelDesc == null) {
			if (other.levelDesc != null)
				return false;
		} else if (!levelDesc.equals(other.levelDesc))
			return false;
		if (levelNo != other.levelNo)
			return false;
		if (memberKey != other.memberKey)
			return false;
		if (modifiedDate == null) {
			if (other.modifiedDate != null)
				return false;
		} else if (!modifiedDate.equals(other.modifiedDate))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (profileUrl == null) {
			if (other.profileUrl != null)
				return false;
		} else if (!profileUrl.equals(other.profileUrl))
			return false;
		if (statusDesc == null) {
			if (other.statusDesc != null)
				return false;
		} else if (!statusDesc.equals(other.statusDesc))
			return false;
		if (totalPoint != other.totalPoint)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	
	
}