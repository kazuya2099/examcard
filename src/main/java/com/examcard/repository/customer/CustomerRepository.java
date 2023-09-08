package com.examcard.repository.customer;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerRepository {
	public List<Customer> select(Customer customer);
	public Customer selectById(String id);
	public List<UserCard> selectUserCard(String id);
	public long update(Customer customer);
	public void insert(Customer customer);
}
