package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

@WebServlet("/memberList")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberServiceI memberService;
	
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		List<MemberVo> list = memberService.selectAllMember();
//		request.setAttribute("memberList", list);
//		request.getRequestDispatcher("/member/memberList.jsp").forward(request, response);
//		int page = Integer.parseInt(request.getParameter("page"));
//		if (page == 0) {
//			page = 1;
//		}
		
		//page
		String page_str = request.getParameter("page");
		int page = page_str == null ? 1 : Integer.parseInt(page_str);
		request.setAttribute("page", page);
		
		// pageSize
		String pageSize_str = request.getParameter("pageSize");
		int pageSize = pageSize_str == null ? 7 : Integer.parseInt(pageSize_str);
		request.setAttribute("pageSize", pageSize);
		
		PageVo pageVo = new PageVo(page, pageSize);
//		pageVo.setPage(page);
//		pageVo.setPageSize(pageSize);
		
		Map<String, Object> map = memberService.selectMemberPageList(pageVo);
		request.setAttribute("memberList", map.get("memberList"));
		request.setAttribute("pages", map.get("pages"));
		
		request.getRequestDispatcher("/member/memberList.jsp").forward(request, response);
		
	}
	

}
