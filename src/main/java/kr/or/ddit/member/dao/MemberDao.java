package kr.or.ddit.member.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;

@Repository("memberDao")
public class MemberDao implements MemberDaoI{
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public MemberVo getMember(String userid) {
		MemberVo memberVo = sqlSession.selectOne("member.getMember", userid);
		return memberVo;
	}

	@Override
	public List<MemberVo> selectAllMember() {
		List<MemberVo> list = sqlSession.selectList("member.selectAllMember");
		return list;
	}
	
	@Override
	public List<MemberVo> selectMemberPageList(PageVo pageVo) {
		return sqlSession.selectList("member.selectMemberPageList", pageVo);
	}


	@Override
	public int selectMemberTotalCnt() {
		return sqlSession.selectOne("member.selectMemberTotalCnt");
	}

	@Override
	public int insertMember(MemberVo memberVo) {
		return sqlSession.insert("member.insertMember", memberVo);
	}

	@Override
	public int deleteMember(String userid) {
		int cnt = sqlSession.delete("member.deleteMember", userid);
		if (cnt == 1) {
//			sqlSession.commit();
		}else {
//			sqlSession.rollback();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVo memberVo) {
		int cnt = sqlSession.delete("member.updateMember", memberVo);
		
		if (cnt == 1) {
//			sqlSession.commit();
		}else {
//			sqlSession.rollback();
		}
		return cnt;
	}
}
