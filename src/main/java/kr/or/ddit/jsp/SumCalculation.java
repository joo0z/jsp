package kr.or.ddit.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class SumCalculation
 */
@WebServlet("/sumCalculation")
public class SumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory.getLogger(SumCalculation.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/sumInput.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int startVal = Integer.parseInt(request.getParameter("start"));
		int endVal = Integer.parseInt(request.getParameter("end"));
		
		int sumResult = 0;
		for (int i = startVal; i <= endVal; i++) {
			sumResult += i;
		}
		
		logger.debug(""+sumResult);
		
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", sumResult);
		
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
		
	}

}
