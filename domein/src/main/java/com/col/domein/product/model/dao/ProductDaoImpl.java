package com.col.domein.product.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.col.domein.product.model.vo.Attachement;
import com.col.domein.product.model.vo.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	//상품등록
	@Override
	public int insertProduct(SqlSession session, Product product) {
		// TODO Auto-generated method stub
		System.out.println("여기냐?"+product);
		return session.insert("insertProduct",product);
	}
	//상품등록후  번호를 받아서 다중파일 등록
	@Override
	public int insertAttachment(SqlSession session, Attachement a) {
		// TODO Auto-generated method stub
		System.out.println(""+a);
		return session.insert("insertAttachement",a);
	}

	
	

}
