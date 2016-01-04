package com.newtouch.xmltest;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.newtouch.domain.User;
import com.newtouch.utils.MyBatisUtil;

public class TestCURDXmlMapper {
	
	public void testAdd(){
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		
		String statement = "com.newtouch.mapping.userMapper.addUser";
		
		User user = new User();
		user.setName("陈伟");
		user.setAge(25);
		
		int retResult = sqlSession.insert(statement, user);
		
		MyBatisUtil.closeSession(sqlSession);
	
		System.out.println(retResult);
	}
	
	public void testUpdate()
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSession(false);
	
		String statement = "com.newtouch.mapping.userMapper.updateUser";
		
		User user = new User();
		user.setId(3);
		user.setName("伟伟哥");
		user.setAge(27);
		
		int retResult = sqlSession.update(statement, user);
		
		//提交事务
		sqlSession.commit();
		
		MyBatisUtil.closeSession(sqlSession);
		
		System.out.println(retResult);
	}
	
	
	public void testDelete()
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		
		String statement = "com.newtouch.mapping.userMapper.deleteUser";
		
		int retResult = sqlSession.delete(statement, 4);
		
		MyBatisUtil.closeSession(sqlSession);
		
		System.out.println(retResult);
	}
	
	@Test
	public void testGetAll()
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		String statement = "com.newtouch.mapping.userMapper.getAllUsers";
		
		List<User> lstUsers = sqlSession.selectList(statement);
		
		MyBatisUtil.closeSession(sqlSession);
		
		System.out.println(lstUsers);
	}
}
