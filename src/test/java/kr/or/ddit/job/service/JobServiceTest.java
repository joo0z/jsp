package kr.or.ddit.job.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.member.model.JobVo;
import kr.or.ddit.member.service.JobService;
import kr.or.ddit.member.service.JobServiceI;

public class JobServiceTest {

	@Test
	public void test() {
		/*** Given ***/
		JobServiceI service = new JobService();
		
		/*** When ***/
		List<JobVo> list = service.selectAllJob();

		/*** Then ***/
		assertNotNull(list);
	}

}
