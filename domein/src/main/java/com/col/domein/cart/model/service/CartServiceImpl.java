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

	//비회원 
	@Override
	public List<Map> selectCartOne(int productNo) {
		// TODO Auto-generated method stub
		return dao.selectCartOne(session,productNo);
	}

	//membercart
	@Override
	public int insertMemberCart(Cart c) {
		// TODO Auto-generated method stub
		return dao.insertMemberCart(session,c);
	}

	//membercart 상품불러오기
	@Override
	public List<Map> selectProductCart(int productNo) {
		// TODO Auto-generated method stub
		return dao.selectProductCart(session,productNo);
	}

	//장바구니 기존 상품 체크
	@Override
	public int checkProductNo(int pNo, int mNo) {
		// TODO Auto-generated method stub
		return dao.checkProductNo(session,pNo,mNo);
	}

	//상품이 잇으면 갯수를 업데이트
	@Override
	public int updateCartProductAmount(Cart c) {
		// TODO Auto-generated method stub
		return dao.updateCartProductAmount(session,c);
	}

	//member cartList불러오기
	@Override
	public List<Map> selectCartList(int memberKey) {
		// TODO Auto-generated method stub
		return dao.selectCartList(session,memberKey);
	}

	//cart 상품삭제
	@Override
	public int deleteCartOne(int memberKey) {
		// TODO Auto-generated method stub
		return dao.deleteCartList(session,memberKey);
	}

	//상품 수량 업데이트
	@Override
	public int addToAmount(int amount, int productNo) {
		// TODO Auto-generated method stub
		return dao.addToAmount(session,productNo, amount);
	}

}
