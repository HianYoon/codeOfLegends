package com.col.domein.ads.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.col.domein.ads.model.vo.BannerAds;

public interface AdsDao {

	int bannerApply(SqlSession session, BannerAds bannerAds);
	
}
