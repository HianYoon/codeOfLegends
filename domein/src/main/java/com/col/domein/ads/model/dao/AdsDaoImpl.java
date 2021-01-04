package com.col.domein.ads.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.col.domein.ads.model.vo.BannerAds;
import com.col.domein.ads.model.vo.DirectAds;
import com.col.domein.product.model.vo.BoardProductSaleContent;

@Repository
public class AdsDaoImpl implements AdsDao {	
	
	@Override
	public int bannerApply(SqlSession session, BannerAds bannerAds) {
		return session.insert("bannerAds.insertBannerAds",bannerAds);
	}	

	@Override
	public int bannerHoldCount(SqlSession session,int applicantKey) {		
		return session.selectOne("bannerAds.selectBannerHoldCount",applicantKey);
	}

	@Override
	public int bannerAcceptCount(SqlSession session,int applicantKey) {		
		return session.selectOne("bannerAds.selectBannerAcceptCount",applicantKey);
	}

	@Override
	public int bannerRejectCount(SqlSession session,int applicantKey) {		
		return session.selectOne("bannerAds.selectBannerRejectCount",applicantKey);
	}

	@Override
	public int directHoldCount(SqlSession session,int applicantKey) {		
		return session.selectOne("directAds.selectDirectHoldCount",applicantKey);
	}

	@Override
	public int directAcceptCount(SqlSession session,int applicantKey) {	
		return session.selectOne("directAds.selectDirectAcceptCount",applicantKey);
	}

	@Override
	public int directRejectCount(SqlSession session,int applicantKey) {	
		return session.selectOne("directAds.selectDirectRejectCount",applicantKey);
	}

	@Override
	public int showMeRate(SqlSession session) {
		return session.selectOne("bannerAds.selectAdsRate");
	}

	@Override
	public int showMeDirectAdsRate(SqlSession session) {
		return session.selectOne("directAds.selectDirectAdsRate");
	}

	@Override
	public List<BoardProductSaleContent> selectBoardDirectSale(SqlSession session, List keys) {
		return session.selectList("directAds.selectBoardDirectSale",keys);
	}

	@Override
	public int directAdsApply(SqlSession session, DirectAds directAds) {
		return session.insert("directAds.insertDirectAds", directAds);
	}
	
	
	
	

}
