package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.model.MemberVo;

public class MemberServiceTest extends ModelTestConfig{
	
	@Resource(name = "memberService")
	private MemberServiceI memberService;

	@Test
	public void insertMember_SUCCESS_Test() {
		/*** Given ***/
		MemberVo memberVo = new MemberVo("temp", "pass", "FAILTEST", "우롱차","","","","","");
		
		/*** When ***/
		int insertCnt = memberService.insertMember(memberVo);

		/*** Then ***/
		assertEquals(1, insertCnt);
	}

//	@Test
//	public void insertMember_FAIL_Test() {
//		/*** Given ***/
//		MemberVo memberVo = new MemberVo("스누피", "pass", "FAILTEST", "우롱차","","","","","");
//		
//		/*** When ***/
//		int insertCnt = memberService.insertMember(memberVo);
//		
//		/*** Then ***/
//		assertEquals(1, insertCnt);
//	}
	
	@Test
	public void selectAllMemberTest() {
		/*** Given ***/
		
		/*** When ***/
		List<MemberVo> memberList = memberService.selectAllMember();

		/*** Then ***/
		assertEquals(memberList.size(), 21);
		
	}
	
	@Test
	public void selectMemberPageListTest() {
		/*** Given ***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(5);
		
		/*** When ***/
		Map<String, Object> map = memberService.selectMemberPageList(pageVo);
		
		/*** Then ***/
		assertEquals(map.get("pages"), 5);
		assertEquals(((List<MemberVo>)map.get("memberList")).size(), 5);
		
	}
	
	@Test
	public void selectMemberTotalCntTest() {
		/*** Given ***/
		
		/*** When ***/
		int total = memberService.selectMemberTotalCnt();

		/*** Then ***/
		assertEquals(total, 21);

	}
	
	@Test
	public void deleteMemberTest() {
		/*** Given ***/
		String userid = "brown";
		
		/*** When ***/
		int deleteCnt = memberService.deleteMember(userid);
		
		/*** Then ***/
		assertEquals(deleteCnt, 1);
		
		
	}
	
	@Test
	public void updateMemberTest() {
		/*** Given ***/
		MemberVo memberVo = new MemberVo("brown", "pass", "", "", "", "", "", "", "");
		
		/*** When ***/
		int updateCnt = memberService.updateMember(memberVo);
		
		/*** Then ***/
		assertEquals(updateCnt, 1);
	}
	
	@Test
	public void getMemberTest() {
		/*** Given ***/
		String userid = "brown";
		
		/*** When ***/
		MemberVo memberVo = memberService.getMember(userid);
		
		/*** Then ***/
		assertEquals(memberVo.getUserid(), "brown");
	}
	
	
	
	

}
