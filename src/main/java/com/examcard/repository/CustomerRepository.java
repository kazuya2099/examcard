package com.examcard.repository;

import java.util.List;

import com.examcard.repository.entity.CustomerEntity;

public interface CustomerRepository {
	public List<CustomerEntity> select(CustomerEntity customer);
	public CustomerEntity selectById(String id);
	public long update(CustomerEntity customer);
	public void insert(CustomerEntity customer);
}
