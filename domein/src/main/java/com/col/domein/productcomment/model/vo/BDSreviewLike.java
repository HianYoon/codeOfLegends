package com.col.domein.productcomment.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Builder;

@Builder
@Component
public class BDSreviewLike {
	
	private int reviewNo;
	private int actorKey;
	private Date likedDate;
	public BDSreviewLike() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BDSreviewLike(int reviewNo, int actorKey, Date likedDate) {
		super();
		this.reviewNo = reviewNo;
		this.actorKey = actorKey;
		this.likedDate = likedDate;
	}
	int getReviewNo() {
		return reviewNo;
	}
	void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	int getActorKey() {
		return actorKey;
	}
	void setActorKey(int actorKey) {
		this.actorKey = actorKey;
	}
	Date getLikedDate() {
		return likedDate;
	}
	void setLikedDate(Date likedDate) {
		this.likedDate = likedDate;
	}
	@Override
	public String toString() {
		return "BDSreviewLike [reviewNo=" + reviewNo + ", actorKey=" + actorKey + ", likedDate=" + likedDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actorKey;
		result = prime * result + ((likedDate == null) ? 0 : likedDate.hashCode());
		result = prime * result + reviewNo;
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
		BDSreviewLike other = (BDSreviewLike) obj;
		if (actorKey != other.actorKey)
			return false;
		if (likedDate == null) {
			if (other.likedDate != null)
				return false;
		} else if (!likedDate.equals(other.likedDate))
			return false;
		if (reviewNo != other.reviewNo)
			return false;
		return true;
	} 
	
	
}
