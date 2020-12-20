package com.col.domein.cart.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.col.domein.cart.model.vo.Cart;

public interface CartDao {

	int insertProductCart(SqlSession session, Cart c);

}
