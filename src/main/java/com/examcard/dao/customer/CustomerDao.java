package com.examcard.dao.customer;

import java.util.List;

public interface CustomerDao {

	public List<Customer> select(Customer customer);
	public Customer selectById(String id);
	public List<UserCard> selectUserCard(String id);
	public long update(Customer customer);
	public void insert(Customer customer);
}
