package com.col.domein.order.model.dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.col.domein.order.model.vo.Order;

@Repository
public class OrderDao {

	public int getCurrentOrderNoSequence(SqlSession session) {
		return session.selectOne("order.getCurrentOrderNoSequence");
	}
	
	public boolean insertOrder(SqlSession session, Order order) {
		return session.insert("order.insertOrder", order) == 1;
	}
	//cart상품불러오기 
	public List<Map> selectCartProduct(SqlSession session, int memberKey, int productNo) {
		// TODO Auto-generated method stub
		TreeMap<String,Integer> map=new TreeMap<String,Integer>();
		map.put("memberKey",memberKey);
		map.put("productNo",productNo);
		return session.selectList("order.selectCartProduct",map);
	}
}
