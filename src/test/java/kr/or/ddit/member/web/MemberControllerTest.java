package kr.or.ddit.member.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

import kr.or.ddit.WebTestConfig;

public class MemberControllerTest extends WebTestConfig{

	@Test
	public void memberListTest() throws Exception {
		mockMvc.perform(get("/member/memberList"))
				.andExpect(view().name("member/memberList"))
				.andExpect(status().isOk());
	}

}
