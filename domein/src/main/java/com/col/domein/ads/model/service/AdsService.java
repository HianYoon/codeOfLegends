package com.col.domein.ads.model.service;

import com.col.domein.ads.model.vo.BannerAds;

public interface AdsService {

	int bannerApply(BannerAds bannerAds);	
	
	int bannerHoldCount();
	
	int bannerAcceptCount();
	
	int bannerRejectCount();
	
	int directHoldCount();
	
	int directAcceptCount();
	
	int directRejectCount();
	
}
