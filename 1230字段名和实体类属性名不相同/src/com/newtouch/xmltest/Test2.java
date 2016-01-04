package com.newtouch.xmltest;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.newtouch.domain.Order;
import com.newtouch.utils.MyBatisUtil;

public class Test2 {

	@Test
	public void testGetOrderById() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);

		String statemnet = "com.newtouch.mapping.orderMapper.getOrderById";

		Order order = sqlSession.selectOne(statemnet, 1);

		MyBatisUtil.closeSession(sqlSession);

		System.out.println(order); // null
	}

	@Test
	public void testGetOrderById2() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();

		String statement = "com.newtouch.mapping.orderMapper.getOrderById2";

		Order order = sqlSession.selectOne(statement, 1);

		MyBatisUtil.closeSession(sqlSession);

		System.out.println(order);
	}

	@Test
	public void testGetOrderById3() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();

		String statement = "com.newtouch.mapping.orderMapper.getOrderById3";

		Order order = sqlSession.selectOne(statement, 2);

		MyBatisUtil.closeSession(sqlSession);

		System.out.println(order);
	}
}
