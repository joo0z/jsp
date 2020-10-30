package kr.or.ddit.db;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionPoolServlet extends HttpServlet{

	private static final Logger logger = LoggerFactory.getLogger(ConnectionPoolServlet.class);
	
	@Override
	public void init() throws ServletException {
		
		logger.debug("ConnectionPoolServlet init() 초기화 확인");
		// ConnectionPoolServlet 초기화 될때 커넥션 풀을 생성해서
		// application 영역에 저장
		// 다른 jsp, servlet에서는 application영역을 통해 컨넥션 풀을 접근
		
		// 컨넥션 pool생성
		BasicDataSource db = new BasicDataSource();
		db.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		db.setUrl("jdbc:oracle:thin:@localhost:1521/xe");
		db.setUsername("spring");
		db.setPassword("java");
		// 저장 공간
		db.setInitialSize(20);
		
		// 어플리케이션 객체
		ServletContext sc = getServletContext();
		sc.setAttribute("db", db);
		
	}
}
