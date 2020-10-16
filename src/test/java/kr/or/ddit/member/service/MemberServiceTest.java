package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.model.MemberVo;

public class MemberServiceTest {

	@Test
	public void getMemberTest() {
	
		/*** Given ***/
		MemberServiceI memberService = new MemberService();
		String userId = "brown";
		
		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");
		
		/*** When ***/
 		MemberVo memberVo = memberService.getMember(userId);
		
 		/*** Then ***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());
 		
 		//assertEquals(answerMemberVo, memberVo);
	}
	
	@Test
	public void pageMemberTest() {
		/*** Given ***/
		MemberServiceI memberService = new MemberService();
		PageVo pv = new PageVo(1,7);
		
		/*** When ***/
		Map<String, Object> map = memberService.selectMemberPageList(pv);
		List<MemberVo> list = (List<MemberVo>)map.get("memberList");

		// 생성해야할 페이지 수
		int pages = (int)map.get("pages");
		/*** Then ***/
		assertEquals(7,  list.size());
		assertEquals(3, pages);
		
	}
	
	
}
