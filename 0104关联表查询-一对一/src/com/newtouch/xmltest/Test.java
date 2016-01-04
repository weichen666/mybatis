package com.newtouch.xmltest;

import org.apache.ibatis.session.SqlSession;

import com.newtouch.domain.Classes;
import com.newtouch.utils.MyBatisUtil;

public class Test {

	@org.junit.Test
	public void testGetClass()
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		String statement = "com.newtouch.mapping.classMapper.getClass";
		
		Classes clazz = sqlSession.selectOne(statement, 1);
		
		MyBatisUtil.closeSession(sqlSession);
		
		System.out.println(clazz);
	}
	
	@org.junit.Test
	public void testGetClass2()
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		String statement = "com.newtouch.mapping.classMapper.getClass2";
		
		Classes clazz = sqlSession.selectOne(statement, 2);
		
		MyBatisUtil.closeSession(sqlSession);
		
		System.out.println(clazz);
	}
	
}
