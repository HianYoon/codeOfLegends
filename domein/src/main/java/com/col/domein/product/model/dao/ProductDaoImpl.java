package com.col.domein.product.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.col.domein.product.model.vo.Attachement;
import com.col.domein.product.model.vo.BoardProductSaleContent;
import com.col.domein.product.model.vo.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	//상품 등록 
	@Override
	public int insertProduct(SqlSession session,Product p ) {
		// TODO Auto-generated method stub
		return session.insert("insertProduct",p);
	}

	@Override
	public int insertBoardSContent(SqlSession session, BoardProductSaleContent bp) {
		// TODO Auto-generated method stub
		return session.insert("insertBoardSContent",bp);
	}
	//파일등록 맵핑값에 주의하자 
	@Override
	public int insertAttachment(SqlSession session, Attachement a) {
		// TODO Auto-generated method stub
		return session.insert("insertAttachement",a);
	}
}
