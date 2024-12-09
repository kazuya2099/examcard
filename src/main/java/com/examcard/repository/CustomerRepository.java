package com.examcard.repository;

import java.util.List;

import com.examcard.repository.entity.Customer;

public interface CustomerRepository {
	public List<Customer> select(Customer customer);
	public Customer selectById(String id);
	public long update(Customer customer);
	public void insert(Customer customer);
}
