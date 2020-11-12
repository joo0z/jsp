package kr.or.ddit.member.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.InputStream;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.WebTestConfig;

public class MemberControllerTest extends WebTestConfig{

	@Test
	public void memberListTest() throws Exception {
		mockMvc.perform(get("/member/memberList"))
				.andExpect(view().name("member/memberList"))
				.andExpect(status().isOk());
	}

	@Test
	public void memberTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/member/member").param("userid", "brown"))
								  .andExpect(status().isOk())
								  .andReturn();
		ModelAndView mav = result.getModelAndView();
		assertEquals("member/member", mav.getViewName());
	}
	
	@Test
	public void registViewTest() throws Exception {
		mockMvc.perform(get("/member/regist"))
				.andExpect(status().isOk());
	}

	
	@Test
	public void memberRegistTest() throws Exception {
		InputStream is =  getClass().getResourceAsStream("/kr/or/ddit/upload/selly.png");
	    MockMultipartFile file = new MockMultipartFile("realFilename2", "selly.png", "image/png", is);
	    mockMvc.perform(fileUpload("/member/regist")
	           .file(file)
	           .param("userid", "ddd")
	           .param("usernm", "브라운")
	           .param("alias", "별명")
	           .param("pass", "pass")
	           .param("addr1", "add")
	           .param("addr2", "add")
	           .param("zipcode", "123")
	          ).andExpect(status().is(302))
	           .andExpect(view().name("redirect:/member/list"));

	}
	@Test
	public void memberUpdateTest() throws Exception {
		
	}
	@Test
	public void uploadTest() throws Exception {
		
	}

}
