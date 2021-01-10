package com.col.domein.ads.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class DirectAds {
	
	private int adsKey;
	private int applicantKey;
	private Date startDate;
	private Date endDate;
	private Date applyDate;
	private String adsMemo;
	private int adsStatusNo;
	private int articleNo;
	private int adsPrice;
	private String adsTitle;
	private String adsDescription;
	private String statusDesc;
	private String nickName;
	
	
	public DirectAds() {
		// TODO Auto-generated constructor stub
	}


	public DirectAds(int adsKey, int applicantKey, Date startDate, Date endDate, Date applyDate, String adsMemo,
			int adsStatusNo, int articleNo, int adsPrice, String adsTitle, String adsDescription, String statusDesc,
			String nickName) {
		super();
		this.adsKey = adsKey;
		this.applicantKey = applicantKey;
		this.startDate = startDate;
		this.endDate = endDate;
		this.applyDate = applyDate;
		this.adsMemo = adsMemo;
		this.adsStatusNo = adsStatusNo;
		this.articleNo = articleNo;
		this.adsPrice = adsPrice;
		this.adsTitle = adsTitle;
		this.adsDescription = adsDescription;
		this.statusDesc = statusDesc;
		this.nickName = nickName;
	}


	public int getAdsKey() {
		return adsKey;
	}


	public void setAdsKey(int adsKey) {
		this.adsKey = adsKey;
	}


	public int getApplicantKey() {
		return applicantKey;
	}


	public void setApplicantKey(int applicantKey) {
		this.applicantKey = applicantKey;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Date getApplyDate() {
		return applyDate;
	}


	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}


	public String getAdsMemo() {
		return adsMemo;
	}


	public void setAdsMemo(String adsMemo) {
		this.adsMemo = adsMemo;
	}


	public int getAdsStatusNo() {
		return adsStatusNo;
	}


	public void setAdsStatusNo(int adsStatusNo) {
		this.adsStatusNo = adsStatusNo;
	}


	public int getArticleNo() {
		return articleNo;
	}


	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}


	public int getAdsPrice() {
		return adsPrice;
	}


	public void setAdsPrice(int adsPrice) {
		this.adsPrice = adsPrice;
	}


	public String getAdsTitle() {
		return adsTitle;
	}


	public void setAdsTitle(String adsTitle) {
		this.adsTitle = adsTitle;
	}


	public String getAdsDescription() {
		return adsDescription;
	}


	public void setAdsDescription(String adsDescription) {
		this.adsDescription = adsDescription;
	}


	public String getStatusDesc() {
		return statusDesc;
	}


	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	@Override
	public String toString() {
		return "DirectAds [adsKey=" + adsKey + ", applicantKey=" + applicantKey + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", applyDate=" + applyDate + ", adsMemo=" + adsMemo + ", adsStatusNo="
				+ adsStatusNo + ", articleNo=" + articleNo + ", adsPrice=" + adsPrice + ", adsTitle=" + adsTitle
				+ ", adsDescription=" + adsDescription + ", statusDesc=" + statusDesc + ", nickName=" + nickName + "]";
	}


	

	

		

}
