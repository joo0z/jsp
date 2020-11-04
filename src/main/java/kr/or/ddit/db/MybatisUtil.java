package kr.or.ddit.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	// 클래스가 로딩될 때 가장먼저 실행되는 부분
	// static 블럭을 통해 클래스가 로딩되면 mybatis 환경을 구성한다.
	// ==> sqlSessionFactory 객체를 생성
	
	static {
		String resource = "kr/or/ddit/config/db/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// sqlSessionFactory 객체를 통해 sqlSession객체를 얻어내는 메소드 
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
}
