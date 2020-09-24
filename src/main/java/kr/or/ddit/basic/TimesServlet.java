package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimesServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("text/html; charset=utf-8");
		
		// writer 객체를 통해  html 문서를 작성해준다.
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("	<head>");
		writer.println("	<body>");
		writer.println("	</head>");
		
		writer.println("	<table border='1'>");
		
		for (int i = 1; i < 10; i++) {
			writer.println("		<tr>");
			for (int j = 2; j < 10; j++) {
			writer.println("		<td>");
			writer.println(j+"*"+i+"="+i*j);
			writer.println("		</td>");
			}
			writer.println("		</tr>");
		}
		writer.println("	</table>");
		writer.println("	</body>");
		writer.println("</html>");
		writer.flush();
		writer.close(); // 알아서 닫아줘서 굳이 안해줘도 돼
	}

}
