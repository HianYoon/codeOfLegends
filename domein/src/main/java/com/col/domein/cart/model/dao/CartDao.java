package com.col.domein.cart.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.col.domein.cart.model.vo.Cart;
import com.col.domein.product.model.vo.ProductAll;

public interface CartDao {

	int insertProductCart(SqlSession session, Cart c);
	//비회원 상품 조회
	List<Cart> selectCartList(SqlSession session, int productNo);
	List<Map> selectCartOne(SqlSession session, int productNo);

}
