package com.col.domein.ads.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.col.domein.ads.model.vo.BannerAds;

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
	
	
	
	

}
