package com.col.domein.product.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.col.domein.product.model.vo.Attachement;
import com.col.domein.product.model.vo.Product;
import com.col.domein.product.model.vo.ProductBoardContent;

public interface ProductDao {

	//상품등록
	int insertProduct(SqlSession session, Product p);

	int insertAttachment(SqlSession session, Attachement a);

	int insertProductContent(SqlSession session, ProductBoardContent pbc);

}
