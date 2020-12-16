/*
	mybatis�� config.xml�� xml �ϻ� ���� �������� �ڹ� ���ø����̼ǰ��� ������� �����̴�
	���� �ڹ��ڵ忡�� config.xml�� �о�鿩�� �Ѵ�
	���� ��ǥ : xml�� �о�鿩�� ���� �������� �������ִ� ��ü�� SqlSession�� ��� ����
	�� Ŭ������ Ư�� new �Ҷ� ���� �ν��Ͻ��� ������ ���̰�, 
	�׷��� �Ǹ� SqlSessionFactory�� �ټ��� �޸𸮿� �ö���Ƿ�, �޸� ������ �ɰ���
	���� SingleTon���� ��������!
*/
package com.webapp1216.mybatis.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfigManager {
	String resource = "com/webapp1216/mybatis/config/config.xml";
	InputStream inputStream;
	SqlSessionFactory sqlSessionFactory;
	private static MybatisConfigManager instance;	//������ ������
	
	private MybatisConfigManager() {
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static MybatisConfigManager getInstance() {
		if(instance==null) {
			instance = new MybatisConfigManager();	//�ƹ��� private�̶� ���� �����ڴ� ���� ȣ�� ������
		}
		return instance;
	}
	
	//SqlSession�� ��ȯ�ϴ� �޼���
	public SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession;
	}
	
	public void close(SqlSession sqlSession) {
		if(sqlSession!=null) {
			sqlSession.close();			
		}
	}
}
