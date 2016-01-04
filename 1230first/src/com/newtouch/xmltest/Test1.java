package com.newtouch.xmltest;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.newtouch.domain.User;

public class Test1 {
	
	public static void main(String[] args) {
		
		//mybatis�������ļ�
		String resource = "conf.xml";
		
		/**
		 	ʹ��MyBatis�ṩ��Resources�����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
        	Reader reader = Resources.getResourceAsReader(resource); 
        	����sqlSession�Ĺ���
        	SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		 */
		
		
		//ʹ�������������mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
		InputStream is = Test1.class.getClassLoader().getResourceAsStream(resource);
		
		//����sqlSession�Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		
		//������ִ��ӳ���ļ���sql��sqlSession
		SqlSession session = sessionFactory.openSession();
		
		 /**
         * ӳ��sql�ı�ʶ�ַ�����
         * com.newtouch.mapping.userMapper��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
         * getUser��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
         */
		String statement = "com.newtouch.mapping.userMapper.getUser";
		
		User user = session.selectOne(statement, 2);
		
		System.out.println(user);
	}
}
