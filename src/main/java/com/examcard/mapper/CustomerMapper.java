package com.examcard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.examcard.repository.entity.CustomerEntity;

@Mapper
public interface CustomerMapper {
	public List<CustomerEntity> select(CustomerEntity customer);
	public CustomerEntity selectById(String id);
	public long update(CustomerEntity customer);
	public void insert(CustomerEntity customer);
}
