package com.examcard.dao.top;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PointDaoImpl implements PointDao {

	@Autowired
	private SqlSession sqlSession;

	public Point selectPoint(Point point) {
		return sqlSession.selectOne("com.examcard.dao.top.PointDao.selectPoint", point);
	}

	public Point selectFuturePoint(Point point) {
		return sqlSession.selectOne("com.examcard.dao.top.PointDao.selectFuturePoint", point);
	}
}
