package com.newtouch.annotatitontest;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.newtouch.domain.User;
import com.newtouch.mapping.UserMapperI;
import com.newtouch.utils.MyBatisUtil;

public class TestCURDAnnoMapper {

	@Test
	public void testAdd() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);

		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);

		User user = new User();
		user.setName("ʷ�ƽ�");
		user.setAge(24);

		int add = mapper.add(user);
		MyBatisUtil.closeSession(sqlSession);

		System.out.println(add);
	}

	@Test
	public void testUpdate() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		// �õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		User user = new User();
		user.setId(3);
		user.setName("�°�����_xdp");
		user.setAge(26);
		// ִ���޸Ĳ���
		int retResult = mapper.update(user);
		// ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
		sqlSession.close();
		System.out.println(retResult);
	}

	@Test
	public void testDelete() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		// �õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		// ִ��ɾ������
		int retResult = mapper.deleteById(7);
		// ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
		sqlSession.close();
		System.out.println(retResult);
	}

	@Test
	public void testGetUser() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		// �õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		// ִ�в�ѯ����������ѯ����Զ���װ��User����
		User user = mapper.getById(1);
		// ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
		sqlSession.close();
		System.out.println(user);
	}

	@Test
	public void testGetAll() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		// �õ�UserMapperI�ӿڵ�ʵ�������UserMapperI�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬��������
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		// ִ�в�ѯ����������ѯ����Զ���װ��List<User>����
		List<User> lstUsers = mapper.getAll();
		// ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
		sqlSession.close();
		System.out.println(lstUsers);
	}

}
