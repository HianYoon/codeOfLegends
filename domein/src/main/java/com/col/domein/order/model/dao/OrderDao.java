package com.col.domein.order.model.dao;

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
}
