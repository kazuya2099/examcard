package com.examcard.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examcard.mapper.CustomerApplicationMapper;
import com.examcard.repository.CustomerApplicationRepository;
import com.examcard.repository.entity.CustomerApplication;
import com.examcard.repository.entity.CustomerApplicationSearchParam;

@Repository
public class CustomerApplicationRepositoryImpl implements CustomerApplicationRepository {
	
	@Autowired
	private CustomerApplicationMapper customerApplicationMapper;
	
	public void insert(CustomerApplication customerApplication) {
		customerApplicationMapper.insert(customerApplication);
	}
	
	public long update(CustomerApplication customerApplication) {
		return customerApplicationMapper.update(customerApplication);
	}
	
	public long count(CustomerApplication customerApplication) {
		return customerApplicationMapper.count(customerApplication);
	}
	
	public List<CustomerApplication> select(CustomerApplicationSearchParam searchParam) {
		return customerApplicationMapper.select(searchParam);
	}
	
	public CustomerApplication selectById(String id) {
		return customerApplicationMapper.selectById(id);
	}
	
	public CustomerApplication selectByIdForUpdate(String id) {
		return customerApplicationMapper.selectByIdForUpdate(id);
	}
	
	public long countForJudgement(CustomerApplication customerApplication) {
		return customerApplicationMapper.countForJudgement(customerApplication);
	}
	
	public List<CustomerApplication> selectForJudgement(CustomerApplicationSearchParam searchParam) {
		return customerApplicationMapper.selectForJudgement(searchParam);
	}
}
