package kr.or.ddit.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.model.JobVo;
import kr.or.ddit.member.service.JobService;
import kr.or.ddit.member.service.JobServiceI;

/**
 * Servlet implementation class JobServlet
 */
@WebServlet("/jobServlet")
public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JobServiceI service = new JobService();
		
		List<JobVo> list = service.selectAllJob();
		
		request.setAttribute("jobList", list);
		
		request.getRequestDispatcher("/jsp/job.jsp").forward(request, response);
		
	}

}
