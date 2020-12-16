package com.col.domein.product.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.col.domein.product.model.vo.Attachement;
import com.col.domein.product.model.vo.BoardProductSaleContent;
import com.col.domein.product.model.vo.Product;


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




	


}
