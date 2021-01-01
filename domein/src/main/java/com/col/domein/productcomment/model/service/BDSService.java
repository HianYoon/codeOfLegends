package com.col.domein.productcomment.model.service;

import java.util.List;
import java.util.Map;

import com.col.domein.productcomment.model.vo.BDSreview;

public interface BDSService {
	//댓글 등록 
	int insertComment(BDSreview bds);
	//댓글 불러오기
	List<Map> selectBDScomment(int reviewNo);

}
