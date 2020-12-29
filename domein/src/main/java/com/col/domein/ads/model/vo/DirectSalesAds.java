package com.col.domein.ads.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class DirectSalesAds {
	
	private int adsKey;
	private int applicantKey;
	private Date startDate;
	private Date endDate;
	private Date applyDate;
	private String adsMemo;
	private int adsStatusNo;
	private int articleNo;
	
	
	public DirectSalesAds() {
		// TODO Auto-generated constructor stub
	}


	public DirectSalesAds(int adsKey, int applicantKey, Date startDate, Date endDate, Date applyDate, String adsMemo,
			int adsStatusNo, int articleNo) {
		super();
		this.adsKey = adsKey;
		this.applicantKey = applicantKey;
		this.startDate = startDate;
		this.endDate = endDate;
		this.applyDate = applyDate;
		this.adsMemo = adsMemo;
		this.adsStatusNo = adsStatusNo;
		this.articleNo = articleNo;
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


	@Override
	public String toString() {
		return "DirectSalesAds [adsKey=" + adsKey + ", applicantKey=" + applicantKey + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", applyDate=" + applyDate + ", adsMemo=" + adsMemo + ", adsStatusNo="
				+ adsStatusNo + ", articleNo=" + articleNo + "]";
	}
	
	
	

}
