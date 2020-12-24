package com.col.domein.cart.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.col.domein.cart.model.vo.Cart;

public interface CartService {
	//상품 list
	int insertProductCart(Cart c);
	
	//비회원 장바구니 상품 가져오기

	List<Cart> selectCartList(int productNo);

	List<Map> selectCartOne(int productNo);

}
