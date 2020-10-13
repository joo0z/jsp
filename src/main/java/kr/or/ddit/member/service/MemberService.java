package kr.or.ddit.member.service;

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
		memberDao = new MemberDao();
		return memberDao.getMember(userId);
	}

}
