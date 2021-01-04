package com.col.domein.business.model.service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.business.model.dao.BusinessDao;
import com.col.domein.business.model.vo.Business;
import com.col.domein.business.model.vo.BusinessCategory;

@Service
public class BusinessService {

	@Autowired
	private BusinessDao bd;
	@Autowired
	private SqlSession session;

	public boolean isEmptyBusinessNo(String businessNo) {
		return bd.isEmptyBusinessNo(session, businessNo);
	}

	public boolean insertBusiness(Business b) {

//		1.seq_business_key 받아오기
		int businessKey = bd.getSeqBusinessKeyNextVal(session);
		b.setBusinessKey(businessKey);
//		2.비지니스 등록
		boolean businessFlag = bd.insertBusiness(session, b);
		if (!businessFlag)
			return false;

//		3.카테고리 등록
		boolean categoryFlag = false;
		TreeSet<BusinessCategory> businessCategories = b.getBusinessCategories();
		try {
			for (BusinessCategory cat : businessCategories) {
				Map<String, Integer> keys = new HashMap<String, Integer>();
				keys.put("businessKey", businessKey);
				keys.put("businessCategoryNo", cat.getBusinessCategoryNo());
				categoryFlag = bd.insertBusinessCategory(session, keys);
				if(!categoryFlag) return false;
			}
			categoryFlag = true;
		} catch (Exception e) {
			categoryFlag = false;
		}
		return categoryFlag;
	}
	
	public int updateBusinessToStoppedByMemberKey(int memberKey) {
		return bd.updateBusinessToStoppedByMemberKey(session, memberKey);
	};
	
	public boolean updateBusinessToStoppedByBusinessKey(int businessKey) {
		return bd.updateBusinessToStoppedByBusinessKey(session, businessKey);
	}
	
	public boolean updateBusinessInfo(Business b) {
		int businessKey = b.getBusinessKey();
//		1.닉네임과 전화번호 업데이트
		boolean flag = bd.updateBusinessNicknameAndTel(session, b);
		if(!flag) return flag;
		
//		2. 카테고리 모두 삭제
		
		flag = bd.deleteCategories(session, businessKey);
		
//		3.카테고리 재등록
		boolean categoryFlag = false;
		TreeSet<BusinessCategory> businessCategories = b.getBusinessCategories();
		try {
			for (BusinessCategory cat : businessCategories) {
				Map<String, Integer> keys = new HashMap<String, Integer>();
				keys.put("businessKey", businessKey);
				keys.put("businessCategoryNo", cat.getBusinessCategoryNo());
				categoryFlag = bd.insertBusinessCategory(session, keys);
				if(!categoryFlag) return false;
			}
			categoryFlag = true;
		} catch (Exception e) {
			categoryFlag = false;
		}
		return categoryFlag;
	}
	
}
