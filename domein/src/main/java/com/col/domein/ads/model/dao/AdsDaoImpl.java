package com.col.domein.ads.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
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

	@Override
	public List selectBannerAccept(SqlSession session, String today) {		
//			System.out.println("dao: "+session.selectList("bannerAds.selectBannerAccept",today));
		return session.selectList("bannerAds.selectBannerAccept",today);		
	}

	@Override
	public List selectDirectAccept(SqlSession session) {
		List<Integer> accept=new ArrayList();
		accept.add(0);
		if(session.selectList("directAds.selectDirectAccept")==null) {
			return accept;
		}else {
			return session.selectList("directAds.selectDirectAccept");			
		}
	}

	@Override
	public List selectBannerDeny(SqlSession session) {
		List<Integer> deny=new ArrayList();
		deny.add(0);
		if(session.selectList("bannerAds.selectBannerDeny")==null) {
			return deny;
		}else {
			return session.selectList("bannerAds.selectBannerDeny");
		}
	}

	@Override
	public List selectDirectDeny(SqlSession session) {
		List<Integer> deny=new ArrayList();
		deny.add(0);
		if(session.selectList("directAds.selectDirectDeny")==null) {
			return deny;
		}else {
			return session.selectList("directAds.selectDirectDeny");			
		}		
	}

	@Override
	public int selectBannerPending(SqlSession session) {				
		return session.selectOne("bannerAds.selectBannerPending");		
	}

	@Override
	public List selectDirectPending(SqlSession session) {
		List<Integer> pending=new ArrayList();
		pending.add(0);
		if(session.selectList("directAds.selectDirectPending")==null) {
			return pending;
		}else {
			return session.selectList("directAds.selectDirectPending");			
		}
	}

	@Override
	public List selectAccept(SqlSession session) {
		List<Integer> accept=new ArrayList();
		accept.add(0);
		System.out.println("이게 다오: "+accept.get(0));
		if(session.selectList("bannerAds.selectAccept")==null&&session.selectList("bannerAds.selectAccept").size()==0) {
			return accept;
		}else {
			return session.selectList("bannerAds.selectAccept");
		}
	}

	@Override
	public List selectDeny(SqlSession session) {
		List deny=new ArrayList();
		deny.add(0);
		if(session.selectList("bannerAds.selectDeny")==null) {
			return deny;
		}else {
			return session.selectList("bannerAds.selectDeny");
		}
	}

	@Override
	public List selectPending(SqlSession session) {
		List pending=new ArrayList();
		pending.add(0);
		if(session.selectList("bannerAds.selectPending")==null) {
			return pending;
		}else {
			return session.selectList("bannerAds.selectPending");
		}
	}

	@Override
	public int selectAdsCountByDay(SqlSession session, String day) {
		return session.selectOne("bannerAds.selectAdsCountByDay",day);
	}

	@Override
	public List selectBannerTotalAccept(SqlSession session) {
		return session.selectList("bannerAds.selectBannerTotalAccept");
	}

	@Override
	public List selectAll(SqlSession session, int cPage, int numPerpage) {
		return session.selectList("bannerAds.selectAll",null,new RowBounds((cPage-1)*numPerpage, numPerpage));
	}

	@Override
	public int selectCountAll(SqlSession session) {
		return session.selectOne("bannerAds.selectCountAll");
	}

	@Override
	public BannerAds selectBannerWhole(SqlSession session, int adsKey) {
		return session.selectOne("bannerAds.selectBannerWhole",adsKey);
	}

	@Override
	public int updateAccept(SqlSession session, int adsKey) {
		return session.update("bannerAds.updateAccept",adsKey);
	}

	@Override
	public int updateDeny(SqlSession session, int adsKey) {
		return session.update("bannerAds.updateDeny",adsKey);
	}
	
	
	
	
	
	

}
