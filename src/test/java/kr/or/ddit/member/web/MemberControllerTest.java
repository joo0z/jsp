package kr.or.ddit.member.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
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
	public void memberRegistTest() throws Exception {
		
	}
	@Test
	public void memberUpdateTest() throws Exception {
		
	}
	@Test
	public void uploadTest() throws Exception {
		
	}
	
}