package kr.or.ddit.mvc.fileupload.web;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.member.service.MemberServiceI;

@RequestMapping("/fileupload")
@Controller
public class FileUploadController {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	/* 
	   localhost/fileupload/view 요청시 화면 요청 처리 메서드
	   jsp 에서는 파일을 선택할 수 있는 input태그 1개 
	   userid 파라미터를 보낼 수 있는 input태그 1개
	   전송을 담당하는 submit input태그 1개 작성
	   jsp : /WEB-INF/views/fileupload/fileupload.jsp
	   테스트코드
	*/
	
	@RequestMapping(path="/view")
	public String fileUpload(String userid) {
		logger.debug("userid : {}", userid);
		return "fileupload/fileupload";
	}
	
	// 파일 업로드 처리 메서드
	@RequestMapping(path="upload")
	public String upload(String userid, @RequestPart("file") MultipartFile file) {
		logger.debug("userid : {}", userid);
		logger.debug("name : {} / filename : {} / size : {}",file.getOriginalFilename(), file.getName(), file.getSize());
		
		File uploadFile = new File("D:\\upload\\" + file.getOriginalFilename());
		try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return "fileupload/fileupload";
	}
	
	

}
