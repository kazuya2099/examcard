package com.examcard.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examcard.mapper.CustomerMapper;
import com.examcard.repository.CustomerRepository;
import com.examcard.repository.entity.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	
	@Autowired
	private CustomerMapper customerMapper;
	
	public List<Customer> select(Customer customer) {
		return customerMapper.select(customer);
	}
	
	public Customer selectById(String id) {
		return customerMapper.selectById(id);
	}
	
	public long update(Customer customer) {
		return customerMapper.update(customer);
	}
	
	public void insert(Customer customer) {
		customerMapper.insert(customer);
	}
}
