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
	
	int selectBannerAccept(SqlSession session);
	
	int selectDirectAccept(SqlSession session);
	
	int selectBannerDeny(SqlSession session);
	
	int selectDirectDeny(SqlSession session);
	
	int selectBannerPending(SqlSession session);
	
	int selectDirectPending(SqlSession session);
	
	List selectAccept(SqlSession session);
	
	List selectDeny(SqlSession session);
	
	List selectPending(SqlSession session);
	
}
