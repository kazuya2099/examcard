package com.examcard.dao.top;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserCardDaoImpl implements UserCardDao {

	@Autowired
	private SqlSession sqlSession;

	public UserCard selectByUserId(String userId) {
		return sqlSession.selectOne("com.examcard.dao.top.UserCardDao.selectByUserId", userId);
	}
}