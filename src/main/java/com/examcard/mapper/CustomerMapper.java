package com.examcard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.examcard.repository.entity.Customer;

@Mapper
public interface CustomerMapper {
	public List<Customer> select(Customer customer);
	public Customer selectById(String id);
	public long update(Customer customer);
	public void insert(Customer customer);
}
