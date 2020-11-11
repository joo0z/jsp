package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVo;

@Service("memberService")
public class MemberService implements MemberServiceI{
	
	@Resource(name = "memberDao")
	private MemberDaoI memberDao;
	
	public MemberService() {
		// 주입해 재사용
//		memberDao = new MemberDao();
	}

	@Override
	public MemberVo getMember(String userid) {
		return memberDao.getMember(userid);
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


	@Override
	public int insertMember(MemberVo memberVo) {
//		logger.debug("첫번째 insert 시작점");
//		memberDao.insertMember(memberVo);
//		logger.debug("첫번째 insert 종료후");
//		
//		logger.debug("두번째 insert 시작점");
//		memberDao.insertMember(memberVo);
//		logger.debug("두번째 insert 종료후");
//		
//		return 1;
//		첫번째 쿼리는 정상적으로 실행되지만 두번째 쿼리에서 동일한 데이터를 입력하여 PROMARY KEY 제약조건에 의해 SQL 실행 실패
//		첫번째 쿼리는 성동했지만 트랜잭션 설정을 service 레벨에 설정했기 때문에
//		서비스 메서드에서 실행된 모든 쿼리를 rollback처리해준다.
		return memberDao.insertMember(memberVo);
	}


	@Override
	public int deleteMember(String userid) {
		return memberDao.deleteMember(userid);
	}


	@Override
	public int updateMember(MemberVo memberVo) {
		return memberDao.updateMember(memberVo);
	}


}
