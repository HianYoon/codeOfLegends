package com.col.domein.product.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.col.domein.product.model.vo.Product;
import com.col.domein.product.model.vo.ProductBoardContent;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Override
	public int insertProduct(SqlSession session, Product product, ProductBoardContent pbc) {
		// TODO Auto-generated method stub
		return session.insert("product.insertProduct",product);
	}
	
	

}
