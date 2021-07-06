package com.examcard.dao.customer;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Customer> select(Customer customer) {
		return sqlSession.selectList("com.examcard.dao.customer.CustomerDao.select", customer);
	}

	@Override
	public Customer selectById(String id) {
		return sqlSession.selectOne("com.examcard.dao.customer.CustomerDao.selectById", id);
	}
	
	@Override
	public List<UserCard> selectUserCard(String id) {
		return sqlSession.selectList("com.examcard.dao.customer.CustomerDao.selectUserCard", id);
	}

	@Override
	public long update(Customer customer) {
		return sqlSession.update("com.examcard.dao.customer.CustomerDao.update", customer);
	}

	@Override
	public void insert(Customer customer) {
		sqlSession.insert("com.examcard.dao.customer.CustomerDao.insert", customer);
	}
}
