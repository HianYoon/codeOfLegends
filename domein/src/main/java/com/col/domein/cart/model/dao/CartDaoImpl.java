package com.col.domein.cart.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
	//멤버cart 상품 불러오기
	@Override
	public List<Map> selectProductCart(SqlSession session, int productNo) {
		// TODO Auto-generated method stub
		return session.selectList("cart.selectProductCart",productNo);
	}
	//중복상품 체크
	@Override
	public int checkProductNo(SqlSession session, int pNo, int mNo) {
		Map<String, Object> map=new TreeMap<String, Object>();
		map.put("productNo",pNo);//pNo키와 value값을 넣어준다.
		map.put("memberKey",mNo );
		
		return session.selectOne("cart.checkProductNo",map);
	}
	
	//기존상품이 있으면 갯수만 업데이트
	@Override
	public int updateCartProductAmount(SqlSession session, Cart c) {
		// TODO Auto-generated method stub
		return session.update("cart.updateCartProductAmount",c) ;
	}
	//member cartList불러오기
	@Override
	public List<Map> selectCartList(SqlSession session, int memberKey) {
		// TODO Auto-generated method stub
		return session.selectList("cart.selectCartList",memberKey);
	}
	//cart 상품 삭제
	@Override
	public int deleteCartList(SqlSession session, int memberKey,int productNo) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new TreeMap<String, Object>();
		map.put("memberKey",memberKey);
		map.put("productNo",productNo);
		return session.delete("cart.deleteCartList",map);
	}
	//상품 수량 더하기
	@Override
	public int addToAmount(SqlSession session, int productNo,int amount,int memberKey) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new TreeMap<String, Object>();
		map.put("productNo",productNo);
		map.put("amount",amount);
		map.put("memberKey", memberKey);
		return session.update("cart.addToAmount",map);
	}
	//상품 수량 빼기
	@Override
	public int minusToAmount(SqlSession session, int productNo, int amount, int memberKey) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new TreeMap<String, Object>();
		map.put("productNo",productNo);
		map.put("amount",amount);
		map.put("memberKey", memberKey);
		return session.update("cart.minusToAmount",map);
	}

}
