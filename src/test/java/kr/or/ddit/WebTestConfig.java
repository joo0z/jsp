package kr.or.ddit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/root-context.xml",
									"classpath:kr/or/ddit/config/spring/application-context.xml"})
@WebAppConfiguration	// 스프링 컨테이너를 웹기반에서 동작하는 컨테이너로 생성하는 옵션(@Controller, @Repository 을 썼기 때문에)
public class WebTestConfig {

	// 테스트 대상 클래스 : LoginController (Spring Bean을 만들기 위해서는 아래 Spring Bean이 있어야 한다는
	// 뜻)
	// ==> MemberService
	// ==> MemberRepository
	// LoginController 스프링빈을 생성하기 위해서는 MemberService, MemberRepository(Dao) 스프링 빈이
	// 필요
	// 즉 service, repository 빈을 스캔하는 설정과 controller를 스켄하는 설정 두개가 필요

	/*
	 * 스프링프레임워크의 컨트롤러 테스트 시나리오 1. 웹기반의 스프링 컨테이너를 구성 2. dispatcherServlet역할을 하는객체 생성
	 * 3. dispatcherServlet역할을 하는 객체를 통해 url, 파라미터등을 첨부하여 요청 전송 4. 응답이 원하는 형태로 나오는지
	 * 체크(viewName, model에 담긴 속성)
	 */

	@Autowired // 동일한 타입의 spring 빈을 자동으로 찾아준다.
	protected WebApplicationContext context;

	protected MockMvc mockMvc; // dispacher servlet 역할을 하는 객체

	/*
	 * @Before(setup) => @Test => @After(tearDown)
	 */
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	// get(), post() : get,post 요청
	// param(파라미터명, 파라미터값) : 요청시 보낼 파라미터

	// status() : 스프링 프레임워크에 의해 요청이 처리되고 생성된 응답 코드
	// view() : 스프링 프레임워크에 의해 요청이 처리되는 과정에서 반환된 viewName
	// model(); 컨트롤러에서 설정한 속성값을 담는 객체
	// request() : 요청 객체
	
	
	@Test
	public void test() {
	
	}

}