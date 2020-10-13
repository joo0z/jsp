package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.JobVo;

public class JobDao implements JobDaoI{

	@Override
	public List<JobVo> selectAllJob() {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<JobVo> list = sqlSession.selectList("job.selectAllJob");
		
		sqlSession.close();
		
		return list;
	}

}
