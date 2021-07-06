package com.examcard.dao.common;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InformationDaoImpl implements InformationDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Information> getInformation(Date systemDate) {
		return sqlSession.selectList("com.examcard.dao.common.InformationDao.selectByDate", systemDate);
	}
}
