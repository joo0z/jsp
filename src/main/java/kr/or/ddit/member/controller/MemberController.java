package kr.or.ddit.member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberServiceI;

@RequestMapping("/member")
@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Resource(name = "memberService")
	private MemberServiceI memberService;
	
	@RequestMapping("/memberList")
	public String list(@RequestParam(name="page", required = false, defaultValue = "1") int page,
						@RequestParam(name="pageSize", required = false, defaultValue = "7") int pageSize,
						Model model) {
		
		logger.debug("page, pageSize : {}, pageSize : {}", page, pageSize);
		// page
		model.addAttribute("page", page);
		// pageSize
		model.addAttribute("pageSize", pageSize);

		PageVo pageVo = new PageVo(page, pageSize);
//		pageVo.setPage(page);
//		pageVo.setPageSize(pageSize);

		Map<String, Object> map = memberService.selectMemberPageList(pageVo);
		model.addAttribute("memberList", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));

//		return "member/memberList";
//		return "tiles.memberList";
		return "tiles/member/memberListContent";
	}
	
	@RequestMapping("/member")
	public String member(@RequestParam(name="userid") String userid,
						 Model model) {
		MemberVo memberVo = memberService.getMember(userid);
		model.addAttribute("memberVo", memberVo);
//		return "member/member";
		return "tiles/member/memberContent";
	}
	
	// 파일 다운로드
	@RequestMapping("/profileDownload")
	public void upload(String userid, HttpServletResponse response) throws Exception {
		logger.debug("userid : {}", userid);
		
		MemberVo memberVo = memberService.getMember(userid);
		response.setHeader("Content-Disposition", "attachment; filename=\"" + memberVo.getRealfilename() + "\"");
	    response.setContentType("application/octet-stream");
		FileInputStream fis = new FileInputStream(memberVo.getFilename());
		ServletOutputStream sos = response.getOutputStream();
		byte[] buffer = new byte[512];
		while ( fis.read(buffer) != -1) {
			sos.write(buffer);
		}
		
		fis.close();
		// 응답이 가지 않은게 있으면 보내고 닫아라
		sos.flush();
		sos.close();
	}
	
	// 회원 등록
	@RequestMapping("/Regist")
	public String memberRegist() {
//		return "member/memberRegist"; // /WEB-INF/views/multi/view/
		return "tiles/member/memberRegistContent";
	}
	
	@RequestMapping("/regist")
	public String memberRegist(MemberVo memberVo, @RequestPart("file") MultipartFile file) {
		
		String realfilename = file.getOriginalFilename();
		String filename = "D:\\upload\\" + realfilename;
		logger.debug("realfilename : {}", realfilename);
		
		File uploadFile = new File("D:\\upload\\" + file.getOriginalFilename());
		try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		memberVo.setRealfilename(realfilename);
		memberVo.setFilename(filename);
		
		int cnt = memberService.insertMember(memberVo);
		logger.debug("insertCnt : {}", cnt);
		
		if (cnt == 1) {
			return "redirect:/member/memberList";
		}else {
			return "tiles/member/memberRegistContent";
		}
	}
	
	// 회원 수정
	@RequestMapping("/updateView")
	public String memberUpdateView() {
		return "tiles/member/memberUpdateContent"; // /WEB-INF/views/multi/view/
	}
	
	@RequestMapping("/memberUpdate")
	public String memberUpdate(MemberVo memberVo, @RequestPart("file") MultipartFile file) {

		String realfilename = file.getOriginalFilename();
		String filename = "D:\\upload\\" + realfilename;
		logger.debug("realfilename : {}", realfilename);
		
		File uploadFile = new File("D:\\upload\\" + file.getOriginalFilename());
		try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		memberVo.setRealfilename(realfilename);
		memberVo.setFilename(filename);
		
		int cnt = memberService.updateMember(memberVo);
		logger.debug("updateCnt : {}", cnt);
		
		return "redirect:/member/memberList";
	}
	
	@RequestMapping("listAjaxPage")
	public String listAjaxPage() {
		return "tiles/member/listAjaxPage";
	}
	
	// 페이지 요청(/list와 다르게 page, pageSize 파라미터가 반드시 존재한다는 가정으로 작성)
	@RequestMapping("/listAjax")
	public String listAjax(PageVo pageVo, Model model) {
		logger.debug("pageVo : {}", pageVo);
		
		Map<String, Object> map = memberService.selectMemberPageList(pageVo);
		model.addAttribute("memberList", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));
		
		return "jsonView";
	}
	
	// 페이지 요청(/list와 다르게 page, pageSize 파라미터가 반드시 존재한다는 가정으로 작성)
	@RequestMapping("/listAjaxHTML")
	public String listAjaxHTML(PageVo pageVo, Model model) {
		logger.debug("pageVo : {}", pageVo);
		
		Map<String, Object> map = memberService.selectMemberPageList(pageVo);
		model.addAttribute("memberList", map.get("memberList"));
		model.addAttribute("pages", map.get("pages"));
		
		
		// 응답 html ==> jsp로 생성
		return "member/listAjaxHTML";
	}
	
	@RequestMapping("/memberContentAjax")
	public String memberContentAjax() {
		return "tiles/member/memberContentAjax";
	}
	
	@RequestMapping("/memberAjax")
	public String memberAjax(String userid,	 Model model) {
		MemberVo memberVo = memberService.getMember(userid);
		model.addAttribute("memberVo", memberVo);
		// 응답 html ==> jsp로 생성
		return "jsonView";
		// model 객체를 jsonView로 만들어 준다.
	}
	
	
}
