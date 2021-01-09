package com.col.domein.ads.model.service;

import java.util.List;

import com.col.domein.ads.model.vo.BannerAds;
import com.col.domein.ads.model.vo.DirectAds;
import com.col.domein.product.model.vo.BoardProductSaleContent;

public interface AdsService {

	int bannerApply(BannerAds bannerAds);	
	
	int bannerHoldCount(int applicantKey);
	
	int bannerAcceptCount(int applicantKey);
	
	int bannerRejectCount(int applicantKey);
	
	int directHoldCount(int applicantKey);
	
	int directAcceptCount(int applicantKey);
	
	int directRejectCount(int applicantKey);
	
	int showMeRate();
	
	int showMeDirectAdsRate();
	
	List<BoardProductSaleContent> selectBoardDirectSale(List keys);
	
	int directAdsApply(DirectAds directAds);
	
	List selectBannerAccept(String today);
	
	List selectDirectAccept();
	
	List selectBannerDeny();
	
	List selectDirectDeny();
	
	int selectBannerPending();
	
	List selectDirectPending();
	
	List selectAccept();
	
	List selectDeny();
	
	List selectPending();
	
	int selectAdsCountByDay(String day);
	
	List selectBannerTotalAccept();
	
	List selectAll(int cPage,int numPerpage);
	
	int selectCountAll();
	
	List selectBannerWhole();
	
}
