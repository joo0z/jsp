package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;

public class MemberDao implements MemberDaoI{

	@Override
	public MemberVo getMember(String userId) {
		
		// 원래는 db에서 데이터를 조회하는 로직이 있어야하나
		// 우리는 controller기능에 집중 =>  하드코딩을 통해 dao, service는 간략하게 넘어간다.
		// Mock (가짜)
		
		/*MemberVo mv = new MemberVo();
		mv.setUserId("brown");
		mv.setPassword("passBrown");
		*/
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		// select 사용 방법
		// 1건 : selectOne
		// 여러건 : seletList
		MemberVo memberVo = sqlSession.selectOne("member.getMember", userId);		
		// 데이터 변경이 일어나는 부분은 commit() rollback()을 해줘야 하는데 데이터 변경이 없는 경우 close()해준다.
		sqlSession.close();
		
		return memberVo;
	}

	@Override
	public List<MemberVo> selectAllMember() {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<MemberVo> list = sqlSession.selectList("member.selectAllMember");
		
		sqlSession.close();
		
		return list;
	}

	@Override
	public List<MemberVo> selectMemberPageList(SqlSession sqlSession, PageVo pageVo) {
		return sqlSession.selectList("member.selectMemberPageList", pageVo);
	}

	@Override
	public int selectMemberTotalCnt(SqlSession sqlSession) {
		return sqlSession.selectOne("member.selectMemberTotalCnt");
	}

	@Override
	public int insertMember(MemberVo memberVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = sqlSession.insert("member.insertMember", memberVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return cnt;
	}

	@Override
	public int deleteMember(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = sqlSession.delete("member.deleteMember", userid);
		
		if (cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}

	@Override
	public int updateMember(MemberVo memberVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = sqlSession.delete("member.updateMember", memberVo);
		
		if (cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}



}
