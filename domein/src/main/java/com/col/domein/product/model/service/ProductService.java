package com.col.domein.product.model.service;

import java.util.List;
import java.util.Map;

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


}
