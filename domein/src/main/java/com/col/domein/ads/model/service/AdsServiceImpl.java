package com.col.domein.ads.model.service;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.ads.model.dao.AdsDao;
import com.col.domein.ads.model.vo.BannerAds;
import com.col.domein.ads.model.vo.DirectAds;
import com.col.domein.product.model.vo.BoardProductSaleContent;

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

	@Override
	public int showMeRate() {		
		return dao.showMeRate(session);
	}

	@Override
	public int showMeDirectAdsRate() {
		return dao.showMeDirectAdsRate(session);
	}

	@Override
	public List<BoardProductSaleContent> selectBoardDirectSale(List keys) {
		return dao.selectBoardDirectSale(session,keys);
	}

	@Override
	public int directAdsApply(DirectAds directAds) {
		return dao.directAdsApply(session, directAds);
	}

	@Override
	public List selectBannerAccept(String today) {
		return dao.selectBannerAccept(session, today);
	}

	@Override
	public List selectDirectAccept() {
		return dao.selectDirectAccept(session);
	}

	@Override
	public List selectBannerDeny() {
		return dao.selectBannerDeny(session);
	}

	@Override
	public List selectDirectDeny() {
		return dao.selectDirectDeny(session);
	}

	@Override
	public int selectBannerPending() {
		return dao.selectBannerPending(session);
	}

	@Override
	public int selectDirectPending() {
		return dao.selectDirectPending(session);
	}

	@Override
	public List selectAccept() {		
		return dao.selectAccept(session);
	}

	@Override
	public List selectDeny() {
		return dao.selectDeny(session);
	}

	@Override
	public List selectPending() {
		return dao.selectPending(session);
	}

	@Override
	public int selectAdsCountByDay(String day) {
		return dao.selectAdsCountByDay(session,day);
	}

	@Override
	public List selectBannerTotalAccept() {
		return dao.selectBannerTotalAccept(session);
	}

	@Override
	public List selectBannerBoardAll(int cPage,int numPerpage) {
		return dao.selectBannerBoardAll(session,cPage,numPerpage);
	}

	@Override
	public int selectBannerCountAll() {
		return dao.selectBannerCountAll(session);
	}

	@Override
	public BannerAds selectBannerWhole(int adsKey) {
		return dao.selectBannerWhole(session,adsKey);
	}

	@Override
	public int updateAccept(int adsKey) {
		return dao.updateAccept(session,adsKey);
	}

	@Override
	public int updateDeny(int adsKey) {
		return dao.updateDeny(session,adsKey);
	}

	@Override
	public List selectDirectBoardAll(int cPage, int numPerpage) {
		return dao.selectDirectBoardAll(session,cPage,numPerpage);
	}

	@Override
	public int selectDirectCountAll() {
		return dao.selectDirectCountAll(session);
	}

	@Override
	public String selectDirectSaleContent(String articleNo) {
		return dao.selectDirectSaleContent(session, articleNo);
	}

	@Override
	public DirectAds selectDirectWhole(int adsKey) {
		return dao.selectDirectWhole(session,adsKey);
	}

	@Override
	public int updateDirectAccept(int adsKey) {
		return dao.updateDirectAccept(session,adsKey);
	}

	@Override
	public int updateDirectDeny(int adsKey) {
		return dao.updateDirectDeny(session,adsKey);
	}

	@Override
	public int insertOrderNo(int orderNo) {
		return dao.insertOrderNo(session,orderNo);
	}

	
	
	
	

}
