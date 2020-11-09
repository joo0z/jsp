package kr.or.ddit.member.web;

import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberServiceI;
import kr.or.ddit.mvc.view.ProfileImgView;

@Controller
public class ProfileController {
	
	@Resource(name = "memberService")
	private MemberServiceI memberService;
	
	@RequestMapping("/profileImgView")
	public String profileImgView(String userid, Model model) throws IOException {
		// 응답으로 생성하려고 하는 것 : 이미지 파일을 읽어서 output stream 객체에 쓰는것
		
		MemberVo memberVo = memberService.getMember(userid);
		model.addAttribute("filepath", memberVo.getFilename());
		
		return "profileImgView";
	}

	@RequestMapping("/profileDownloadView")
	public String profileDownloadView(String userid, Model model) throws IOException {
		// 응답으로 생성하려고 하는 것 : 이미지 파일을 읽어서 output stream 객체에 쓰는것
		MemberVo memberVo = memberService.getMember(userid);
		model.addAttribute("filepath", memberVo.getFilename());
		return "profileDownloadView";
	}
		
	@RequestMapping("/profileImg")
	public void profileImg(String userid, HttpServletResponse response) throws IOException {
		// response  content-type설정
		response.setContentType("image/png");
		
		// db에서 사용자 filename확인
		MemberVo memberVo = memberService.getMember(userid);
		
		// 경로 확인 후 파일 입출력을 통해 응답 생성
		// 파일 읽기
		// 응답 생성
		
		FileInputStream fis = new FileInputStream(memberVo.getFilename());
		ServletOutputStream sos = response.getOutputStream();
		
		// 이미지는 text가 아니고 바이너리 파일로 보내야한다.
		byte[] buffer = new byte[512];
		
		while ( fis.read(buffer) != -1) {
			sos.write(buffer);
		}
		
		fis.close();
		// 응답이 가지 않은게 있으면 보내고 닫아라
		sos.flush();
		sos.close();
	}

	
}
