package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.fileupload.FileUploadUtil;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

@WebServlet("/regist")
@MultipartConfig
public class MemberRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(MemberRegistServlet.class);
	private MemberServiceI memberService;
    @Override
    public void init() throws ServletException {
    	memberService = new MemberService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/memberRegist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String usernm = request.getParameter("usernm");
		String alias = request.getParameter("alias");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");

		logger.debug("parameter : {}, {}, {}, {}, {}, {}, {}", userid, usernm, alias, pass, addr1, addr2, zipcode);

		Part profile = request.getPart("realfilename");
		logger.debug("file : {}", profile.getHeader("Content-Disposition"));
//		String fileName = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
		// 중복되지 않는 값을 만들어주는 
		String realfilename = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
		String filename = UUID.randomUUID().toString();
		String filePath = "";
		String extension = FileUploadUtil.getExtension(realfilename);
		
		if (profile.getSize() > 0) {
			filePath = "D:\\profile\\" + filename + "." + extension;
			profile.write(filePath);
		}
		
		// 사용자 정보 등록
		MemberVo memberVo = new MemberVo( userid,  pass,  usernm,  alias,  addr1,  addr2,  zipcode,
				filePath,  realfilename);
		
		int cnt = memberService.insertMember(memberVo);
		
		if (cnt == 1) {
			// 서버쪽 상태가 바뀌는 경우 sendRedirect요청 forword X
			// contextPath 입력해줘야 한다.
			response.sendRedirect(request.getContextPath() + "/memberList");
		}else {
			// 회원등록 실패
			doGet(request, response);
		}
		
	}

}
