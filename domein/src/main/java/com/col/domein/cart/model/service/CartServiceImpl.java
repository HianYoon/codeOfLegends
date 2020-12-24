package com.col.domein.cart.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.cart.model.dao.CartDao;
import com.col.domein.cart.model.vo.Cart;
import com.col.domein.product.model.vo.ProductAll;

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


	//비회원 상품가져오기
	@Override
	public List<Cart> selectCartList(int productNo) {
		// TODO Auto-generated method stub
		return dao.selectCartList(session,productNo);
	}

	//비회원 
	@Override
	public List<Map> selectCartOne(int productNo) {
		// TODO Auto-generated method stub
		return dao.selectCartOne(session,productNo);
	}

}
