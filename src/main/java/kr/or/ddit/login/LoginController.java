package kr.or.ddit.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// @WebServlet 혹은 web.xml url-mapping을 통해 url 등록

@RequestMapping("/login")
@Controller
public class LoginController{
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	// localhost/login/view 요청시 처리되는 메서드
	@RequestMapping("/view.do") // 클래스에 등록된 url이 먼저 나오고 부모 url이 나온다.
	public String getView() {
		// view-name return
		logger.debug("LoginController.getView()");
		return "login/view";
	}

}
