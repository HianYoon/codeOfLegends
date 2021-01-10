package com.col.domein.ads.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.col.domein.ads.model.vo.BannerAds;
import com.col.domein.ads.model.vo.DirectAds;
import com.col.domein.product.model.vo.BoardProductSaleContent;

public interface AdsDao {

	int bannerApply(SqlSession session, BannerAds bannerAds);
	
	int bannerHoldCount(SqlSession session,int applicantKey);
	
	int bannerAcceptCount(SqlSession session,int applicantKey);
	
	int bannerRejectCount(SqlSession session,int applicantKey);
	
	int directHoldCount(SqlSession session,int applicantKey);
	
	int directAcceptCount(SqlSession session,int applicantKey);
	
	int directRejectCount(SqlSession session,int applicantKey);
	
	int showMeRate(SqlSession session);
	
	int showMeDirectAdsRate(SqlSession session);
	
	List<BoardProductSaleContent> selectBoardDirectSale(SqlSession session,List keys);
	
	int directAdsApply(SqlSession session, DirectAds directAds);
	
	List selectBannerAccept(SqlSession session, String today);
	
	List selectDirectAccept(SqlSession session);
	
	List selectBannerDeny(SqlSession session);
	
	List selectDirectDeny(SqlSession session);
	
	int selectBannerPending(SqlSession session);
	
	int selectDirectPending(SqlSession session);
	
	List selectAccept(SqlSession session);
	
	List selectDeny(SqlSession session);
	
	List selectPending(SqlSession session);
	
	int selectAdsCountByDay(SqlSession session,String day);
	
	List selectBannerTotalAccept(SqlSession session);
	
	List selectBannerBoardAll(SqlSession session,int cPage,int numPerpage);
	
	int selectBannerCountAll(SqlSession session);
	
	BannerAds selectBannerWhole(SqlSession session, int adsKey);
	
	int updateAccept(SqlSession session, int adsKey);
	
	int updateDeny(SqlSession session, int adsKey);
	
	List selectDirectBoardAll(SqlSession session,int cPage,int numPerpage);
	
	int selectDirectCountAll(SqlSession session);
	
	String selectDirectSaleContent(SqlSession session,String articleNo);
	
}
