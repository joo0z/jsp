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

@WebServlet("/memberUpdate")
@MultipartConfig
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(MemberRegistServlet.class);
	private MemberServiceI memberService;
	private MemberVo memberVo;
    @Override
    public void init() throws ServletException {
    	memberService = new MemberService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/memberupdate.jsp").forward(request, response);
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		logger.debug("userid : {}", userid);
		String usernm = request.getParameter("usernm");
		String alias = request.getParameter("alias");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");

		logger.debug("parameter : {}, {}, {}, {}, {}, {}, {}", userid, usernm, alias, pass, addr1, addr2, zipcode);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		logger.debug("userid : {}", userid);
		String usernm = request.getParameter("usernm");
		String alias = request.getParameter("alias");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		
		logger.debug("parameter : {}, {}, {}, {}, {}, {}, {}", userid, usernm, alias, pass, addr1, addr2, zipcode);
		
		Part profile = request.getPart("realfilename");
		logger.debug("file : {}", profile.getHeader("Content-Disposition"));
		
		String realfilename = "";
		String filename = "";
		String filePath = "";
		
		memberVo = memberService.getMember(userid);
		if (filePath == null || filePath.equals("")) {
			filename = memberVo.getFilename();
			realfilename = memberVo.getRealfilename();
		}
		if (profile.getSize() > 0) {
			String extension = FileUploadUtil.getExtension(realfilename);
			logger.debug("extension : {}", extension);
			realfilename = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
			filename = "D:\\profile\\" + UUID.randomUUID().toString() + "." + extension;
			profile.write(filename);
		}
		
		logger.debug("realfilename : {}", realfilename);
		logger.debug("filename : {}", filename);
		logger.debug("filePath : {}", filePath);
		
		memberVo.setUserid(userid);
		memberVo.setUsernm(usernm);
		memberVo.setAlias(alias);;
		memberVo.setPass(pass);
		memberVo.setAddr1(addr1);
		memberVo.setAddr2(addr2);
		memberVo.setZipcode(zipcode);
		memberVo.setFilename(filename);
		memberVo.setRealfilename(realfilename);
		int cnt = memberService.updateMember(memberVo);
		if (cnt == 1) {
			response.sendRedirect(request.getContextPath() + "/member?userid="+userid);
		}else {
			doGet(request, response);
		}
		
	}

}
