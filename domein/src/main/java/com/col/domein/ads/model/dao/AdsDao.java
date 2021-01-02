package com.col.domein.ads.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.col.domein.ads.model.vo.BannerAds;

public interface AdsDao {

	int bannerApply(SqlSession session, BannerAds bannerAds);
	
	int bannerHoldCount(SqlSession session,int applicantKey);
	
	int bannerAcceptCount(SqlSession session,int applicantKey);
	
	int bannerRejectCount(SqlSession session,int applicantKey);
	
	int directHoldCount(SqlSession session,int applicantKey);
	
	int directAcceptCount(SqlSession session,int applicantKey);
	
	int directRejectCount(SqlSession session,int applicantKey);
	
	int showMeRate(SqlSession session);
	
}
