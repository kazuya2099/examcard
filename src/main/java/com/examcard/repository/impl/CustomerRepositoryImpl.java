package com.examcard.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examcard.mapper.CustomerMapper;
import com.examcard.repository.CustomerRepository;
import com.examcard.repository.entity.CustomerEntity;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	
	@Autowired
	private CustomerMapper customerMapper;
	
	public List<CustomerEntity> select(CustomerEntity customer) {
		return customerMapper.select(customer);
	}
	
	public CustomerEntity selectById(String id) {
		return customerMapper.selectById(id);
	}
	
	public long update(CustomerEntity customer) {
		return customerMapper.update(customer);
	}
	
	public void insert(CustomerEntity customer) {
		customerMapper.insert(customer);
	}
}
