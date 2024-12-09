package com.examcard.repository;

import java.util.List;

import com.examcard.repository.entity.CustomerApplication;
import com.examcard.repository.entity.CustomerApplicationSearchParam;

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
