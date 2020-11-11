package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.member.model.MemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/root-context.xml",
									"classpath:kr/or/ddit/config/spring/datasource-context.xml"})
public class MemberServiceTest extends ModelTestConfig{
	
	@Resource(name = "memberService")
	private MemberServiceI memberService;

	@Test
	public void insertMember_SUCCESS_Test() {
		/*** Given ***/
		MemberVo memberVo = new MemberVo("스누피", "pass", "FAILTEST", "우롱차","","","","","");
		
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

}
