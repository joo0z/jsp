package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest {

	@Test
	public void getMemberTest() {
	
		/*** Given ***/
		MemberDao memberDao = new MemberDao();
		String userId = "brown";
		
		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");
		
		/*** When ***/
 		MemberVo memberVo = memberDao.getMember(userId);
		
 		/*** Then ***/
//		assertEquals("brown", memberVo.getUserId());
//		assertEquals("passBrown", memberVo.getPassword());
 		
 		assertEquals(answerMemberVo, memberVo);
		
	}
	
	@Test
	public void selectAllMemberTest() {
		/*** Given ***/
		MemberDaoI memberDao = new MemberDao();
		
		/*** When ***/
		List<MemberVo> list = memberDao.selectAllMember();

		/*** Then ***/
		
		assertNotNull(list);
	}

	@Test
	public void selectMemberPageListTest() {
		/*** Given ***/
		MemberDaoI memberDao = new MemberDao();
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
		MemberDaoI memberDao = new MemberDao();
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		/*** When ***/
		int cnt = memberDao.selectMemberTotalCnt(sqlSession);
		
		/*** Then ***/
		// 15개가 맞는지 확인
		assertEquals(15, cnt);
		
	}

}
