package com.col.domein.product.model.service;

import java.util.List;
import java.util.Map;

import com.col.domein.common.crteria.SearchCriteria;
import com.col.domein.product.model.vo.Attachement;
import com.col.domein.product.model.vo.BoardProductSaleContent;
import com.col.domein.product.model.vo.Product;
import com.col.domein.product.model.vo.ProductAll;

public interface ProductService {

	




	//boardSaleContent
	int insertBoardSContent(BoardProductSaleContent bp);
	//product && files
	int insertProductFileList(Product p, List<Attachement> files);
	
	//product 페이징처리
	List<Map> selectProductList(int cPage, int numPerpage);
	//조회
	int selectCount();
	List<Map> selectProductDetail(int articleNo);
	//내상품조회
	List<Map> selectProductUpdate(int businessKey);
	//상품선택시 상품 리스트불러오기
	List<Map> selectProductOne(int articleNo);
	//상품삭제
	int productDelete(int articleNo);
	//상품수정 BDS수정  
	int updateBDS(ProductAll p);
	//상품수정PDS수정
	int updatePDS(ProductAll p, List<Attachement> files);
	//비즈니스키로 상품목록 조회
	List<Map> selectProductByBusinessKey(int businessKey);
	
	//검색기능
	List<ProductAll> searchList(SearchCriteria scri)throws Exception;
	//게시물 갯수
	int searchListCount(SearchCriteria scri)throws Exception;


}
