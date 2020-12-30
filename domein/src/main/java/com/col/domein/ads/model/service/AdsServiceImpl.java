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

	@Override
	public int bannerHoldCount(int applicantKey) {		
		return dao.bannerHoldCount(session,applicantKey);
	}

	@Override
	public int bannerAcceptCount(int applicantKey) {		
		return dao.bannerAcceptCount(session,applicantKey);
	}

	@Override
	public int bannerRejectCount(int applicantKey) {		
		return dao.bannerRejectCount(session,applicantKey);
	}

	@Override
	public int directHoldCount(int applicantKey) {		
		return dao.directHoldCount(session,applicantKey);
	}

	@Override
	public int directAcceptCount(int applicantKey) {		
		return dao.directAcceptCount(session,applicantKey);
	}

	@Override
	public int directRejectCount(int applicantKey) {		
		return dao.directRejectCount(session,applicantKey);
	}
	
	

}
