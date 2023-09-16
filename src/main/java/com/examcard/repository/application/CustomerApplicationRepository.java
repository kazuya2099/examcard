package com.examcard.repository.application;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.examcard.entity.CustomerApplication;

@Mapper
public interface CustomerApplicationRepository {
	public void insert(CustomerApplication customerApplication);
	public long update(CustomerApplication customerApplication);
	public long count(CustomerApplication customerApplication);
	public List<CustomerApplication> select(CustomerApplicationSearchParam searchParam);
	public CustomerApplication selectById(String id);
	public CustomerApplication selectByIdForUpdate(String id);
	public long countForJudgement(CustomerApplication customerApplication);
	public List<CustomerApplication> selectForJudgement(CustomerApplicationSearchParam searchParam);
}
