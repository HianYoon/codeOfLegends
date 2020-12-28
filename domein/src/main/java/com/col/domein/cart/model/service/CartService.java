package com.col.domein.cart.model.service;

import java.util.List;
import java.util.Map;

import com.col.domein.cart.model.vo.Cart;
import com.col.domein.product.model.vo.ProductAll;

public interface CartService {
	//상품 list
	int insertProductCart(Cart c);
	
	//비회원 장바구니 상품 가져오기
	List<Map> selectCartOne(int productNo);
	//memberCart
	int insertMemberCart(Cart c);
	//memberCart상품 불러오기
	List<Map> selectProductCart(int productNo);
	//중복 상품 체크
	int checkProductNo(int pNo, int mNo);
	//상품이 있으면 갯수를 업데이트
	int updateCartProductAmount(Cart c);
	//member cartList
	List<Map> selectCartList(int memberKey);

	int deleteCartOne(int memberKey);

}
