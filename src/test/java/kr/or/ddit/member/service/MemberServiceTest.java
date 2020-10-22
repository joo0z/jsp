package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.model.MemberVo;

public class MemberServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);
	MemberServiceI memberService;
	
	@Before
	public void setup() {
		memberService = new MemberService();
		String userid = "jyp";
		memberService.deleteMember(userid);
	}
	
	@Test
	public void getMemberTest() {
	
		/*** Given ***/
		memberService = new MemberService();
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
		memberService = new MemberService();
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
	
	@Test
	public void localListTest() {
		
		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		for(Locale locale : locales) {
			logger.debug("{}",locale);
			logger.debug(locale.toString());
		}
	}
	
	@Test
	public void insertMemberServiceTest() {
		/*** Given ***/
		memberService = new MemberService();
		
		/*** When ***/
		MemberVo memberVo = new MemberVo("jyp",  "pass",  "박주영",  "주영",  "대전 중구 중앙로 76", "영민빌딩 404호",  
				"34904", "D:\\profile\\ryan.png",  "ryan.png");
		int cnt = memberService.insertMember(memberVo);

		/*** Then ***/
		assertEquals(1, cnt);
	}
	
	@Test 
	public void deleteMemberService() {
		/*** Given ***/
		memberService = new MemberService();
		
		/*** When ***/
		String userid = "jyp";
		int cnt = memberService.deleteMember(userid);

		/*** Then ***/
		assertEquals(1, cnt);
	}
	
}
