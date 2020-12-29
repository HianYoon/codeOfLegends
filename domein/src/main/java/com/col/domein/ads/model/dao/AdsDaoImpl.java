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

}
