package com.col.domein.ads.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.ads.model.dao.AdsDao;
import com.col.domein.ads.model.vo.BannerAds;

@Service
public class AdsServiceImpl implements AdsService {

	@Autowired
	private AdsDao dao;
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int bannerApply(BannerAds bannerAds) {
		return dao.bannerApply(session,bannerAds);
	}

}
