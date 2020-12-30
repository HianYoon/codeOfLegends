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
	public int bannerHoldCount() {		
		return dao.bannerHoldCount(session);
	}

	@Override
	public int bannerAcceptCount() {		
		return dao.bannerAcceptCount(session);
	}

	@Override
	public int bannerRejectCount() {		
		return dao.bannerRejectCount(session);
	}

	@Override
	public int directHoldCount() {		
		return dao.directHoldCount(session);
	}

	@Override
	public int directAcceptCount() {		
		return dao.directAcceptCount(session);
	}

	@Override
	public int directRejectCount() {		
		return dao.directRejectCount(session);
	}
	
	

}
