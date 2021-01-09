package com.col.domein.ads.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class BannerAds {

	private int adsKey;
	private int applicantKey;
	private String adsOriginalFileName;
	private String adsRenamedFileName;
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date startDate;
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date endDate;
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date applyDate;
	private String urlLink;
	private String adsDescription;
	private String adsMemo;
	private int adsStatusNo;
	private String adsTitle;
	private int adsPrice;
	private String statusDesc;
	private String nickName;
	
	
	public BannerAds() {
		// TODO Auto-generated constructor stub
	}


	public BannerAds(int adsKey, int applicantKey, String adsOriginalFileName, String adsRenamedFileName,
			Date startDate, Date endDate, Date applyDate, String urlLink, String adsDescription, String adsMemo,
			int adsStatusNo, String adsTitle, int adsPrice, String statusDesc, String nickName) {
		super();
		this.adsKey = adsKey;
		this.applicantKey = applicantKey;
		this.adsOriginalFileName = adsOriginalFileName;
		this.adsRenamedFileName = adsRenamedFileName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.applyDate = applyDate;
		this.urlLink = urlLink;
		this.adsDescription = adsDescription;
		this.adsMemo = adsMemo;
		this.adsStatusNo = adsStatusNo;
		this.adsTitle = adsTitle;
		this.adsPrice = adsPrice;
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


	public String getAdsOriginalFileName() {
		return adsOriginalFileName;
	}


	public void setAdsOriginalFileName(String adsOriginalFileName) {
		this.adsOriginalFileName = adsOriginalFileName;
	}


	public String getAdsRenamedFileName() {
		return adsRenamedFileName;
	}


	public void setAdsRenamedFileName(String adsRenamedFileName) {
		this.adsRenamedFileName = adsRenamedFileName;
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


	public String getUrlLink() {
		return urlLink;
	}


	public void setUrlLink(String urlLink) {
		this.urlLink = urlLink;
	}


	public String getAdsDescription() {
		return adsDescription;
	}


	public void setAdsDescription(String adsDescription) {
		this.adsDescription = adsDescription;
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


	public String getAdsTitle() {
		return adsTitle;
	}


	public void setAdsTitle(String adsTitle) {
		this.adsTitle = adsTitle;
	}


	public int getAdsPrice() {
		return adsPrice;
	}


	public void setAdsPrice(int adsPrice) {
		this.adsPrice = adsPrice;
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
		return "BannerAds [adsKey=" + adsKey + ", applicantKey=" + applicantKey + ", adsOriginalFileName="
				+ adsOriginalFileName + ", adsRenamedFileName=" + adsRenamedFileName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", applyDate=" + applyDate + ", urlLink=" + urlLink + ", adsDescription="
				+ adsDescription + ", adsMemo=" + adsMemo + ", adsStatusNo=" + adsStatusNo + ", adsTitle=" + adsTitle
				+ ", adsPrice=" + adsPrice + ", statusDesc=" + statusDesc + ", nickName=" + nickName + "]";
	}


	

	
		
	
}
