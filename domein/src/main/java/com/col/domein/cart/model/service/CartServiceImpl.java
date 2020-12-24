package com.col.domein.cart.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.cart.model.dao.CartDao;
import com.col.domein.cart.model.vo.Cart;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao dao;
	@Autowired
	private SqlSession session;
	

	@Override
	public int insertProductCart(Cart c) {
		int result=dao.insertProductCart(session,c);
		return result;
	}

}
