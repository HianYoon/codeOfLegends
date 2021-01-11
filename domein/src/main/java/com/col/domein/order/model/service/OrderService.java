package com.col.domein.order.model.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.col.domein.order.model.dao.OrderDao;
import com.col.domein.order.model.vo.Order;

@Service
public class OrderService {
	
	@Autowired
	private OrderDao od;
	
	@Autowired
	private SqlSession session;
	
	public int getCurrentOrderNoSequence() {
		return od.getCurrentOrderNoSequence(session);
	}
	
	public int insertOrder(Order order) {
		int orderNo = getCurrentOrderNoSequence();
		order.setOrderNo(orderNo);
		boolean flag = od.insertOrder(session, order);
		if(!flag) return -1;
		return orderNo;
	}
	public List<Map> selectCartProduct(int memberKey, int productNo) {
		// TODO Auto-generated method stub
		return od.selectCartProduct(session,memberKey,productNo);
	}
	
}
