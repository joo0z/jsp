package kr.or.ddit.member.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVo;

//repository + sercice : root-context.xml
//sqlSessionTemplate : datasource-context.xml
public class MemberDaoTest extends ModelTestConfig{

	@Resource(name = "memberDao")
	private MemberDaoI memberDao;
	
	@Test
	public void selectAllMemberTest() {
		/*** Given ***/
		
		/*** When ***/
		List<MemberVo> memberList = memberDao.selectAllMember();

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
		List<MemberVo> pageList = memberDao.selectMemberPageList(pageVo);
		
		/*** Then ***/
		assertEquals(pageList.size(), 5);
		
	}
	
	@Test
	public void selectMemberTotalCntTest() {
		/*** Given ***/
		
		/*** When ***/
		int total = memberDao.selectMemberTotalCnt();

		/*** Then ***/
		assertEquals(total, 21);

	}
	
	@Test
	public void insertMemberTest() {
		/*** Given ***/
		MemberVo memberVo = new MemberVo("test", "pass", "", "", "", "", "", "", "");
		
		/*** When ***/
		int insertCnt = memberDao.insertMember(memberVo);
		
		/*** Then ***/
		assertEquals(insertCnt, 1);
		
	}
	
	@Test
	public void deleteMemberTest() {
		/*** Given ***/
		String userid = "brown";
		
		/*** When ***/
		int deleteCnt = memberDao.deleteMember(userid);
		
		/*** Then ***/
		assertEquals(deleteCnt, 1);
		
		
	}
	
	@Test
	public void updateMemberTest() {
		/*** Given ***/
		MemberVo memberVo = new MemberVo("brown", "pass", "", "", "", "", "", "", "");
		
		/*** When ***/
		int updateCnt = memberDao.updateMember(memberVo);
		
		/*** Then ***/
		assertEquals(updateCnt, 1);
		
	}
	
	@Test
	public void getMemberTest() {
		/*** Given ***/
		String userid = "brown";
		
		/*** When ***/
		MemberVo memberVo = memberDao.getMember(userid);
		
		/*** Then ***/
		assertEquals(memberVo.getUserid(), "brown");
		
		
	}
	
	
	

}
