package com.examcard.dao.application;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public class CustomerApplicationDaoImpl implements CustomerApplicationDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(CustomerApplication customerApplication) {
		sqlSession.insert("com.examcard.dao.application.CustomerApplicationDao.insert", customerApplication);
	}

	@Override
	public long update(CustomerApplication customerApplication) {
		return sqlSession.update("com.examcard.dao.application.CustomerApplicationDao.update", customerApplication);
	}

	@Override
	public List<CustomerApplication> select(CustomerApplication customerApplication) {
		return sqlSession.selectList("com.examcard.dao.application.CustomerApplicationDao.select", customerApplication);
	}

	@Override
	public CustomerApplication selectById(String id) {
		return sqlSession.selectOne("com.examcard.dao.application.CustomerApplicationDao.selectById", id);
	}

	@Override
	public long count(CustomerApplication customerApplication) {
		return sqlSession.selectOne("com.examcard.dao.application.CustomerApplicationDao.count", customerApplication);
	}
	
	@Override
	public CustomerApplication selectByIdForUpdate(String id) {
		return sqlSession.selectOne("com.examcard.dao.application.CustomerApplicationDao.selectByIdForUpdate", id);
	}

	@Override
	public long countForJudgement(CustomerApplication customerApplication) {
		return sqlSession.selectOne("com.examcard.dao.application.CustomerApplicationDao.countForJudgement", customerApplication);
	}

	@Override
	public List<CustomerApplication> selectForJudgement(CustomerApplication customerApplication) {
		return sqlSession.selectList("com.examcard.dao.application.CustomerApplicationDao.selectForJudgement", customerApplication);
	}

}
