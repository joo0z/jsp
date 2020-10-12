package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.JobDao;
import kr.or.ddit.member.dao.JobDaoI;
import kr.or.ddit.member.model.JobVo;

public class JobService implements JobServiceI{

	@Override
	public List<JobVo> selectAllJob() {
		JobDaoI dao = new JobDao();
		return dao.selectAllJob();
	}

}
