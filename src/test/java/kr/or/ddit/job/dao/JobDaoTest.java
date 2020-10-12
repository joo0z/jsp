package kr.or.ddit.job.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.member.dao.JobDao;
import kr.or.ddit.member.dao.JobDaoI;
import kr.or.ddit.member.model.JobVo;

public class JobDaoTest {

	@Test
	public void test() {
		/*** Given ***/
		JobDaoI jobDao = new JobDao();
		
		/*** When ***/
		List<JobVo> list = jobDao.selectAllJob();
		
		/*** Then ***/
		assertNotNull(list);
	}

}
