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
	
	int selectDirectPending();
	
	List selectAccept();
	
	List selectDeny();
	
	List selectPending();
	
	int selectAdsCountByDay(String day);
	
	List selectBannerTotalAccept();
	
	List selectBannerBoardAll(int cPage,int numPerpage);
	
	int selectBannerCountAll();
	
	BannerAds selectBannerWhole(int adsKey);
	
	int updateAccept(int adsKey);
	
	int updateDeny(int adsKey);
	
	List selectDirectBoardAll(int cPage,int numPerpage);
	
	int selectDirectCountAll();
	
	String selectDirectSaleContent(String articleNo);
	
	DirectAds selectDirectWhole(int adsKey);
	
	int updateDirectAccept(int adsKey);
	
	int updateDirectDeny(int adsKey);
	
	int insertOrderNo(int orderNo);
	
}
