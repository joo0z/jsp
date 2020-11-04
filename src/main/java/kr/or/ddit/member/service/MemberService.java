package kr.or.ddit.member.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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

}
