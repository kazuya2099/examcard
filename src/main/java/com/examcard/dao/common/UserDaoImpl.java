package com.examcard.dao.common;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<User> selectUser(String id) {
		return sqlSession.selectList("com.examcard.dao.common.UserDao.selectUser", id);
	}

	@Override
	public User selectUserById(String id) {
		return sqlSession.selectOne("com.examcard.dao.common.UserDao.selectUserById", id);
	}
}
