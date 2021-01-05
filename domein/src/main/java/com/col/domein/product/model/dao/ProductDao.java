package com.col.domein.product.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.col.domein.business.model.vo.Business;
import com.col.domein.common.crteria.SearchCriteria;
import com.col.domein.product.model.vo.Attachement;
import com.col.domein.product.model.vo.BoardProductSaleContent;
import com.col.domein.product.model.vo.Product;
import com.col.domein.product.model.vo.ProductAll;


public interface ProductDao {

	//상품등록
	int insertProduct(SqlSession session, Product p);

	//boardSaleContent등록
	int insertBoardSContent(SqlSession session, BoardProductSaleContent bp);
	
	//파일등록
	int insertAttachment(SqlSession session, Attachement a);
	
	//상품리스트
	List<Map> selectProductList(SqlSession session, int cPage, int numPerpage);
	//조회수
	int selectCount(SqlSession session);

	List<Map> selectProductDetail(SqlSession session, int articleNo);
	//내상품조회
	List<Map> selectProductUpdate(SqlSession session, int businessKey);
	//내상품조회 상품 수정
	List<Map> selectProductOne(SqlSession session, int articleNo);
	// 상품 삭제
	int deleteProduct(SqlSession session, int articleNo);
	//상품 BDS 수정
	int updateBDS(SqlSession session, ProductAll p);
	//상품PDS 수정
	int updatePDS(SqlSession session,ProductAll p);
	//상품files수정
	int updateAttachment(SqlSession session, Attachement a);
	List<Map> selectProductByBusinessKey(SqlSession session,int businessKey);
	
	//상품검색
	List<Map> searchListAll(SqlSession session, SearchCriteria scri)throws Exception;
	//상품조회물갯수
	int searchListCount(SqlSession session, SearchCriteria scri);

	int blindProduct(SqlSession session, int productNo,int status);

	int updateProductStatusToStoppedByArticleNo(SqlSession session, int articleNo);
	
	int updateSaleStatusToStoppedByBusinessKey(SqlSession session, int businessKey);
	
	int updateBidStatusToStoppedByBusinessKey(SqlSession session, int businessKey);
	
	int updateAuctionStatusToStoppedByBusinessKey(SqlSession session, int businessKey);
	
	List<Map> searchArticle(SqlSession session, String keyword, String searchOption);
	//memberKey
	List<Map> selectBusinessOne(SqlSession session, int memberKey);

}
