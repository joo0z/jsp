package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest {
	
	/*
	 테스트 메소드 실행 순서 
	 	@Before (static)
	 	@Before => @Test => @After
	 	@Before => @Test => @After
	 	@Before => @Test => @After
	 	@After (static)
	 */
	MemberDaoI memberDao;
	
	@Before
	public void setup() {
		memberDao = new MemberDao();
		String userid = "jyp";
		memberDao.deleteMember(userid);
	}

	@Test
	public void getMemberTest() {
	
		/*** Given ***/
		memberDao = new MemberDao();
		String userId = "brown";
		
		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");
		
		/*** When ***/
 		MemberVo memberVo = memberDao.getMember(userId);
		
 		/*** Then ***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());
 		
// 		assertEquals(answerMemberVo, memberVo);
		
	}
	
	@Test
	public void selectAllMemberTest() {
		/*** Given ***/
		memberDao = new MemberDao();
		
		/*** When ***/
		List<MemberVo> list = memberDao.selectAllMember();

		/*** Then ***/
		
		assertNotNull(list);
	}

	@Test
	public void selectMemberPageListTest() {
		/*** Given ***/
		memberDao = new MemberDao();
		PageVo pv = new PageVo(1,7);
		SqlSession sqlSession = MybatisUtil.getSqlSession();
//		int page = 1;
//		int pageSize = 3;
//		pv.setPage(page);
//		pv.setPageSize(pageSize);
		
		/*** When ***/
		List<MemberVo> list = memberDao.selectMemberPageList(sqlSession, pv);
		
		/*** Then ***/
		assertEquals(7, list.size());
		assertNotNull(list);
	}
	
	@Test
	public void selectMemberTotalCntTest() {
		/*** Given ***/
		memberDao = new MemberDao();
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		/*** When ***/
		int cnt = memberDao.selectMemberTotalCnt(sqlSession);
		
		/*** Then ***/
		// 15개가 맞는지 확인
		assertEquals(15, cnt);
		
	}
	
	@Test
	public void insertMemberDaoTest() {
		// 이미 등록한 데이터는 안들어가서 오류나는게 맞다. => pk값이 중복될 수 없기때문 (unique constraint (JYP.PK_USER) violated)
		/*** Given ***/
		memberDao = new MemberDao();
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		/*** When ***/
		MemberVo memberVo = new MemberVo("jyp",  "pass",  "박주영",  "주영",  "대전 중구 중앙로 76", "영민빌딩 404호",  
				"34904", "D:\\profile\\ryan.png",  "ryan.png");
		int cnt = memberDao.insertMember(memberVo);
		
		/*** Then ***/
		assertEquals(1, cnt);
	}
	

}
