package com.examcard.dao.common;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SequenceDaoImpl implements SequenceDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public Sequence selectSequence(String tableName) {
		return sqlSession.selectOne("com.examcard.dao.common.SequenceDao.selectSequence", tableName);
	}

	@Override
	public int updateSequence(Sequence sequence) {
		return sqlSession.update("com.examcard.dao.common.SequenceDao.updateSequence", sequence);
	}

}
