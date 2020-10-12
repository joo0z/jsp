package kr.or.ddit.db;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisUtilTest {

	@Test
	public void getSqlSessionTest() {
		/*** Given ***/
		// static이라 바로 불러올 수 있어서 생략한다.
		/*** When ***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		/*** Then ***/
		assertNotNull(sqlSession);
		
	}

}
