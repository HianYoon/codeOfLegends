package com.col.domein.cart.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.col.domein.cart.model.vo.Cart;
@Repository
public class CartDaoImpl implements CartDao{

	//장바구니 상품(로그인시)
	@Override
	public int insertProductCart(SqlSession session, Cart c) {

		
		return session.insert("cart.insertProductCart",c);
	}

}
