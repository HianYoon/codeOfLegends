package com.col.domein.cart.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	//비회원 상품조회
	@Override
	public List<Map> selectCartOne(SqlSession session, int productNo) {
		// TODO Auto-generated method stub
		return session.selectList("cart.selectCartOne",productNo);
	}
	//멤버cart
	@Override
	public int insertMemberCart(SqlSession session, Cart c) {
		// TODO Auto-generated method stub
		return session.insert("cart.insertMemberCart",c);
	}

}
