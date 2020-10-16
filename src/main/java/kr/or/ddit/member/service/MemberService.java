package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVo;

public class MemberService implements MemberServiceI {

	private MemberDaoI memberDao;
	
	public MemberService() {
		// 생성자에서 객체를 호출하면 메소드마다 객체생성을 하지 않아도 된다. 
		memberDao = new MemberDao();
	}
	
	
	@Override
	public MemberVo getMember(String userId) {
		return memberDao.getMember(userId);
	}


	@Override
	public List<MemberVo> selectAllMember() {
		return memberDao.selectAllMember();
	}


	@Override
	public Map<String, Object> selectMemberPageList(PageVo pageVo) {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberList", memberDao.selectMemberPageList(sqlSession, pageVo));
		
		// 15건, 페이지 사이즈를 7로 가정했을 때 3개의 페이지가 나와야 한다.
		
		int cnt = memberDao.selectMemberTotalCnt(sqlSession);
		int pages = (int) Math.ceil((double)cnt/7);
		map.put("pages", pages);
		
		sqlSession.close();
		return map;
	}

	 
	@Override
	public int selectMemberTotalCnt() {
		 SqlSession sqlSession = MybatisUtil.getSqlSession();
	     return memberDao.selectMemberTotalCnt(sqlSession);
	}


}
