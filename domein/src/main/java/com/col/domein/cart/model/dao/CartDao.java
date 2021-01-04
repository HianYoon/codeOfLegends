package com.col.domein.cart.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.col.domein.cart.model.vo.Cart;
import com.col.domein.product.model.vo.ProductAll;

public interface CartDao {

	int insertProductCart(SqlSession session, Cart c);
	//비회원 상품 조회
	
	List<Map> selectCartOne(SqlSession session, int productNo);
	//멤버cart
	int insertMemberCart(SqlSession session, Cart c);
	//멤버cart 상품 불러오기
	List<Map> selectProductCart(SqlSession session, int productNo);
	//중복상품 체크
	int checkProductNo(SqlSession session, int pNo, int mNo);
	//기존상품에 amount더하기
	int updateCartProductAmount(SqlSession session, Cart c);
	//member cartList
	List<Map> selectCartList(SqlSession session, int memberKey);
	//cart 상품 삭제
	int deleteCartList(SqlSession session, int memberKey,int productNo);
	//상품 수량 업데이트
	int addToAmount(SqlSession session, int productNo,int amount, int memberKey);
	//상품 수량 minus업데이트 
	int minusToAmount(SqlSession session, int productNo, int amount, int memberKey);
	//비회원 상품 불러오기
	ProductAll selectNonproductList(SqlSession session, int productNo);

	

}
