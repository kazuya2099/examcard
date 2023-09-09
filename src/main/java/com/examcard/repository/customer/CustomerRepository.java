package com.examcard.repository.customer;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.examcard.entity.Customer;

@Mapper
public interface CustomerRepository {
	public List<Customer> select(Customer customer);
	public Customer selectById(String id);
	public long update(Customer customer);
	public void insert(Customer customer);
}
